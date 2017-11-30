package testes;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
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
		//instancia��o do objeto Professor passando um valor inv�lido ao par�metro 'salario'
		try {
			new Professor("Sebasti�o", 12345, true, true, 150000, -1, 150);
			fail("N�o deve cair aqui");
		}catch(Exception e) {
			assertEquals("Valor do sal�rio do professor inv�lido.", e.getMessage());
		}
		//instancia��o do objeto Professor passando um valor inv�lido ao par�metro 'gastosComMateriais'
		try {
			new Professor("Sebasti�o", 12345, true, true, 150000, 1500, -1);
			fail("N�o deve cair aqui");
		}catch(Exception e) {
			assertEquals("Os gastos com materiais n�o pode ser um valor negativo.", e.getMessage());
		}
	}
}
