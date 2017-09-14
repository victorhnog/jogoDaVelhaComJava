package org.meuprimeiroscript;
import java.util.Scanner;

class Principal{
	//Retorna os elementos do tabuleiro
	static void retornaTabuleiro(String tab[][]) {
		for(byte i=0; i<=2; i++){
			for(byte j=0; j<=2; j++){
				System.out.printf("%s ", tab[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.print("\n\n");
	}
	
	//Faz a jogada - substitui elemento pela inicial do jogador
	static void fazerJogada(String tab[][], String jogador) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("Linha: ");
		byte linha = teclado.nextByte();
		System.out.printf("Coluna: ");
		byte coluna = teclado.nextByte();
		
		for(byte i=0; i<=2; i++) {
			for(byte j=0; j<=2; j++) {
				if(tab[i][j] == "0") {
					//posicao disponivel para fazer a jogada
					if(i == linha && j == coluna){
						tab[i][j] = jogador;
						retornaTabuleiro(tab);
						break;
					}
				}else {
					//posicao indisponivel para fazer jogada
				}
			}
		}
	}
	
	//verifica se todos os elementos do tabuleiro estao em "branco"
	static boolean verificaFinalizou(String tab[][]) {
		boolean finalizou = true;
		for(byte i=0; i<=2; i++) {
			for(byte j=0; j<=2; j++) {
					if(tab[i][j] == "0"){
						finalizou = false;
					}
				}
			}
		return finalizou;
	}
	
	public static void main(String[] args){
		String tabuleiro[][] = {{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
		String jogadorUm = "1";
		String jogadorDois = "2";
		String vez = jogadorUm;
		
		retornaTabuleiro(tabuleiro);
		while(verificaFinalizou(tabuleiro) == false) {
			System.out.printf("Vez do jogado %s\n", vez);
			fazerJogada(tabuleiro, vez);
			if(vez == jogadorUm) {
				vez = jogadorDois;
			}else {
				vez = jogadorUm;
			}
		}
		
	}
}