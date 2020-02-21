package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView {

	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menuCadastro;
	private JMenu menuRelatorio;
	private JMenuItem cadastroAluno;
	private JMenuItem cadastroFuncionario;
	private JMenuItem cadastroCidade;
	private JMenuItem cadastroEstado;
	private JMenuItem relatorioAluno;
	private JMenuItem relatorioFuncionario;
	private JPanel painelDaJanela;
	
	
	public void iniciaGui() {
		
		//criar as instancias
		janela = new JFrame("Exemplo de menu");
		barraMenu = new JMenuBar();
		menuCadastro = new JMenu("Cadastro");
		menuRelatorio = new JMenu("Relat�rio");
		cadastroAluno = new JMenuItem("Cadastro de alunos");
		cadastroFuncionario = new JMenuItem("Cadastro de Funcion�rios");
		cadastroCidade = new JMenuItem("Cadastro de Cidades");
		cadastroEstado = new JMenuItem("Cadastro de Estados");
		relatorioAluno = new JMenuItem("Relat�rio de Alunos");
		relatorioFuncionario = new JMenuItem("Relat�rio de Funcion�rios");
		
		painelDaJanela = (JPanel) janela.getContentPane();
		
		//acresentar menus na barra de menu 
		barraMenu.add(menuCadastro);
		barraMenu.add(menuRelatorio);
		
		//acresentar itens de menu nos menus
		menuCadastro.add(cadastroAluno);
		menuCadastro.add(cadastroFuncionario);
		menuCadastro.add(cadastroCidade);
		menuCadastro.add(cadastroEstado);
		menuRelatorio.add(relatorioFuncionario);
		menuRelatorio.add(relatorioAluno);
		
		//configura��es do painel da tela
		painelDaJanela.setLayout(null);
		
		
		//configura��es da tela
		janela.setJMenuBar(barraMenu);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(500, 500);
		janela.setVisible(true);
		
		
		
		
		
		
		//Configurar a a��o do item menu 1
		cadastroAluno.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new AlunoView().iniciaGui();
				
			}
			
			
			
		});
		
		//Configurar a a��o do item menu 2
	//	cadastroFuncionario.addActionListener(new ActionListener() {
			
		//	public void actionPerformed(ActionEvent e) {
				
				
			}
			
			
			
	//	});

		
		
		
		
		
		
		
		
			}
	
	
	
//}


