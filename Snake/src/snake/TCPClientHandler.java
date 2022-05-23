package snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class TCPClientHandler extends Thread {

    private Socket socket;
    private Cliente caller;
    private BufferedReader input;

    public TCPClientHandler(Socket socket, Cliente caller) throws IOException {
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
                this.caller.apagaBolinha();
                StringTokenizer tokens = new StringTokenizer(message, "|");
                this.caller.x = Integer.parseInt(tokens.nextToken());
                this.caller.y = Integer.parseInt(tokens.nextToken());
                this.caller.t = Integer.parseInt(tokens.nextToken());
                this.caller.d = Integer.parseInt(tokens.nextToken());
                this.caller.pintaBolinha();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }
    }
}
