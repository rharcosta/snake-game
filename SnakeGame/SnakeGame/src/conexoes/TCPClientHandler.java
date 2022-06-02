package conexoes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.Timer;
import snakegame.Jogar;

public class TCPClientHandler extends Thread implements ActionListener {

    private Socket socket;
    private Jogar caller;
    private BufferedReader input;
    public Timer timer;
    int delay, delayAtual;

    public TCPClientHandler(Socket socket, Jogar caller) throws IOException {
        this.socket = socket;
        this.caller = caller;
        this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {
        boolean msg = true;
        while (msg) {
            msg = lerMensagem();
        }
    }

    private int[] lerVetor(String mensagem) {
        StringTokenizer tokens = new StringTokenizer(mensagem, ",");
        int numeroDeValores = mensagem.length() - mensagem.replace(",", "").length() + 1;
        int[] vetor = new int[numeroDeValores];

        for (int i = 0; i < numeroDeValores; i++) {
            vetor[i] = Integer.parseInt(tokens.nextToken());
        }
        return vetor;
    }

    private boolean lerMensagem() {
        String message;
        try {
            if (this.socket.isConnected() && this.input != null) {
                message = this.input.readLine();
                //System.out.println("Input");
            } else {
                //System.out.println("No input");
                return false;
            }
            if (message == null || message.equals("")) {
                //System.out.println("Mensagem nula");
                return false;
            }
            //System.out.println("Mensagem recebida.");
            //System.out.println("Mensagem: " + message);
            StringTokenizer tokens = new StringTokenizer(message, "|");
            caller.larguraTela = Integer.parseInt(tokens.nextToken());
            caller.alturaTela = Integer.parseInt(tokens.nextToken());
            caller.area = Integer.parseInt(tokens.nextToken());
            caller.tamUnidade = Integer.parseInt(tokens.nextToken());
            delay = Integer.parseInt(tokens.nextToken());
            caller.ativo = Boolean.parseBoolean(tokens.nextToken());
            caller.macaX = Integer.parseInt(tokens.nextToken());
            caller.macaY = Integer.parseInt(tokens.nextToken());
            caller.corpo1 = Integer.parseInt(tokens.nextToken());
            caller.corpo2 = Integer.parseInt(tokens.nextToken());
            caller.direcao1 = tokens.nextToken().charAt(0);
            caller.direcao2 = tokens.nextToken().charAt(0);
            caller.x1 = lerVetor(tokens.nextToken());
            caller.y1 = lerVetor(tokens.nextToken());
            caller.x2 = lerVetor(tokens.nextToken());
            caller.y2 = lerVetor(tokens.nextToken());
            if (timer == null && caller.ativo) {
                timer = new Timer(delay / 2, this);
                timer.start();
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lerMensagem();
        caller.tick();
    }
}
