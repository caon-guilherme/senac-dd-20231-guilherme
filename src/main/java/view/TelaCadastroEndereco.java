package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.privatejgoodies.forms.layout.ColumnSpec;
import com.privatejgoodies.forms.layout.FormLayout;
import com.privatejgoodies.forms.layout.FormSpecs;
import com.privatejgoodies.forms.layout.RowSpec;

import controller.EnderecoController;
import model.exception.CampoInvalidoException;
import model.vo.Endereco;

public class TelaCadastroEndereco {

	private JFrame frmCadastroDeEndereco;
	private MaskFormatter mascaraCep;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
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
		frmCadastroDeEndereco.getContentPane()
				.setLayout(new FormLayout(
						new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(34dlu;default)"),
								FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(171dlu;default):grow"),
								FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("right:max(2dlu;default)"), },
						new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

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

		txtNumero = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(txtNumero, "4, 8, fill, default");
		txtNumero.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		frmCadastroDeEndereco.getContentPane().add(lblBairro, "2, 10");

		txtBairro = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(txtBairro, "4, 10, fill, default");
		txtBairro.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		frmCadastroDeEndereco.getContentPane().add(lblCidade, "2, 12");

		txtCidade = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(txtCidade, "4, 12, fill, default");
		txtCidade.setColumns(10);

		lblEstado = new JLabel("Estado:");
		frmCadastroDeEndereco.getContentPane().add(lblEstado, "2, 14");

		txtEstado = new JTextField();
		frmCadastroDeEndereco.getContentPane().add(txtEstado, "4, 14, fill, default");
		txtEstado.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Preencher um novo Endereco com o que foi informado na tela
				Endereco novoEndereco = new Endereco();

				//String cepInformado = (String) mascaraCep.stringToValue(txtCep.getText());

				novoEndereco.setRua(txtRua.getText());
				novoEndereco.setRua(txtNumero.getText());
				novoEndereco.setRua(txtCidade.getText());
				novoEndereco.setRua(txtEstado.getText());

				// Instanciar um objeto de Enderecco Controller
				EnderecoController controller = new EnderecoController();
				// Chamar o controller.salver(novoEndereco)

				try {
					controller.inserir(novoEndereco);
					JOptionPane.showMessageDialog(null, "Endereço cadastrado!");
				} catch (CampoInvalidoException e1) {
					JOptionPane.showMessageDialog(null, "Informe os seguintes campos\n");
				}
			}
		});
		frmCadastroDeEndereco.getContentPane().add(btnNewButton, "2, 16, 3, 1");
	}
}
