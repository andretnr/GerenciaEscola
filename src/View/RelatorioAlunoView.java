package View;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RelatorioAlunoView {
	
	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JScrollPane jspLista;
//	private String[] colunas = new String [] {};
//	private String[][] dados = new String[] []{listarTodos()};
    private JButton ok;
    
    public void iniciaGui() {
    	
    	//instancias da tela
    	janela = new JFrame("Relatorio de Alunos");
    	painelDaJanela = new JPanel();
    	ok = new JButton("OK");    	
    	
    	//cfg da tela
    	
    	
    	
    	
    	ok.setBounds(200, 200, 100, 50);
    	
    	painelDaJanela = (JPanel) janela.getContentPane();
		painelDaJanela.setLayout(null);
		painelDaJanela.add(jspLista);
		painelDaJanela.add(ok);
		
		
		
		jspLista.setBounds(10, 20, 200, 300);
		jspLista.add(listarTodos());
    	
    	janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
    	
    	
    }
    
	public  Component listarTodos() {

		try {
			FileInputStream is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				String dados[] = texto.split(";");
				System.out.println("Matricula do aluno: " + dados[0]);
				System.out.println("Nome do aluno:      " + dados[1]);
				System.out.println("Data de nascimento: " + dados[2]);
				System.out.println("Sexo do aluno:      " + dados[3]);
				System.out.println("RG do aluno:        " + dados[4]);
				System.out.println("CPF do aluno:       " + dados[5]);
				System.out.println("Endereço do aluno:  " + dados[6]);
				System.out.println("Telefone do aluno:  " + dados[7]);
				System.out.println("Senha do aluno:     " + dados[8]);
				System.out.println("\n");

				texto = leitor.readLine();
				leitor.close();
			}

		} catch (FileNotFoundException e) {
			System.out.println("arquivo de entrada não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jspLista;
	}

}
