package principal;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Fernanda Eduarda de Medeiros Silva
 */

/**
 * Classe que representa uma progressão aritmética.
 * @version 1.2  Last modified: 11/10/2017 14:07
 * @author Ivanildo/Vinicius/Fernanda
 */
public class ProgressaoAritmetica {

	private int primeiro;
	private int razao;
	private int termoAtual;
	
	/**
	 * Construtor da classe.
	 * @param primeiro primeiro termo da progressão aritmética.
	 * @param razao razão da progressão aritmética.
	 */
	public ProgressaoAritmetica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
		this.termoAtual = 1;
	}
	
	/**
	 * Gera os n primeiros termos da progressão aritmética. Valor de n >= 1, caso for passado um número inválido, será exibido
	 * o primeiro termo da PA e este mesmo termo será o termo atual da PA.
	 * @param n números de termos que serão gerados da PA.
	 * @return uma representação String dos n termos gerados da PA. (formato: [termo1, termo2, ...])
	 */
	public String geraTermos(int n) {
		termoAtual = n > 0 ? n : 1;
		StringBuilder pa = new StringBuilder();
		pa.append("[");
		for(int i = 1; i <= termoAtual; i++) {
			pa.append(calculaSerie(i));
			if(i != termoAtual) pa.append(", ");
		}
		pa.append("]");
		return pa.toString();
	}
	
	/**
	 * Retorna a razão da progressão aritmética.
	 * @return a razão da PA.
	 */
	public int getRazao() {
		return this.razao;
	}
	
	/**
	 * Reinicia a progressão aritmética para seu primeiro termo. O primeiro termo passa a ser o termo atual da progressao.
	 * @return o primeiro termo da PA.
	 */
	public int primeiro() {
		termoAtual = 1;
		return this.primeiro;
	}
	
	/**
	 * Calcula o próximo termo da progressão aritmética. O termo gerado passa a ser o termo atual da progressão.
	 * @return próximo termo da PA.
	 */
	public int proximo() {
		return calculaSerie(++termoAtual);
	}
	
	/**
	 * Calcula o n-ésimo termo da progressão aritmética. Valor de n >= 1, caso for passado um número inválido, será exibido
	 * o primeiro termo da PA e este mesmo termo será o termo atual da PA.
	 * @param n n-ésimo termo da PA a ser calculado.
	 * @return o n-ésimo termo da PA.
	 */
	public int termo(int n) {
		termoAtual = n > 0 ? n : 1;
		return calculaSerie(termoAtual);
	}
	
	/*
	 * Faz o cálculo da progressão aritmética e retorna o n-ésimo termo.
	 */
	private int calculaSerie(int n) {
		return primeiro+(n-1)*razao;
	}
}
