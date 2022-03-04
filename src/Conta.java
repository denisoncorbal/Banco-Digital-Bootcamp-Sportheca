import java.math.BigDecimal;

public abstract class Conta {
	protected static final int AGENCIA_PADRAO = 1;
	
	protected static int CONTA_SEQUENCIAL = 1;
	
	protected BigDecimal saldo;
	
	protected int limiteSaque;
	
	protected BigDecimal taxaSaque;
	
	protected BigDecimal taxaTransferencia;
	
	protected int agencia;
	
	protected int conta;
	
	protected Cliente cliente;
	
	public abstract void depositar(BigDecimal d);
	
	public abstract void sacar(BigDecimal d);
	
	public abstract void transferir(Conta c, BigDecimal v);
}
	