package principal;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02:
 * Aluno 03:
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaRobo{

	private Sala sala = null;
	private Robo robo = null;
	private int ENERGIA_PADRAO = 10;
	private int LINHA = 5;
	private int COLUNA = 5;
	
	@Before
	public void criaSala() throws Exception{
		sala = new Sala(LINHA, COLUNA);
	}
	
	public void preencheSala() {
		for(int i = 0; i < sala.getNumPosicoesHorizontais(); i++) {
			for(int j = 0; j < sala.getNumPosicoesVerticais(); j++) {
				sala.setPosicao(i, j, Sala.OCUPADO);
			}
		}
	}
	
	@Before
	public void criaRobo() throws Exception {
		robo = new Robo(sala, ENERGIA_PADRAO);
	}
	
	@Test
	public void testaCriacaoRobo() {
		try {
			new Robo(sala, -1);
			Assert.fail("Esperado uma exceção pois a energia não pode ser negativa.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Não é possível criar um robo com energia menor ou igual zero.", e.getMessage());
		}
		try {
			new Robo(sala, 0);
			Assert.fail("Esperado uma exceção pois a energia não pode ser igual a zero.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Não é possível criar um robo com energia menor ou igual zero.", e.getMessage());
		}
		try {
			new Robo(null, ENERGIA_PADRAO);
			Assert.fail("Esperado uma exceção pois não pode ser passado null no parâmetro sala");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Nenhuma sala passada ao robo.", e.getMessage());
		}
		try {
			preencheSala();
			new Robo(sala, ENERGIA_PADRAO);
			Assert.fail("Esperado uma exceção pois a sala passada está cheia.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "A sala passada está cheia, não é possível posicionar o robo nesta sala.", e.getMessage());
		}
	}
	
	@Test
	public void testaMovimentosIniciaisRobo() throws Exception {
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));
		Assert.assertFalse(robo.subir());
		Assert.assertFalse(robo.esquerda());
		Assert.assertEquals(ENERGIA_PADRAO, robo.energiaAtual());
		Assert.assertEquals(0, robo.numeroPassos());
		Assert.assertTrue(robo.descer());
		Assert.assertTrue(robo.isPosicaoAtual(1,0));
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertTrue(robo.subir());
		Assert.assertTrue(robo.isPosicao(0,1));
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		
		try {
			sala = new Sala(LINHA, COLUNA);
			sala.inserirObstaculo(0, 0);
			robo = new Robo(sala, ENERGIA_PADRAO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(robo.isPosicaoAtual(0,0));
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
	}
	
	@Test
	public void testaMovimentosComObstaculos() {
		sala.inserirObstaculo(1, 0);
		sala.inserirObstaculo(0, 2);
		Assert.assertFalse(robo.descer());
		Assert.assertEquals(ENERGIA_PADRAO, robo.energiaAtual());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertEquals(1, robo.numeroPassos());
		Assert.assertEquals(ENERGIA_PADRAO-1, robo.energiaAtual());
		Assert.assertFalse(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertEquals(1, robo.numeroPassos());
		Assert.assertEquals(ENERGIA_PADRAO-1, robo.energiaAtual());
		Assert.assertTrue(robo.descer());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertEquals(2, robo.numeroPassos);
		Assert.assertEquals(ENERGIA_PADRAO-2, robo.energiaAtual);
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(1,2));
		Assert.assertEquals(ENERGIA_PADRAO-3, robo.energiaAtual);
		Assert.assertEquals(3, robo.numeroPassos());
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertFalse(robo.esquerda());
		Assert.assertEquals(ENERGIA_PADRAO-4, robo.energiaAtual());
		Assert.assertEquals(4, robo.numeroPassos());
	}
	
	@Test
	public void testeEmSalaVazia() {
		
	}
	
	@Test
	public void testaQuinas() {
		
	}
	
	@Test
	public void testaEquals() {
		
	}
}
