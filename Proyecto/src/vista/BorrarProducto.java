/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import entidades.Producto;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BorrarProducto extends javax.swing.JFrame {

    /**
     * Creates new form BorrarEAN
     */
    public BorrarProducto(int numero, int numero2) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.numero = numero;
        this.numero2 = numero2;
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
        jLabel6 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        FondoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("Eliminar producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 153));
        jLabel6.setText("Código ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 90, -1));

        Modificar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Modificar.setText("Eliminar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        CampoCodigo.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        CampoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 310, -1));

        FondoCliente.setForeground(new java.awt.Color(153, 255, 153));
        FondoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen_1.jpg"))); // NOI18N
        getContentPane().add(FondoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -40, 700, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        switch (numero) {
            case 5:
                this.setVisible(false);
                GerenteGeneral gg = new GerenteGeneral();
                gg.setVisible(true);
                break;
            case 7:
                this.setVisible(false);
                PrincipalSistemas ps = new PrincipalSistemas();
                ps.setVisible(true);
                break;
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        try {
            if (!this.CampoCodigo.getText().isEmpty()) {
                controlador.eliminarProducto(returnProducto());
                limpiarCampos();
            } else {
                Object[] message = {"Hay campos vacíos"};
                JOptionPane.showMessageDialog(BorrarProducto.this, message, "Error", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            Object[] message = {"Código no existe"};
            JOptionPane.showMessageDialog(BorrarProducto.this, message, "Error", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void limpiarCampos() {
        this.CampoCodigo.setText(null);
    }

    private Producto returnProducto() {
        Producto p = new Producto();
        p.setCodigo(this.CampoCodigo.getText());
        return p;
    }

    private void CampoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodigoActionPerformed

    }//GEN-LAST:event_CampoCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(BorrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int numero = 0;
                int numero2 = 0;
                new BorrarProducto(numero, numero2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JLabel FondoCliente;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
    int numero;
    int numero2;
    Controlador controlador = new Controlador();
}
