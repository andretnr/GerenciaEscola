package Model;

public class Funcionario {
	
	
	
	private String nome;

	
	private String rg;
	private String cpf;
	private Data dataNascimento;
	private Endere�o endere�o;
	private String telefone;
	private String salario;
	

	public Funcionario() {
				
		
	}

	public Funcionario(String nome, String rg, String cpf, Data dataNascimento, Endere�o endere�o, String telefone,
			String salario, String materia, String ramal, String periodo) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endere�o = endere�o;
		this.telefone = telefone;
		this.salario = salario;
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endere�o getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(Endere�o endere�o) {
		this.endere�o = endere�o;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	


	
	
}
