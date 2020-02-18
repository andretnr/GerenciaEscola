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
import Model.Data;

public class AlunoController {

	public void inserirAluno() {

		Data data1 = new Data(18, 05, 1982);
		Aluno aluno1 = new Aluno(matricula, nome, data1, 'M');
	

		try {

			File arquivo = new File("aluno.txt");
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			// matricul
			gravador.print(aluno1.getMatricula());
			gravador.print(";");
			gravador.print(aluno1.getNome());
			gravador.print(";");
			gravador.print(aluno1.getDataNascimento());
			gravador.print(";");
			gravador.print(aluno1.getSexo());
			gravador.print("\n");


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