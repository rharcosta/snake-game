package snake;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Instrucoes extends javax.swing.JFrame {

    public Instrucoes() {
        initComponents();
        Color minhaCor = new Color(212, 247, 212);
        getContentPane().setBackground(minhaCor);

        BufferedImage logoImgCima = null;
        BufferedImage logoImgBaixo = null;
        BufferedImage logoImgDireita = null;
        BufferedImage logoImgEsquerda = null;
        try {
            logoImgCima = ImageIO.read(new File(Principal.class.getResource("imagens/setacima.png").toURI()));
            logoImgBaixo = ImageIO.read(new File(Principal.class.getResource("imagens/setabaixo.png").toURI()));
            logoImgDireita = ImageIO.read(new File(Principal.class.getResource("imagens/setadireita.png").toURI()));
            logoImgEsquerda = ImageIO.read(new File(Principal.class.getResource("imagens/setaesquerda.png").toURI()));
        } catch (Exception e) {
            System.out.println("NÃO ACHEI IMAGEM DO LOGO!");
            e.printStackTrace();
        }

        ImageIcon iconCima = new ImageIcon(logoImgCima);
        ImageIcon iconBaixo = new ImageIcon(logoImgBaixo);
        ImageIcon iconDireita = new ImageIcon(logoImgDireita);
        ImageIcon iconEsquerda = new ImageIcon(logoImgEsquerda);
        
        Icon imagemCima = new ImageIcon(iconCima.getImage().getScaledInstance(setabaixo.getWidth(), setabaixo.getHeight(), Image.SCALE_DEFAULT));
        Icon imagemBaixo = new ImageIcon(iconBaixo.getImage().getScaledInstance(setacima.getWidth(), setacima.getHeight(), Image.SCALE_DEFAULT));
        Icon imagemDireita = new ImageIcon(iconDireita.getImage().getScaledInstance(setadireita.getWidth(), setadireita.getHeight(), Image.SCALE_DEFAULT));
        Icon imagemEsquerda = new ImageIcon(iconEsquerda.getImage().getScaledInstance(setaesquerda.getWidth(), setaesquerda.getHeight(), Image.SCALE_DEFAULT));
        
        setabaixo.setIcon(imagemCima);
        setacima.setIcon(imagemBaixo);
        setadireita.setIcon(imagemDireita);
        setaesquerda.setIcon(imagemEsquerda);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnJogar = new javax.swing.JButton();
        setabaixo = new javax.swing.JLabel();
        setaesquerda = new javax.swing.JLabel();
        setadireita = new javax.swing.JLabel();
        setacima = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setText("COMO JOGAR:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("A Gigi é uma cobrinha muito gulosa e está sempre com muita fome. \nAjude Gigi a conseguir comer o maior número de maçãs possíveis.  \nUtilize as teclas do teclado para se movimentar:\n\nIr para cima\n\n\nIr para baixo\n\n\nIr para a direita\n\n\nIr para a esquerda");
        jScrollPane1.setViewportView(jTextArea1);

        btnJogar.setBackground(new java.awt.Color(255, 255, 255));
        btnJogar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnJogar.setText("Voltar");
        btnJogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setabaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(setacima, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setaesquerda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(setadireita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(setabaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setacima, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(setadireita, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setaesquerda, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
        new Principal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnJogarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Instrucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instrucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instrucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instrucoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel setabaixo;
    private javax.swing.JLabel setacima;
    private javax.swing.JLabel setadireita;
    private javax.swing.JLabel setaesquerda;
    // End of variables declaration//GEN-END:variables
}
