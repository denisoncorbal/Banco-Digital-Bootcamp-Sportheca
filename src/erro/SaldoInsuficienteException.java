
public class SaldoInsuficienteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException() {
		super("O saldo � insuficiente para realizar a opera��o");
	}
	
}
