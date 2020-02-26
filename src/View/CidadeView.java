package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;



public class CidadeView {
	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JTable tabela;
	private String[] colunas = new String [] {"Cidade"};
	private String[][] dados = new String[] []{
			{"Sampa"},
			{"Osasco"},{}};
	private JLabel lblIncluirCidade;
	private JLabel lbIncluirEstado;
	private JTextField txtIncluirCidade;
	private JTextField txtIncluirEstado;
	private JButton btnIncluir;
	private JButton btnExcluir;
	private JScrollPane painelDeScroll;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	
	public void iniciaGui(){
		
		//instancias 
		janela = new JFrame("Cadastrar Cidades");
		lblIncluirCidade = new JLabel("Informe a Cidade:");
	//	lbIncluirEstado = new JLabel("Informe Estado:");
		txtIncluirCidade = new JTextField();
//		txtIncluirEstado = new JTextField();
		btnIncluir = new JButton("INCLUIR");
		btnExcluir = new JButton("EXCLUIR");
		
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");
		
		painelDaJanela = (JPanel) janela.getContentPane();
		painelDaJanela.setLayout(null);
		
	
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
	
		tabela = new JTable(modelo);
		
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabela.setEnabled(true);
		
		//CFG da tabela -------------------------------------------------------------------
		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		painelDeScroll.setBounds(10, 75, 360, 115);
		tabela.setBounds(10, 30, 300, 95);
		btnIncluir.setBounds(75, 50, 100, 25);
		btnExcluir.setBounds(195, 50, 100, 25);
		lblIncluirCidade.setBounds(15, 20, 100, 25);
	//	lbIncluirEstado.setBounds(15, 55, 90, 25);
		txtIncluirCidade.setBounds(130, 20, 180, 25);
	//	txtIncluirEstado.setBounds(110, 55, 260, 25);
		btnSalvar.setBounds(20, 200, 150, 50);
		btnCancelar.setBounds(180, 200, 150, 50);
		
		btnIncluir.addActionListener(new ListenerbtnIncluir());
		btnExcluir.addActionListener(new ListenerbtnExcluir());
		
		painelDaJanela.add(lblIncluirCidade);
	//	painelDaJanela.add(lbIncluirEstado);
		painelDaJanela.add(txtIncluirCidade);
	//	painelDaJanela.add(txtIncluirEstado);
		painelDaJanela.add(painelDeScroll);
		painelDaJanela.add(btnIncluir);
		painelDaJanela.add(btnExcluir);
		painelDaJanela.add(btnSalvar);
		painelDaJanela.add(btnCancelar);
		
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	
	}
	
	public class ListenerbtnIncluir implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			adicionaLinha();
		}
	}
	

	public class ListenerbtnExcluir implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			removeLinhaSelecionada();
		}
	}
	

	public void adicionaLinha(){
		if ((txtIncluirCidade.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "Campo Cidade é Obrigatorio");
		}else {
			
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			
			txtIncluirCidade.setText("");
		//	txtIncluirEstado.setText("");
			modelo.addRow(new String[] {txtIncluirCidade.getText().toUpperCase()});
			JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso!");
		}
	}
	
	
	public void removeLinhaSelecionada(){
		//Obtem o modelo da JTable
		if (tabela.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha!");
		}else if (tabela.getSelectedRow() > 1) {
			JOptionPane.showMessageDialog(null, "Selecione apenas uma linha!");			
		}else{
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.removeRow(tabela.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
		}
	}
	
	
	

}
