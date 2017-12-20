import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;


public class MockServicoRemoto implements ServicoRemoto{
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	
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
		
	@Test
	public void testeRecuperaConta(){
		ContaCorrente conta;
		conta =  recuperarConta(3);
		assertNull(conta);
				
	}
	
	@Test
	public void testepersistirConta(){
		setContaCorrente(new ContaCorrente(3,10));
		ContaCorrente conta = recuperarConta(3);
		persistirConta(3,13);
		assertEquals(conta.getSaldo(),13);	
	}
	
}
