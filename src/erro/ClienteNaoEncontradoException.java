
public class ClienteNaoEncontradoException extends Exception {
	public ClienteNaoEncontradoException() {
		super("Não foi encontado cliente com o código informado");
	}
}
