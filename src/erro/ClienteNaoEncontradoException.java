
public class ClienteNaoEncontradoException extends Exception {
	public ClienteNaoEncontradoException() {
		super("N�o foi encontado cliente com o c�digo informado");
	}
}
