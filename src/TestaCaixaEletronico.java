import static org.junit.Assert.*;


import org.junit.Test;

public class TestaCaixaEletronico {
	CaixaEletronico caixaEletronico = new CaixaEletronico();
	MockServicoRemoto mock = new MockServicoRemoto();
	ContaCorrente conta;
	MockHardware mockHardware = new MockHardware();
	@Test
	public void testaLogarNaoFunciona() throws NumberFormatException, ErroNumeroDaContaException {
		//Pegando o número do cartão a partir do hardware.
		int numeroConta = Integer.parseInt(mockHardware.pegarNumeroDaContaCartao());
		assertEquals(caixaEletronico.logar(numeroConta, mock),null);
	}
	
	
	@Test
	public void testaSacarFunciona() throws ErroAoEntregaroDinheiroException {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.sacar(2, mockServico, 9),"Retire seu dinheiro");
	}
	
	@Test
	public void testaSacarNaoFunciona() throws ErroAoEntregaroDinheiroException {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.sacar(2, mockServico, 1000),"Saldo insuficiente");
	}
	
	@Test
	public void testaDepositarFunciona() throws ErroAoLerEnvelopeException {
		MockServicoRemoto mockServico = new MockServicoRemoto();
		ContaCorrente conta1 = new ContaCorrente(2,10);
		mockServico.setContaCorrente(conta1);
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.logar(2, mockServico);
		assertEquals(caixaEletronico.depositar(2, mockServico, 13), "Depósito recebido com sucesso");
	}
	
	@Test
	public void testaDepositarNaoFunciona() throws ErroAoLerEnvelopeException {
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
