package snake.conexoes;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class TCPServerAtivosHandler extends Thread {

    private TCPServerConnection cliente;
    private TCPServerAtivosMain caller;

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
                caller.x += caller.vel;
                if (caller.x + caller.tamX > 700) {
                    caller.x = -30;
                }
                break;
            case KeyEvent.VK_LEFT:
                caller.x -= caller.vel;
                if (caller.x < 0) {
                    caller.x = 700;
                }
                break;
            case KeyEvent.VK_DOWN:
                caller.y += caller.vel;
                if (caller.y + caller.tamY > 480) {
                    caller.y = 0;
                }
                break;
            case KeyEvent.VK_UP:
                caller.y -= caller.vel;
                if (caller.y < 0) {
                    caller.y = 480;
                }
                break;
            //case KeyEvent.VK_A:
            //    caller.d--;
            //    if (caller.d < 0) {
            //        caller.d = 0;
            //    }
            //    break;
            //case KeyEvent.VK_S:
            //    caller.d++;
            //    if (caller.d > 10) {
            //        caller.d = 10;
            //    }
            //    break;
        }
    }

    @Override
    public void run() {

        String message;
        while (true) {
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
                message = String.valueOf(caller.x);
                message += "|";
                message += caller.y;
                message += "|";
                message += caller.tamX;
                message += "|";
                message += caller.tamY;
                message += "|";
                message += caller.vel;
                messageDispatcher(message);
                //System.out.println(message);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }
        encerrar();
    }
}
