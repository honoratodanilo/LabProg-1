package testes;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import static org.junit.Assert.*;
import org.junit.Test;
import principal.Professor;

/**
 * Classe de testes da classe Professor.
 */
public class TDD_Professor {

	@Test
	public void testaCriacao() {
		//instanciação do objeto Professor passando um valor inválido ao parâmetro 'salario'
		try {
			new Professor("Sebastião", 12345, true, true, 150000, -1, 150);
			fail("Não deve cair aqui");
		}catch(Exception e) {
			assertEquals("Valor do salário do professor inválido.", e.getMessage());
		}
		//instanciação do objeto Professor passando um valor inválido ao parâmetro 'gastosComMateriais'
		try {
			new Professor("Sebastião", 12345, true, true, 150000, 1500, -1);
			fail("Não deve cair aqui");
		}catch(Exception e) {
			assertEquals("Os gastos com materiais não pode ser um valor negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		//SALARIO_MININO = 925,00
		Professor professor = new Professor("Ivan Simplício", 12345, true, true, 150000, 925, 560);
		assertEquals(46.25, professor.calculaTributos(), 0); // tributos calculados: 925 * 0,05 = 46,25
		assertEquals(280, professor.calculaDesconto(), 0); // descontos calculados: 50% dos gastos = 280
		assertEquals(0, professor.calculaImpostoASerPago(), 0); // imposto a ser pago: 46,25 - 280 = não paga imposto
		
		professor = new Professor("Ivan Simplício", 12345, true, true, 150000, 2650, 120);
		assertEquals(265, professor.calculaTributos(), 0); // tributos calculados: 2650 * 0,1 = 265
		assertEquals(60, professor.calculaDesconto(), 0); // descontos calculados: 50% dos gastos = 60
		assertEquals(205, professor.calculaImpostoASerPago(), 0); // imposto a ser pago: 265 - 60 = 205
		
		professor = new Professor("Ivan Simplício", 12345, true, true, 150000, 5100, 260);
		assertEquals(1020, professor.calculaTributos(), 0); // tributos calculados: 5100 * 0,2 = 1020
		assertEquals(130, professor.calculaDesconto(), 0); // descontos calculados: 50% dos gastos = 130
		assertEquals(890, professor.calculaImpostoASerPago(), 0); // imposto a ser pago: 1020 - 130 = 890
		
	}
}
