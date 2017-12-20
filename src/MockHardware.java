import org.junit.Test;
import java.lang.Exception.*;

public class MockHardware implements Hardware{

	private boolean falhaNumeroConta = false;
	private boolean falhaEntregaDinheiro = false;
	private boolean falhaLerEnvelope = false;
	private String conta = "1";
	
	public boolean retornaFalharNumConta(){
		return falhaNumeroConta;
	}
	
	public void setarFalharNumConta(boolean falhaNumeroConta){
		this.falhaNumeroConta = falhaNumeroConta;
	}
	
	public boolean retornafalhaEntregaDinheiro(){
		return falhaEntregaDinheiro;
	}
	
	public void setarfalhaEntregaDinheiro(boolean falhaEntregaDinheiro){
		this.falhaEntregaDinheiro = falhaEntregaDinheiro;
	}
	
	public boolean retornafalhaLerEnvelope(){
		return falhaLerEnvelope;
	}
	
	public void setarfalhaLerEnvelope(boolean falhaLerEnvelope){
		this.falhaLerEnvelope = falhaLerEnvelope;
	}
	
	@Override
	public String pegarNumeroDaContaCartao() throws ErroNumeroDaContaException {
		// TODO Auto-generated method stub
		if (this.retornaFalharNumConta()==true)
			throw new ErroNumeroDaContaException();
		return this.conta;
	}
	
	@Override
	public void entregarDinheiro() throws ErroAoEntregaroDinheiroException{
		// TODO Auto-generated method stub
		if(this.retornafalhaEntregaDinheiro()==true)
			throw new ErroAoEntregaroDinheiroException();
	}

	@Override
	public void lerEnvelope() throws ErroAoLerEnvelopeException{
		// TODO Auto-generated method stub
		if(this.retornafalhaLerEnvelope()){
			//throw new ErroAoLerEnvelopeException();
		}
		
	}
	
	@Test(expected = ErroNumeroDaContaException.class)
	public void numeroDaContaFalha() throws ErroNumeroDaContaException{
		this.setarFalharNumConta(true);
		this.retornaFalharNumConta();
		
	} 
	
	@Test
	public void numeroDaContaSucesso() throws ErroNumeroDaContaException{
		this.setarFalharNumConta(false);
		this.retornaFalharNumConta();
	}
		
	@Test(expected = ErroAoEntregaroDinheiroException.class)
	public void entregarDinheiroFalha() throws ErroAoEntregaroDinheiroException{
		this.setarfalhaEntregaDinheiro(true);
		this.retornafalhaEntregaDinheiro();
	}
	
	@Test
	public void entregarDinheiroSucesso() throws ErroAoEntregaroDinheiroException{
		this.setarfalhaEntregaDinheiro(false);
		this.retornafalhaEntregaDinheiro();
	}
	
	@Test(expected = ErroAoLerEnvelopeException.class)
	public void lerEnvelopeFalha() throws ErroAoLerEnvelopeException{
		this.setarfalhaLerEnvelope(true);
		this.retornafalhaLerEnvelope();
	}

	@Test
	public void lerEnvelopeSucesso() throws ErroAoLerEnvelopeException{
		this.setarfalhaLerEnvelope(false);
		this.retornafalhaLerEnvelope();
	}
	

}
