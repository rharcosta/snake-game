package snakegame;

import conexoes.TCPClientMain;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Jogar extends javax.swing.JFrame {

    final Color COR_FUNDO = new Color(204, 255, 204);
    final Color COR_MACA = new Color(255, 0, 0);
    final Color COR_COBRA1_CABECA = new Color(51, 51, 255);
    final Color COR_COBRA1_CORPO = new Color(51, 102, 255);
    final Color COR_COBRA2_CABECA = new Color(255, 0, 255);
    final Color COR_COBRA2_CORPO = new Color(255, 102, 255);

    Graphics g;
    public int larguraTela, alturaTela, area;
    public int tamUnidade;
    public int macaX, macaY;
    public int corpo1, corpo2;
    public int score1, score2;
    public char direcao1, direcao2;
    public int x1[], x2[];
    public int y1[], y2[];

    public boolean ativo;

    Jogar() {
        initComponents();
        g = jPanel1.getGraphics();
    }

    public void desenhar() {
        g.setColor(COR_FUNDO);
        g.fillRect(0, 0, larguraTela * 2, alturaTela * 2);
        g.setColor(COR_MACA);
        g.fillOval(macaX, macaY, tamUnidade, tamUnidade);

        for (int i = 0; i < corpo1; i++) {
            if (i == 0) {
                g.setColor(COR_COBRA1_CABECA);
                g.fillRect(x1[i], y1[i], tamUnidade, tamUnidade);
            } else {
                g.setColor(COR_COBRA1_CORPO);
                g.fillRect(x1[i], y1[i], tamUnidade, tamUnidade);
            }
        }

        for (int i = 0; i < corpo2; i++) {
            if (i == 0) {
                g.setColor(COR_COBRA2_CABECA);
                g.fillRect(x2[i], y2[i], tamUnidade, tamUnidade);
            } else {
                g.setColor(COR_COBRA2_CORPO);
                g.fillRect(x2[i], y2[i], tamUnidade, tamUnidade);
            }
        }
        score();
    }

    public void score() {
        g.setColor(Color.blue);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("SCORE 1: " + score1, 150, g.getFont().getSize());
        g.setColor(Color.pink);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("SCORE 2: " + score2, 300, g.getFont().getSize());
    }

    public void gameOver() {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Swis721 BlkOul BT", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        if (score1 > score2) {
            g.drawString("JOGADOR 1 VENCEU!", (larguraTela - metrics2.stringWidth("JOGADOR 1 VENCEU")) / 2, alturaTela / 2);
        } else if (score2 > score1) {
            g.drawString("JOGADOR 2 VENCEU!", (larguraTela - metrics2.stringWidth("JOGADOR 2 VENCEU")) / 2, alturaTela / 2);
        } else {
            g.drawString("EMPATE!", (larguraTela - metrics2.stringWidth("EMPATE!")) / 2, alturaTela / 2);
        }

        //int resposta = JOptionPane.showConfirmDialog(this, "Deseja jogar novamente?");
        //if (resposta == JOptionPane.YES_OPTION) {
           //colocar algo 
        //} else {
        //    closeConnection();
        //    System.exit(0);
        //}
    }

    public void tick() {
        if (ativo) {
            desenhar();
        } else {
            gameOver();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSair.setText("SAIR");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addGap(0, 533, Short.MAX_VALUE)
        );

        btnJogar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnJogar.setText("JOGAR");
        btnJogar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });

        txtServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtServer.setText("localhost");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Server:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Porta:");

        txtPorta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPorta.setText("6789");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
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
