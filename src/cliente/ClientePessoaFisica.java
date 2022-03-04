public class ClientePessoaFisica extends Cliente {
	public ClientePessoaFisica() {
		this.codigo = Cliente.CODIGO_SEQUENCIAL++;
	}

	@Override
	protected void imprimirExtrato(Conta con) {
		System.out.println("Extrato");
		System.out.println("Código: " + this.codigo);
		System.out.println("Cliente: " + this.nome);
		System.out.println("CPF: " + this.documento);
		con.imprimirExtrato();
	}
}
