package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.FuncionarioController;
import View.AlunoView.cancelarListenner;

public class FuncionarioView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painel1;
	private JPanel painel2;
	private JPanel painelProfessor;
	private JPanel painelSecretaria;
	private JPanel painelFaxineira;

	// atributo de seleção
	private JComboBox cmbSeleção;
	private String[] funcionarioCamps = { "Professor(a)", "Secretario(a)", "Faxineiro(a)" };
	private JLabel lblSeleção;

	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtData;
	private JTextField txtTelefone;
	private JTextField txtSalario;
	private JLabel lblDadosFuncionario;

	// Atributos de endereço
	private JLabel lblEndereço;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtBairro;

	private JComboBox cboxCidade;
	private String[] cidadeCamps = { "Osasco", "Niteroi" };
	private JComboBox cboxEstado;
	private String[] estadoCamps = { "São PAulo", "Rio de JAneiro" };

//Botoes
	private JButton btnSalvar;
	private JButton btnCancelar;

	// atributos especificos
	// professor
	private JTable tbtMateria;
	private JTextField txtIncluirMateria;
	private JButton btnIncluirMateria;
	private JButton btnExcluirMateria;
	private JScrollPane painelDeScroll;
	private String[] coluna = new String[] { "Materia" };
	private String[][] dados = new String[][] { { "Matemática" }, { "Portugues" } };

	// secretaria
	private JTextField txtRamal;
	private JLabel lblRamal;

	// faxineira
	private ButtonGroup grpPeriodo;
	private JRadioButton rbtDiurno;
	private JRadioButton rbtNoturno;
	private JLabel lblPeriodo;

	public void iniciaGui() {

		janela = new JFrame("Cadastro de Funcionários");
		painelDaJanela = (JPanel) janela.getContentPane();
		painel1 = new JPanel();
		painel2 = new JPanel();
		painelProfessor = new JPanel();
		painelSecretaria = new JPanel();
		painelFaxineira = new JPanel();

		// cfgSeleção --------------------------------------------------------------
		// Seletor
		cmbSeleção = new JComboBox(funcionarioCamps);
		cmbSeleção.setBounds(164, 10, 270, 20);
		cmbSeleção.setSelectedIndex(-1);

		lblSeleção = new JLabel("Selecione a Função:");
		lblSeleção.setName("Selecione a Função:");
		lblSeleção.setBounds(30, 10, 150, 20);

		// adicionar paineis na janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(painel1);
		painelDaJanela.add(painel2);
		painelDaJanela.add(painelProfessor);
		painelDaJanela.add(painelSecretaria);
		painelDaJanela.add(painelFaxineira);
		painelDaJanela.add(cmbSeleção);
		painelDaJanela.add(lblSeleção);

		// cfg painel 1 =============================================================
		// painel 1
		painel1.setBounds(4, 43, 585, 130);
		painel1.setLayout(null);
		painel1.setBorder(BorderFactory.createRaisedBevelBorder());

		// instancias do painel 1
		lblDadosFuncionario = new JLabel("Digite os Dados do Funcionário");
		lblDadosFuncionario.setBounds(210, 4, 200, 23);

		JLabel lblNome = new JLabel();
		lblNome.setText("Nome do Funcionário: ");
		lblNome.setBounds(10, 25, 150, 23);

		JLabel lblRg = new JLabel();
		lblRg.setText("Numero do RG: ");
		lblRg.setBounds(310, 50, 100, 23);

		JLabel lblCpf = new JLabel();
		lblCpf.setText("Numero do CPF: ");
		lblCpf.setBounds(10, 50, 100, 23);

		JLabel lblData = new JLabel();
		lblData.setText("Data de Nascimento: ");
		lblData.setBounds(10, 75, 120, 23);

		JLabel lblTelefone = new JLabel();
		lblTelefone.setText("Telefone: ");
		lblTelefone.setBounds(310, 75, 120, 23);

		JLabel lblSalario = new JLabel();
		lblSalario.setText("Informe o Salário do Funcionário: ");
		lblSalario.setBounds(10, 100, 210, 23);

		JLabel lblSalario2 = new JLabel();
		lblSalario2.setText("R$");
		lblSalario2.setBounds(330, 100, 50, 23);

		txtNome = new JTextField();
		txtNome.setBounds(150, 25, 400, 23);

		txtCpf = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCpf.setBounds(150, 50, 130, 23);

		txtRg = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##.###.###-#");
			txtRg = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtRg.setBounds(420, 50, 130, 23);

		txtData = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtData = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtData.setBounds(150, 75, 98, 23);

		txtTelefone = new JTextField();
		try {
			javax.swing.text.MaskFormatter tl = new javax.swing.text.MaskFormatter("(##)####-####");
			txtTelefone = new javax.swing.JFormattedTextField(tl);
		} catch (Exception e) {
		}
		txtTelefone.setBounds(420, 75, 130, 23);

		txtSalario = new JTextField();
		txtSalario.setBounds(195, 100, 130, 23);

		painel1.add(lblDadosFuncionario);
		painel1.add(lblNome);
		painel1.add(txtNome);
		painel1.add(lblCpf);
		painel1.add(txtCpf);
		painel1.add(lblRg);
		painel1.add(txtRg);
		painel1.add(lblData);
		painel1.add(txtData);
		painel1.add(lblTelefone);
		painel1.add(txtTelefone);
		painel1.add(lblSalario);
		painel1.add(lblSalario2);
		painel1.add(txtSalario);

		// cfg Painel 2
		// ===================================================================== Painel
		// 2 Endereço
		painel2.setBounds(4, 172, 585, 110);
		painel2.setLayout(null);
		painel2.setBorder(BorderFactory.createRaisedBevelBorder());

		// instancias do painel 2

		lblEndereço = new JLabel("Digite o Endereço do Funcionário");
		lblEndereço.setBounds(210, 4, 200, 23);

		JLabel lblRua = new JLabel();
		lblRua.setText("Logradouro: ");
		lblRua.setBounds(10, 25, 120, 23);

		JLabel lblNumero = new JLabel();
		lblNumero.setText("Nº: ");
		lblNumero.setBounds(420, 25, 100, 23);

		JLabel lblComplemento = new JLabel();
		lblComplemento.setText("Complemento: ");
		lblComplemento.setBounds(10, 50, 100, 23);

		JLabel lblBairro = new JLabel();
		lblBairro.setText("Bairro: ");
		lblBairro.setBounds(220, 50, 80, 23);

		JLabel lblCep = new JLabel();
		lblCep.setText("CEP: ");
		lblCep.setBounds(420, 50, 120, 23);

		txtRua = new JTextField();
		txtRua.setBounds(100, 25, 300, 23);

		txtNumero = new JTextField();
		txtNumero.setBounds(450, 25, 100, 23);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(100, 50, 100, 23);

		txtCep = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("#####-###");
			txtCep = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCep.setBounds(460, 50, 90, 23);

		txtBairro = new JTextField();
		txtBairro.setBounds(260, 50, 150, 23);

		// configurações do combo box (Cidade e Estados)
		// ---------------------------------------------------------------- Combo box

		JLabel lblEstado = new JLabel();
		lblEstado.setText("Selecione o Estado:");
		lblEstado.setBounds(300, 75, 150, 23);

		JComboBox cboxEstado = new JComboBox(estadoCamps);
		cboxEstado.setSelectedItem(estadoCamps);
		cboxEstado.setBounds(420, 75, 130, 20);
		cboxEstado.setSelectedIndex(-1);

		JLabel lblCidade = new JLabel();
		lblCidade.setText("Selecione a Cidade:");
		lblCidade.setBounds(10, 75, 150, 20);

		JComboBox cboxCidade = new JComboBox(cidadeCamps);
		cboxCidade.setSelectedItem(cidadeCamps);
		cboxCidade.setBounds(125, 75, 170, 20);
		cboxCidade.setSelectedIndex(-1);

		painel2.add(lblEndereço);
		painel2.add(lblRua);
		painel2.add(txtRua);
		painel2.add(lblNumero);
		painel2.add(txtNumero);
		painel2.add(lblComplemento);
		painel2.add(txtComplemento);
		painel2.add(lblBairro);
		painel2.add(txtBairro);
		painel2.add(lblCep);
		painel2.add(txtCep);
		painel2.add(lblCidade);
		painel2.add(cboxCidade);
		painel2.add(lblEstado);
		painel2.add(cboxEstado);

		// cfg Painel 3 ======================================================== painel 3
        //instanciar botoes
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");
		
		// instancias da secretaria
		lblRamal = new JLabel("Ramal:");
		lblRamal.setBounds(10, 10, 80, 23);
		txtRamal = new JTextField();
		txtRamal.setBounds(80, 10, 100, 23);

		// instancias da faxineira
		lblPeriodo = new JLabel("Selecione o periodo: ");
		lblPeriodo.setBounds(10, 10, 150, 23);

		grpPeriodo = new ButtonGroup();
		rbtDiurno = new JRadioButton("Diurno");
		rbtDiurno.setBounds(10, 40, 80, 23);
		rbtDiurno.setText("Diurno");

		rbtNoturno = new JRadioButton("Noturno");
		rbtNoturno.setBounds(100, 40, 80, 23);
		rbtNoturno.setText("Noturno");

		// instancias do professor
		painelDeScroll = new JScrollPane();
		DefaultTableModel modelo = new DefaultTableModel(dados, coluna);

		JLabel lblIncluirMateria = new JLabel("Adicionar / Remover Matérias:");

		txtIncluirMateria = new JTextField();
		btnIncluirMateria = new JButton("Incluir");
		btnExcluirMateria = new JButton("Excluir");
		
		
		
		tbtMateria = new JTable(modelo);
		tbtMateria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbtMateria.setEnabled(true);
		

		painelDeScroll = new JScrollPane(tbtMateria);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		painelDeScroll.setBounds(200, 10, 350, 100);
		painelDeScroll.add(tbtMateria);
		tbtMateria.setBounds(10, 10, 300, 95);
		lblIncluirMateria.setBounds(13, 10, 200, 23);
		txtIncluirMateria.setBounds(10, 30, 180, 23);
		btnIncluirMateria.setBounds(10, 50, 80, 30);
		btnExcluirMateria.setBounds(100, 50, 80, 30);

		// cfg Painel Professor -----------------------------------------------Painel
		// Professor
		painelProfessor.setBounds(4, 282, 585, 170);
		painelProfessor.setLayout(null);
		painelProfessor.setBorder(BorderFactory.createRaisedBevelBorder());
		painelProfessor.setVisible(false);
		painelProfessor.add(painelDeScroll);
		painelProfessor.add(lblIncluirMateria);
		painelProfessor.add(btnExcluirMateria);
		painelProfessor.add(btnIncluirMateria);
		painelProfessor.add(txtIncluirMateria);
		
		

		// cfg Painel Secretaria -------------------------------------------------painel
		// secretaria
		painelSecretaria.setBounds(4, 282, 585, 50);
		painelSecretaria.setLayout(null);
		painelSecretaria.setBorder(BorderFactory.createRaisedBevelBorder());
		painelSecretaria.setVisible(false);
		painelSecretaria.add(lblRamal);
		painelSecretaria.add(txtRamal);
		

		// cfg Painel Faxineira --------------------------------------------------Painel
		// faxineira
		painelFaxineira.setBounds(4, 282, 585, 74);
		painelFaxineira.setLayout(null);
		painelFaxineira.setBorder(BorderFactory.createRaisedBevelBorder());
		painelFaxineira.setVisible(false);
		grpPeriodo.add(rbtDiurno);
		grpPeriodo.add(rbtNoturno);
		painelFaxineira.add(lblPeriodo);
		painelFaxineira.add(rbtDiurno);
		painelFaxineira.add(rbtNoturno);
		

		cmbSeleção.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ((AbstractButton) cmbSeleção.getSelectedItem()).getText();
				String função = (String) cmbSeleção.getSelectedItem();

				if (função == "Professor(a)") {
					painelProfessor.setVisible(true);
					painelSecretaria.setVisible(false);
					painelFaxineira.setVisible(false);
					janela.setSize(new Dimension(610, 500));
					btnIncluirMateria.addActionListener(new ActionListener() {
						
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if ((txtIncluirMateria.getText().equals(""))) {
								JOptionPane.showMessageDialog(null, "Campo Cidade é Obrigatorio");
							}else {
								
								DefaultTableModel modelo = (DefaultTableModel) tbtMateria.getModel();
								
								txtIncluirMateria.setText("");
							//	txtIncluirEstado.setText("");
								modelo.addRow(new String[] {txtIncluirMateria.getText().toUpperCase()});
								JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso!");
							}
							
						}
					});
					btnExcluirMateria.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if (tbtMateria.getSelectedRow() == -1) {
								JOptionPane.showMessageDialog(null, "Selecione uma linha!");
							}else if (tbtMateria.getSelectedRow() > 1) {
								JOptionPane.showMessageDialog(null, "Selecione apenas uma linha!");			
							}else{
								DefaultTableModel modelo = (DefaultTableModel) tbtMateria.getModel();
								modelo.removeRow(tbtMateria.getSelectedRow());
								JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
							}
							
						}
					});
					
					painelProfessor.add(btnSalvar);
					painelProfessor.add(btnCancelar);
					btnCancelar.setBounds(380, 120, 100, 35);
					btnSalvar.setBounds(200, 120, 100, 35);
					

				}
				if (função == "Secretario(a)") {
					painelSecretaria.setVisible(true);
					painelProfessor.setVisible(false);
					painelFaxineira.setVisible(false);
					janela.setSize(new Dimension(610, 376));
					painelSecretaria.add(btnSalvar);
					painelSecretaria.add(btnCancelar);
					btnCancelar.setBounds(380, 6, 100, 35);
					btnSalvar.setBounds(250, 6, 100, 35);
					
					

				}
				if (função == "Faxineiro(a)") {
					painelFaxineira.setVisible(true);
					painelProfessor.setVisible(false);
					painelSecretaria.setVisible(false);
					janela.setSize(new Dimension(610, 400));
					painelFaxineira.add(btnSalvar);
					painelFaxineira.add(btnCancelar);
					btnCancelar.setBounds(380, 10, 90, 50);
					btnSalvar.setBounds(250, 10, 90, 50);
					
					
					
					
				
				}
			

			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cadastro encerrado");
				janela.dispose();
				
				
			}
		});

		// janela principal ================================================= cfg Janela
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(new Dimension(610, 327));
		janela.setVisible(true);


	}

}
