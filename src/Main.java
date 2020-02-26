import javax.swing.UIManager;

import Controller.AlunoController;
//import Controller.ProfessorController;
import View.AlunoView;
import View.CidadeView;
import View.EstadoView;
import View.FuncionarioView;
import View.MenuView;
import View.RelatorioAlunoView;

public class Main {

	public static void main(String[] args) {
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception e) {
			e.printStackTrace();
	}
		
		//inicializado principal
	//	 new MenuView().iniciaGui();

		
//		ProfessorController Professor = new ProfessorController();
//		Professor.testeProfessor();
		
//		AlunoController alunoController = new AlunoController();
//		alunoController.inserirAluno();
//		alunoController.listarTodos();
//		alunoController.listarAniversariante(0);
	//	new AlunoView().iniciaGui();
	//  new FuncionarioView().iniciaGui();
	//	 new CidadeView().iniciaGui();
	//	new RelatorioAlunoView().iniciaGui();
	    new EstadoView().iniciarGui();

	}

}
