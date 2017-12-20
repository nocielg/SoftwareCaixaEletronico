import static org.junit.Assert.*;


import org.junit.Test;

public class TestaCaixaEletronico {
	CaixaEletronico caixaEletronico = new CaixaEletronico();
	MockServicoRemoto mock = new MockServicoRemoto();
	ContaCorrente conta;
	
	@Test
	public void testaLogarNaoFunciona() {
		 assertEquals(caixaEletronico.logar(12, mock),null);
	}
	/*	
	@Test
	public void testaLogarFunciona() {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		assertSame(caixaEletronico.logar(2, mock), conta);
	}*/
	
	
	@Test
	public void testaSacarFunciona() {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.sacar(2, mockServico, 9),"Retire seu dinheiro");
	}
	
	@Test
	public void testaSacarNaoFunciona() {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.sacar(2, mockServico, 1000),"Saldo insuficiente");
	}
	
	@Test
	public void testaDepositarFunciona() {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.depositar(2, mockServico, 13), "Depósito recebido com sucesso");
	}
	
	@Test
	public void testaDepositarNaoFunciona() {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.depositar(2, mockServico, -13), "Não é possível realizar o depósito se você não possuir o dinheiro");
	}
		
	@Test
	public void testaSaldo() {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(1,1000);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(1, mockServico);
		assertEquals(caixaEletronico.saldo(1, mockServico), "O saldo da conta é R$,1000");
	}
}
