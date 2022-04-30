package dama;

public class Dama {

    
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(10);
        tabuleiro.imprimirTabuleiro();
        tabuleiro.moverPeca("4B,5A");
        tabuleiro.moverPeca("7a,6b");
    }   
}
