import Controller.AlunoController;
//import Controller.ProfessorController;
import View.AlunoView;

public class Main {

	public static void main(String[] args) {
		
//		ProfessorController Professor = new ProfessorController();
//		Professor.testeProfessor();
		
		AlunoController alunoController = new AlunoController();
		alunoController.inserirAluno();
		alunoController.listarTodos();
		alunoController.listarAniversariante(0);
		new AlunoView();

	}

}
