package main.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.view.PainelCadastroCliente;
import main.view.PainelCadastroEndereco;
import main.view.PainelCadastroTelefone;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal10 extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCliente;
	private JMenuItem mntmCadastrarCliente;
	private JMenuItem mntmListarCliente;
	private JMenu mnTefelone;
	private JMenuItem mntmCadastroTelefone;
	private JMenuItem mntmListarTelefone;
	private JMenu mnEndereco;
	private JMenuItem mntmCadastroEndereco;
	private PainelCadastroCliente painelCadastroCliente;
	private PainelCadastroTelefone painelCadastroTelefone;
	private PainelCadastroEndereco painelCadastroEndereco;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal10 frame = new TelaPrincipal10();
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
	public TelaPrincipal10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroCliente = new PainelCadastroCliente();
				setContentPane(painelCadastroCliente);
				revalidate();
			}
		});
		mnCliente.add(mntmCadastrarCliente);
		
		mntmListarCliente = new JMenuItem("Listar Clientes");
		mnCliente.add(mntmListarCliente);
		
		mnTefelone = new JMenu("Tefelone");
		menuBar.add(mnTefelone);
		
		mntmCadastroTelefone = new JMenuItem("Cadastrar Telefone");
		mntmCadastroTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroTelefone = new PainelCadastroTelefone();
				setContentPane(painelCadastroTelefone);
				revalidate();
			}
		});
		mnTefelone.add(mntmCadastroTelefone);
		
		mntmListarTelefone = new JMenuItem("Listar Telefones");
		mnTefelone.add(mntmListarTelefone);
		
		mnEndereco = new JMenu("Endereço");
		menuBar.add(mnEndereco);
		
		mntmCadastroEndereco = new JMenuItem("Cadastrar Endereço");
		mnEndereco.add(mntmCadastroEndereco);
	}
}