/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;

import javax.swing.JOptionPane;

public class BackupRecovery extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarUsuario
     */
    public BackupRecovery() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Backup = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        recovery = new javax.swing.JButton();
        FondoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("Ingresar usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 290, 40));

        Backup.setText("Aplicar Backup");
        Backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupActionPerformed(evt);
            }
        });
        getContentPane().add(Backup, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 170, 100));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 90, -1));

        recovery.setText("Aplicar Recovey");
        recovery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoveryActionPerformed(evt);
            }
        });
        getContentPane().add(recovery, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 170, 90));

        FondoCliente.setForeground(new java.awt.Color(153, 255, 153));
        FondoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen_1.jpg"))); // NOI18N
        getContentPane().add(FondoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -60, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupActionPerformed

    }//GEN-LAST:event_BackupActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        PrincipalSistemas vista = new PrincipalSistemas();
        vista.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void recoveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recoveryActionPerformed

    private void limpiarCampos() {

    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BackupRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackupRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackupRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackupRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackupRecovery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backup;
    private javax.swing.JLabel FondoCliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton recovery;
    // End of variables declaration//GEN-END:variables
    Controlador controlador = new Controlador();
}
