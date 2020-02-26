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



public class EstadoView {
	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JTable tabela;
	private String[] colunas = new String [] {"uf", "Estado"};
	private String[][] dados = new String[] []{
			{"SP", "São Paulo"},
			{"RJ", "Rio de Janeiro"},
			{"RN", "Rio Grande do Norte"},
			{"PR", "Paraná"}};
	private JLabel lbIncluirUf;
	private JLabel lbIncluirEstado;
	private JTextField jtfIncluirUf;
	private JTextField jtfIncluirEstado;
	private JButton btnIncluir;
	private JButton btnExcluir;
	private JScrollPane painelDeScroll;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	public void iniciarGui(){
		janela = new JFrame("Cadastrar Estados");
		lbIncluirUf = new JLabel("Informe UF:");
		lbIncluirEstado = new JLabel("Informe Estado:");
		jtfIncluirUf = new JTextField();
		jtfIncluirEstado = new JTextField();
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
		
		//Inserindo a tabela em um painel de scroll
		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		painelDeScroll.setBounds(10, 100, 360, 95);
		tabela.setBounds(10, 30, 300, 95);
		btnIncluir.setBounds(75, 70, 100, 25);
		btnExcluir.setBounds(195, 70, 100, 25);
		lbIncluirUf.setBounds(10, 10, 70, 25);
		lbIncluirEstado.setBounds(10, 35, 90, 25);
		jtfIncluirUf.setBounds(110, 10, 50, 25);
		jtfIncluirEstado.setBounds(110, 35, 260, 25);
		btnSalvar.setBounds(75, 200, 100, 50);
		btnCancelar.setBounds(195, 200, 100, 50);
		
		
		btnIncluir.addActionListener(new ListenerbtnIncluir());
		btnExcluir.addActionListener(new ListenerbtnExcluir());
		
		
		
		painelDaJanela.add(lbIncluirUf);
		painelDaJanela.add(lbIncluirEstado);
		painelDaJanela.add(jtfIncluirUf);
		painelDaJanela.add(jtfIncluirEstado);
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
		if ((jtfIncluirUf.getText().equals("")) || (jtfIncluirEstado.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "Campo UF e Estado obrigatório!");
		}else {
			//pega o mdelo da jtable
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			//Adiciona linha no modelo
			jtfIncluirUf.setText("");
			jtfIncluirEstado.setText("");
			modelo.addRow(new String[] {jtfIncluirUf.getText().toUpperCase(), jtfIncluirEstado.getText()});
			JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso!");
		}
	}
	
	
	public void removeLinhaSelecionada(){
		
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
