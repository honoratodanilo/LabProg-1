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
}
