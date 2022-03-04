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
	
	public abstract void depositar(BigDecimal d);
	
	public abstract void sacar(BigDecimal d) throws SaldoInsuficienteException;
	
	public abstract void transferir(Conta c, BigDecimal v) throws SaldoInsuficienteException;

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
		
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", limiteSaque=" + limiteSaque + ", taxaSaque=" + taxaSaque
				+ ", taxaTransferencia=" + taxaTransferencia + ", agencia=" + agencia + ", conta=" + conta
				+ "]";
	}

	protected abstract void imprimirExtrato();
}
	