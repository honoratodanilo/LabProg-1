package principal;

/*
 * Aluno 01: Ivanildo Simpl�cio da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Fernanda Eduarda de Medeiros Silva
 */


/**
 * Classe que calcula a s�rie de Fibonacci.
 * @author Ivanildo/Vinicius/Fernanda
 * @version 1.1 Last modified 11/10/2017 14:10
 */
public class Fibonacci {
		
	private int termoAtual;
	
	/**
	 * Construtor padr�o da classe.
	 */
	public Fibonacci() {
		this.termoAtual = 1;
	}
	
	/**
	 * Gera n termos da s�rie. Caso seja passado um valor de n < 1 a s�rie exibir� o primeiro termo da s�rie e o mesmo
	 * se tornar� o termo atual.
	 * @param n o n�mero de termos que ser�o gerados na s�rie. 
	 * @return uma representa��o em String da s�rie. (formato: [termo1, termo2,...])
	 */
	public String geraTermos(int n) {
		termoAtual = n > 0 ? n : 1;
		StringBuilder fib = new StringBuilder();
		fib.append("[");
		int aux = 0, anterior = 1, atual = 1;
		for(int i = 1; i <= termoAtual; i++) {
			if(i <= 2) {
				fib.append("1");
			}else{
				aux = anterior+atual;
				anterior = atual;
				atual = aux;
				fib.append(atual);
			}
			if(i != termoAtual)
				fib.append(", ");
		}
		fib.append("]");
		return fib.toString();
	}
	
	
	/**
	 * Define o primeiro termo como termo atual e o retorna.
	 * @return o primeiro termo da s�rie.
	 */
	public int primeiro() {
		return termoAtual = 1;
	}
	
	/**
	 * Calcula o pr�ximo termo da s�rie. O termo gerado passa a ser o termo atual da s�rie.
	 * @return o pr�ximo termo da s�rie.
	 */
	public int proximo() {
		return fibonacci(++termoAtual);
	}
	
	/**
	 * Calcula o n-�simo termo da s�rie.  Caso seja passado um valor de n < 1 a s�rie exibir� o primeiro termo da s�rie e o mesmo
	 * se tornar� o termo atual.
	 * @param n n-�simo termo a ser calculado.
	 * @return o n-�simo termo da s�rie.
	 */
	public int termo(int n) {
		termoAtual = n > 0 ? n : 1;
		return fibonacci(termoAtual);
	}
	
	/*
	 * Calcula a s�rie de Fibonacci de forma recursiva e retorna o n-�simo termo.
	 */
	private int fibonacci(int n) {
		if(n < 3) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
}
