package principal;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um CD de m�sicas.
 * @author ivanildo/fernanda/evelin
 */

public class CD {
	 
	private String artista;
	private String titulo;
	private String faixaPrincipal;
	private int quantMusicas;
	private List<String> musicas;
	private final int TAM_PADRAO = 10;
	
	/**
	 * Construtor que recebe o t�tulo e o artista do CD e define o n�mero de m�sicas padr�o = 10.
	 * @param titulo T�tulo do �lbum do artista.
	 * @param artista Artista compositor do CD.
	 * @throws Exception Ser� lan�ada um Exception caso algum argumento passado seja inv�lido.
	 */
	public CD(String titulo, String artista) throws Exception {
		validaInfos(titulo, artista);
		quantMusicas = TAM_PADRAO;
		musicas = new ArrayList<>(quantMusicas);
	}
	
	/**
	 * Construtor que recebe o t�tulo, o artista o n�mero de m�sicas do CD.
	 * @param titulo T�tulo do �lbum do artista.
	 * @param artista Artista compositor do CD.
	 * @param quantMusicas N�mero de m�sicas que comp�em o CD.
	 * @throws Exception Ser� lan�ada um Exception caso algum argumento passado seja inv�lido.
	 */
	public CD(String titulo, String artista, int quantMusicas) throws Exception{
		validaInfos(titulo, artista);
		validaNumFaixas(quantMusicas);
		musicas = new ArrayList<>(this.quantMusicas);
	}
	
	/**
	 * Verifica se o t�tulo e o artista passados s�o v�lidos.
	 * @param titulo T�tulo do CD passado como argumento para verifica��o.
	 * @param artista Artista do CD passado como argumento para verifica��o.
	 */
	private void validaInfos(String titulo, String artista) throws Exception{
		if(titulo != null && !titulo.trim().isEmpty()) {
			this.titulo = titulo;
		}else {
			throw new Exception("O CD deve conter um t�tulo.");
		}
		if(artista != null && !artista.trim().isEmpty()) {
			this.artista = artista;
		}else {
			throw new Exception("O CD deve conter um artista.");
		}
	}
	
	/**
	 * Verifica se o valor passado como n�mero de m�sicas do CD � v�lido.
	 * @param numeroMusicas N�mero de m�sicas do CD passado para verifica��o.
	 * @throws Exception Ser� lan�ada uma exception caso o argumento passado seja inv�lido.
	 */
	private void validaNumFaixas(int quantMusicas) throws Exception{
		if(quantMusicas > 0) {
			this.quantMusicas = quantMusicas;
		}else {
			throw new Exception("O �lbum deve conter pelo menos 1 m�sica.");
		}
	}
	
	/**
	 * Retorna o artista compositor do CD.
	 * @return O artista do CD.
	 */
	public String getArtista() {
		return artista;
	}
	
	/**
	 * Retorna o t�tulo do CD.
	 * @return O t�tulo do CD.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Retorna a faixa principal do �lbum do artista.
	 * @return A faixa principal do CD.
	 */
	public String getFaixaPrincipal() {
		return faixaPrincipal;
	}
	
	/**
	 * Retorna o n�mero de m�sicas que comp�em o CD.
	 * @return O n�mero de m�sicas do CD.
	 */
	public int getNumeroMusicas() {
		return quantMusicas;
	}
	
	/**
	 * Retorna uma refer�ncia pra uma List<String> que cont�m todas as m�sicas do CD.
	 * @return Uma List com todas as m�sicas do CD.
	 */
	public List<String> getMusicas() {
		return musicas;
	}
	
	/**
	 * Altera a faixa principal do CD caso o argumento passado seja v�lido.
	 * @param musica A m�sica que se deseja tornar a faixa principal do CD.
	 */
	public boolean alteraFaixaPrincipal(String musica) {
		if(musica != null && !musica.trim().isEmpty()) {
			for(int i = 0; i < musicas.size(); i++) {
				if(musica.equals(musicas.get(i))) {
					faixaPrincipal = musica;
					return true;
				}	
			}
		}
		return false;
	}
	
	/**
	 * Retorna a n-�sima faixa do CD, caso seja passado um n�mero entre 1 < N < n� total de faixas.
	 * @param indice Um �ndice (1 < N < n� total de m�sicas) da m�sica que deseja-se verificar.
	 * @return A m�sica da n-�sima posi��o pesquisada, ou null caso a mesma n�o esteja na lista.
	 */
	public String getMusica(int indice){
		if(indice >= 0 && indice < musicas.size()){
			return musicas.get(indice);
		}
		return null;
	}
	
	/**
	 * Cadastra uma nova m�sica no CD. Pode-se inserir qualquer m�sica v�lida at� que o n�mero total de m�sicas seja alcan�ado.
	 * @param musica A m�sica que se deseja cadastrar no CD.
	 * @return true se a m�sica for adicionada, false caso n�o seja poss�vel adicion�-la a lista de m�sicas.
	 */
	public boolean cadastrarMusica(String musica) {
		if(musica != null && !musica.trim().isEmpty() && musicas.size() < quantMusicas) {
			return musicas.add(musica);
		}
		return false;
	}
	
	/**
	 * Compara dois CD's, verificando se s�o iguais.
	 */
	@Override
	public boolean equals(Object cd) {
		if(cd instanceof CD && cd != null) {
			CD cdAux = (CD) cd;
			if(getArtista().equals(cdAux.getArtista()) && getTitulo().equals(cdAux.getTitulo()))
				return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma representa��o em String do CD.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Artista: "+getArtista());
		string.append("\nT�tulo: "+getTitulo());
		string.append("\nFaixa principal: "+getFaixaPrincipal());
		string.append("\n\nLista de m�sicas: ");
		for(int i = 0; i < musicas.size(); i++) {
			string.append(String.format("\n%02d - %s", i+1, getMusica(i)));
		}
		return string.toString();
	}
}