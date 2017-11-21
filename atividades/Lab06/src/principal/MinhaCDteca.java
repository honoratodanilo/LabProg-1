package principal;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cont�m uma cole��o de CD's com m�todos para manipul�-los devidamente.
 * @author ivanildo/fernanda/evelin
 *
 */
public class MinhaCDteca {

	private List<CD> listaCDs;
	private int variedade;
	
	/**
	 * Contrutor padr�o que instancia um cole��o do CD's.
	 */
	public MinhaCDteca() {
		listaCDs = new ArrayList<CD>();
		variedade = 0;
	}
	
	/**
	 * Adiciona um novo CD a cole��o de CD's.
	 * @param novoCD Um CD que ser� adicionado a cole��o.
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
	 * Adiciona uma lista de CD's na cole��o de CD's.
	 * @param listaCDs Uma List<CD> que ser� adicionada a cole��o.
	 */
	public void adicionaCDs(List<CD> listaCDs) {
		for(int i = 0; i < listaCDs.size(); i++) {
			adicionaCD(listaCDs.get(i));
		}
	}
	
	/**
	 * Remove um CD da lista de CD's a partir de uma chave (o t�tulo do CD).
	 * @param titulo O t�tulo do CD que se quer remover.
	 * @return O CD removido, ou null se n�o tiver sido encontrado.
	 * @throws Exception Ser� lan�ada caso o CD que o usu�rio esteja tentando remover n�o esteja na cole��o.
	 */
	public CD removeCD(String titulo) throws Exception{
		for(int i = 0; i < listaCDs.size(); i++) {
			if(titulo.equals(listaCDs.get(i).getTitulo())) {
				return listaCDs.remove(i);
			}
		}
		throw new Exception("Este CD n�o est� na cole��o da CDteca.");
	}
	
	/**
	 * Tenta remover uma quantidade N de CD's da cole��o de CD's a partir de um array de t�tulos de tamanho N.
	 * @param titulos Os t�tulos dos �lbuns que deseja-se excluir.
	 * @return true se pelo menos um CD for removido, false se n�o remover nenhum CD da cole��o.
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
	 * Pesquisa um CD na cole��o de CD's com base no seu t�tulo.
	 * @param titulo O t�tulo do CD procurado.
	 * @return O CD caso ele esteja na cole��o ou null se n�o o achar.
	 */
	public CD pesquisaCD(String titulo) {
		for(int i = 0; i < listaCDs.size(); i++)
			if(titulo.equals(listaCDs.get(i).getTitulo()))
				return listaCDs.get(i);
		return null;
	}
	
	/**
	 * Retorna a quantidade de CD's que existem na cole��o.
	 * @return O n�mero de CD's que existem na cole��o.
	 */
	public int numeroDeCDs() {
		return this.listaCDs.size();
	}
	
	/**
	 * Verifica se uma cole��o de CD's � igual a outra cole��o de CD's.
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
	 * Retorna um representa��o String da cole��o de CD's.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Lista de CD's da cole��o: ");
		for(int i = 0; i < listaCDs.size(); i++) {
			string.append(String.format("\n\nCD %02d", i+1));
			string.append("\nArtista: "+listaCDs.get(i).getArtista());
			string.append("\nT�tulo: "+listaCDs.get(i).getTitulo());
		}
		return string.toString();
	}
}
