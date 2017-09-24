package principal;

/*
 * Aluno 01: Ivanildo Simplício da Silva Filho
 */

import java.util.Scanner;

public class JogoDaVelhaModularizado {
	
	Scanner sc = new Scanner(System.in);
	char tabuleiro[][] = new char[3][3];
	final String SAIR = "-1";
	final char O = 'O';
	final char X = 'X';
    int linha, coluna, jogada;
    
	public static void main(String args[]){
		JogoDaVelhaModularizado jogo = new JogoDaVelhaModularizado();
		jogo.play();  
	}
	
	public void play() {
		String opcao = "";
		do {
			jogada = 0;
			limpaTabuleiro();
			while(jogada<=1){
				
				mostraTabuleiro();
				jogada();
	
				if(testaVitoria(O)){
					mostraResultado("O PLAYER 1 VENCEU!!!");
					break;
				}else if(testaVitoria(X)){
					mostraResultado("O PLAYER 2 VENCEU!!!");
					break;
				}else if(jogada==9){
					mostraResultado("PARTIDA EMPATADA!!!");
					break;
				}
			}
			imprimeMensagem("DIGITE -1 PARA SAIR\nOU ENTER PARA INICIAR\nUMA NOVA PARTIDA");
			if(sc.hasNextLine()) {
				opcao = sc.nextLine();
			}
		}while(!opcao.equals(SAIR));
		sc.close();
	}
	
	public void jogada() {
		linha = coluna = 0;
		if((jogada%2) == 1)
			System.out.println("\n\nPLAYER 2 - \"X\"\nINSIRA AS COORDENADAS");
		else
			System.out.println("\n\nPLAYER 1 - \"O\"\nINSIRA AS COORDENADAS");
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
		System.out.println("\n---------------------");
		System.out.println(mensagem);
		System.out.println("---------------------");
	}
	
	public void limpaTabuleiro() {
		for(int i = 0; i < 3; i++)
	        for(int j = 0; j < 3; j++)
	            tabuleiro[i][j] = ' ';
	}
}