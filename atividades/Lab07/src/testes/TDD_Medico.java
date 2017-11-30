package testes;

/*
 * Aluno 01: <Ivanildo Simpl�cio da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Floren�o da Silva>
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
		//instancia��o do objeto Medico passando um valor inv�lido ao par�metro 'numeroDePacientesAtendidos'
		try {
			new Medico("Sebasti�o", 12345, true, true, 150000, -1, 1500);
			fail("N�o deve cair aqui");
		}catch(Exception e) {
			assertEquals("O n�mero de pacientes atendidos pelo m�dico n�o pode ser negativo.", e.getMessage());
		}
		//instancia��o do objeto Medico passando um valor inv�lido ao par�metro 'gastosEmCongressos'
		try {
			new Medico("Sebasti�o", 12345, true, true, 150000, 100, -100);
			fail("N�o deve cair aqui");
		} catch (Exception e) {
			assertEquals("O total de gastos em congressos do m�dico n�o pode ser negativo.", e.getMessage());
		}
	}
}
