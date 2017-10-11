package principal;

/*
 * Aluno 01: Ivanildo Simpl�cio da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Fernanda Eduarda de Medeiros Silva
 */

/**
 * Classe que representa uma progress�o aritm�tica.
 * @version 1.2  Last modified: 11/10/2017 14:07
 * @author Ivanildo/Vinicius/Fernanda
 */
public class ProgressaoAritmetica {

	private int primeiro;
	private int razao;
	private int termoAtual;
	
	/**
	 * Construtor da classe.
	 * @param primeiro primeiro termo da progress�o aritm�tica.
	 * @param razao raz�o da progress�o aritm�tica.
	 */
	public ProgressaoAritmetica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
		this.termoAtual = 1;
	}
	
	/**
	 * Gera os n primeiros termos da progress�o aritm�tica. Valor de n >= 1, caso for passado um n�mero inv�lido, ser� exibido
	 * o primeiro termo da PA e este mesmo termo ser� o termo atual da PA.
	 * @param n n�meros de termos que ser�o gerados da PA.
	 * @return uma representa��o String dos n termos gerados da PA. (formato: [termo1, termo2, ...])
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
	 * Retorna a raz�o da progress�o aritm�tica.
	 * @return a raz�o da PA.
	 */
	public int getRazao() {
		return this.razao;
	}
	
	/**
	 * Reinicia a progress�o aritm�tica para seu primeiro termo. O primeiro termo passa a ser o termo atual da progressao.
	 * @return o primeiro termo da PA.
	 */
	public int primeiro() {
		termoAtual = 1;
		return this.primeiro;
	}
	
	/**
	 * Calcula o pr�ximo termo da progress�o aritm�tica. O termo gerado passa a ser o termo atual da progress�o.
	 * @return pr�ximo termo da PA.
	 */
	public int proximo() {
		return calculaSerie(++termoAtual);
	}
	
	/**
	 * Calcula o n-�simo termo da progress�o aritm�tica. Valor de n >= 1, caso for passado um n�mero inv�lido, ser� exibido
	 * o primeiro termo da PA e este mesmo termo ser� o termo atual da PA.
	 * @param n n-�simo termo da PA a ser calculado.
	 * @return o n-�simo termo da PA.
	 */
	public int termo(int n) {
		termoAtual = n > 0 ? n : 1;
		return calculaSerie(termoAtual);
	}
	
	/*
	 * Faz o c�lculo da progress�o aritm�tica e retorna o n-�simo termo.
	 */
	private int calculaSerie(int n) {
		return primeiro+(n-1)*razao;
	}
}
