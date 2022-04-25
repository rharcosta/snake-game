package dama;

public class Tabuleiro {
    private String[][] tabuleiro;
    private int tam;
    private static final String alfabeto = "@abcdefghijklmnopqrstuvwxyz";
    
    public Tabuleiro(int tam){
        tam++;
        this.tam = tam;
        this.tabuleiro = new String[tam][tam];
        this.tabuleiro[0][0] = " ";
        
        for(int coluna = 1; coluna < this.tam; coluna++){
            this.tabuleiro[0][coluna] = String.valueOf(alfabeto.charAt(coluna));
        }
        for(int linha = 1; linha < this.tam; linha++)
    }
}
