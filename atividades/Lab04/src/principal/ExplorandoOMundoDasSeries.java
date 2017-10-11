package principal;

import java.util.Scanner;

/*
 * Aluno 01: Ivanildo Simpl�cio da Silva Filho
 * Aluno 02: Carlos Vinicius Nascimento Lira
 * Aluno 03: Fernanda Eduarda de Medeiros Silva
 */

/**
 * Classe para manipular s�ries matem�ticas (Usando as classes ProgressaoAritmetica e Fibonacci).
 * 	@version 1.0 11/10/2017 15:48
 *	@author Ivanildo/Vinicius/Fernanda
 */
public class ExplorandoOMundoDasSeries {

	private static Scanner sc = new Scanner(System.in);
	private static ProgressaoAritmetica pa = null;
	private static Fibonacci fib = null;
	
	/**
	 * Met�do main, inicializador do programa.
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
			System.out.println("1 - Criar uma Progress�o Aritm�tica");
			System.out.println("2 - Criar uma Sequ�ncia de Fibonacci");
			System.out.println("3 - Ver n-�simo termo da PA");
			System.out.println("4 - Ver n-�simo termo de Fibonacci");
			System.out.println("5 - Ver os n primeiros termos da PA e de Fibonacci");
			System.out.println("0 - Sair");
			do {
				System.out.print("Op��o: ");
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
			System.out.print("Informa a raz�o da PA: ");
			int razao = sc.nextInt();
			pa = new ProgressaoAritmetica(primeiro, razao);
			System.out.print("\nProgress�o Aritm�tica criada!");
		}else {
			System.out.println("J� existe uma PA criada!");
			System.out.println("Primeiro termo definido: "+pa.primeiro());
			System.out.print("Raz�o da PA: "+pa.getRazao());
		}
	}

	/*
	 * Cria ou reinicializa uma sequ�ncia de Fibonacci.
	 */
	private static void criaSFibonacci() {
		imprimeLinha();
		if(fib == null) {
			fib = new Fibonacci();
			System.out.print("Sequ�ncia de Fibonacci criada!");
		}else {
			System.out.println("Sequ�ncia de Fibonacci j� criada!");
			System.out.print("Primeiro termo da sequ�ncia: "+fib.primeiro());
		}
	}
	
	/*
	 * Solicita e exibe o n-�simo termo da PA.
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
	 * Solicita e exibe o n-�simo termo da sequ�ncia de Fibonacci. 
	 */
	private static void verTermoFibonacci() {
		imprimeLinha();
		if(fib == null) {
			System.out.print("Nenhuma Sequ�ncia de Fibonacci criada!");
		}else {
			System.out.print("Termo da sequ�ncia: ");
			int termo = sc.nextInt();
			System.out.printf("Valor do termo %d da Sequ�ncia: %d", termo, fib.termo(termo));
		}
	}
	
	/*
	 * Mostra os n primeiros termos das duas s�ries.
	 */
	private static void verTermosGerais() {
		imprimeLinha();
		if(pa == null || fib == null) {
			System.out.print("Para exibir os termos � necess�rio que tenha\nsido criada uma PA e uma Sequ�ncia de Fibonacci!");
		}else {
			System.out.print("Deseja ver quantos termos de cada s�rie? ");
			int n = sc.nextInt();
			System.out.println("\nProgress�o Aritm�tica");
			System.out.println(pa.geraTermos(n));
			System.out.printf("Raz�o: %d\nPr�ximo termo da PA: %d\n\n", pa.getRazao(), pa.proximo());
			System.out.println("Sequ�ncia de Fibonacci");
			System.out.println(fib.geraTermos(n));
			System.out.print("Pr�ximo termo da Sequ�ncia: "+fib.proximo());
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
