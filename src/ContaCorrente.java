import java.math.BigDecimal;

public class ContaCorrente extends Conta{
	
	public ContaCorrente() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.conta = Conta.CONTA_SEQUENCIAL++;
		this.limiteSaque = 10;
		this.taxaSaque = new BigDecimal("10.00");
		this.taxaTransferencia = new BigDecimal("10.00");
		this.saldo = new BigDecimal("0.0");
	}

	@Override
	public void depositar(BigDecimal d) {
		
		this.setSaldo(this.getSaldo().add(d));
	}

	@Override
	public void sacar(BigDecimal d) {
				
		this.setSaldo(this.getSaldo().add(d.negate()));
	}

	@Override
	public void transferir(Conta c, BigDecimal v) {
		
		this.setSaldo(this.getSaldo().add(v.negate()));
		c.setSaldo(c.getSaldo().add(v));
	}

}
