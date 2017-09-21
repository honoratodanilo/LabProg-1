package principal;

import java.util.Random;
import java.util.Scanner;

/*
 * Aluno: Ivanildo Simplício da Silva Filho
 */

public class PedraPapelTesoura {
	
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	final int COMBINACOES = 3;
	final int SAIR = -1;
	int escolhaPlayer1;
	int escolhaPlayer2;
	String tipoJogador;
	
	public static void main(String[] args) {
		PedraPapelTesoura jogo = new PedraPapelTesoura();
		jogo.play();
	}
	
	public void play() {
		tipoJogador = tipoDeJogo();
		while(true) {
			System.out.print("JOGADOR 1:");
			escolhaPlayer1 = escolhaDoJogador();
			System.out.printf("%s: ", tipoJogador);
			if(tipoJogador.equals("COMPUTADOR")){
				escolhaPlayer2 = 1+rand.nextInt(3);
				System.out.println(escolhaPlayer2);
			}else {
				escolhaPlayer2 = escolhaDoJogador();
			}
			
			System.out.printf("\n%s - %s\n", jogada(escolhaPlayer1), jogada(escolhaPlayer2));
			if(!resultado()) {
				sc.nextLine();
				String buffer = sc.nextLine();
				if(buffer.equals("-1"))
					break;
			}
		}
	}
	
	public String tipoDeJogo() {
		int opcao = -1;
		do {
			System.out.print("Deseja jogar contra: (1) Player - (2) Computador ? ");
			if(sc.hasNextInt()) {
				opcao = sc.nextInt();
			}
			sc.nextLine();
		}while(opcao < 1 || opcao > 2);
		return opcao == 1 ? "JOGADOR 2" : "COMPUTADOR";
	}	
	
	public int escolhaDoJogador() {
		int escolha = -1;
		do {
			System.out.print("\n(1) Pedra - (2) Papel - (3) Tesoura? ");
			if(sc.hasNextInt()) {
				escolha = sc.nextInt();
			}
			sc.nextLine();
		}while(escolha < 1 || escolha > COMBINACOES);
		return escolha;
	}
	
	public String jogada(int escolhaDoPlayer) {
		String jogada = "";
		switch(escolhaDoPlayer) {
			case 1: jogada = "PEDRA";
				break;
			case 2: jogada = "PAPEL";
				break;
			case 3: jogada = "TESOURA";
				break;
		}
		return jogada;
	}
	
	public boolean resultado() {
		int resultado = Math.abs((COMBINACOES+escolhaPlayer1-escolhaPlayer2) % COMBINACOES);

		if(0 < resultado && resultado <= (COMBINACOES/2)) {
			System.out.println("O JOGADOR 1 VENCEU!");
		}else if(resultado > (COMBINACOES/2)) {
			System.out.printf("O %s VENCEU!\n", tipoJogador);
		}else{
			System.out.println("EMPATE!\n");
			return true;
		}
		return false;
	}
}
