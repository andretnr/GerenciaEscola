package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.AlunoController;

public class AlunoView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painel1;
	private JPanel painel2;
	private JTextField txtMatricula;
	private JTextField txtNome;

	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtData;
	private JTextField txtTelefone;
	private JPasswordField txtSenha;
	// private JPasswordField txtSenha2;

	// Atributos de endereço
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtBairro;

	private JButton btnSalvar;
	private JButton btnCancelar;

	private JLabel lblEscolha;
	private JRadioButton rbtMasculino;
	private JRadioButton rbtFeminino;
	private ButtonGroup grpRadio;

	private JComboBox cboxEstado;
	private String[] estado = { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
			"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Paraná",
			"Paraíba", "Pará", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
			"Rio Grande do Sul, Rondonia", "Roraima", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins" };

	private JComboBox cboxCidade;
	private String[] cidade = { "Osasco", "São Paulo", "Niterói" };

	public void iniciaGui() {

		// Cria as instâncias da tela
		janela = new JFrame("Cadastro de Alunos");
		painelDaJanela = (JPanel) janela.getContentPane();

		// Cria as instancias dos botões
		// Configurações do botão
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");

		// cria as instancias do tipo
		// JTextField----------------------------------------------------------Jtext
		// field
		txtMatricula = new JTextField();
		txtNome = new JTextField();
		txtData = new JTextField();
		txtTelefone = new JTextField();
		txtSenha = (JPasswordField) new JPasswordField();

		// cria as instancias tipo Combo box (Estados e
		// cidades)----------------------------------------- Combo box

		cboxEstado = new JComboBox(estado);
		cboxCidade = new JComboBox(cidade);

		// cria as instancias tipo Radio button (Sexo)
		// ---------------------------------------------------- rdio button
		lblEscolha = new JLabel();
		rbtMasculino = new JRadioButton();
		rbtFeminino = new JRadioButton();

		// Configurações JFieldText --------------------------------------------------
		JLabel lblMatricula = new JLabel();
		lblMatricula.setText("Matricula: ");
		lblMatricula.setBounds(10, 20, 60, 23);

		JLabel lblNome = new JLabel();
		lblNome.setText("Nome: ");
		lblNome.setBounds(135, 20, 60, 23);

		JLabel lblRg = new JLabel();
		lblRg.setText("Numero do RG: ");
		lblRg.setBounds(10, 92, 100, 23);

		JLabel lblCpf = new JLabel();
		lblCpf.setText("Numero do CPF: ");
		lblCpf.setBounds(300, 92, 100, 23);

		JLabel lblData = new JLabel();
		lblData.setText("Data de Nascimento: ");
		lblData.setBounds(350, 56, 120, 23);

		// JLabel lblData2 = new JLabel();
		// lblData2.setText("Nascimento: ");
		// lblData2.setBounds(400, 56, 60, 23);

		txtMatricula = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("####");
			txtMatricula = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtMatricula.setBounds(72, 20, 50, 23);

		txtNome = new JTextField();
		txtNome.setBounds(178, 20, 400, 23);

		txtData = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtData = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtData.setBounds(480, 56, 98, 23);

		JLabel lblTelefone = new JLabel();
		lblTelefone.setText("Tel.: ");
		lblTelefone.setBounds(410, 184, 77, 23);
		txtTelefone = new JTextField();
		try {
			javax.swing.text.MaskFormatter tl = new javax.swing.text.MaskFormatter("(##)####-####");
			txtTelefone = new javax.swing.JFormattedTextField(tl);
		} catch (Exception e) {
		}
		txtTelefone.setBounds(440, 184, 138, 23);

		txtRg = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##.###.###-#");
			txtRg = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtRg.setBounds(103, 92, 170, 23);

		txtCpf = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCpf.setBounds(400, 92, 178, 23);

		// cria as instancias de endereço ------------------------ endereço ---------
		JLabel lblEndereço = new JLabel();
		lblEndereço.setText(
				"-------------------------------------------------------------    ENDEREÇO   -----------------------------------------------------------");
		lblEndereço.setBounds(10, 120, 800, 23);

		JLabel lblRua = new JLabel();
		lblRua.setText("Logradouro: ");
		lblRua.setBounds(10, 148, 80, 23);
		txtRua = new JTextField();
		txtRua.setBounds(86, 148, 230, 23);

		JLabel lblNumero = new JLabel();
		lblNumero.setText("N°: ");
		lblNumero.setBounds(320, 148, 40, 23);

		txtNumero = new JTextField();

		txtNumero.setBounds(344, 148, 50, 23);

		JLabel lblCep = new JLabel();
		lblCep.setText("Cep: ");
		lblCep.setBounds(285, 184, 30, 23);
		txtCep = new JTextField();
		txtCep = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("#####-###");
			txtCep = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCep.setBounds(320, 184, 74, 23);

		JLabel lblComplemento = new JLabel();
		lblComplemento.setText("Comp.: ");
		lblComplemento.setBounds(400, 148, 60, 23);
		txtComplemento = new JTextField();
		txtComplemento.setBounds(445, 148, 133, 23);

		JLabel lblBairro = new JLabel();
		lblBairro.setText("Bairro: ");
		lblBairro.setBounds(10, 184, 50, 23);
		txtBairro = new JTextField();
		txtBairro.setBounds(55, 184, 220, 23);

//cria as instancias de senha

		JLabel lblSenha = new JLabel();
		lblSenha.setText("Insira a senha:");
		lblSenha.setBounds(10, 256, 100, 23);
		txtSenha = (JPasswordField) new JPasswordField();
		txtSenha.setBounds(100, 256, 160, 23);

		JLabel lblSenha2 = new JLabel();
		lblSenha2.setText("Version 0.1 - Dev. André Nunes");
		lblSenha2.setBounds(300, 256, 200, 23);
		// txtSenha2 = new JTextField();
		// txtSenha2.setBounds(420, 256, 160, 23);

		// Configurações
		// ----------------------------------------------------------------------------------CFG

		// configurações do combo box (Cidade e Estados)
		// ---------------------------------------------------------------- Combo box
		JLabel lblEstado = new JLabel();
		lblEstado.setText("Selecione o Estado:");
		lblEstado.setBounds(340, 220, 150, 23);

		cboxEstado.setSelectedIndex(-1);
		cboxEstado.setBounds(460, 220, 117, 20);
		cboxEstado.setMaximumRowCount(10);

		JLabel lblCidade = new JLabel();
		lblCidade.setText("Selecione a Cidade:");
		lblCidade.setBounds(10, 220, 150, 20);

		cboxCidade.setSelectedIndex(-1);
		cboxCidade.setBounds(130, 220, 200, 20);
		cboxCidade.setMaximumRowCount(10);

		// Configurações da Radio Button
		// (Sexo)---------------------------------------------------------------- cfg
		// radio button
		JLabel lblSexo = new JLabel();
		lblSexo.setText("Selecione o sexo:");
		lblSexo.setBounds(10, 55, 100, 20);

		grpRadio = new ButtonGroup();
		grpRadio.add(rbtFeminino);
		grpRadio.add(rbtMasculino);

		rbtMasculino.setText("Masculino");
		rbtMasculino.setBounds(150, 56, 100, 20);

		rbtFeminino.setText("Feminino");
		rbtFeminino.setBounds(250, 56, 100, 20);

		// configurações do painel da tela ----------------------------------------- cfg
		// painel
		painelDaJanela.setLayout(null);
		// painelDaJanela.add(painel1);
		// painelDaJanela.add(painel2);

		// combo box
		painelDaJanela.setLayout(null);
		// painelDaJanela1.setBorder(BorderLayout.SOUTH);
		painelDaJanela.add(cboxEstado);
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(cboxCidade);
		painelDaJanela.add(lblCidade);

		// Radio button
		painelDaJanela.add(lblSexo);
		painelDaJanela.add(rbtFeminino);
		painelDaJanela.add(rbtMasculino);

		// Jtext
		painelDaJanela.add(lblMatricula);
		painelDaJanela.add(txtMatricula);
		painelDaJanela.add(lblNome);
		painelDaJanela.add(txtNome);
		painelDaJanela.add(lblData);
		// painelDaJanela.add(lblData2);
		painelDaJanela.add(txtData);
		painelDaJanela.add(lblRg);
		painelDaJanela.add(txtRg);
		painelDaJanela.add(lblCpf);
		painelDaJanela.add(txtCpf);
		painelDaJanela.add(lblSenha2);
		painelDaJanela.add(lblSenha);
		painelDaJanela.add(txtSenha);
		// painelDaJanela.add(txtSenha2);
		// Jtext endereço
		painelDaJanela.add(lblRua);
		painelDaJanela.add(txtRua);
		painelDaJanela.add(lblNumero);
		painelDaJanela.add(txtNumero);
		painelDaJanela.add(lblComplemento);
		painelDaJanela.add(txtComplemento);
		painelDaJanela.add(lblCep);
		painelDaJanela.add(txtCep);
		painelDaJanela.add(lblBairro);
		painelDaJanela.add(txtBairro);
		painelDaJanela.add(lblEndereço);
		painelDaJanela.add(lblTelefone);
		painelDaJanela.add(txtTelefone);

		// Botões
		painelDaJanela.add(btnSalvar);
		painelDaJanela.add(btnCancelar);

		// configurações da tela
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// janela.setLocationRelativeTo(null);
		janela.setSize(610, 400);
		janela.setVisible(true);

		// configuração dos botões

		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(300, 292, 290, 65);
		btnCancelar.addActionListener(new cancelarListenner());

		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(5, 292, 300, 65);
	    btnSalvar.addActionListener(new salvarListenner());

	}

	public class cancelarListenner implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Cadastro encerrado");
			janela.dispose();
		}
	}

	public class salvarListenner implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			AlunoController ac = new AlunoController();

			String txtSexo = " ";

			if (rbtMasculino.isSelected()) {
				txtSexo += "M";
			}
			if (rbtFeminino.isSelected()) {
				txtSexo += "F";
			}

			String city = (String) cboxCidade.getSelectedItem();
			String estate = (String) cboxEstado.getSelectedItem();

			String senha = new String(txtSenha.getPassword());
			
			//int numero =  Integer.parseInt(txtNumero.getText());

			ac.consistirDados(txtMatricula.getText(), txtNome.getText(), txtData.getText(), txtRua.getText(),
					 txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), city, estate, txtCep.getText(),
					txtSexo, txtRg.getText(), txtCpf.getText(), txtTelefone.getText(), senha);

		}
	}
}