
public class ContaNaoEncontradaException extends Exception {
	public ContaNaoEncontradaException() {
		super("Não foi possível encontrar a conta com a agência e número informados");
	}
}
