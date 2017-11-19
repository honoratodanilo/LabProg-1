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
 * Classe de Testes do objeto CD.
 */
public class TDD_CD {

	CD cd = null;
	int QNTD_MUSICAS_CD = 12;
	String[] listaMusicas = {"Around The World", "Scar Tissue", "Otherside", "Californication", "Easily", 
							"Porcelain", "Emit Remmus", "Road Trippin'", "Right On Time", "Purple Stain",
							"Get On Top", "Parallel Universe", "I Like Dirt"}; //array com 13 músicas
	
	@Before
	public void criaCD() throws Exception {
		cd = new CD("Californication", "Red Hot Chili Peppers", QNTD_MUSICAS_CD);
	}
	
	@Test
	public void testaCriacao() {
		try {
			cd = new CD(null, "Apocalyptica");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um título.", e.getMessage());
		}
		try {
			cd = new CD("   ", "Apocalyptica");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um título.", e.getMessage());
		}
		try {
			cd = new CD("Not Strong Enough", null);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		try {
			cd = new CD("Not Strong Enough", "   ");
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		try {
			cd = new CD("Not Strong Enough", "Apocalyptica", -2);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O álbum deve conter pelo menos 1 música.", e.getMessage());
		}
		try {
			cd = new CD("Not Strong Enough", "Apocalyptica", 0);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O álbum deve conter pelo menos 1 música.", e.getMessage());
		}
	}
	
	@Test
	public void testaEstadoInicial() {
		assertEquals("Red Hot Chili Peppers", cd.getArtista());
		assertEquals("Californication", cd.getTitulo());
		assertEquals(null, cd.getFaixaPrincipal());
		assertEquals(QNTD_MUSICAS_CD, cd.getNumeroMusicas());
		assertEquals(null, cd.getMusica(0));
	}
	
	@Test
	public void testaCadastroDeMusicas() {
		assertFalse(cd.alteraFaixaPrincipal("Californication"));
		assertFalse(cd.cadastrarMusica(null));
		assertFalse(cd.cadastrarMusica("     "));
		for(int i = 0; i < cd.getNumeroMusicas(); i++) {
			assertTrue(cd.cadastrarMusica(listaMusicas[i]));
		}
		assertFalse(cd.cadastrarMusica(listaMusicas[cd.getNumeroMusicas()]));
		assertTrue(cd.alteraFaixaPrincipal("Californication"));
		assertFalse(cd.alteraFaixaPrincipal("Dani California"));
		assertFalse(cd.alteraFaixaPrincipal(null));
		assertFalse(cd.alteraFaixaPrincipal("    "));
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "Não é um CD";
		assertFalse(cd.equals(obj));
		assertFalse(cd.equals(null));
		CD novoCD = new CD("Novo CD", "Testando Equals");
		assertFalse(cd.equals(novoCD));
		novoCD = new CD("Californication", "Red Hot Chili Peppers");
		assertTrue(cd.equals(novoCD));
	}
}