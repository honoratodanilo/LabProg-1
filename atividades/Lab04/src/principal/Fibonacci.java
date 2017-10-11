package principal;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Fernanda Eduarda de Medeiros Silva
 */


/**
 * Classe que calcula a série de Fibonacci.
 * @author Ivanildo/Vinicius/Fernanda
 * @version 1.1 Last modified 11/10/2017 14:10
 */
public class Fibonacci {
		
	private int termoAtual;
	
	/**
	 * Construtor padrão da classe.
	 */
	public Fibonacci() {
		this.termoAtual = 1;
	}
	
	/**
	 * Gera n termos da série. Caso seja passado um valor de n < 1 a série exibirá o primeiro termo da série e o mesmo
	 * se tornará o termo atual.
	 * @param n o número de termos que serão gerados na série. 
	 * @return uma representação em String da série. (formato: [termo1, termo2,...])
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
	 * @return o primeiro termo da série.
	 */
	public int primeiro() {
		return termoAtual = 1;
	}
	
	/**
	 * Calcula o próximo termo da série. O termo gerado passa a ser o termo atual da série.
	 * @return o próximo termo da série.
	 */
	public int proximo() {
		return fibonacci(++termoAtual);
	}
	
	/**
	 * Calcula o n-ésimo termo da série.  Caso seja passado um valor de n < 1 a série exibirá o primeiro termo da série e o mesmo
	 * se tornará o termo atual.
	 * @param n n-ésimo termo a ser calculado.
	 * @return o n-ésimo termo da série.
	 */
	public int termo(int n) {
		termoAtual = n > 0 ? n : 1;
		return fibonacci(termoAtual);
	}
	
	/*
	 * Calcula a série de Fibonacci de forma recursiva e retorna o n-ésimo termo.
	 */
	private int fibonacci(int n) {
		if(n < 3) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
}
