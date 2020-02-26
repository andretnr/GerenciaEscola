package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import Model.Aluno;
import Model.Cidade;
import Model.Data;
import Model.Endereço;
import Model.Estado;

public class AlunoController {

	public void consistirDados(String matricula, String nome, String dataNascimento, String rua, String numero,
			String complemento, String bairro, String cidade, String estado, String cep, String sexo, String rg,
			String cpf, String telefone, String senha) {

		//String endereçoCompleto = (rua+";"+numero+";"+complemento+";"+bairro+";"+cidade+";"+estado+";"+cep);
		//String endereçoCompleto1 = new String();
	
		
		
		Aluno aluno = new Aluno();
		Endereço endereço = new Endereço();
		
		int trfNumero = Integer.parseInt(numero);
		
		String dataQuebrada[] = dataNascimento.split("/");
		int dia = Integer.parseInt(dataQuebrada[0]);
		int mes = Integer.parseInt(dataQuebrada[1]);
		int ano = Integer.parseInt(dataQuebrada[2]);
		Data dt = new Data(dia, mes, ano);
		
		char sex = sexo.charAt(0);
		

		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setDataNascimento(dt);
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
		aluno.setSexo(sex);
		aluno.setRg(rg);
		aluno.setCpf(cpf);
		aluno.setTelefone(telefone);
		aluno.setSenha(senha);
		
		aluno.setEndereço(rua,numero,complemento,bairro,cidade,estado,cep);
	
		inserirAluno(aluno);
	}

	public void inserirAluno(Aluno aluno) {
		

		try {

			File arquivo = new File("aluno.txt");
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			// matricul
			gravador.print(aluno.getMatricula());
			gravador.print(";");
			gravador.print(aluno.getNome());
			gravador.print(";");
			gravador.print(aluno.getEndereço());
			gravador.print(";");
			gravador.print(aluno.getSexo());
			gravador.print(";");
			gravador.print(aluno.getRg());
			gravador.print(";");
			gravador.print(aluno.getCpf());
			gravador.print(";");
			gravador.print(aluno.getTelefone());
			gravador.print(";");
			gravador.print(aluno.getSenha());
			gravador.print(";");

			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void listarTodos() {

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
	}

	public void listarAniversariante(int mes) {
		FileInputStream is;
		try {
			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");

				String dataAniversario = dados[2];
				String dataQuebrada[] = dataAniversario.split("/");
				int mesCompara = Integer.parseInt(dataQuebrada[1]);

				if (mesCompara == mes) {

					System.out.println("Matricula do aluno: " + dados[0]);
					System.out.println("Nome do aluno:      " + dados[1]);
					System.out.println("Data de nascimento: " + dados[2]);
					System.out.println("Sexo do aluno:      " + dados[3]);
					System.out.println("\n");
				}
				texto = leitor.readLine();
				leitor.close();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}