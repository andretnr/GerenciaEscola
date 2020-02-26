package Model;

public class Professor extends Funcionario {
	
	private String id = "1";
private String materia;
public Professor(String id, String materia) {
	
	this.id = id;
	this.materia = materia;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMateria() {
	return materia;
}
public void setMateria(String materia) {
	this.materia = materia;
}




}
