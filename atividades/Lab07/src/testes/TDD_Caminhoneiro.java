package testes;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import static org.junit.Assert.*;

import org.junit.Test;

import principal.Caminhoneiro;

/**
 * Classe de testes da classe Caminhoneiro.
 */
public class TDD_Caminhoneiro {

	@Test
	public void testaCriacao() {
		//instanciação do objeto Caminhoneiro passando um valor inválido ao parâmetro 'quilometragemPercorrida'
		try {
			new Caminhoneiro("Sebastião", 12345, true, true, 150000, -150, 1000);
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
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		Caminhoneiro caminhoneiro = new Caminhoneiro("Ivan Simplício", 12345, true, true, 150000, 10000, 10);
		assertEquals(500, caminhoneiro.calculaTributos(), 0); // tributos calculados: TAXA_FIXA até 10T = 500
		assertEquals(100, caminhoneiro.calculaDesconto(), 0); // descontos calculados: 10000 * 0,01 = 100
		assertEquals(400, caminhoneiro.calculaImpostoASerPago(), 0); // imposto a ser pago: 500 - 100 = 400
		caminhoneiro = new Caminhoneiro("Ivan Simplício", 12345, true, true, 150000, 22000, 22);
		assertEquals(1700, caminhoneiro.calculaTributos(), 0); // tributos calculados: TAXA_FIXA + 12 * 100 = 1700
		assertEquals(220, caminhoneiro.calculaDesconto(), 0); // descontos calculados: 5000 * 0,01 = 220
		assertEquals(1480, caminhoneiro.calculaImpostoASerPago(), 0); // imposto a ser pago: 1700-220 = 1480
	}
}
