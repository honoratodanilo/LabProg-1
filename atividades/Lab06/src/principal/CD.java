package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um CD de músicas.
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
	 * Construtor que recebe o título e o artista do CD e define o número de músicas padrão = 10.
	 * @param titulo Título do álbum do artista.
	 * @param artista Artista compositor do CD.
	 * @throws Exception Será lançada um Exception caso algum argumento passado seja inválido.
	 */
	public CD(String titulo, String artista) throws Exception {
		validaInfos(titulo, artista);
		quantMusicas = TAM_PADRAO;
		musicas = new ArrayList<>(quantMusicas);
	}
	
	/**
	 * Construtor que recebe o título, o artista o número de músicas do CD.
	 * @param titulo Título do álbum do artista.
	 * @param artista Artista compositor do CD.
	 * @param quantMusicas Número de músicas que compõem o CD.
	 * @throws Exception Será lançada um Exception caso algum argumento passado seja inválido.
	 */
	public CD(String titulo, String artista, int quantMusicas) throws Exception{
		validaInfos(titulo, artista);
		validaNumFaixas(quantMusicas);
		musicas = new ArrayList<>(this.quantMusicas);
	}
	
	/**
	 * Verifica se o título e o artista passados são válidos.
	 * @param titulo Título do CD passado como argumento para verificação.
	 * @param artista Artista do CD passado como argumento para verificação.
	 */
	private void validaInfos(String titulo, String artista) throws Exception{
		if(titulo != null && !titulo.trim().isEmpty()) {
			this.titulo = titulo;
		}else {
			throw new Exception("O CD deve conter um título.");
		}
		if(artista != null && !artista.trim().isEmpty()) {
			this.artista = artista;
		}else {
			throw new Exception("O CD deve conter um artista.");
		}
	}
	
	/**
	 * Verifica se o valor passado como número de músicas do CD é válido.
	 * @param numeroMusicas Número de músicas do CD passado para verificação.
	 * @throws Exception Será lançada uma exception caso o argumento passado seja inválido.
	 */
	private void validaNumFaixas(int quantMusicas) throws Exception{
		if(quantMusicas > 0) {
			this.quantMusicas = quantMusicas;
		}else {
			throw new Exception("O álbum deve conter pelo menos 1 música.");
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
	 * Retorna o título do CD.
	 * @return O título do CD.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Retorna a faixa principal do álbum do artista.
	 * @return A faixa principal do CD.
	 */
	public String getFaixaPrincipal() {
		return faixaPrincipal;
	}
	
	/**
	 * Retorna o número de músicas que compõem o CD.
	 * @return O número de músicas do CD.
	 */
	public int getNumeroMusicas() {
		return quantMusicas;
	}
	
	/**
	 * Retorna uma referência pra uma List<String> que contém todas as músicas do CD.
	 * @return Uma List com todas as músicas do CD.
	 */
	public List<String> getMusicas() {
		return musicas;
	}
	
	/**
	 * Altera a faixa principal do CD caso o argumento passado seja válido.
	 * @param musica A música que se deseja tornar a faixa principal do CD.
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
	 * Retorna a n-ésima faixa do CD, caso seja passado um número entre 1 < N < nº total de faixas.
	 * @param indice Um índice (1 < N < nº total de músicas) da música que deseja-se verificar.
	 * @return A música da n-ésima posição pesquisada, ou null caso a mesma não esteja na lista.
	 */
	public String getMusica(int indice){
		if(indice >= 0 && indice < musicas.size()){
			return musicas.get(indice);
		}
		return null;
	}
	
	/**
	 * Cadastra uma nova música no CD. Pode-se inserir qualquer música válida até que o número total de músicas seja alcançado.
	 * @param musica A música que se deseja cadastrar no CD.
	 * @return true se a música for adicionada, false caso não seja possível adicioná-la a lista de músicas.
	 */
	public boolean cadastrarMusica(String musica) {
		if(musica != null && !musica.trim().isEmpty() && musicas.size() < quantMusicas) {
			return musicas.add(musica);
		}
		return false;
	}
	
	/**
	 * Compara dois CD's, verificando se são iguais.
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
	 * Retorna uma representação em String do CD.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Artista: "+getArtista());
		string.append("\nTítulo: "+getTitulo());
		string.append("\nFaixa principal: "+getFaixaPrincipal());
		string.append("\n\nLista de músicas: ");
		for(int i = 0; i < musicas.size(); i++) {
			string.append(String.format("\n%02d - %s", i+1, getMusica(i)));
		}
		return string.toString();
	}
}