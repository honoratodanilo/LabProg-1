package principal;

/*
 * Aluno 01: Ivanildo Simpl�cio da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Wesley Porto Santos
 */

/**
 * Classe Robo que representa um robo real e todas suas poss�veis a��es dentro de uma sala.
 * @version 1.0 - Last Modified: 27/10/2017 11:22
 */
public class Robo {

	private Sala sala = null;
	private int linhaAtual;
	private int colunaAtual;
	private int energia;
	private int nPassos;
	
	/**
	 * Construtor padr�o do Rob�.
	 * @param sala A sala a qual o rob� estar� posicionado.
	 * @param energia Quantidade de energia inicial do rob�.
	 * @throws Exception Caso algum valor passado seja inv�lido ser� lan�ada uma exce��o.
	 */
	public Robo(Sala sala, int energia) throws Exception{
		validaEnergia(energia);
		posicionaRobo(sala);
	}
	
	/**
	 * Valida se a quantidade de energia passada � v�lida.
	 * @param energia Quantidade de energia inicial de um rob�.
	 * @throws Exception Ser� lan�ada caso a energia passada for <= 0.
	 */
	private void validaEnergia(int energia) throws Exception{
		if(energia > 0) {
			this.energia = energia;
		}else {
			throw new Exception("N�o � poss�vel criar um robo com energia menor ou igual zero.");
		}
	}
	
	/**
	 * Valida se a sala passada � v�lida.
	 * @param sala A sala em que o rob� ser� posicionado.
	 * @throws Exception Ser� lan�ada caso a sala passada seja nula ou esteja lotada.
	 */
	private void posicionaRobo(Sala sala) throws Exception{
		boolean status = false;
		if(!(sala == null)){
			for(int i = 0; i < sala.getNumPosicoesHorizontais(); i++){
				for(int j = 0; j < sala.getNumPosicoesVerticais(); j++){
					if(sala.isPosicaoLivre(i, j)){
						linhaAtual = i;
						colunaAtual = j;
						sala.setPosicao(linhaAtual, colunaAtual, Sala.OCUPADO);
						this.sala = sala;
						status = true;
						break;
					}
				}
				if(status) break;
			}
			if(!status){
				throw new Exception("A sala passada est� cheia, n�o � poss�vel posicionar o robo nesta sala.");
			}
		}else{
			throw new Exception("Nenhuma sala passada ao robo.");
		}
	}

	/**
	 * Testa se a posi��o passada � a posi��o atual do rob�.
	 * @param linha A posi��o horizontal que deseja ser testada.
	 * @param coluna A posi��o vertical que deseja ser testada.
	 * @return true caso seja a posi��o do rob�, false caso n�o seja.
	 */
	public boolean isPosicaoAtual(int linha, int coluna) {
		return linha == linhaAtual && coluna == colunaAtual;
	}
	
	/**
	 * Retorna o n�mero de passos que o rob� j� deu.
	 * @return o n�mero de passos do rob�.
	 */
	public int numeroPassos() {
		return nPassos;
	}

	/**
	 * Retorna a atual energia do rob�.
	 * @return a energia do rob�.
	 */
	public int energiaAtual() {
		return energia;
	}	

	/**
	 * Atualiza a posi��o do Robo na sala.
	 * @param linhaAtual A linha em que o robo ser� posicionado.
	 * @param colunaAtual A coluna em que o robo ser� posicionado.
	 * @param status O novo status da posi��o.
	 */
	private void atualizaPosicao(int linhaAtual, int colunaAtual, int status) {
		sala.setPosicao(linhaAtual, colunaAtual, status);
		nPassos++;
		energia--;
	}
	
	/**
	 * Movimenta o rob� para nova posi��o caso seja poss�vel.
	 * @param linha A linha em que o robo ser� posicionado.
	 * @param coluna A coluna em que o robo ser� posicionado.
	 * @return true caso seja poss�vel movimentar o robo para a nova posi��o, false se n�o for poss�vel.
	 */
	private boolean movimentarRobo(int linha, int coluna) {
		try {
			if(sala.isPosicaoLivre(linha, coluna)) {
				sala.setPosicao(linhaAtual, colunaAtual, Sala.LIVRE);
				return true;
			}	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
	/**
	 * Movimenta o rob� para tr�s caso n�o esteja na margem e n�o tenha obst�culo.
	 * @return true caso tenha sido movido, false caso n�o tenha sido poss�vel mover.
	 */
	public boolean praTras() {
		if(energiaAtual() > 0 && linhaAtual > 0) {
			if(movimentarRobo(linhaAtual-1, colunaAtual)) {
				atualizaPosicao(--linhaAtual, colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Movimenta o rob� para frente caso n�o esteja na margem e n�o tenha obst�culo.
	 * @return true caso tenha sido movido, false caso n�o tenha sido poss�vel mover.
	 */
	public boolean praFrente() {
		if(energiaAtual() > 0 && linhaAtual < this.sala.getNumPosicoesVerticais()-1) {
			if(movimentarRobo(linhaAtual+1, colunaAtual)) {
				atualizaPosicao(++linhaAtual, colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Movimenta o rob� para esquerda caso n�o esteja na margem e n�o tenha obst�culo.
	 * @return true caso tenha sido movido, false caso n�o tenha sido poss�vel mover.
	 */
	public boolean esquerda() {
		if(energiaAtual() > 0 && colunaAtual > 0) {
			if(movimentarRobo(linhaAtual, colunaAtual-1)) {
				atualizaPosicao(linhaAtual, --colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}

	/**
	 * Movimenta o rob� para direita caso n�o esteja na margem e n�o tenha obst�culo.
	 * @return true caso tenha sido movido, false caso n�o tenha sido poss�vel mover.
	 */
	public boolean direita() {
		if(energiaAtual() > 0 && colunaAtual < this.sala.getNumPosicoesHorizontais()-1) {
			if(movimentarRobo(linhaAtual, colunaAtual+1)) {
				atualizaPosicao(linhaAtual, ++colunaAtual, Sala.OCUPADO);
				return true;
			}
		}
		return false;
	}

	/**
	 * Compara se dois rob�s s�o iguais, levando em conta sua posi��o atual e a sua sala.
	 */
	@Override
	public boolean equals(Object robo2) {
		if(!(robo2 == null)) {
			Robo roboAux = (Robo) robo2;
			if(sala.equals(roboAux.sala) && isPosicaoAtual(roboAux.linhaAtual, roboAux.colunaAtual)) {
				return true;
			}
		}
		return false;
	}
}
