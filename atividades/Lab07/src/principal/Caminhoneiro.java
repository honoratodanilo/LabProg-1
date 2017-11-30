package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Classe que define todas as características de um Caminhoneiro.
 */
public class Caminhoneiro extends Rodoviario{

	private double toneladasTransportadas;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do caminhoneiro.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param temCasaPropria Será passado true se o caminhoneiro tiver casa própria, false se não tiver.
	 * @param temCarro Será passado true se o caminhoneiro tiver carro, false se não tiver.
	 * @param valorDosBens Valor somado de todos os bens do caminhoneiro.
	 * @param quilometragemPercorrida Total de quilômetros percorridos pelo caminhoneiro.
	 * @param toneladasTransportadas Total de toneladas transportadas pelo Caminhoneiro.
	 * @throws Exception Será lançada caso alguma informação passada ao construtor seja inválida.
	 */
	public Caminhoneiro(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida, double toneladasTransportadas) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens, quilometragemPercorrida);
		setToneladasTransportadas(toneladasTransportadas);
	}

	/**
	 * Valida a quantidade de toneladas passada por argumento para o construtor.
	 * @param toneladasTransportadas O valor que será verificado.
	 * @throws Exception Será lançada caso o valor passado seja inválido.
	 */
	private void setToneladasTransportadas(double toneladasTransportadas) throws Exception{
		if(toneladasTransportadas >= 0) {
			this.toneladasTransportadas = toneladasTransportadas;
		}else {
			throw new Exception("O número de toneladas transportadas não pode ser negativo.");
		}
	}
	
	/**
	 * Retorna a quantidade total de toneladas transportadas por um caminhoneiro.
	 * @return A quantidade de toneladas transportadas.
	 */
	public double getToneladasTransportadas() {
		return toneladasTransportadas;
	}

	/**
	 * Calcula o devido valor do imposto que deverá ser pago pelo caminhoneiro.
	 */
	@Override
	public double calculaTributos() {
		final int TAXA_FIXA = 500;
		if(toneladasTransportadas <= 10) {
			return TAXA_FIXA;
		}else {
			double toneladasExtras = toneladasTransportadas - 10;
			return TAXA_FIXA + (toneladasExtras * 10);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nTotal de toneladas transportadas: %,.1f T\n", toneladasTransportadas));
		return string.toString();
	}
}
