package principal;

import java.util.List;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Classe abstrata que define as características padrões de todos contribuintes.
 */
public abstract class Contribuinte {

	private static int NUMERO_DE_CONTRIBUINTES_CADASTRADOS = 0;
	private String nome;
	private int numeroDoContribuinte;
	private boolean temCasaPropria = false;
	private boolean temCarro = false;
	private double valorDosBens;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do contribuinte.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param temCasaPropria Será passado true se o contribuinte tiver casa própria, false se não tiver.
	 * @param temCarro Será passado true se o contribuinte tiver carro, false se não tiver.
	 * @param valorDosBens Valor somado de todos os bens do contribuinte.
	 * @throws Exception Será lançada caso alguma informação passada ao construtor seja inválida.
	 */
	public Contribuinte(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens) throws Exception{
		validaDados(nome, numeroDoContribuinte, valorDosBens);
		this.temCasaPropria = temCasaPropria;
		this.temCarro = temCarro;
		NUMERO_DE_CONTRIBUINTES_CADASTRADOS++;
	}

	/**
	 * Validação dos dados passados pelo usuário.
	 * @param nome Nome do contribuinte.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param valorDosBens Valor dos bens do contribuinte.
	 */
	private void validaDados(String nome, int numeroDoContribuinte, double valorDosBens) throws Exception{
		if(nome != null && !nome.trim().isEmpty()) {
			this.nome = nome;
		}else {
			throw new Exception("O nome não pode ser vazio.");
		}
		if(numeroDoContribuinte >= 0 && numeroDoContribuinte <= Integer.MAX_VALUE) {
			this.numeroDoContribuinte = numeroDoContribuinte;
		}else {
			throw new Exception("Número de contribuinte inválido.");
		}
		if(valorDosBens >= 0) {
			this.valorDosBens = valorDosBens;
		}else {
			throw new Exception("O valor dos bens não pode ser negativo.");
		}
	}
	
	/**
	 * Verifica se o sinal exterior de riqueza de um contribuinte é excessivo ou não, tomando como base a média de todos os outros contribuintes de sua categoria.
	 * @param mediaDosContribuintes Média do valor dos bens dos contribuintes de uma mesma categoria.
	 * @return true caso o sinal de exterior de riqueza de um contribuinte seja excessivo, false se não for excessivo.
	 */
	public boolean sinaisExterioresDeRiquezaExcessivos(double mediaDosContribuintes) {
		double valorTotal = mediaDosContribuintes + (mediaDosContribuintes * 0.5);
		return valorDosBens > valorTotal;
	}
	
	/**
	 * Método estático que calcula a média dos bens dos contribuintes de uma categoria e acrecenta 50% no valor médio.
	 * @return A média dos bens dos contribuintes acrescido de 50% desse valor.
	 */
	public static double calculaMediaDosBensDeContribuintes(List<?> lista) {
		int somaDosBens=0;
		for(int i = 0; i < lista.size(); i++) {
			somaDosBens += ((Contribuinte)lista.get(i)).getValorDosBens();
		}
		double mediaDosBens = somaDosBens/lista.size();
		return mediaDosBens *= 1.5;
	}

	/**
	 * Retorna o nome do contribuinte.
	 * @return O nome do contribuinte.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o número de cadastro do contribuinte.
	 * @return O número de cadastro do contribuinte.
	 */
	public int getNumeroDoContribuinte() {
		return numeroDoContribuinte;
	}

	/**
	 * Retorna um booleano que diz se um contribuinte tem ou não casa própria.
	 * @return true se tiver casa própria, false se não tiver.
	 */
	public boolean temCasaPropria() {
		return temCasaPropria;
	}

	/**
	 * Retorna um booleano que diz se um contribuinte tem ou não carro.
	 * @return true se tiver carro, false se não tiver.
	 */
	public boolean temCarro() {
		return temCarro;
	}

	/**
	 * Retorna o valor somado de todos os bens do contribuintes.
	 * @return O valor total dos bens do contribuinte.
	 */
	public double getValorDosBens() {
		return valorDosBens;
	}
	
	/**
	 * Método estático que retorna o número de contribuintes já cadastrados no sistema.
	 * @return O número de contribuintes já cadastrados.
	 */
	public static int numeroContribuintesCadastrados() {
		return NUMERO_DE_CONTRIBUINTES_CADASTRADOS;
	}
	
	/**
	 * Faz o cálculo devido do imposto a ser pago, sendo esse valor o tributo subtraído do desconto referente a cada contribuinte.
	 * @return O valor de todos tributos subtraído do desconto devido. Se o valor do desconto for maior que seus tributos, o contribuinte não paga imposto.
	 */
	public double calculaImpostoASerPago() {
		double imposto = calculaTributos();
		double desconto = calculaDesconto();
		return imposto < desconto ? 0 : (imposto-desconto);
	}
	
	/**
	 * Método abstrato que sugere o cálculo dos tributos de cada contribuinte.
	 * @return O valor devido do imposto a ser pago.
	 */
	public abstract double calculaTributos();
	
	/**
	 * Método abstrato que sugere o cálculo do desconto aplicado ao tributo de um contribuinte.
	 * @return O valor do desconto a ser aplicado sobre o tributo de um contribuinte.
	 */
	public abstract double calculaDesconto();
	
	/**
	 * Representação em String dos dados do contribuinte.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Profissão do contribuinte: "+getClass().getSimpleName());
		string.append("\nNome do contribuinte: "+nome);
		string.append("\nNº do contribuinte: "+numeroDoContribuinte);
		string.append(String.format("\nTem casa própria: %s", temCasaPropria ? "Sim" : "Não"));
		string.append(String.format("\nTem carro próprio: %s", temCarro ? "Sim" : "Não"));
		string.append(String.format("\nValor total dos bens = R$ %,.2f", valorDosBens));
		return string.toString();
	}
}