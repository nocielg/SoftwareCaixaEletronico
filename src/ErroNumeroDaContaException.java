
public class ErroNumeroDaContaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String mensagem(){
		return "O número da conta é inválido.";
	}
}
