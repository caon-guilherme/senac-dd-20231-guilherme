package main.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import main.controller.ClienteController;
import main.model.exception.ClienteComTelefoneException;
import main.model.vo.Cliente;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class PainelListagemCliente extends JPanel {
	private JTable tblClientes;
	private ArrayList<Cliente> clientes;
	private String[] nomesColunas = { "Nome", "CPF", "Endereço", "Total de Telefones", "Ativo?" };
	private JTextField txtNome;
	private MaskFormatter mascaraCpf;
	private JFormattedTextField txtCPF;
	
	//componentes externos -> dependência "LGoodDatePicker" foi adicionada no pom.xml
	private DatePicker dtNascimentoInicial;
	private DatePicker dtNascimentoFinal;
	private JButton btnEditar;
	private JButton btnBuscar;
	private JButton btnBuscarTodos;
	private JButton btnGerarPlanilha;
	private JButton btnExcluir;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JLabel lblDataNascimentoDe;
	private JLabel lblAte;
	
	private ClienteController controller = new ClienteController();
	private Cliente clienteSelecionado;
	
	private void limparTabelaClientes() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaClientes() {
		this.limparTabelaClientes();

		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		for (Cliente c : clientes) {
			Object[] novaLinhaDaTabela = new Object[5];
			novaLinhaDaTabela[0] = c.getNome();
			novaLinhaDaTabela[1] = c.getCpf();
			novaLinhaDaTabela[2] = c.getEndereco().getEnderecoResumido();
			novaLinhaDaTabela[3] = c.getTelefones().size();
			novaLinhaDaTabela[4] = c.isAtivo() ? "Sim" : "Não";

			model.addRow(novaLinhaDaTabela);
		}
	}
	
	public PainelListagemCliente() {

		btnBuscar = new JButton("Buscar (em construção...)");
		btnBuscar.setBounds(285, 119, 157, 35);
		btnBuscar.setBackground(new Color(255, 0, 255));
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO descomentar na aula 11
//				ClienteSeletor seletor = new ClienteSeletor();
//				seletor.setNome(txtNome.getText());
//				seletor.setSobrenome(txtSobrenome.getText());
//				seletor.setDataNascimentoInicial(dtNascimentoInicial.getDate());
//				seletor.setDataNascimentoFinal(dtNascimentoFinal.getDate());
//				clientes = controller.listarClientes(seletor);

				atualizarTabelaClientes();
			}
		});
		setLayout(null);
		this.add(btnBuscar);

		tblClientes = new JTable();
		tblClientes.setBounds(10, 157, 665, 328);
		this.limparTabelaClientes(); // Adicionei essa linha

		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblClientes.getSelectedRow();

				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					clienteSelecionado = clientes.get(indiceSelecionado - 1);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		this.add(tblClientes);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 21, 119, 14);
		this.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(155, 14, 245, 29);
		this.add(txtNome);
		txtNome.setColumns(10);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(410, 21, 40, 14);
		this.add(lblCpf);

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCPF = new JFormattedTextField(mascaraCpf);
			txtCPF.setBounds(450, 14, 86, 29);
			this.add(txtCPF);
			txtCPF.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		lblDataNascimentoDe = new JLabel("Data de dascimento. De:");
		lblDataNascimentoDe.setBounds(10, 49, 119, 14);
		this.add(lblDataNascimentoDe);

		dtNascimentoInicial = new DatePicker();
		dtNascimentoInicial.setBounds(155, 49, 520, 30);
		this.add(dtNascimentoInicial);

		lblAte = new JLabel("Até:");
		lblAte.setBounds(10, 84, 215, 14);
		this.add(lblAte);

		dtNascimentoFinal = new DatePicker();
		dtNascimentoFinal.setBounds(155, 84, 520, 30);
		this.add(dtNascimentoFinal);

		btnGerarPlanilha = new JButton("Gerar Planilha (Aula 12)");
		btnGerarPlanilha.setBounds(10, 491, 215, 45);
		btnGerarPlanilha.setEnabled(false);
		btnGerarPlanilha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser janelaSelecaoDestinoArquivo = new JFileChooser();
				janelaSelecaoDestinoArquivo.setDialogTitle("Selecione um destino para a planilha...");

				int opcaoSelecionada = janelaSelecaoDestinoArquivo.showSaveDialog(null);
				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = janelaSelecaoDestinoArquivo.getSelectedFile().getAbsolutePath();
					//TODO decomentar na aula 11
					//controller.gerarRelatorio(clientes, caminhoEscolhido);
				}
			}
		});
		this.add(btnGerarPlanilha);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(250, 491, 200, 45);
		btnEditar.setEnabled(false);
		this.add(btnEditar);
		
		btnBuscarTodos = new JButton("Buscar todos");
		btnBuscarTodos.setBounds(155, 119, 120, 35);
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientes = (ArrayList<Cliente>) controller.consultarTodos();
				atualizarTabelaClientes();
			}
		});
		this.add(btnBuscarTodos);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(450, 491, 225, 45);
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do cliente selecionado?");
				
				if(opcaoSelecionada == JOptionPane.YES_OPTION) {
					try {
						controller.excluir(clienteSelecionado.getId());
						JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
						clientes = (ArrayList<Cliente>) controller.consultarTodos();
						atualizarTabelaClientes();
					} catch (ClienteComTelefoneException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		this.add(btnExcluir);
	}
	
	//Torna o btnEditar acessível externamente à essa classe
	public JButton getBtnEditar() {
		return this.btnEditar;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
}
