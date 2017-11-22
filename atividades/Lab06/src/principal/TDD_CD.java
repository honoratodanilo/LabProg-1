package principal;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes do objeto CD.
 */
public class TDD_CD {

	CD cd = null;
	int QNTD_MUSICAS_CD = 12;
	String[] listaMusicas = {"Around The World", "Scar Tissue", "Otherside", "Californication", "Easily", 
							"Porcelain", "Emit Remmus", "Road Trippin'", "Right On Time", "Purple Stain",
							"Get On Top", "Parallel Universe", "I Like Dirt"}; //array com 13 m�sicas
	
	@Before
	public void criaCD() throws Exception {
		cd = new CD("Californication", "Red Hot Chili Peppers", QNTD_MUSICAS_CD); //inst�cia um objeto CD
	}
	
	@Test
	public void testaCriacao() {
		//tenta criar um CD passando null como argumento para o par�metro t�tulo
		try {
			cd = new CD(null, "Apocalyptica");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um t�tulo.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o par�metro t�tulo
		try {
			cd = new CD("   ", "Apocalyptica");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um t�tulo.", e.getMessage());
		}
		//tenta criar um CD passando null como argumento para o par�metro artista
		try {
			cd = new CD("Not Strong Enough", null);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o par�metro artista
		try {
			cd = new CD("Not Strong Enough", "   ");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando um valor negativo como argumento para o par�metro quantMusicas
		try {
			cd = new CD("Not Strong Enough", "Apocalyptica", -2);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O �lbum deve conter pelo menos 1 m�sica.", e.getMessage());
		}
		//tenta criar um CD passando zero como argumento para o par�metro quantMusicas
		try {
			cd = new CD("Not Strong Enough", "Apocalyptica", 0);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O �lbum deve conter pelo menos 1 m�sica.", e.getMessage());
		}
	}
	
	@Test
	public void testaEstadoInicial() {
		assertEquals("Red Hot Chili Peppers", cd.getArtista()); //confere se o artista foi "setado" corretamente
		assertEquals("Californication", cd.getTitulo()); //confere se o titulo do CD foi "setado" corretamente
		assertEquals(null, cd.getFaixaPrincipal()); //retorna null j� que ainda n�o foi atribu�do nenhuma m�sica ao CD
		assertEquals(QNTD_MUSICAS_CD, cd.getNumeroMusicas()); //confere se o n�mero de m�sicas foi "setado" corretamente
		assertEquals(null, cd.getMusica(0)); //retorna null j� que o CD ainda est� vazio
	}
	
	@Test
	public void testaCadastroDeMusicas() {
		assertFalse(cd.alteraFaixaPrincipal("Californication")); //ainda n�o tem nenhuma m�sica cadastrada...
		assertFalse(cd.cadastrarMusica(null)); //tentativa de atribuir null a faixa principal
		assertFalse(cd.cadastrarMusica("     ")); //tentativa de atribuir uma String em branco a faixa principal
		for(int i = 0; i < cd.getNumeroMusicas(); i++) {
			assertTrue(cd.cadastrarMusica(listaMusicas[i]));
		} //cadastra 10 m�sicas no CD
		assertFalse(cd.cadastrarMusica(listaMusicas[cd.getNumeroMusicas()])); //tenta cadastrar mais uma m�sica, por�m, j� chegou ao limite permitido
		assertTrue(cd.alteraFaixaPrincipal("Californication")); //altera a faixa principal (a m�sica est� na lista)
		assertFalse(cd.alteraFaixaPrincipal("Dani California")); //tentativa de alterar a faixa principal (a m�sica n�o est� na lista)
		assertFalse(cd.alteraFaixaPrincipal(null)); //novamente uma tentativa de atribuir null a faixa principal
		assertFalse(cd.alteraFaixaPrincipal("    ")); //novamente uma tentativa de atribuir uma String em branco a faixa principal
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "N�o � um CD";
		assertFalse(cd.equals(obj)); //testa o equals com outro objeto
		assertFalse(cd.equals(null)); //testa o equals passando null
		CD novoCD = new CD("Novo CD", "Testando Equals"); 
		assertFalse(cd.equals(novoCD)); //testa o equals passando um CD diferente
		novoCD = new CD("Californication", "Red Hot Chili Peppers");
		assertTrue(cd.equals(novoCD)); //testa o equals passando um CD igual
	}
}