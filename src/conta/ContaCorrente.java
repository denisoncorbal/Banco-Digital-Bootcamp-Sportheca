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
		
		this.saldo = this.saldo.add(d);
	}

	@Override
	public void sacar(BigDecimal d) throws SaldoInsuficienteException{
		if(this.limiteSaque <= 0) {
			d.add(this.taxaSaque);
			if(this.saldo.compareTo(d)==-1) {
				throw new SaldoInsuficienteException();
			}
			this.limiteSaque = 10;
		}
		if(this.saldo.compareTo(d)==-1) {
			throw new SaldoInsuficienteException();
		}
		this.saldo = this.saldo.add(d.negate());
	}

	@Override
	public void transferir(Conta c, BigDecimal v) throws SaldoInsuficienteException{
		BigDecimal deposito = new BigDecimal(v.toString());
		v = v.add(this.taxaTransferencia);
		if(this.saldo.compareTo(v)==-1) {
			throw new SaldoInsuficienteException();
		}
		this.saldo = this.saldo.add(v.negate());
		c.saldo = c.saldo.add(deposito);
	}

	@Override
	protected void imprimirExtrato() {
		System.out.println("Tipo: Conta Corrente");
		System.out.println("Agência: " + this.agencia);
		System.out.println("Conta: " + this.conta);
		System.out.println("Saldo: " + this.saldo);
		
	}

}