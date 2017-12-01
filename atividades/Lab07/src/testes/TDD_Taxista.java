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
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		Taxista taxista = new Taxista("Ivan Simpl�cio", 12345, true, true, 150000, 10000, 200);
		assertEquals(100, taxista.calculaTributos(), 0); // tributos calculados: 200 * 0,5 = 100
		assertEquals(100, taxista.calculaDesconto(), 0); // descontos calculados: 10000 * 0,01 = 100
		assertEquals(0, taxista.calculaImpostoASerPago(), 0); // imposto a ser pago: 100 - 100 = 0
		taxista = new Taxista("Ivan Simpl�cio", 12345, true, true, 150000, 5000, 420);
		assertEquals(210, taxista.calculaTributos(), 0); // tributos calculados: 420 * 0,5 = 210
		assertEquals(50, taxista.calculaDesconto(), 0); // descontos calculados: 5000 * 0,01 = 50
		assertEquals(160, taxista.calculaImpostoASerPago(), 0); // imposto a ser pago: 210 - 50 = 160
	}
}
