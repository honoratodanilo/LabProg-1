package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Classe que define todas as características de um taxista.
 */
public class Taxista extends Rodoviario{

	private int numeroDePassageiros;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do taxista.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param temCasaPropria Será passado true se o taxista tiver casa própria, false se não tiver.
	 * @param temCarro Será passado true se o taxista tiver carro, false se não tiver.
	 * @param valorDosBens Valor somado de todos os bens do taxista.
	 * @param quilometragemPercorrida Total de quilômetros percorridos pelo taxista.
	 * @param numeroDePassageiros Número de passageiros transportados pelo taxista.
	 * @throws Exception Será lançada caso alguma informação passada ao construtor seja inválida.
	 */
	public Taxista(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida, int numeroDePassageiros) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens, quilometragemPercorrida);
		setNumeroDePassageiros(numeroDePassageiros);
	}

	/**
	 * Verifica se o número de passageiros passado como argumento é válido.
	 * @param numeroDePassageiros O número de passageiros que será validado.
	 * @throws Exception Será lançada caso o número de passageiros passado seja inválido.
	 */
	private void setNumeroDePassageiros(int numeroDePassageiros) throws Exception{
		if(numeroDePassageiros >= 0) {
			this.numeroDePassageiros = numeroDePassageiros;
		}else {
			throw new Exception("O número de passageiros transportados não pode ser negativo.");
		}
	}
	
	
	/**
	 * A número total de passageiros transportados por um taxista.
	 * @return O número de passageiros tranportados.
	 */
	public int getNumeroDePassageiros() {
		return numeroDePassageiros;
	}

	/**
	 * Calcula o devido valor do imposto que deverá ser pago pelo taxista.
	 */
	@Override
	public double calculaTributos() {
		return (numeroDePassageiros * 0.5);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("\nNúmero total de passageiros transportados: "+numeroDePassageiros+"\n");
		return string.toString();
	}
}
