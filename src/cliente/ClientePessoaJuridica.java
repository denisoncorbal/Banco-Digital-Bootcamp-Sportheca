public class ClientePessoaJuridica extends Cliente {
	public ClientePessoaJuridica() {
		this.codigo = Cliente.CODIGO_SEQUENCIAL++;
	}

	@Override
	protected void imprimirExtrato(Conta con) {
		System.out.println("Extrato");
		System.out.println("Código: " + this.codigo);
		System.out.println("Cliente: " + this.nome);
		System.out.println("CNPJ: " + this.documento);
		con.imprimirExtrato();
	}
	
	
}
