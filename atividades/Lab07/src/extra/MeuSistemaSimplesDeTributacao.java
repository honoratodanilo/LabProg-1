package extra;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

import java.util.*;
import principal.*;

/**
 * Sistema simples de cadastros de contribuintes e verificação dos seus tributos e descontos.
 */
public class MeuSistemaSimplesDeTributacao {

	List<Contribuinte> listaDeContribuintes = null;
	List<Professor> listaProfessores = null;
	List<Medico> listaMedicos = null;
	List<Caminhoneiro> listaCaminhoneiros = null;
	List<Taxista> listaTaxitas = null;
	Scanner sc = null;
	
	/**
	 * Método principal que inicia a aplicação.
	 * @param args
	 */
	public static void main(String[] args) {
		new MeuSistemaSimplesDeTributacao().menuPrincipal();
	}
	
	/**
	 * Método que chama o menu principal do sistema.
	 */
	private void menuPrincipal() {
		listaDeContribuintes = new ArrayList<>();
		listaProfessores = new ArrayList<>();
		listaMedicos = new ArrayList<>();
		listaCaminhoneiros = new ArrayList<>();
		listaTaxitas = new ArrayList<>();
		sc = new Scanner(System.in);
		int opcao=-1;
		do {
			System.out.println("1 - Cadastrar novo contribuinte");
			System.out.println("2 - Calcular impostos e descontos de um contribuinte");
			System.out.println("3 - Mostrar dados de todos contribuintes");
			System.out.println("4 - Listar os contribuintes em função dos sinais exteriores de riqueza indicando se são excessivos ou não");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			if(sc.hasNextInt()) {
				opcao = sc.nextInt();
			} else {
				sc.nextLine();
				opcao = -1;
			}
	
			switch (opcao) {
			case 1:
				cadastrarContribuinte();
				break;
			case 2:
				calcularImpostosEDescontos();
				break;
			case 3:
				listarTodosContribuintes();
				break;
			case 4:
				sinaisExterioresDeRiqueza();
				break;
			case 0:
				imprimeLinha();
				System.out.println("Programa finalizado.");
				imprimeLinha();
				break;
			default:
				imprimeLinha();
				System.out.println("Opção inválida!");
				imprimeLinha();
				break;
			}
			sc.nextLine();
		}while(opcao != 0);
	}

	/**
	 * Método responsável por fazer coletar todos dados (de um contribuinte selecionável) e cadastrá-lo.
	 */
	private void cadastrarContribuinte() {
		imprimeLinha();
		int opcao = 0;
		System.out.println("Selecione o tipo de contribuinte a ser cadastrado:");
		System.out.println("[1] Professor - [2] Médico - [3] Caminhoneiro - [4] Taxista");
		do {
			System.out.print("Opção: ");
			if(sc.hasNextInt())
				opcao = sc.nextInt();
			else
				sc.nextLine();
		}while(opcao < 1 || opcao > 4);
		sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		Random rand = new Random();
		int numeroDoContribuinte = rand.nextInt(Integer.MAX_VALUE);
		System.out.printf("Número do contribuinte: %d\n", numeroDoContribuinte);
		System.out.println("Tem casa própria? [1] SIM - [2] NÃO");
		int opCasa = 0;
		do {
			System.out.print("Opção: ");
			if(sc.hasNextInt())
				opCasa = sc.nextInt();
			else{
				sc.nextLine();
			}
		}while(opCasa != 1 && opCasa != 2);
		System.out.println("Tem carro ? [1] SIM - [2] NÃO");
		int opCarro = 0;
		do {
			System.out.print("Opção: ");
			if(sc.hasNextInt())
				opCarro = sc.nextInt();
			else
				sc.nextLine();
		}while(opCarro != 1 && opCarro != 2);
		double valorDosBens = -1;
		System.out.print("Valor dos bens: ");
		if(sc.hasNextDouble())
			valorDosBens = sc.nextDouble();
		else
			sc.nextLine();
		
		switch (opcao) {
		case 1: 
			System.out.print("Salário: ");
			double salario = -1;
			if(sc.hasNextDouble())
				salario = sc.nextDouble();
			else
				sc.nextLine();
			System.out.print("Seus gastos com materiais: ");
			double gastosComMateriais = -1;
			if(sc.hasNextDouble())
				gastosComMateriais = sc.nextDouble();
			else
				sc.nextLine();
			try {
				Professor prof = new Professor(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, salario, gastosComMateriais);
				listaDeContribuintes.add(prof);
				listaProfessores.add(prof);
				System.out.println("\nContribuinte cadastrado com sucesso!");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2: 
			System.out.print("Número de pacientes atendidos: ");
			int numeroDePacientes = -1;
			if(sc.hasNextInt())
				numeroDePacientes = sc.nextInt();
			else
				sc.nextLine();
			System.out.print("Seus gastos em congressos: ");
			double gastosEmCongressos = -1;
			if(sc.hasNextDouble())
				gastosEmCongressos = sc.nextDouble();
			else
				sc.nextLine();
			try {
				Medico med = new Medico(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, numeroDePacientes, gastosEmCongressos);
				listaDeContribuintes.add(med);
				listaMedicos.add(med);
				System.out.println("\nContribuinte cadastrado com sucesso!");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.print("KM percorridos: ");
			double KMpercorridos = -1;
			if(sc.hasNextDouble())
				KMpercorridos = sc.nextDouble();
			else
				sc.nextLine();
			System.out.print("Total de toneladas transportadas: ");
			double toneladasTransportadas = -1;
			if(sc.hasNextDouble())
				toneladasTransportadas = sc.nextDouble();
			else
				sc.nextLine();
			try {
				Caminhoneiro cam = new Caminhoneiro(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, KMpercorridos, toneladasTransportadas);
				listaDeContribuintes.add(cam);
				listaCaminhoneiros.add(cam);
				System.out.println("\nContribuinte cadastrado com sucesso!");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			System.out.print("KM percorridos: ");
			double quilometrosPercorridos = -1;
			if(sc.hasNextDouble())
				quilometrosPercorridos = sc.nextDouble();
			else
				sc.nextLine();
			System.out.print("Número de passageiros transportados: ");
			int passageirosTransportados = -1;
			if(sc.hasNextInt())
				passageirosTransportados = sc.nextInt();
			else
				sc.nextLine();
			try {
				Taxista taxi = new Taxista(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, quilometrosPercorridos, passageirosTransportados);
				listaDeContribuintes.add(taxi);
				listaTaxitas.add(taxi);
				System.out.println("\nContribuinte cadastrado com sucesso!");
			}catch (Exception e) {
				System.out.println("\n"+e.getMessage());
			}
			break;
		}
		imprimeLinha();
	}
	
	/**
	 * Calcula os impostos e descontos de um contribuinte especificado.
	 */
	private void calcularImpostosEDescontos() {
		imprimeLinha();
		sc.nextLine();
		System.out.println("LISTA DE TODOS OS CONTRIBUINTES\n");
		for(int i = 0; i < listaDeContribuintes.size(); i++) {
			System.out.printf("%02d - %s\n", i+1, listaDeContribuintes.get(i).getNome());
		}
		System.out.print("\nNome do contribuinte ser verificado: ");
		String nome = sc.nextLine();
		boolean status = true;
		for(int i = 0; i < listaDeContribuintes.size(); i++) {
			if(listaDeContribuintes.get(i).getNome().equals(nome)) {
				imprimeLinha();
				System.out.printf("Nome do contribuinte: %s\n", nome);
				System.out.printf("Total de tributos calculados: R$ %,.2f\n", listaDeContribuintes.get(i).calculaTributos());
				System.out.printf("Descontos totais: R$ %,.2f\n", listaDeContribuintes.get(i).calculaDesconto());
				System.out.printf("Valor final a ser pago: R$ %,.2f\n", listaDeContribuintes.get(i).calculaImpostoASerPago());
				status = false;
				break;
			}
		}
		if(status)
			System.out.println("\nO usuário procurado não está cadastrado no sistema.");
		imprimeLinha();
	}
	
	/**
	 * Lista todos os contribuintes cadastrados no sistema.
	 */
	private void listarTodosContribuintes() {
		imprimeLinha();
		System.out.println("LISTA DE TODOS OS CONTRIBUINTES\n");
		for(int i = 0; i < listaDeContribuintes.size(); i++) {
			System.out.println(listaDeContribuintes.get(i));
		}
		imprimeLinha();
	}
	
	/**
	 * Verifica os usuários que possuem ou não sinais exteriores de riqueza levando em conta sua categoria.
	 */
	private void sinaisExterioresDeRiqueza() {
		imprimeLinha();
		int opcao = 0;
		System.out.println("Selecione a categoria que deseja verificar:");
		System.out.println("[1] Professor - [2] Médico - [3] Caminhoneiro - [4] Taxista");
		do {
			System.out.print("Opção: ");
			if(sc.hasNextInt())
				opcao = sc.nextInt();
			else
				sc.nextLine();
		}while(opcao < 1 || opcao > 4);
		imprimeLinha();
		switch (opcao) {
		case 1:
			if(!listaProfessores.isEmpty()) {
				double mediaProfessores = Contribuinte.calculaMediaDosBensDeContribuintes(listaProfessores);
				System.out.println("LISTA DE PROFESSORES\n");
				for(int i = 0; i < listaProfessores.size(); i++) {
					System.out.printf("Nome: %-25s Bens: R$ %-15s Externa riqueza: %s\n", listaProfessores.get(i).getNome(), String.format("%,.2f", listaProfessores.get(i).getValorDosBens()), listaProfessores.get(i).sinaisExterioresDeRiquezaExcessivos(mediaProfessores) ? "Sim" : "Não");
				}
			}else {
				System.out.println("Nenhum professor cadastrado.");
			}
			break;
		case 2:
			if(!listaMedicos.isEmpty()) {
				double mediaMedicos = Contribuinte.calculaMediaDosBensDeContribuintes(listaMedicos);
				System.out.println("LISTA DE MÉDICOS\n");
				for(int i = 0; i < listaMedicos.size(); i++) {
					System.out.printf("Nome: %-25s Bens: R$ %-15s Externa riqueza: %s\n", listaMedicos.get(i).getNome(), String.format("%,.2f", listaMedicos.get(i).getValorDosBens()), listaMedicos.get(i).sinaisExterioresDeRiquezaExcessivos(mediaMedicos) ? "Sim" : "Não");
				}
			}else {
				System.out.println("Nenhum médico cadastrado.");
			}
			break;
		case 3:
			if(!listaCaminhoneiros.isEmpty()) {
				double mediaCaminhoneiros = Contribuinte.calculaMediaDosBensDeContribuintes(listaCaminhoneiros);
				System.out.println("LISTA DE CAMINHONEIROS\n");
				for(int i = 0; i < listaCaminhoneiros.size(); i++) {
					System.out.printf("Nome: %-25s Bens: R$ %-15s Externa riqueza: %s\n", listaCaminhoneiros.get(i).getNome(), String.format("%,.2f", listaCaminhoneiros.get(i).getValorDosBens()), listaCaminhoneiros.get(i).sinaisExterioresDeRiquezaExcessivos(mediaCaminhoneiros) ? "Sim" : "Não");
				}
			}else {
				System.out.println("Nenhum caminhoneiro cadastrado.");
			}	
			break;
		case 4:
			if(!listaTaxitas.isEmpty()) {
				double mediaTaxistas = Contribuinte.calculaMediaDosBensDeContribuintes(listaTaxitas);
				System.out.println("LISTA DE TAXISTAS\n");
				for(int i = 0; i < listaTaxitas.size(); i++) {
					System.out.printf("Nome: %-25s Bens: R$ %-15s Externa riqueza: %s\n", listaTaxitas.get(i).getNome(), String.format("%,.2f", listaTaxitas.get(i).getValorDosBens()), listaTaxitas.get(i).sinaisExterioresDeRiquezaExcessivos(mediaTaxistas) ? "Sim" : "Não");
				}
			}else {
				System.out.println("Nenhum taxista cadastrado.");
			}			
			break;
		}
		imprimeLinha();
	}

	/**
	 * Imprime linha para dividir os menus.
	 */
	private static void imprimeLinha() {
		for(int i = 0; i < 110; i++)
			System.out.print("-");
		System.out.println();
	}
}