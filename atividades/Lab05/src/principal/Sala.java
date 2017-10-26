package principal;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02:
 * Aluno 03:
 */

/**
 * Classe Sala que contém todos métodos que caracterizam uma sala real.
 * @author ivansimplicio
 * @version 1.0 - Last Modified: 26/10/2017 10:49
 */
public class Sala {
	
	private int[][] sala;
	public static final int LIVRE = 0;
	public static final int OCUPADO = 1;
	
	/**
	 * Construtor da classe Sala.
	 * @param linhas Número de linhas da sala.
	 * @param colunas Número de colunas da sala.
	 * @throws Exception Será lançada caso sejam passados valores inválidos.
	 */
	public Sala(int linhas, int colunas) throws Exception{
		validaDimensoes(linhas, colunas);
	}
	
	/**
	 * Valida e atribui as dimensões da sala.
	 * @param linhas Números de linhas da sala.
	 * @param colunas Número de colunas da sala.
	 * @return boolean (true) caso os valores passados sejam válidos.
	 * @throws Exception Será lançada caso sejam passados valores inválidos.
	 */
	private void validaDimensoes(int linhas, int colunas) throws Exception{
		if(linhas > 0 && colunas > 0) {
			sala = new int[linhas][colunas];
		}else {
			throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
		}
	}

	/**
	 * A dimensão horizontal da sala.
	 * @return A quantidade de "linhas" que a Sala tem.
	 */
	public int getNumPosicoesHorizontais() {
		return sala.length;
	}

	/**
	 * A dimensão vertical da Sala.
	 * @return A quantidade de "colunas" que a Sala tem.
	 */
	public int getNumPosicoesVerticais() {
		return sala[0].length;
	}
	
	/**
	 * Verifica se a sala está vazia.
	 * @return Um boolean que retornará true caso a sala esteja vazia, e false se tiver algum objeto na sala.
	 */
	public boolean isVazia() {
		for(int i = 0; i < getNumPosicoesHorizontais(); i++) {
			for(int j = 0; j < getNumPosicoesVerticais(); j++) {
				if(sala[i][j] == Sala.OCUPADO) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Insere um obstáculo a sala.
	 * @param linha A primeira coordenada do obstáculo.
	 * @param coluna A segunda coordenada do obstáculo.
	 * @return true caso o obstáculo tiver sido fixado na sala, e false caso não tenha sido fixado.
	 * @throws Exception 
	 */
	public boolean inserirObstaculo(int linha, int coluna){
		try {
			if(isPosicaoLivre(linha, coluna)) {
				sala[linha][coluna] = Sala.OCUPADO;
				return true;
			}	
		}catch(Exception e) {
			
		}
		return false;
	}

	/**
	 * Verifica se a posição passada em válida com base nas dimensões da sala.
	 * @param linha A primeira coordenada da sala.
	 * @param coluna A segunda coordenada da sala.
	 * @return true case for uma posição válida e false caso não seja.
	 */
	public boolean posicaoValida(int linha, int coluna) {
		if((linha >= 0 && linha < sala.length) && (coluna >= 0 && coluna < sala[0].length)) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se a posição passada está livre.
	 * @param linha Linha da sala.
	 * @param coluna Coluna da sala.
	 * @return true case esteja livre e false caso não esteja.
	 */
	public boolean isPosicaoLivre(int linha, int coluna) throws Exception{
		if(posicaoValida(linha, coluna)) {
			return sala[linha][coluna] == Sala.LIVRE;
		}
		throw new Exception("Posicao inexistente.");
	}
	
	/**
	 * Atribui um novo "status" (LIVRE ou OCUPADO) a uma posição da sala.
	 * @param linha Linha na qual se deseja atribuir o novo status.
	 * @param coluna Coluna na qual se deseja atribuir o novo status.
	 * @param status O status que irá ser atribuído a uma posição da sala (LIVRE ou OCUPADO).
	 * @return true caso seja atribuído com sucesso, false no caso de falha.
	 */
	public boolean setPosicao(int linha, int coluna, int status) {
		if(posicaoValida(linha, coluna)) {
			sala[linha][coluna] = status;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object outraSala) {
		if(!(outraSala == null)) {
			Sala salaAux = (Sala)outraSala;
			if(getNumPosicoesHorizontais() == salaAux.getNumPosicoesHorizontais() && getNumPosicoesVerticais() == salaAux.getNumPosicoesVerticais()) {
				for(int i = 0; i < getNumPosicoesHorizontais(); i++) {
					for(int j = 0; j < getNumPosicoesVerticais(); j++) {
						if(sala[i][j] != salaAux.sala[i][j]) {
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
}