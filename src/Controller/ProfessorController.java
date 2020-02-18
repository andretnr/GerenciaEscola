package Controller;

import Model.Professor;

public class ProfessorController {
	
	public void testeProfessor() {
		
		Professor p1 = new Professor();
		p1.setNome("Bruna");
		p1.setCpf("123.456.789-35");
		p1.setSalario(20000);
		p1.exibe();
	}

	
	
}
