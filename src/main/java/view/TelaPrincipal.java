package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmClienteCadastro = new JMenuItem("Cadastro");
		mntmClienteCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCliente.add(mntmClienteCadastro);
		
		JMenuItem mntmClienteListagem = new JMenuItem("Listagem");
		mnCliente.add(mntmClienteListagem);
		
		JMenu mnEndereco = new JMenu("Endereço");
		menuBar.add(mnEndereco);
		
		JMenuItem mntmEnderecoCadastro = new JMenuItem("Cadastro");
		mnEndereco.add(mntmEnderecoCadastro);
		
		JMenuItem mntmEnderecoListagem = new JMenuItem("Listagem");
		mnEndereco.add(mntmEnderecoListagem);
		
		JMenu mnTelefone = new JMenu("Telefone");
		menuBar.add(mnTelefone);
		
		JMenuItem mntmTelefoneCadastro = new JMenuItem("Cadastro");
		mnTelefone.add(mntmTelefoneCadastro);
		
		JMenuItem mntmTelefoneListagem = new JMenuItem("Listagem");
		mnTelefone.add(mntmTelefoneListagem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
