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
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		Taxista taxista = new Taxista("Ivan Simplício", 12345, true, true, 150000, 10000, 200);
		assertEquals(100, taxista.calculaTributos(), 0); // tributos calculados: 200 * 0,5 = 100
		assertEquals(100, taxista.calculaDesconto(), 0); // descontos calculados: 10000 * 0,01 = 100
		assertEquals(0, taxista.calculaImpostoASerPago(), 0); // imposto a ser pago: 100 - 100 = 0
		taxista = new Taxista("Ivan Simplício", 12345, true, true, 150000, 5000, 420);
		assertEquals(210, taxista.calculaTributos(), 0); // tributos calculados: 420 * 0,5 = 210
		assertEquals(50, taxista.calculaDesconto(), 0); // descontos calculados: 5000 * 0,01 = 50
		assertEquals(160, taxista.calculaImpostoASerPago(), 0); // imposto a ser pago: 210 - 50 = 160
	}
}
