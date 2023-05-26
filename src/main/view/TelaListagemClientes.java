package main.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import main.controller.ClienteController;
import main.model.vo.Cliente;

public class TelaListagemClientes extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private ArrayList<Cliente> clientes;
	private String[] nomesColunas = { "#", "Nome", "CPF", "Endereço", "Total de Telefones" };
	private JTextField txtNome;

	private ClienteController controller = new ClienteController();
	private Cliente clienteSelecionado;

	private void limparTabelaClientes() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaClientes() {
		this.limparTabelaClientes();
		
		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
		//Preencher os valores na tabela linha a linha
		for (Cliente c : clientes) {
			Object[] novaLinhaDaTabela = new Object[5];
			novaLinhaDaTabela[0] = c.getId();
			novaLinhaDaTabela[1] = c.getNome();
			novaLinhaDaTabela[2] = c.getCpf();
			novaLinhaDaTabela[3] = c.getEndereco().getEnderecoResumido();
			novaLinhaDaTabela[4] = c.getTelefones().size();
			model.addRow(novaLinhaDaTabela);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemClientes frame = new TelaListagemClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TelaListagemClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tblClientes = new JTable();
		tblClientes.setBounds(36, 85, 579, 272);
		contentPane.add(tblClientes);

		JButton btnBuscarTodos = new JButton("Listar Clientes");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes = (ArrayList<Cliente>) controller.consultarTodos();
				atualizarTabelaClientes();
			}
		});
		btnBuscarTodos.setBounds(271, 23, 120, 32);
		contentPane.add(btnBuscarTodos);
	}

}
