package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Classe que define as características padrões de todos os rodoviários.
 */
public abstract class Rodoviario extends Contribuinte{

	private double quilometragemPercorrida;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do rodoviário.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param temCasaPropria Será passado true se o rodoviário tiver casa própria, false se não tiver.
	 * @param temCarro Será passado true se o rodoviário tiver carro, false se não tiver.
	 * @param valorDosBens Valor somado de todos os bens do rodoviário.
	 * @param quilometragemPercorrida Total de quilômetros percorridos pelo rodoviário.
	 * @throws Exception Será lançada caso alguma informação passada ao construtor seja inválida.
	 */
	public Rodoviario(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		setQuilometragem(quilometragemPercorrida);
	}

	/**
	 * Valida a quilometragem percorrida pelo rodoviário.
	 * @param quilometragemPercorrida O valor (km) que será verificado.
	 * @throws Exception Será lançada caso o valor (km) passado seja inválido.
	 */
	private void setQuilometragem(double quilometragemPercorrida) throws Exception{
		if(quilometragemPercorrida >= 0) {
			this.quilometragemPercorrida = quilometragemPercorrida;
		}else {
			throw new Exception("Valor da quilometragem inválido.");
		}
	}
	
	/**
	 * Retorna a quilômetragem total percorrida por um rodoviário.
	 * @return A quilometragem percorrida por um rodoviário.
	 */
	public double getQuilometragemPercorrida() {
		return quilometragemPercorrida;
	}

	/**
	 * Calcula os descontos que serão aplicados aos rodoviários.
	 */
	@Override
	public double calculaDesconto() {
		return (quilometragemPercorrida * 0.01);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nQuilometragem total percorrida: %,.1f km", quilometragemPercorrida));
		return string.toString();
	}
}
