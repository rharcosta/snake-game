package dama;

public class Tabuleiro {

    private String[][] tabuleiro;
    private int tam, linha, coluna;
    private static final String alfabeto = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Tabuleiro(int tam) {
        tam++;
        this.tam = tam;
        //cria o tabuleiro
        this.tabuleiro = new String[tam][tam];
        //insere dois valores vazios na posição inicial[0][0]
        this.tabuleiro[0][0] = " ";

        //preenche colunas com o alfabeto
        for (coluna = 1; coluna < this.tam; coluna++) {
            this.tabuleiro[0][coluna] = String.valueOf(alfabeto.charAt(coluna));
        }

        //preenche linhas
        for (linha = 1; linha < this.tam; linha++) {
            String numLinha = "";
            if (linha < 10) {
                numLinha += "0";
            }
            //concatenação do valor da linha com um espaço em branco
            numLinha += String.valueOf(linha) + " ";
            this.tabuleiro[linha][0] = numLinha;
        }

        //preenchendo todas as posições com -
        for (linha = 1; linha < this.tam; linha++) {
            for (int coluna = 1; coluna < this.tam; coluna++) {
                this.tabuleiro[linha][coluna] = "-";
            }
        }

        //tamanho do tabuleiro
        if (this.tam == 11) {
            int linhaPeca = 4;
            for (linha = 1; linha <= linhaPeca; linha++) {
                coluna = 0;
                if (linha % 2 == 0) {
                    coluna = 2;
                } else {
                    coluna = 1;
                }
                while (coluna < this.tam) {
                    this.tabuleiro[linha][coluna] = "B";
                    coluna = coluna + 2;
                }
            }
            for (linha = this.tam - 1; linha >= (this.tam - linhaPeca); linha--) {
                coluna = 0;
                if (linha % 2 == 0) {
                    coluna = 2;
                } else {
                    coluna = 1;
                }

                while (coluna < this.tam) {
                    this.tabuleiro[linha][coluna] = "P";
                    coluna = coluna + 2;
                }
            }

        }
    }

    public void imprimirTabuleiro() {
        for (linha = 0; linha < this.tam; linha++) {
            for (coluna = 0; coluna < this.tam; coluna++) {
                System.out.print(this.tabuleiro[linha][coluna]);
            }
            System.out.println("");
        }
        System.out.println("==========================================");
    }

    public void moverPeca(String coordenadas) {
        String[] vetorCoordenadas = coordenadas.split(",");

        String coordenadaAnterior = vetorCoordenadas[0].toUpperCase();
        String novaCoordenada = vetorCoordenadas[1].toUpperCase();

        int linhaAnterior = getLinha(coordenadaAnterior);
        int colunaAnterior = getColuna(coordenadaAnterior);

        String peca = this.tabuleiro[linhaAnterior][colunaAnterior];

        this.tabuleiro[linhaAnterior][colunaAnterior] = "-";

        int novaLinha = getLinha(novaCoordenada);
        int novaColuna = getColuna(novaCoordenada);

        this.tabuleiro[novaLinha][novaColuna] = peca;

        imprimirTabuleiro();
    }

    private int getLinha(String coordenada) {
        return Integer.valueOf(coordenada.substring(0, 1));
    }

    private int getColuna(String coordenada) {
        return alfabeto.indexOf(coordenada.substring(1, 2));
    }
}
