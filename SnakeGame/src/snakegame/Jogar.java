package snakegame;

import conexoes.TCPClientMain;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
//import javax.swing.Timer;

public class Jogar extends javax.swing.JFrame implements ActionListener{

    Graphics g;
    public int larguraTela, alturaTela; 
            //area;
    public int tamUnidade; 
            //delay;
    public int macaX, macaY;
    public int corpo1, corpo2;
    //public char direcao1, direcao2;
    public int x1[], x2[];
    public int y1[], y2[];

    public boolean ativo;
    //Timer tempo;

    Jogar() {
        initComponents();
        g = jPanel1.getGraphics();
    }

    public void iniciar() {
        ativo = true;
        //tempo = new Timer(delay, this);
        //tempo.start();
        desenhar(g);
    }

    public void desenhar(Graphics g) {
        if (ativo) {
            g.setColor(Color.red);
            g.fillOval(macaX, macaY, tamUnidade, tamUnidade);

            for (int i = 0; i < corpo1; i++) {
                if (i == 0) {
                    g.setColor(Color.PINK);
                    g.fillRect(x1[i], y1[i], tamUnidade, tamUnidade);
                } else {
                    g.setColor(new Color(255, 33, 240));
                    g.fillRect(x1[i], y1[i], tamUnidade, tamUnidade);
                }
            }
            for (int i = 0; i < corpo2; i++) {
                if (i == 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x2[i], y2[i], tamUnidade, tamUnidade);
                } else {
                    g.setColor(new Color(255, 33, 240));
                    g.fillRect(x2[i], y2[i], tamUnidade, tamUnidade);
                }
            }
        } else {
            gameOver(g);
        }
    }
    public void gameOver(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Swis721 BlkOul BT", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over!", (larguraTela - metrics2.stringWidth("Game Over")) / 2, alturaTela / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ativo) {
            desenhar(g);
        }
        //repaint();
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
            .addGap(0, 700, Short.MAX_VALUE)
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
                .addGap(70, 70, 70))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        closeConnection();
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

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

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        int tecla = evt.getKeyCode();
        String mensagem = String.valueOf(tecla);
        tcpClient.writeMessage(mensagem);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        tcpClient.writeMessage("100");
    }//GEN-LAST:event_jPanel1FocusGained

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
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServer;
    // End of variables declaration//GEN-END:variables
    private TCPClientMain tcpClient;
}
