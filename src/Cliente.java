import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {	
	

	protected static int CODIGO_SEQUENCIAL = 1;
	
	protected int codigo;
	protected String nome;
	protected String documento;
	protected int senha;
	protected List<Conta> contas = new ArrayList<Conta>();
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", documento=" + documento + ", senha=" + senha
				+ ", contas=" + contas + "]";
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
}
