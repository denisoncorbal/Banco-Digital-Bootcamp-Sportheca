
public class ContaNaoEncontradaException extends Exception {
	public ContaNaoEncontradaException() {
		super("N�o foi poss�vel encontrar a conta com a ag�ncia e n�mero informados");
	}
}
