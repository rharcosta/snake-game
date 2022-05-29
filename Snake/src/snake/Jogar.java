package snake;

import snake.conexoes.TCPClientMain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Jogar extends javax.swing.JFrame {

    Graphics g;
    public int x, y, tamX, tamY, vel;
    int score = 0;
    int macaX = 200;
    int macaY = 200;

    public Jogar() {

        initComponents();
        g = jPanel1.getGraphics();

        BufferedImage logoImg = null;
        try {
            logoImg = ImageIO.read(new File(Principal.class.getResource("imagens/sair.png").toURI()));
        } catch (Exception e) {
            System.out.println("NÃO ACHEI IMAGEM DO LOGO!");
            e.printStackTrace();  //Exceção
        }

        //Imagem na label
        ImageIcon icon = new ImageIcon(logoImg);
        Icon imagem = new ImageIcon(icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(imagem);
        this.repaint();
        sleep();
    }

    public void pintaCobrinha() {

        //score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Swis721 BlkOul BT", Font.PLAIN, 24));
        g.drawString("SCORE: " + score, 10, 25);

        //cobrinha
        g.setColor(Color.BLACK);
        g.fillRect(x, y, tamX, tamY);

        //maçã
        g.setColor(Color.red);
        g.fillRect(macaX, macaY, 10, 10);

        if (new Rectangle(x, y, tamX, tamY).intersects(new Rectangle(macaX, macaY, 10, 10))) {
            macaX = new Random().nextInt(480 - 10);
            macaY = new Random().nextInt(480 - 10);
            score++;
            this.repaint();

            g.setColor(Color.BLACK);
            g.fillRect(x, y, tamX, tamY);
        }
    }

    public void apagaCobrinha() {
        g.setColor(jPanel1.getBackground());
        g.fillRect(x, y, tamX, tamY);
    }

    private void sleep() {
        // Evitar que outro programa mate a Thread enquanto ela está dormindo
        try {

            Thread.sleep(20); //20 milissegundos- 50 fps (roda 50 vezes por segundo)
        } catch (InterruptedException ex) {
            Logger.getLogger(Jogar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnJogar = new javax.swing.JButton();
        txtServer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSair.setText("SAIR");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.setEnabled(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(153, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        btnJogar.setBackground(new java.awt.Color(255, 255, 255));
        btnJogar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnJogar.setText("JOGAR");
        btnJogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });

        txtServer.setText("localhost");

        jLabel3.setText("Server:");

        jLabel4.setText("Porta:");

        txtPorta.setText("6789");

        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnJogar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        closeConnection();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        tcpClient.writeMessage("100");
    }//GEN-LAST:event_jPanel1FocusGained

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        int tecla = evt.getKeyCode();
        String mensagem = String.valueOf(tecla);
        tcpClient.writeMessage(mensagem);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        jPanel1.requestFocus();
    }//GEN-LAST:event_formFocusGained

    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
        try {
            String server = txtServer.getText();
            int porta = Integer.parseInt(txtPorta.getText());
            tcpClient = new TCPClientMain(server, porta, this);
            btnJogar.setEnabled(false);
            btnSair.setEnabled(true);
            jPanel1.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnJogarActionPerformed

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        System.exit(0);
    }//GEN-LAST:event_logoMouseClicked

    public void closeConnection() {
        try {
            tcpClient.closeConnection();
            btnSair.setEnabled(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Jogar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJogar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServer;
    // End of variables declaration//GEN-END:variables
    private TCPClientMain tcpClient;
}
