

public class CaixaEletronico {

	private ContaCorrente conta; 
	private MockHardware mockHardware = new MockHardware();
	
	public ContaCorrente logar(int numConta, MockServicoRemoto mock) {
		conta = mock.recuperarConta(numConta);
		if (conta == null){
			System.out.println("Não foi possível autenticar o usuário");
			
		}
		else{
			System.out.println("Usuário autenticado");
			
		}
		return conta;
	}

	
	public String sacar(int numConta, MockServicoRemoto mock, int dinheiroSacado) throws ErroAoEntregaroDinheiroException {
		ContaCorrente conta = mock.recuperarConta(numConta);
		int saldo=0;
		if (dinheiroSacado <= conta.getSaldo()){
			mockHardware.entregarDinheiro();
			saldo = conta.getSaldo();
			saldo=saldo-dinheiroSacado;
			mock.persistirConta(numConta, saldo);
			return "Retire seu dinheiro";
		}
		return "Saldo insuficiente";
			
	}
	
	
	public String depositar(int numConta, MockServicoRemoto mock, int dinheiroDepositado) throws ErroAoLerEnvelopeException {
		ContaCorrente conta = mock.recuperarConta(numConta);
		int saldo=0;
		saldo=conta.getSaldo();
		saldo=saldo+dinheiroDepositado;
		if (dinheiroDepositado>0){
			mockHardware.lerEnvelope();
			mock.persistirConta(numConta, saldo);
			return "Depósito recebido com sucesso";
		}
		return "Não é possível realizar o depósito se você não possuir o dinheiro";
		
		
	}
	
	public String saldo(int numConta, MockServicoRemoto mock) {
		ContaCorrente conta = mock.recuperarConta(numConta);
		return "O saldo da conta é R$," + conta.getSaldo();
	}
}
