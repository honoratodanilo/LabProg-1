package principal;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes do objeto MinhaCDteca.
 *
 */
public class TDD_MinhaCDteca {

	MinhaCDteca cdteca;
	List<CD> cds;
	CD cd;
	
	@Before
	public void criaCDteca() throws Exception {
		cdteca = new MinhaCDteca();
		cds = new ArrayList<CD>();
		cds.add(new CD("Californication", "Red Hot Chili Peppers"));
		cds.add(new CD("Not Strong Enough", "Apocalyptica"));
		cds.add(new CD("Rebirth", "Angra"));
		cdteca.adicionaCDs(cds);
		cd = new CD("Led Zeppelin IV", "Led Zeppelin");
		cdteca.adicionaCD(cd);
	}

	@Test
	public void testaRemocao() {
		try {
			cdteca.removeCD("A volta dos que n�o foram.");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("Este CD n�o est� na cole��o da CDteca.", e.getMessage());
		}
		try {
			assertEquals(cd, cdteca.removeCD("Led Zeppelin IV"));
		}catch(Exception e) {
			fail("N�o deve cair aqui.");
			e.printStackTrace();
		}
		String[] titulos1 = {"Led Zeppelin IV", "A volta dos que n�o foram"}; // nenhum desses t�tulos est� na lista, pois "Led Zeppelin IV n�o est� mais na lista
		String[] titulos2 = {"Californication", "A volta dos que n�o foram"}; //cont�m um t�tulo que est� na lista
		String[] titulos3 = {"Not Strong Enough", "Rebirth"}; //todos t�tulos est�o na lista, logo, todos ser�o removidos
		
		assertFalse(cdteca.removeCDs(titulos1));
		assertTrue(cdteca.removeCDs(titulos2));
		assertTrue(cdteca.removeCDs(titulos3));
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "N�o � uma cdteca.";
		assertFalse(cdteca.equals(obj));
		assertFalse(cdteca.equals(null));
		MinhaCDteca outraCDteca = new MinhaCDteca();
		assertFalse(cdteca.equals(outraCDteca));
		outraCDteca.adicionaCDs(cds);
		outraCDteca.adicionaCD(cd);
		System.out.println(cdteca);
		System.out.println(outraCDteca);
		assertTrue(cdteca.equals(outraCDteca));
		outraCDteca.adicionaCD(cd);
		assertTrue(cdteca.equals(outraCDteca));
		System.out.println(cdteca);
		System.out.println(outraCDteca);
		outraCDteca.adicionaCD(new CD("A volta dos que n�o foram", "Autor desconhecido"));
		assertFalse(cdteca.equals(outraCDteca));
		System.out.println(cdteca);
		System.out.println(outraCDteca);
	}
	
	@Test
	public void outrosTestes() {
		assertEquals(4, cdteca.numeroDeCDs());
		assertEquals(null, cdteca.pesquisaCD("A volta dos que n�o foram"));
		assertEquals(cd, cdteca.pesquisaCD(cd.getTitulo()));
		assertEquals(cd, cdteca.pesquisaCD("Led Zeppelin IV"));
		String[] titulos = {"Led Zeppelin IV", "Californication", "Not Strong Enough", "Rebirth"};
		assertTrue(cdteca.removeCDs(titulos));
		assertEquals(0, cdteca.numeroDeCDs());
		assertEquals(null, cdteca.pesquisaCD("Led Zeppelin IV"));
	}
}
