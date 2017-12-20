import org.junit.Test;
import static org.junit.Assert.*;

public class TestaContaCorrente {
	ContaCorrente contaCorrente = new ContaCorrente(1, 10);
	
	@Test
	public void retornoNumeroContaCorrente(){
		assertEquals(contaCorrente.getnumConta(),1);
	}
	
	@Test
	public void retornoSaldoContaCorrente(){
		assertEquals(contaCorrente.getSaldo(),10);
	}
	
	
}
