package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Classe que define todas as características de um médico.
 */
public class Medico extends Contribuinte{

	private int numeroDePacientesAtendidos;
	private double gastosEmCongressos;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do médico.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param temCasaPropria Será passado true se o médico tiver casa própria, false se não tiver.
	 * @param temCarro Será passado true se o médico tiver carro, false se não tiver.
	 * @param valorDosBens Valor somado de todos os bens do médico.
	 * @param numeroDePacientesAtendidos Número de pacientes atendidos pelo médico em um ano.
	 * @param gastosEmCongressos Total de gastos que o médico teve em congressos.
	 * @throws Exception Será lançada caso alguma informação passada ao construtor seja inválida.
	 */
	public Medico(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, int numeroDePacientesAtendidos, double gastosEmCongressos) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(numeroDePacientesAtendidos, gastosEmCongressos);
	}

	/**
	 * Valida as informações do médico.
	 * @param numeroDePacientesAtendidos Será validado o valor passado referente ao total de pacientes atendidos pelo médico em um ano.
	 * @param gastosEmCongressos Será validado o valor passado referente ao total de gastos que o médico teve em congresssos.
	 * @throws Exception Será lançada caso alguma informação passada seja inválida.
	 */
	private void validaDados(int numeroDePacientesAtendidos, double gastosEmCongressos) throws Exception{
		if(numeroDePacientesAtendidos >= 0) {
			this.numeroDePacientesAtendidos = numeroDePacientesAtendidos;
		}else {
			throw new Exception("O número de pacientes atendidos pelo médico não pode ser negativo.");
		}
		if(gastosEmCongressos >= 0) {
			this.gastosEmCongressos = gastosEmCongressos;
		}else {
			throw new Exception("O total de gastos em congressos do médico não pode ser negativo.");
		}
	}
	
	/**
	 * Retorna o número total de pacientes atendidos pelo médico.
	 * @return O número de pacientes que o médico atendeu.
	 */
	public int getNumeroDePacientesAtendidos() {
		return numeroDePacientesAtendidos;
	}

	/**
	 * Retorna o total de gastos que o médico teve em congressos.
	 * @return Os gastos em congressos.
	 */
	public double getGastosEmCongressos() {
		return gastosEmCongressos;
	}

	/**
	 * Calcula o devido valor do imposto que deverá ser pago pelo médico.
	 */
	@Override
	public double calculaTributos() {
		return numeroDePacientesAtendidos * 10;
	}

	/**
	 * Calcula os descontos que serão aplicados ao médico.
	 */
	@Override
	public double calculaDesconto() {
		return this.gastosEmCongressos;
	}
	
	/**
	 * Representação em String dos dados do médico.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("\nNúmero de pacientes atendidos: "+numeroDePacientesAtendidos);
		string.append(String.format("\nTotal de gastos em congressos: R$ %,.2f\n", gastosEmCongressos));
		return string.toString();
	}
}
