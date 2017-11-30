package testes;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import static org.junit.Assert.*;

import org.junit.Test;

import principal.Caminhoneiro;
import principal.Contribuinte;
import principal.Taxista;

/**
 * Classe de testes da classe Caminhoneiro.
 */
public class TDD_Caminhoneiro {

	@Test
	public void testaCriacao() {
		//instanciação do objeto Caminhoneiro passando um valor inválido ao parâmetro 'quilometragemPercorrida'
		try {
			new Taxista("Sebastião", 12345, true, true, 150000, -150, 1000);
			fail("Não deve cair aqui");
		} catch (Exception e) {
			assertEquals("Valor da quilometragem inválido.", e.getMessage());
		}
		//instanciação do objeto Caminhoneiro passando um valor inválido ao parâmetro 'toneladasTransportadas'
		try {
			new Caminhoneiro("Sebastião", 12345, true, true, 150000, 12000, -500);
			fail("Não deve cair aqui.");
		} catch (Exception e) {
			assertEquals("O número de toneladas transportadas não pode ser negativo.", e.getMessage());
		}
	}
}
