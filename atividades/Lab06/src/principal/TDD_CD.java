package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
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
							"Get On Top", "Parallel Universe", "I Like Dirt"}; //array com 13 músicas
	
	@Before
	public void criaCD() throws Exception {
		cd = new CD("Californication", "Red Hot Chili Peppers", QNTD_MUSICAS_CD); //instâcia um objeto CD
	}
	
	@Test
	public void testaCriacao() {
		//tenta criar um CD passando null como argumento para o parâmetro título
		try {
			cd = new CD(null, "Apocalyptica");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um título.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o parâmetro título
		try {
			cd = new CD("   ", "Apocalyptica");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um título.", e.getMessage());
		}
		//tenta criar um CD passando null como argumento para o parâmetro artista
		try {
			cd = new CD("Not Strong Enough", null);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o parâmetro artista
		try {
			cd = new CD("Not Strong Enough", "   ");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando um valor negativo como argumento para o parâmetro quantMusicas
		try {
			cd = new CD("Not Strong Enough", "Apocalyptica", -2);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O álbum deve conter pelo menos 1 música.", e.getMessage());
		}
		//tenta criar um CD passando zero como argumento para o parâmetro quantMusicas
		try {
			cd = new CD("Not Strong Enough", "Apocalyptica", 0);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O álbum deve conter pelo menos 1 música.", e.getMessage());
		}
	}
	
	@Test
	public void testaEstadoInicial() {
		assertEquals("Red Hot Chili Peppers", cd.getArtista()); //confere se o artista foi "setado" corretamente
		assertEquals("Californication", cd.getTitulo()); //confere se o titulo do CD foi "setado" corretamente
		assertEquals(null, cd.getFaixaPrincipal()); //retorna null já que ainda não foi atribuído nenhuma música ao CD
		assertEquals(QNTD_MUSICAS_CD, cd.getNumeroMusicas()); //confere se o número de músicas foi "setado" corretamente
		assertEquals(null, cd.getMusica(0)); //retorna null já que o CD ainda está vazio
	}
	
	@Test
	public void testaCadastroDeMusicas() {
		assertFalse(cd.alteraFaixaPrincipal("Californication")); //ainda não tem nenhuma música cadastrada...
		assertFalse(cd.cadastrarMusica(null)); //tentativa de atribuir null a faixa principal
		assertFalse(cd.cadastrarMusica("     ")); //tentativa de atribuir uma String em branco a faixa principal
		for(int i = 0; i < cd.getNumeroMusicas(); i++) {
			assertTrue(cd.cadastrarMusica(listaMusicas[i]));
		} //cadastra 10 músicas no CD
		assertFalse(cd.cadastrarMusica(listaMusicas[cd.getNumeroMusicas()])); //tenta cadastrar mais uma música, porém, já chegou ao limite permitido
		assertTrue(cd.alteraFaixaPrincipal("Californication")); //altera a faixa principal (a música está na lista)
		assertFalse(cd.alteraFaixaPrincipal("Dani California")); //tentativa de alterar a faixa principal (a música não está na lista)
		assertFalse(cd.alteraFaixaPrincipal(null)); //novamente uma tentativa de atribuir null a faixa principal
		assertFalse(cd.alteraFaixaPrincipal("    ")); //novamente uma tentativa de atribuir uma String em branco a faixa principal
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "Não é um CD";
		assertFalse(cd.equals(obj)); //testa o equals com outro objeto
		assertFalse(cd.equals(null)); //testa o equals passando null
		CD novoCD = new CD("Novo CD", "Testando Equals"); 
		assertFalse(cd.equals(novoCD)); //testa o equals passando um CD diferente
		novoCD = new CD("Californication", "Red Hot Chili Peppers");
		assertTrue(cd.equals(novoCD)); //testa o equals passando um CD igual
	}
}