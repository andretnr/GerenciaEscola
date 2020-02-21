package Model;







public class Aluno {
	
	private String matricula;
	private String nome;
	private Data dataNascimento;
	private char sexo;
	private String rg;
	private String cpf;
	private Endere�o endere�o;
	private String telefone;
	private String senha;

	
	
	public Aluno() {
		
	}



	public Aluno(String matricula, String nome, Data dataNascimento, char sexo, String rg, String cpf,
			Endere�o endere�o, String telefone, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.rg = rg;
		this.cpf = cpf;
		this.endere�o = endere�o;
		this.telefone = telefone;
		this.senha = senha;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Data getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public char getSexo() {
		return sexo;
	}



	public void setSexo(char sexo) {
		this.sexo = sexo;
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



	public Endere�o getEndere�o() {
		return endere�o;
	}



	public void setEndere�o(String rua, String numero, String complemento, String bairro, String cidade, String estado,
			String cep) {
	
		
	}
	



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	
	
	
	

}
