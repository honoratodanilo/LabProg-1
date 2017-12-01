package testes;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import static org.junit.Assert.*;
import org.junit.Test;
import principal.Medico;

/**
 * Classe de testes da classe Medico.
 */
public class TDD_Medico {

	@Test
	public void testaCriacao() {
		//instanciação do objeto Medico passando um valor inválido ao parâmetro 'numeroDePacientesAtendidos'
		try {
			new Medico("Sebastião", 12345, true, true, 150000, -1, 1500);
			fail("Não deve cair aqui");
		}catch(Exception e) {
			assertEquals("O número de pacientes atendidos pelo médico não pode ser negativo.", e.getMessage());
		}
		//instanciação do objeto Medico passando um valor inválido ao parâmetro 'gastosEmCongressos'
		try {
			new Medico("Sebastião", 12345, true, true, 150000, 100, -100);
			fail("Não deve cair aqui");
		} catch (Exception e) {
			assertEquals("O total de gastos em congressos do médico não pode ser negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		Medico medico = new Medico("Ivan Simplício", 12345, true, true, 150000, 100, 560);
		assertEquals(1000, medico.calculaTributos(), 0); // tributos calculados: 100 * 10 = 1000
		assertEquals(560, medico.calculaDesconto(), 0); // descontos calculados: gastos = 560
		assertEquals(440, medico.calculaImpostoASerPago(), 0); // imposto a ser pago: 1000 - 560 = 440
		medico = new Medico("Ivan Simplício", 12345, true, true, 150000, 125, 620);
		assertEquals(1250, medico.calculaTributos(), 0); // tributos calculados: 125 * 10 = 1250
		assertEquals(620, medico.calculaDesconto(), 0); // descontos calculados: gastos = 620
		assertEquals(630, medico.calculaImpostoASerPago(), 0); // imposto a ser pago: 1250 - 620 = 630
	}
}
