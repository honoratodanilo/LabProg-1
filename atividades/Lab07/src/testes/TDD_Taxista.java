package testes;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import static org.junit.Assert.*;

import org.junit.Test;

import principal.Taxista;

/**
 * Classe de testes da classe Taxista.
 */
public class TDD_Taxista {

	@Test
	public void testaCriacao() {
		//instanciação do objeto Taxista passando um valor inválido ao parâmetro 'quilometragemPercorrida'
		try {
			new Taxista("Sebastião", 12345, true, true, 150000, -150, 1000);
			fail("Não deve cair aqui");
		} catch (Exception e) {
			assertEquals("Valor da quilometragem inválido.", e.getMessage());
		}
		//instanciação do objeto Taxista passando um valor inválido ao parâmetro 'numeroDePassageiros'
		try {
			new Taxista("Sebastião", 12345, true, true, 150000, 12000, -36);
			fail("Não deve cair aqui");
		} catch (Exception e) {
			assertEquals("O número de passageiros transportados não pode ser negativo.", e.getMessage());
		}
	}
}
