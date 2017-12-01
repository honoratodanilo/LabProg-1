package testes;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import principal.*;

import org.junit.Test;

/**
 * Classe de testes da classe abstrata Contribuinte.
 */
public class TDD_Contribuinte {

	Contribuinte c = null;
	
	@Test
	public void testaCriacaoContribuinte() {
		//testa criação passando o valor 'null' no parâmetro 'nome'
		try {
			new Professor(null, 12345, true, true, 150000, 1500, 290);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O nome não pode ser vazio.", e.getMessage());
		}
		//testa criação passando uma String em branco no parâmetro 'nome'
		try {
			new Professor("   ", 12345, true, true, 150000, 1500, 290);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O nome não pode ser vazio.", e.getMessage());
		}
		//testa criação passando um valor negativo no parâmetro 'numeroDoContribuinte'
		try {
			new Professor("José", -1, true, true, 150000, 1500, 290);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("Número de contribuinte inválido.", e.getMessage());
		}
		//testa criação passando o valor muito grande no parâmetro 'numeroDoContribuinte' (Integer.MAX_VALUE+1)
		try {
			new Professor("José", Integer.MAX_VALUE+1, true, true, 150000, 1500, 290);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("Número de contribuinte inválido.", e.getMessage());
		}
		//testa criação passando um valor negativo ao parâmetro 'valorDosBens'
		try {
			new Professor("José", 12345, true, true, -1, 1500, 290);
			fail("Não deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O valor dos bens não pode ser negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testeAtributosInicializados() {
		try {
			c = new Professor("Sebastião", 12345, true, true, 150000, 1650, 290);
		}catch(Exception e) {
			fail("Não deve cair aqui");
		}
		assertEquals("Sebastião", c.getNome());
		assertEquals(12345, c.getNumeroDoContribuinte());
		assertEquals(true, c.temCasaPropria());
		assertEquals(true, c.temCarro());
		assertEquals(0, 150000, c.getValorDosBens());
	}
	
	@Test
	public void testeSinaisExterioresDeRiqueza() throws Exception {
		List<Contribuinte> lista = new ArrayList<Contribuinte>();
		lista.add(new Professor("Augusto", 001, true, true, 160000, 5500, 350));
		lista.add(new Professor("Madalena", 002, false, true, 20.000, 1.200, 90));
		lista.add(new Professor("Israel", 003, true, false, 50000, 1600, 120));
		lista.add(new Professor("Josefa", 004, true, true, 7000, 2100, 260));
		lista.add(new Professor("Sebastião", 005, false, true, 25000, 1550, 145));
		
		double mediaDosBens = Contribuinte.calculaMediaDosBensDeContribuintes(lista); //calcula média dos bens dos contribuintes de uma categoria + 50% desse valor
		
		assertTrue(lista.get(0).sinaisExterioresDeRiquezaExcessivos(mediaDosBens)); //possui sinais exteriores de riqueza
		assertFalse(lista.get(1).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//não possui sinais exteriores de riqueza
		assertFalse(lista.get(2).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//não possui sinais exteriores de riqueza
		assertFalse(lista.get(3).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//não possui sinais exteriores de riqueza
		assertFalse(lista.get(4).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//não possui sinais exteriores de riqueza
		
		assertEquals(lista.size()+1, Contribuinte.numeroContribuintesCadastrados());
		//verifica a quantidade de Contribuintes instânciados (5 desse método + 1 do método anterior)
	}
}