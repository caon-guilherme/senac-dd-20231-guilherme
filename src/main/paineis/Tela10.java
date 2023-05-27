package main.paineis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Tela10 extends JFrame {

	private JPanel contentPane;
	private PainelVerde painelVerde;
	private PainelAzul painelAzul;
	private PainelAmarelo painelAmarelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela10 frame = new Tela10();
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
	public Tela10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);

		JMenu mnRelatorio = new JMenu("Relatórios");
		menuBar.add(mnRelatorio);

		JMenuItem mntmRelatorioVerde = new JMenuItem("Relatório Verde");
		mntmRelatorioVerde.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				painelVerde = new PainelVerde();
				setContentPane(painelVerde);
				revalidate();
			}
		});

		mnRelatorio.add(mntmRelatorioVerde);

		JMenuItem mntmRelatorioAzul = new JMenuItem("Relatório Azul");
		mntmRelatorioAzul.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				painelAzul = new PainelAzul();
				setContentPane(painelAzul);
				revalidate();
			}
		});
		mnRelatorio.add(mntmRelatorioAzul);
	}
}
