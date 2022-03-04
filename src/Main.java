import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
	
	private static Banco banco = new Banco();
	
	private static Scanner scan = new Scanner(System.in);
	
	private static Logger logger = Logger.getLogger("BancoLog");

	public static void main(String[] args) {	
		openLogFile();
		int opcao = 0;
		do {
			inicio();
			try{
				opcao = Integer.parseInt(scan.nextLine());
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
				logger.warning(e.getMessage());
				e.printStackTrace();
				closeLogFile();
				System.exit(1);
			}
		}while(opcao != 0);
		closeLogFile();
		System.exit(0);
	}
	
	private static void closeLogFile() {
		for(Handler handler : logger.getHandlers()) {
			handler.close();
		}
		
	}

	private static void openLogFile() {
		
		FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("src/resources/ArquivoDeLog.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.info("Teste de log");

        } catch (SecurityException e) {
            logger.info("Exception:" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.info("IO Exception:" + e.getMessage());
            e.printStackTrace();
        }
        logger.info("Início do Log");
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
		System.out.println();
		System.out.println("Bem vindo ao " + banco.getNome());
		System.out.println();
		System.out.println("Digite a agencia originaria: ");
		int agenciaOriginaria = Integer.parseInt(scan.nextLine());
		System.out.println("Digite o número da conta originaria: ");
		int contaOriginaria = Integer.parseInt(scan.nextLine());
		Conta conOriginaria = buscarConta(agenciaOriginaria, contaOriginaria); 
		Cliente c = buscarCliente(conOriginaria);
		System.out.println("Digite a agencia destinataria: ");
		int agenciaDestinataria = Integer.parseInt(scan.nextLine());
		System.out.println("Digite o número da conta destinataria: ");
		int contaDestinataria = Integer.parseInt(scan.nextLine());
		Conta conDestinataria = buscarConta(agenciaDestinataria, contaDestinataria);
		System.out.println();
		System.out.println("Digite o valor: ");		
		BigDecimal valor = new BigDecimal(scan.nextLine());
		
		System.out.println("Digite a senha: ");
		int senha = Integer.parseInt(scan.nextLine());
		if(c.getSenha() == senha) {
			logger.info("Tentativa de transferência da conta: " + conOriginaria.toString());
			logger.info("Tentativa de transferência para conta: " + conDestinataria.toString());
			logger.info("Saldo da conta originária antes da transferência: " + conOriginaria.getSaldo());
			logger.info("Saldo da conta destinatária antes da transferência: " + conDestinataria.getSaldo());
			conOriginaria.transferir(conDestinataria, valor);
			System.out.println();
			System.out.println("Transferência efetuada com sucesso");
			logger.info("Saldo da conta originária depois da transferência: " + conOriginaria.getSaldo());
			logger.info("Saldo da conta destinatária depois da transferência: " + conDestinataria.getSaldo());
		}
		else {
			
		}
		
	}

	private static void fazerDeposito() {
		System.out.println();
		System.out.println("Bem vindo ao " + banco.getNome());
		System.out.println();
		System.out.println("Digite a agencia: ");
		int agencia = Integer.parseInt(scan.nextLine());
		System.out.println("Digite o número da conta: ");
		int conta = Integer.parseInt(scan.nextLine());		
		Conta con = buscarConta(agencia, conta); 
		Cliente c = buscarCliente(con);
		System.out.println();
		System.out.println("Digite o valor: ");		
		BigDecimal valor = new BigDecimal(scan.nextLine());
		
		System.out.println("Digite a senha: ");
		int senha = Integer.parseInt(scan.nextLine());
		if(c.getSenha() == senha) {
			logger.info("Tentativa de depósito na conta: " + con.toString());
			logger.info("Saldo antes do depósito: " + con.getSaldo());
			con.depositar(valor);
			System.out.println();
			System.out.println("Depositó efetuado com sucesso");
			logger.info("Saldo após o depósito: " + con.getSaldo());
		}
		else {
			
		}
	}

	private static Cliente buscarCliente(Conta con) {
		for(Cliente c : banco.clientes) {
			for(Conta conta : c.contas) {
				if(conta.equals(con)) {
					return c;
				}
			}
		}
		
		return null;
	}

	private static void fazerSaque() {		
		System.out.println();
		System.out.println("Bem vindo ao " + banco.getNome());
		System.out.println();
		System.out.println("Digite a agencia: ");
		int agencia = Integer.parseInt(scan.nextLine());
		System.out.println("Digite o número da conta: ");
		int conta = Integer.parseInt(scan.nextLine());
		Conta con = buscarConta(agencia, conta); 
		Cliente c = buscarCliente(con);
		System.out.println();
		System.out.println("Digite o valor: ");		
		BigDecimal valor = new BigDecimal(scan.nextLine());
		
		System.out.println("Digite a senha: ");
		int senha = Integer.parseInt(scan.nextLine());
		if(c.getSenha() == senha) {
			logger.info("Tentativa de saque da conta: " + con.toString());
			logger.info("Saldo antes do saque: " + con.getSaldo());
			con.sacar(valor);
			System.out.println();
			System.out.println("Saque efetuado com sucesso");
			logger.info("Saldo após o saque: " + con.getSaldo());
			
		}
		else {
			
		}
		
	}

	private static Conta buscarConta(int agencia, int conta) {				
		for(Cliente c : banco.clientes) {
			for(Conta con : c.contas) {
				if(con.getAgencia() == agencia && con.getConta() == conta) {
					return con;
				}			
			}
		}
		
		return null;
	}

	private static void abrirConta() {		
		System.out.println();
		System.out.println("Bem vindo ao " + banco.getNome());
		System.out.println();
		System.out.println("Digite o código do cliente: ");		
		Cliente c = banco.clientes.get(Integer.parseInt(scan.nextLine())-1); 
		System.out.println();
		System.out.println("Escolha uma opção: ");		
		System.out.println("1 - Abrir conta corrente");
		System.out.println("2 - Abrir conta poupança");
		Conta con = null;
		int opcao = Integer.parseInt(scan.nextLine());
		switch(opcao) {
			case 1: {
				con = new ContaCorrente();
				break;
			}
			
			case 2: {
				con = new ContaPoupanca();
				break;
			}
		}
		c.contas.add(con);
		System.out.println();
		System.out.println("Conta aberta com sucesso");
		logger.info("Conta aberta: " + con.toString());
	}

	private static void cadastrarCliente() {		
		Cliente c = null;
		System.out.println();
		System.out.println("Bem vindo ao " + banco.getNome());
		System.out.println();
		System.out.println("Escolha uma opção: ");		
		System.out.println("1 - Cadastrar pessoa física");
		System.out.println("2 - Cadastrar pessoa jurídica");		
		int opcao = Integer.parseInt(scan.nextLine());
		switch(opcao) {
			case 1: {
				c = new ClientePessoaFisica();
				break;
			}
			
			case 2: {
				c = new ClientePessoaJuridica();
				break;
			}
		}
		System.out.println("Digite o nome do cliente: ");
		c.setNome(scan.nextLine());
		System.out.println();
		System.out.println("Digite o número do documento (CPF ou CNPJ)");
		c.setDocumento(scan.nextLine());	
		System.out.println("Cadastre uma senha numérica de 4 dígitos: ");
		c.setSenha(Integer.parseInt(scan.nextLine()));
		banco.clientes.add(c);
		System.out.println();
		System.out.println("Cliente cadastrado com sucesso");
		logger.info("Cliente cadastrado: " + c.toString());
	}

}