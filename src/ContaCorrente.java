
public class ContaCorrente {
	private int numConta;
	private int saldo;
		
	public ContaCorrente(int numConta, int saldo){
		this.numConta = numConta;
		this.saldo = saldo;
	}
	
	public int getnumConta(){
		return numConta;
	}
	
	public int getSaldo(){
		return saldo;
	}
	
	public void setSaldo(int saldo){
		this.saldo=saldo;
	}
}
