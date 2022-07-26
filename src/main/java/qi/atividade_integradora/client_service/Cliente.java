package qi.atividade_integradora.client_service;

import java.util.InputMismatchException;
import java.util.Scanner;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class Cliente {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Scanner scanner = new Scanner(System.in);
		boolean continuacao = true;
		do {
			System.out.flush();
			System.out.printf("\n----Escolha uma opção----"
					+ "\n\t1 - Listar todos os alunos."
					+ "\n\t2 - Buscar aluno por ID."
					+ "\n\tQualquer outro - Sair"
					+ "\n\tEscolha: ");
			try {
				int choice = scanner.nextInt();
				if(choice==1) {
					WebTarget target = client.target("http://localhost:8080/aluno/getallalunos");
					Invocation.Builder inBuilder = target.request();
					Response response = inBuilder.get();
					System.out.println("\n" + response.readEntity(String.class));
				}else if(choice==2) {
					System.out.println("Digite o ID: ");
					int id = scanner.nextInt();
					WebTarget target = client.target("http://localhost:8080/aluno/getalunobyid/" + id + "");
					Invocation.Builder inBuilder = target.request();
					Response response = inBuilder.get();
					System.out.println("\n" + response.readEntity(String.class));
				}else {
					continuacao=false;
					System.out.println("\n\tSaindo do software."
							+ "\nDesenvolvido por Cássio Corrêa "
							+ "como atividade integradora da cadeira de "
							+ "SERVIÇOS PARA WEB E OBJETOS DISTRIBUÍDOS");
				}
			} catch (InputMismatchException e) {
				continuacao=false;
				System.out.println("Saindo do software."
						+ "\n\tDesenvolvido por Cássio Corrêa "
						+ "como atividade integradora da cadeira de "
						+ "SERVIÇOS PARA WEB E OBJETOS DISTRIBUÍDOS.");
			}
		}while(continuacao==true);
		
	}

}
