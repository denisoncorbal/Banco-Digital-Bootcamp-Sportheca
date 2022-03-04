
public class SaldoInsuficienteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException() {
		super("O saldo é insuficiente para realizar a operação");
	}
	
}
