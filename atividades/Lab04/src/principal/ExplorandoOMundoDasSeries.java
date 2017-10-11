package principal;

import java.util.Scanner;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Fernanda Eduarda de Medeiros Silva
 */

/**
 * Classe para manipular séries matemáticas (Usando as classes ProgressaoAritmetica e Fibonacci).
 * 	@version 1.0 11/10/2017 15:48
 *	@author Ivanildo/Vinicius/Fernanda
 */
public class ExplorandoOMundoDasSeries {

	private static Scanner sc = new Scanner(System.in);
	private static ProgressaoAritmetica pa = null;
	private static Fibonacci fib = null;
	
	/**
	 * Metódo main, inicializador do programa.
	 * @param args argumentos da linha de comando.
	 */
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	/*
	 * Menu principal do programa.
	 */
	private static void menuPrincipal() {
		int opcao = -1;
		do {
			System.out.println("1 - Criar uma Progressão Aritmética");
			System.out.println("2 - Criar uma Sequência de Fibonacci");
			System.out.println("3 - Ver n-ésimo termo da PA");
			System.out.println("4 - Ver n-ésimo termo de Fibonacci");
			System.out.println("5 - Ver os n primeiros termos da PA e de Fibonacci");
			System.out.println("0 - Sair");
			do {
				System.out.print("Opção: ");
				if(sc.hasNextInt()) {
					opcao = sc.nextInt();
				}
				sc.nextLine();
			}while(opcao < 0 || opcao > 5);
			
			switch(opcao) {
			case 1:	criaPA();
				break;
			case 2: criaSFibonacci();
				break;
			case 3:	verTermoPA();
				break;
			case 4: verTermoFibonacci();
				break;
			case 5: verTermosGerais();
				break;
			case 0:
				imprimeLinha();
				System.out.print("Programa finalizado!");
			}
			imprimeLinha();
		}while(opcao != 0);
	}

	/*
	 * Cria ou reinicializa uma PA.
	 */
	private static void criaPA() {
		imprimeLinha();
		if(pa == null) {
			System.out.print("Informe o primeiro termo da PA: ");
			int primeiro = sc.nextInt();
			System.out.print("Informa a razão da PA: ");
			int razao = sc.nextInt();
			pa = new ProgressaoAritmetica(primeiro, razao);
			System.out.print("\nProgressão Aritmética criada!");
		}else {
			System.out.println("Já existe uma PA criada!");
			System.out.println("Primeiro termo definido: "+pa.primeiro());
			System.out.print("Razão da PA: "+pa.getRazao());
		}
	}

	/*
	 * Cria ou reinicializa uma sequência de Fibonacci.
	 */
	private static void criaSFibonacci() {
		imprimeLinha();
		if(fib == null) {
			fib = new Fibonacci();
			System.out.print("Sequência de Fibonacci criada!");
		}else {
			System.out.println("Sequência de Fibonacci já criada!");
			System.out.print("Primeiro termo da sequência: "+fib.primeiro());
		}
	}
	
	/*
	 * Solicita e exibe o n-ésimo termo da PA.
	 */
	private static void verTermoPA() {
		imprimeLinha();
		if(pa == null) {
			System.out.print("Nenhuma PA criada!");
		}else {
			System.out.print("Termo da PA: ");
			int termo = sc.nextInt();
			System.out.printf("Valor do termo %d da PA: %d", termo, pa.termo(termo));
		}
	}
	
	/*
	 * Solicita e exibe o n-ésimo termo da sequência de Fibonacci. 
	 */
	private static void verTermoFibonacci() {
		imprimeLinha();
		if(fib == null) {
			System.out.print("Nenhuma Sequência de Fibonacci criada!");
		}else {
			System.out.print("Termo da sequência: ");
			int termo = sc.nextInt();
			System.out.printf("Valor do termo %d da Sequência: %d", termo, fib.termo(termo));
		}
	}
	
	/*
	 * Mostra os n primeiros termos das duas séries.
	 */
	private static void verTermosGerais() {
		imprimeLinha();
		if(pa == null || fib == null) {
			System.out.print("Para exibir os termos é necessário que tenha\nsido criada uma PA e uma Sequência de Fibonacci!");
		}else {
			System.out.print("Deseja ver quantos termos de cada série? ");
			int n = sc.nextInt();
			System.out.println("\nProgressão Aritmética");
			System.out.println(pa.geraTermos(n));
			System.out.printf("Razão: %d\nPróximo termo da PA: %d\n\n", pa.getRazao(), pa.proximo());
			System.out.println("Sequência de Fibonacci");
			System.out.println(fib.geraTermos(n));
			System.out.print("Próximo termo da Sequência: "+fib.proximo());
		}
	}
	/*
	 * Imprime uma linha tracejada para separar os menus.
	 */
	private static void imprimeLinha() {
		System.out.println();
		for(int i = 0; i < 50; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
