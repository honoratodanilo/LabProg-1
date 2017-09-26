package principal;

import java.util.Arrays;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 * Aluno 02: Fernanda Eduarda de Medeiros Silva
 * Aluno 03: Wesley Porto Santos
 */

import java.util.Scanner;

public class JogoDaVelhaCampeonato {

	final int NUMERO_DE_JOGADORES = 4;
	Scanner sc = new Scanner(System.in);
	char tabuleiro[][] = new char[3][3];
	String[] jogadoresNomes = new String[NUMERO_DE_JOGADORES];
	int[] jogadoresVitorias = new int[NUMERO_DE_JOGADORES];
	final int SAIR = 0;
	final char O = 'O';
	final char X = 'X';
	int linha, coluna, jogada, player1, player2;

	public static void main(String args[]){
		JogoDaVelhaCampeonato jogo = new JogoDaVelhaCampeonato();
		jogo.inscreveJogadores();
		while(jogo.play());
	}

	public void inscreveJogadores() {
		System.out.print("Inscrição dos jogadores\npara o campeonato");
		imprimeLinha();
		for(int i = 0; i < NUMERO_DE_JOGADORES; i++) {
			System.out.printf("Player %d: ", i+1);
			if(sc.hasNextLine()) {
				jogadoresNomes[i] = sc.nextLine();
			}
		}
	}
	
	public void selecionaDuelo() {
		player1 = player2 = -1;
		imprimeMensagem("Jogadores inscritos\n"+Arrays.toString(jogadoresNomes)+"\n\nSelecione os jogadores\npara o duelo [1,2,3,4]");
		do {
			System.out.print("Player 1: ");
			if(sc.hasNextInt())
				player1 = sc.nextInt()-1;
			sc.nextLine();
			
		}while(player1 < 0 || player1 > NUMERO_DE_JOGADORES-1);
		
		do {
			System.out.print("Player 2: ");
			if(sc.hasNextInt())
				player2 = sc.nextInt()-1;
			sc.nextLine();
		}while(player2 < 0 || player2 > NUMERO_DE_JOGADORES-1 || player2 == player1);
		
	}
	
	public boolean play() {
		int opcao = -1;
		selecionaDuelo();
		do {
			jogada = 0;
			limpaTabuleiro();
			while(jogada<9){

				mostraTabuleiro();
				jogada();

				if(testaVitoria(O)){
					mostraResultado(String.format("%s venceu!!!", jogadoresNomes[player1]));
					++jogadoresVitorias[player1];
					break;
				}else if(testaVitoria(X)){
					mostraResultado(String.format("%s venceu!!!", jogadoresNomes[player2]));
					++jogadoresVitorias[player2];
					break;
				}else if(jogada==9){
					mostraResultado("Partida empatada!!!");
					break;
				}
			}
			opcao = menu();
			if(opcao == 2)
				return true;
			
		}while(opcao != SAIR);
		exibeRanking();
		sc.close();
		return false;
	}

	public void jogada() {
		linha = coluna = 0;
		if((jogada%2) == 1)
			System.out.printf("\n\n%s - \"X\"\nINSIRA AS COORDENADAS\n", jogadoresNomes[player2]);
		else
			System.out.printf("\n\n%s - \"O\"\nINSIRA AS COORDENADAS\n", jogadoresNomes[player1]);
		do {
			System.out.print("LINHA: ");
			if(sc.hasNextInt()) {
				linha = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("COLUNA: ");
			if(sc.hasNextInt()) {
				coluna = sc.nextInt();	
			}
			sc.nextLine();
		}while((linha < 1 || linha > 3) || (coluna < 1 || coluna > 3));

		if(tabuleiro[linha-1][coluna-1] == ' '){
			if((jogada%2) == 1) {
				tabuleiro[linha-1][coluna-1] = X;
			}else{
				tabuleiro[linha-1][coluna-1] = O;
			}
			jogada++;
		}
	}

	public boolean testaVitoria(char c) {
		return  (tabuleiro[0][0]==c && tabuleiro[0][1]==c && tabuleiro[0][2]==c)||
				(tabuleiro[1][0]==c && tabuleiro[1][1]==c && tabuleiro[1][2]==c)||
				(tabuleiro[2][0]==c && tabuleiro[2][1]==c && tabuleiro[2][2]==c)||
				(tabuleiro[0][0]==c && tabuleiro[1][0]==c && tabuleiro[2][0]==c)||
				(tabuleiro[0][1]==c && tabuleiro[1][1]==c && tabuleiro[2][1]==c)||
				(tabuleiro[0][2]==c && tabuleiro[1][2]==c && tabuleiro[2][2]==c)||
				(tabuleiro[0][0]==c && tabuleiro[1][1]==c && tabuleiro[2][2]==c)||
				(tabuleiro[0][2]==c && tabuleiro[1][1]==c && tabuleiro[2][0]==c);
	}

	public void mostraTabuleiro() {
		imprimeMensagem("    JOGO DA VELHA");
		for(int i = 0; i < 3; i++){
			System.out.printf("     %c | %c | %c ", tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]);
			if(i < 3-1){
				System.out.print("\n    -----------\n");
			}
		}
	}

	public void mostraResultado(String mensagem) {
		mostraTabuleiro();
		imprimeMensagem(mensagem);
	}

	public void imprimeMensagem(String mensagem) {
		imprimeLinha();
		System.out.print(mensagem);
		imprimeLinha();
	}

	public void limpaTabuleiro() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tabuleiro[i][j] = ' ';
	}
	
	public void imprimeLinha() {
		System.out.println();
		for(int i = 0; i < 25; i++)
			System.out.print("-");
		System.out.println();
	}
	
	public void exibeRanking() {
		ordenaRanking();
		imprimeMensagem("Ranking geral");
		System.out.printf("VENCEU   JOGADOR\n");
		for(int i = 0; i < NUMERO_DE_JOGADORES; i++) {
			System.out.printf("%4d     %s\n", jogadoresVitorias[i], jogadoresNomes[i]);
		}
	}
	
	public void ordenaRanking() {
		for(int i = 0; i < NUMERO_DE_JOGADORES; i++) {
			int maior = i;
			for(int j = i+1; j < NUMERO_DE_JOGADORES; j++) {
				if(jogadoresVitorias[maior] < jogadoresVitorias[j]) {
					maior = j;
				}
			}
			if(maior != i) {
				int aux = jogadoresVitorias[maior];
				jogadoresVitorias[maior] = jogadoresVitorias[i];
				jogadoresVitorias[i] = aux;
				String sAux = jogadoresNomes[maior];
				jogadoresNomes[maior] = jogadoresNomes[i];
				jogadoresNomes[i] = sAux;
			}
		}
	}
	
	public int menu() {
		int opcao = -1;
		System.out.println("1 - Repetir duelo");
		System.out.println("2 - Novo duelo");
		System.out.println("0 - Sair");
		do {
			System.out.print("Opção: ");
			if(sc.hasNextInt()) {
				opcao = sc.nextInt();
			}
			sc.nextLine();
		}while(opcao < 0 || opcao > 2);
		return opcao;
	}
	
}
