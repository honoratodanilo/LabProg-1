package principal;

import java.util.Scanner;

/*
 * Aluno: Ivanildo Simplício da Silva Filho
 * 
 */

public class MinMaxRefatorado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int valores[] = new int[3];
		int min, max;
		
		for(int i = 0; i < valores.length; i++) {
			System.out.printf("Insira o valor %d: ", i+1);
			valores[i] = sc.nextInt();
		}
		
		min = max = valores[0];
		for(int i = 1; i < valores.length; i++) {
			if(valores[i] > max) {
				max = valores[i];
			}else if(valores[i] < min){
				min = valores[i];
			}
		}
		
		System.out.println("Menor valor: "+min);
		System.out.println("Maior valor: "+max);
	}
}
