
public class Main {
	
	private static Banco banco = new Banco();

	public static void main(String[] args) {	
		int opcao = 0;
		do {
			inicio();
			try{
				opcao = System.in.read();
				switch(opcao) {
					case 1: {
						cadastrarCliente();
						break;
					}
					
					case 2: {
						abrirConta();
						break;
					}
					
					case 3: {
						fazerSaque();
						break;
					}
					
					case 4: {
						fazerDeposito();
						break;
					}
					
					case 5:{
						fazerTransferencia();
						break;
					}
				}		
			}
			catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}while(opcao != 0);
		
	}
	
	private static void inicio() {
		System.out.println();
		System.out.println("Bem vindo ao " + banco.getNome());
		System.out.println();
		System.out.println("Escolha uma opção: ");
		System.out.println();
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Abrir conta");
		System.out.println("3 - Fazer saque");
		System.out.println("4 - Fazer depósito");
		System.out.println("5 - Fazer transferência");
		System.out.println();
	}
	
	private static void fazerTransferencia() {
		// TODO Auto-generated method stub
		
	}

	private static void fazerDeposito() {
		// TODO Auto-generated method stub
		
	}

	private static void fazerSaque() {
		// TODO Auto-generated method stub
		
	}

	private static void abrirConta() {
		// TODO Auto-generated method stub
		
	}

	private static void cadastrarCliente() {
		// TODO Auto-generated method stub
		
	}

	

}