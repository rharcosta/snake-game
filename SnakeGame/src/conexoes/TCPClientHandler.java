package conexoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;
import snakegame.Jogar;

public class TCPClientHandler extends Thread {

    private Socket socket;
    private Jogar caller;
    private BufferedReader input;

    public TCPClientHandler(Socket socket, Jogar caller) throws IOException {
        this.socket = socket;
        this.caller = caller;
        this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {
        String message;
        while (true) {
            try {
                if (this.socket.isConnected() && this.input != null) {
                    message = this.input.readLine();
                } else {
                    break;
                }
                if (message == null || message.equals("")) {
                    break;
                }
                StringTokenizer tokens = new StringTokenizer(message, "|");
                this.caller.larguraTela = Integer.parseInt(tokens.nextToken());
                this.caller.alturaTela = Integer.parseInt(tokens.nextToken());
                //this.caller.area = Integer.parseInt(tokens.nextToken());
                this.caller.tamUnidade = Integer.parseInt(tokens.nextToken());
                //this.caller.delay = Integer.parseInt(tokens.nextToken());
                this.caller.macaX = Integer.parseInt(tokens.nextToken());
                this.caller.macaY = Integer.parseInt(tokens.nextToken());
                this.caller.corpo1 = Integer.parseInt(tokens.nextToken());
                this.caller.corpo2 = Integer.parseInt(tokens.nextToken());
                //this.caller.direcao1 = tokens.nextToken().charAt(0);
                //this.caller.direcao2 = tokens.nextToken().charAt(0);
                this.caller.x1 = lerVetor(tokens.nextToken());
                this.caller.y1 = lerVetor(tokens.nextToken());
                this.caller.x2 = lerVetor(tokens.nextToken());
                this.caller.y2 = lerVetor(tokens.nextToken());
                this.caller.ativo = Boolean.parseBoolean(tokens.nextToken());
                this.caller.iniciar();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }
    }
    
    private int[] lerVetor(String mensagem){
        StringTokenizer tokens = new StringTokenizer(mensagem, ",");
        int numeroDeValores = mensagem.length() - mensagem.replace(",", "").length() + 1;
        int[] vetor = new int[numeroDeValores];
        
        for (int i = 0; i < numeroDeValores; i++) {
            vetor[i] = Integer.parseInt(tokens.nextToken());
        }
        return vetor;
    }
}
