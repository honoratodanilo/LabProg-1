package testes;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
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
		//instancia��o do objeto Taxista passando um valor inv�lido ao par�metro 'quilometragemPercorrida'
		try {
			new Taxista("Sebasti�o", 12345, true, true, 150000, -150, 1000);
			fail("N�o deve cair aqui");
		} catch (Exception e) {
			assertEquals("Valor da quilometragem inv�lido.", e.getMessage());
		}
		//instancia��o do objeto Taxista passando um valor inv�lido ao par�metro 'numeroDePassageiros'
		try {
			new Taxista("Sebasti�o", 12345, true, true, 150000, 12000, -36);
			fail("N�o deve cair aqui");
		} catch (Exception e) {
			assertEquals("O n�mero de passageiros transportados n�o pode ser negativo.", e.getMessage());
		}
	}
}
