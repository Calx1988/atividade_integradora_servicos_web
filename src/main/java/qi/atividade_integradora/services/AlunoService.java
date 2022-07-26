package qi.atividade_integradora.services;

import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import qi.atividade_integradora.entities.Aluno;

@Path("aluno")
public class AlunoService {
	
	static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();	
	
	@GET
	@Path("getallalunos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Aluno> getAll(){	
		return listaAlunos;
	}
	
	@GET
	@Path("getalunobyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno getAlunoById(@PathParam("id") int id) {
		for(Aluno aluno: listaAlunos) {
			if(aluno.getId()==id) return aluno;
		}
		return null;
	}
	
	 public static void popularLista() {		 	
	        listaAlunos.add(new Aluno(1, "Joao", "joao@joao.com",3));
	        listaAlunos.add(new Aluno(2, "Maria", "maria@maria.com",1));
	        listaAlunos.add(new Aluno(3, "Jose", "jose@mariajoao.com",2));
	        listaAlunos.add(new Aluno(4, "Pedro", "pedro@email.com",1));
	        listaAlunos.add(new Aluno(5, "Cassio", "cassio@email.com",3));
	        listaAlunos.add(new Aluno(6, "Natalia", "natalia@email.com",2));
	    	}

}
