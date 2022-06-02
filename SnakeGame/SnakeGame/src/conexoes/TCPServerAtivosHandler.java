package conexoes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.Timer;

public class TCPServerAtivosHandler extends Thread implements ActionListener {

    private TCPServerConnection cliente;
    private TCPServerAtivosMain caller;
    int delay;
    Timer timer;

    public TCPServerAtivosHandler(TCPServerConnection cliente, TCPServerAtivosMain caller) throws IOException {
        this.cliente = cliente;
        this.caller = caller;
    }

    @Override
    protected void finalize() throws Throwable {
        encerrar();
    }

    private void encerrar() {
        this.caller.removerCliente(this.cliente);
    }

    public synchronized void messageDispatcher(String message) throws IOException {
        List<TCPServerConnection> clientes = this.caller.getClientes();
        for (TCPServerConnection cli : clientes) {
            if (cli.getSocket() != null && cli.getSocket().isConnected() && cli.getOutput() != null) {
                cli.getOutput().println(message);
                cli.getOutput().flush();
            }
        }
    }

    private synchronized void processar(String message) {
        int tecla = Integer.parseInt(message);
        switch (tecla) {
            case KeyEvent.VK_RIGHT:
                if (cliente.id == 1) {
                    if (caller.direcao1 != 'E') {
                        caller.direcao1 = 'D';
                    }
                } else {
                    if (caller.direcao2 != 'E') {
                        caller.direcao2 = 'D';
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if (cliente.id == 1) {
                    if (caller.direcao1 != 'D') {
                        caller.direcao1 = 'E';
                    }
                } else {
                    if (caller.direcao2 != 'D') {
                        caller.direcao2 = 'E';
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if (cliente.id == 1) {
                    if (caller.direcao1 != 'C') {
                        caller.direcao1 = 'B';
                    }
                } else {
                    if (caller.direcao2 != 'C') {
                        caller.direcao2 = 'B';
                    }
                }
                break;
            case KeyEvent.VK_UP:
                if (cliente.id == 1) {
                    if (caller.direcao1 != 'B') {
                        caller.direcao1 = 'C';
                    }
                } else {
                    if (caller.direcao2 != 'B') {
                        caller.direcao2 = 'C';
                    }
                }
                break;
        }
    }

    @Override
    public void run() {
        String message;
        boolean msg = true;
        while (msg) {
            try {
                if (this.cliente.getSocket().isConnected() && this.cliente.getInput() != null) {
                    message = this.cliente.getInput().readLine();
                    processar(message);
                } else {
                    break;
                }
                if (message == null || message.equals("")) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                break;
            }
            msg = enviarMensagem();
        }
        encerrar();
    }

    private String adicionarInts(int[] valores) {
        String mensagem = "";
        for (int i = 0; i < valores.length; i++) {
            mensagem += valores[i];
            if (i != valores.length - 1) {
                mensagem += ",";
            }
        }
        return mensagem;
    }

    private boolean enviarMensagem() {
        String message;
        try {
            message = String.valueOf(caller.larguraTela);
            message += "|";
            message += caller.alturaTela;
            message += "|";
            message += caller.area;
            message += "|";
            message += caller.tamUnidade;
            message += "|";
            delay = caller.delay;
            message += delay;
            message += "|";
            message += caller.ativo;
            message += "|";
            message += caller.macaX;
            message += "|";
            message += caller.macaY;
            message += "|";
            message += caller.corpo1;
            message += "|";
            message += caller.corpo2;
            message += "|";
            message += caller.direcao1;
            message += "|";
            message += caller.direcao2;
            message += "|";
            message += adicionarInts(caller.x1);
            message += "|";
            message += adicionarInts(caller.y1);
            message += "|";
            message += adicionarInts(caller.x2);
            message += "|";
            message += adicionarInts(caller.y2);
            if (timer == null) {
                timer = new Timer(delay / 2, this);
                timer.start();
                System.out.println("TCPServerAtivosHandler timer start.");
            }
            //System.out.println("Mensagem enviada.");
            messageDispatcher(message);
            //System.out.println("Mensagem: " + message);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enviarMensagem();
    }
}
