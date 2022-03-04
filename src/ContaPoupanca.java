import java.math.BigDecimal;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.conta = Conta.CONTA_SEQUENCIAL++;
		this.limiteSaque = 5;
		this.taxaSaque = new BigDecimal("5.00");
		this.taxaTransferencia = new BigDecimal("5.00");
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
