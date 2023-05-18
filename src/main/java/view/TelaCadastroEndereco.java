package view;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroEndereco {

	private JFrame frmCadastroDeEndereco;
	private MaskFormatter mascaraCep; 
	private JTextField txtRua;
	private JTextField textNumero;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JLabel lblCEP;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco window = new TelaCadastroEndereco();
					window.frmCadastroDeEndereco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeEndereco = new JFrame();
		frmCadastroDeEndereco.setTitle("Cadastro de Endereço");
		frmCadastroDeEndereco.setBounds(100, 100, 415, 300);
		frmCadastroDeEndereco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeEndereco.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(171dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:max(2dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		lblCEP = new JLabel("CEP:");
		frmCadastroDeEndereco.getContentPane().add(lblCEP, "2, 4");
		
		try {
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCep.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a máscara de CEP.");
		}
		
		JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setText("      -   ");
		frmCadastroDeEndereco.getContentPane().add(txtCep, "4, 4");
		
		lblRua = new JLabel("Rua:");
		frmCadastroDeEndereco.getContentPane().add(lblRua, "2, 6");
		
		txtRua = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(txtRua, "4, 6, fill, default");
		txtRua.setColumns(10);
		
		lblNumero = new JLabel("Número:");
		frmCadastroDeEndereco.getContentPane().add(lblNumero, "2, 8");
		
		textNumero = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(textNumero, "4, 8, fill, default");
		textNumero.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		frmCadastroDeEndereco.getContentPane().add(lblBairro, "2, 10");
		
		textBairro = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(textBairro, "4, 10, fill, default");
		textBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		frmCadastroDeEndereco.getContentPane().add(lblCidade, "2, 12");
		
		textCidade = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(textCidade, "4, 12, fill, default");
		textCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		frmCadastroDeEndereco.getContentPane().add(lblEstado, "2, 14");
		
		textEstado = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(textEstado, "4, 14, fill, default");
		textEstado.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Preencher um novo Endereco com o que foi informado na tela	
				
			// Instanciar um objeto de Enderecco Controller
				
			//Chamar o controller.salver(novoEndereco)
			}
		});
		frmCadastroDeEndereco.getContentPane().add(btnNewButton, "2, 16, 3, 1");
	}
}
