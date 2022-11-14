
package vista;

import javax.swing.JOptionPane;

public class PrincipalSistemas extends javax.swing.JFrame {


    public PrincipalSistemas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        bitacora = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        FondoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Salir.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, 110, 50));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Consulta.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 120, -1));

        bitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Consulta.png"))); // NOI18N
        bitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitacoraActionPerformed(evt);
            }
        });
        getContentPane().add(bitacora, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 110, -1));

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Insertar.png"))); // NOI18N
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 110, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 100, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/modificar.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 110, -1));

        FondoCliente.setForeground(new java.awt.Color(153, 255, 153));
        FondoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/PrincipalSistemas.jpg"))); // NOI18N
        getContentPane().add(FondoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Login vista = new Login();
        vista.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ConsultarProducto c = new ConsultarProducto(7);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void bitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitacoraActionPerformed
        Bitacora bita = new Bitacora();
        bita.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bitacoraActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        try {

            InsertarProducto ean = new InsertarProducto(7);
            ean.setVisible(true);
            this.setVisible(false);

        } catch (NullPointerException e) {
            Object[] message = {"Se ha cancelado"};
            JOptionPane.showMessageDialog(PrincipalSistemas.this, message, "Error", JOptionPane.OK_OPTION);
            String[] productos = {"Abarrote", "Fresco", "Mercancia", "Personal"};
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {

            BorrarProducto ean = new BorrarProducto(7);
            ean.setVisible(true);
            this.setVisible(false);

        } catch (NullPointerException e) {
            Object[] message = {"Se ha cancelado"};
            JOptionPane.showMessageDialog(PrincipalSistemas.this, message, "Error", JOptionPane.OK_OPTION);
            String[] productos = {"Abarrote", "Fresco", "Mercancia", "Personal"};
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {

            ModificarGerentes mod = new ModificarGerentes(7);
            mod.setVisible(true);
            this.setVisible(false);

        } catch (NullPointerException e) {
            Object[] message = {"Se ha cancelado"};
            JOptionPane.showMessageDialog(PrincipalSistemas.this, message, "Error", JOptionPane.OK_OPTION);
            String[] productos = {"Abarrote", "Fresco", "Mercancia", "Personal"};
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalSistemas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoCliente;
    private javax.swing.JButton bitacora;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
