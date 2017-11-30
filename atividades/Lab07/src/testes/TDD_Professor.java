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
}
