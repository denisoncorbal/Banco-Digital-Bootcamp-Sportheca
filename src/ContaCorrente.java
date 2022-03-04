import java.math.BigDecimal;

public class ContaCorrente extends Conta{
	
	public ContaCorrente() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.conta = Conta.CONTA_SEQUENCIAL++;
		this.limiteSaque = 10;
		this.taxaSaque = new BigDecimal("10.00");
		this.taxaTransferencia = new BigDecimal("10.00");
	}

	@Override
	public void depositar(BigDecimal d) {
		// TODO Auto-generated method stub
		this.saldo.add(d);
	}

	@Override
	public void sacar(BigDecimal d) {
		// TODO Auto-generated method stub		
		this.saldo.add(d.negate());
	}

	@Override
	public void transferir(Conta c, BigDecimal v) {
		// TODO Auto-generated method stub
		this.saldo.add(v.negate());
		c.saldo.add(v);
	}


}
