package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import Model.Aluno;
import Model.Cidade;
import Model.Data;
import Model.Endereço;
import Model.Estado;
import Model.Funcionario;
import View.FuncionarioView;

public class FuncionarioController {
	
	public void consistirDados( String nome, String dataNascimento, String rua, String numero,
			String complemento, String bairro, String cidade, String estado, String cep,  String rg,
			String cpf, String telefone, String salario) {
		
		Funcionario funcionario = new Funcionario();
		Endereço endereço = new Endereço();
		
		int trfNumero = Integer.parseInt(numero);
		
		String dataQuebrada[] = dataNascimento.split("/");
		int dia = Integer.parseInt(dataQuebrada[0]);
		int mes = Integer.parseInt(dataQuebrada[1]);
		int ano = Integer.parseInt(dataQuebrada[2]);
		Data dt = new Data(dia, mes, ano);
		
		
		

		
		funcionario.setNome(nome);
		funcionario.setDataNascimento(dt);
		endereço.setLogradouro(rua);
		endereço.setNumero(trfNumero);
		endereço.setComplemento(complemento);
		endereço.setBairro(bairro);
		Cidade cid = new Cidade(cidade);
		endereço.setCidade(cid);
		Estado est = new Estado();
		est.setNome(estado); //não esquecer do uf
		endereço.setEstado(est);
		endereço.setCep(cep);
		
		funcionario.setRg(rg);
		funcionario.setCpf(cpf);
		funcionario.setTelefone(telefone);
	
		
		funcionario.setEndereço(rua,numero,complemento,bairro,cidade,estado,cep);
	
		inserirFuncionario(funcionario);
		
	}
	
	public void inserirFuncionario(Funcionario funcionario) {
		

		try {

			File arquivo = new File("funcionario.txt");
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			// matricul
			
			gravador.print(funcionario.getNome());
			gravador.print(";");
			gravador.print(funcionario.getEndereço());
			gravador.print(";");
			gravador.print(funcionario.getRg());
			gravador.print(";");
			gravador.print(funcionario.getCpf());
			gravador.print(";");
			gravador.print(funcionario.getTelefone());
			gravador.print(";");
			gravador.print(funcionario.getSalario());
			gravador.print(";");

			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	
	
	

}


