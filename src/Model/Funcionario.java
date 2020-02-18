package Model;

public class Funcionario {

	public Funcionario() {
System.out.println("Funcion�rio criado");

	}

	// Parametros
	private String nome;
	private String cpf;
	private double salario;

	public String getNome() {
		return nome;
	}

	public Funcionario(String nome, String cpf, double salario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void exibe() {

		System.out.println("Nome do funcion�rio:    "+nome);
		System.out.println("CPF do funcion�rio:     "+cpf);
		System.out.println("Sal�rio do funcion�rio: "+salario);

	}

}
