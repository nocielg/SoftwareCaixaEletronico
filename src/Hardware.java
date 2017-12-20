import java.lang.Exception;


public interface Hardware {
	public String pegarNumeroDaContaCartao() throws ErroNumeroDaContaException;
	public void entregarDinheiro() throws ErroAoEntregaroDinheiroException;
	public void lerEnvelope() throws ErroAoLerEnvelopeException;
	
}
