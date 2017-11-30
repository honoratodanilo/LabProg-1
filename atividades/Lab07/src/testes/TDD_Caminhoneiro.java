package testes;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
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
		//instancia��o do objeto Caminhoneiro passando um valor inv�lido ao par�metro 'quilometragemPercorrida'
		try {
			new Taxista("Sebasti�o", 12345, true, true, 150000, -150, 1000);
			fail("N�o deve cair aqui");
		} catch (Exception e) {
			assertEquals("Valor da quilometragem inv�lido.", e.getMessage());
		}
		//instancia��o do objeto Caminhoneiro passando um valor inv�lido ao par�metro 'toneladasTransportadas'
		try {
			new Caminhoneiro("Sebasti�o", 12345, true, true, 150000, 12000, -500);
			fail("N�o deve cair aqui.");
		} catch (Exception e) {
			assertEquals("O n�mero de toneladas transportadas n�o pode ser negativo.", e.getMessage());
		}
	}
}
