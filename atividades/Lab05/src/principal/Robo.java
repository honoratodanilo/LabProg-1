package principal;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Wesley Porto Santos
 */

/**
 * Classe Robo que representa um robo real e todas suas possíveis ações dentro de uma sala.
 * @version 1.0 - Last Modified: 27/10/2017 11:22
 */
public class Robo {

	private Sala sala = null;
	private int linhaAtual;
	private int colunaAtual;
	private int energia;
	private int nPassos;
	
	/**
	 * Construtor padrão do Robô.
	 * @param sala A sala a qual o robô estará posicionado.
	 * @param energia Quantidade de energia inicial do robô.
	 * @throws Exception Caso algum valor passado seja inválido será lançada uma exceção.
	 */
	public Robo(Sala sala, int energia) throws Exception{
		validaEnergia(energia);
		posicionaRobo(sala);
	}
	
	/**
	 * Valida se a quantidade de energia passada é válida.
	 * @param energia Quantidade de energia inicial de um robô.
	 * @throws Exception Será lançada caso a energia passada for <= 0.
	 */
	private void validaEnergia(int energia) throws Exception{
		if(energia > 0) {
			this.energia = energia;
		}else {
			throw new Exception("Não é possível criar um robo com energia menor ou igual zero.");
		}
	}
	
	/**
	 * Valida se a sala passada é válida.
	 * @param sala A sala em que o robô será posicionado.
	 * @throws Exception Será lançada caso a sala passada seja nula ou esteja lotada.
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
				throw new Exception("A sala passada está cheia, não é possível posicionar o robo nesta sala.");
			}
		}else{
			throw new Exception("Nenhuma sala passada ao robo.");
		}
	}

	/**
	 * Testa se a posição passada é a posição atual do robô.
	 * @param linha A posição horizontal que deseja ser testada.
	 * @param coluna A posição vertical que deseja ser testada.
	 * @return true caso seja a posição do robô, false caso não seja.
	 */
	public boolean isPosicaoAtual(int linha, int coluna) {
		return linha == linhaAtual && coluna == colunaAtual;
	}
	
	/**
	 * Retorna o número de passos que o robô já deu.
	 * @return o número de passos do robô.
	 */
	public int numeroPassos() {
		return nPassos;
	}

	/**
	 * Retorna a atual energia do robô.
	 * @return a energia do robô.
	 */
	public int energiaAtual() {
		return energia;
	}	

	/**
	 * Atualiza a posição do Robo na sala.
	 * @param linhaAtual A linha em que o robo será posicionado.
	 * @param colunaAtual A coluna em que o robo será posicionado.
	 * @param status O novo status da posição.
	 */
	private void atualizaPosicao(int linhaAtual, int colunaAtual, int status) {
		sala.setPosicao(linhaAtual, colunaAtual, status);
		nPassos++;
		energia--;
	}
	
	/**
	 * Movimenta o robô para nova posição caso seja possível.
	 * @param linha A linha em que o robo será posicionado.
	 * @param coluna A coluna em que o robo será posicionado.
	 * @return true caso seja possível movimentar o robo para a nova posição, false se não for possível.
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
	 * Movimenta o robô para trás caso não esteja na margem e não tenha obstáculo.
	 * @return true caso tenha sido movido, false caso não tenha sido possível mover.
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
	 * Movimenta o robô para frente caso não esteja na margem e não tenha obstáculo.
	 * @return true caso tenha sido movido, false caso não tenha sido possível mover.
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
	 * Movimenta o robô para esquerda caso não esteja na margem e não tenha obstáculo.
	 * @return true caso tenha sido movido, false caso não tenha sido possível mover.
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
	 * Movimenta o robô para direita caso não esteja na margem e não tenha obstáculo.
	 * @return true caso tenha sido movido, false caso não tenha sido possível mover.
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
	 * Compara se dois robôs são iguais, levando em conta sua posição atual e a sua sala.
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
