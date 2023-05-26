package main.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import main.controller.ClienteController;
import main.controller.EnderecoController;
import main.model.exception.CampoInvalidoException;
import main.model.exception.CpfJaUtilizadoException;
import main.model.exception.EnderecoInvalidoException;
import main.model.vo.Cliente;
import main.model.vo.Endereco;

public class TelaCadastroCliente {

	private JFrame frmNovoCliente;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEndereco;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	
	private MaskFormatter mascaraCpf;
	private JComboBox cbEndereco;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmNovoCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public TelaCadastroCliente() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmNovoCliente = new JFrame();
		frmNovoCliente.setTitle("Novo Cliente");
		frmNovoCliente.setBounds(100, 100, 420, 220);
		//Fecha apenas a janela atual, sem destruir as demais abertas
		frmNovoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNovoCliente.getContentPane().setLayout(null);
		
		mascaraCpf = new MaskFormatter("###.###.###-##");
		mascaraCpf.setValueContainsLiteralCharacters(false);
		
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(85, 60, 300, 20);
		frmNovoCliente.getContentPane().add(txtCpf);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 20, 50, 14);
		frmNovoCliente.getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(25, 60, 50, 14);
		frmNovoCliente.getContentPane().add(lblCpf);
		
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(25, 100, 50, 14);
		frmNovoCliente.getContentPane().add(lblEndereco);
		
		txtNome = new JTextField();
		txtNome.setBounds(85, 20, 300, 20);
		frmNovoCliente.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		EnderecoController endController = new EnderecoController();
		List<Endereco> enderecosCadastrados = endController.consultarTodos();
		
		cbEndereco = new JComboBox(enderecosCadastrados.toArray());
		cbEndereco.setBounds(85, 100, 300, 22);
		frmNovoCliente.getContentPane().add(cbEndereco);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente novoCliente = new Cliente();
				novoCliente.setNome(txtNome.getText());
				
				try {
					String cpfSemMascara = (String) mascaraCpf.stringToValue(
							txtCpf.getText());
					novoCliente.setCpf(cpfSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao converter o CPF", 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
				novoCliente.setEndereco((Endereco) cbEndereco.getSelectedItem());
				
				ClienteController controller = new ClienteController();
			
				try {
					controller.inserir(novoCliente);
					
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!", 
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CpfJaUtilizadoException | EnderecoInvalidoException | CampoInvalidoException excecao) {
					JOptionPane.showMessageDialog(null, excecao.getMessage(), 
							"Erro", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		btnSalvar.setForeground(new Color(255, 0, 128));
		btnSalvar.setOpaque(true); //forçando a mudança de cor
		btnSalvar.setBackground(new Color(0, 64, 64));
		btnSalvar.setBounds(85, 140, 300, 30);
		frmNovoCliente.getContentPane().add(btnSalvar);
	}
}
