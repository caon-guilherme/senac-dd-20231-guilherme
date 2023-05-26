package main.view;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroCliente extends JPanel {
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
	 * Create the panel.
	 */
	public CadastroCliente() throws ParseException {
		initialize();
		}

	private void initialize() {
		// TODO Auto-generated method stub
		
	}

}
