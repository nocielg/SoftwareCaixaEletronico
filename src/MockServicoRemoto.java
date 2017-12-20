import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;


public class MockServicoRemoto implements ServicoRemoto{
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	private MockHardware mockHardware = new MockHardware();
	
	public void setContaCorrente(ContaCorrente conta){
		contas.add(conta);
	}
	
	@Override
	public ContaCorrente recuperarConta(int numConta) {
		for(ContaCorrente conta: contas){
			if(conta.getnumConta()==numConta)
					return conta;
		}	
		return null;	
	}
	
	@Override
	public void persistirConta(int numeroConta, int saldo){
		ContaCorrente conta = recuperarConta(numeroConta);
		conta.setSaldo(saldo);
	}
		//
	@Test
	public void testeRecuperaConta(){
		ContaCorrente conta;
		conta =  recuperarConta(3);
		assertNull(conta);
				
	}
	
	@Test
	public void testepersistirConta() throws NumberFormatException, ErroNumeroDaContaException{
		//Testando também a integração do mock do hardware com o serviço remoto.
		int numeroConta = Integer.parseInt(mockHardware.pegarNumeroDaContaCartao());
		setContaCorrente(new ContaCorrente(numeroConta,10));
		ContaCorrente conta = recuperarConta(1);
		persistirConta(1,13);
		assertEquals(conta.getSaldo(),13);	
	}
	
}
