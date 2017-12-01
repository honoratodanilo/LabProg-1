package principal;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Classe que define todas as características de um professor.
 */
public class Professor extends Contribuinte {

	private final double SALARIO_MINIMO = 925.00;
	private double salario;
	private double gastosComMateriais;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do professor.
	 * @param numeroDoContribuinte Número de cadastro do contribuinte.
	 * @param temCasaPropria Será passado true se o professor tiver casa própria, false se não tiver.
	 * @param temCarro Será passado true se o professor tiver carro, false se não tiver.
	 * @param valorDosBens Valor somado de todos os bens do professor.
	 * @param salario Valor do salário recebido pelo professor.
	 * @param gastosComMateriais Total de gastos que o professor teve com seus materiais.
	 * @throws Exception Será lançada caso alguma informação passada ao construtor seja inválida.
	 */
	public Professor(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double salario, double gastosComMateriais) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(salario, gastosComMateriais);
	}

	/**
	 * Valida as informações do professor.
	 * @param salario Será validado o valor do salário do professor que será passado como argumento.
	 * @param gastosComMateriais Será validado o valor total de gastos com materiais que o professor teve e que será passado como argumento.
	 * @throws Exception Será lançada caso alguma informação passada seja inválida.
	 */
	private void validaDados(double salario, double gastosComMateriais) throws Exception{
		if(salario > 0) {
			this.salario = salario;
		}else {
			throw new Exception("Valor do salário do professor inválido.");
		}
		if(gastosComMateriais >= 0) {
			this.gastosComMateriais = gastosComMateriais;
		}else {
			throw new Exception("Os gastos com materiais não pode ser um valor negativo.");
		}		
	}
	
	/**
	 * Retorna o salário do professor.
	 * @return O salário do professor.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Retorna o valor total que o professor teve com materiais.
	 * @return O valor gasto em materiais.
	 */
	public double getGastosComMateriais() {
		return gastosComMateriais;
	}

	/**
	 * Calcula o devido valor do imposto que deverá ser pago pelo professor.
	 */
	@Override
	public double calculaTributos() {
		double imposto;
		if(salario <= SALARIO_MINIMO) {
			imposto = (salario * 0.05);
		}else if(salario <= 5*SALARIO_MINIMO) {
			imposto = (salario * 0.1);
		}else {
			imposto = (salario * 0.2);
		}
		return imposto;
	}

	/**
	 * Calcula os descontos que serão aplicados ao professor.
	 */
	@Override
	public double calculaDesconto() {
		return (gastosComMateriais * 0.5);
	}
	
	/**
	 * Representação em String dos dados do professor.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nSalário: R$ %,.2f", salario));
		string.append(String.format("\nGastos com materiais: R$ %,.2f\n", gastosComMateriais));
		return string.toString();
	}
}
