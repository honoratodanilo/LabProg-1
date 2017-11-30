package extra;

import java.util.*;
import principal.*;

/*
 * Aluno 01: <Ivanildo Simplício da Silva Filho>
 * Aluno 02: <Fernanda Eduarda de Medeiros Silva>
 * Aluno 03: <Evelin Florenço da Silva>
 */

/**
 * Sistema simples de cadastros de contribuintes e verificação dos seus tributos e descontos.
 */
public class MeuSistemaSimplesDeTributacao {

	List<Contribuinte> listaDeContribuintes = null;
	Scanner sc = null;
	
	public static void main(String[] args) {
		new MeuSistemaSimplesDeTributacao().menuPrincipal();
	}
	
	public void menuPrincipal() {
		listaDeContribuintes = new ArrayList<Contribuinte>();
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
				System.out.println("Opção em construção...");
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
				listaDeContribuintes.add(new Professor(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, salario, gastosComMateriais));
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
				listaDeContribuintes.add(new Medico(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, numeroDePacientes, gastosEmCongressos));
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
				listaDeContribuintes.add(new Caminhoneiro(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, KMpercorridos, toneladasTransportadas));
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
				listaDeContribuintes.add(new Taxista(nome, numeroDoContribuinte, opCasa == 1, opCarro == 1, valorDosBens, quilometrosPercorridos, passageirosTransportados));
				System.out.println("\nContribuinte cadastrado com sucesso!");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		imprimeLinha();
	}
	
	private void calcularImpostosEDescontos() {
		imprimeLinha();
		System.out.println("Lista de todos os contribuintes:");
		for(int i = 0; i < listaDeContribuintes.size(); i++) {
			System.out.printf("%02d - %s\n", i+1, listaDeContribuintes.get(i).getNome());
		}
		imprimeLinha();
	}
	
	private void listarTodosContribuintes() {
		imprimeLinha();
		System.out.println("LISTA DE TODOS OS CONTRIBUINTES\n");
		for(int i = 0; i < listaDeContribuintes.size(); i++) {
			System.out.println(listaDeContribuintes.get(i));
		}
		imprimeLinha();
	}
	
	public static void imprimeLinha() {
		for(int i = 0; i < 110; i++)
			System.out.print("-");
		System.out.println();
	}
}
