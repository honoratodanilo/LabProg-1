package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém uma coleção de CD's com métodos para manipulá-los devidamente.
 * @author ivanildo/fernanda/evelin
 *
 */
public class MinhaCDteca {

	private List<CD> listaCDs;
	private int variedade;
	
	/**
	 * Contrutor padrão que instancia um coleção do CD's.
	 */
	public MinhaCDteca() {
		listaCDs = new ArrayList<CD>();
		variedade = 0;
	}
	
	/**
	 * Adiciona um novo CD a coleção de CD's.
	 * @param novoCD Um CD que será adicionado a coleção.
	 */
	public void adicionaCD(CD novoCD) {
		int cont=0;
		for(int i = 0; i < listaCDs.size(); i++) {
			if(!novoCD.getTitulo().equals(listaCDs.get(i).getTitulo()))
				cont++;
		}
		if(cont == numeroDeCDs())
			variedade++;
		listaCDs.add(novoCD);
	}
	
	/**
	 * Adiciona uma lista de CD's na coleção de CD's.
	 * @param listaCDs Uma List<CD> que será adicionada a coleção.
	 */
	public void adicionaCDs(List<CD> listaCDs) {
		for(int i = 0; i < listaCDs.size(); i++) {
			adicionaCD(listaCDs.get(i));
		}
	}
	
	/**
	 * Remove um CD da lista de CD's a partir de uma chave (o título do CD).
	 * @param titulo O título do CD que se quer remover.
	 * @return O CD removido, ou null se não tiver sido encontrado.
	 * @throws Exception Será lançada caso o CD que o usuário esteja tentando remover não esteja na coleção.
	 */
	public CD removeCD(String titulo) throws Exception{
		for(int i = 0; i < listaCDs.size(); i++) {
			if(titulo.equals(listaCDs.get(i).getTitulo())) {
				return listaCDs.remove(i);
			}
		}
		throw new Exception("Este CD não está na coleção da CDteca.");
	}
	
	/**
	 * Tenta remover uma quantidade N de CD's da coleção de CD's a partir de um array de títulos de tamanho N.
	 * @param titulos Os títulos dos álbuns que deseja-se excluir.
	 * @return true se pelo menos um CD for removido, false se não remover nenhum CD da coleção.
	 */
	public boolean removeCDs(String[] titulos) {
		int cont = 0;
		for(int i = 0; i < titulos.length; i++) {
			try {
				removeCD(titulos[i]);
				cont++;
			}catch(Exception e) {
			}
		}
		if(cont != 0)
			return true;
		return false;
	}
	
	/**
	 * Pesquisa um CD na coleção de CD's com base no seu título.
	 * @param titulo O título do CD procurado.
	 * @return O CD caso ele esteja na coleção ou null se não o achar.
	 */
	public CD pesquisaCD(String titulo) {
		for(int i = 0; i < listaCDs.size(); i++)
			if(titulo.equals(listaCDs.get(i).getTitulo()))
				return listaCDs.get(i);
		return null;
	}
	
	/**
	 * Retorna a quantidade de CD's que existem na coleção.
	 * @return O número de CD's que existem na coleção.
	 */
	public int numeroDeCDs() {
		return this.listaCDs.size();
	}
	
	/**
	 * Verifica se uma coleção de CD's é igual a outra coleção de CD's.
	 */
	@Override
	public boolean equals(Object outraBiblioteca) {
		if(outraBiblioteca instanceof MinhaCDteca && outraBiblioteca != null) {
			MinhaCDteca auxCDteca = (MinhaCDteca) outraBiblioteca;
			if(variedade == auxCDteca.variedade) {
				for(int i = 0; i < listaCDs.size(); i++) {
					if(auxCDteca.pesquisaCD(listaCDs.get(i).getTitulo()) == null) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retorna um representação String da coleção de CD's.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Lista de CD's da coleção: ");
		for(int i = 0; i < listaCDs.size(); i++) {
			string.append(String.format("\n\nCD %02d", i+1));
			string.append("\nArtista: "+listaCDs.get(i).getArtista());
			string.append("\nTítulo: "+listaCDs.get(i).getTitulo());
		}
		return string.toString();
	}
}
