import java.util.ArrayList;
import java.util.List;

public class Banco {		
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Banco(){
		this.nome = "Banco de Teste";
	}
}
