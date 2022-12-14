
package vista;

import controlador.Controlador;
import logic.Producto;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModificarProducto extends javax.swing.JFrame {

    /**
     * Creates new form ModificarProducto
     */
    public String retornaArea(int numero) {
        String area = " ";
        if (numero == 1) {
            area = "Abarrote";
        }
        if (numero == 2) {
            area = "Mercancia";
        }
        if (numero == 3) {
            area = "Personal";
        }
        if (numero == 4) {
            area = "Fresco";
        }
        return area;
    }

    public ModificarProducto(int numero, int numero2) {
        initComponents();
        this.numero = numero;
        this.numero2 = numero2;
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

        Salir = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        CampoCantidad = new javax.swing.JTextField();
        CampoDescripcion = new javax.swing.JTextField();
        FondoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Salir.png"))); // NOI18N
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 100, -1));

        CampoCodigo.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        CampoCodigo.setForeground(java.awt.Color.black);
        CampoCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 310, -1));

        btnModificar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/modificar.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        CampoCantidad.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        CampoCantidad.setForeground(java.awt.Color.black);
        CampoCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 310, -1));

        CampoDescripcion.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        CampoDescripcion.setForeground(java.awt.Color.black);
        CampoDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(CampoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 310, -1));

        FondoCliente.setForeground(new java.awt.Color(153, 255, 153));
        FondoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ModificarProducto.jpg"))); // NOI18N
        getContentPane().add(FondoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.setVisible(false);
        switch (numero) {
            case 1:
                GerenteAbarrote gg = new GerenteAbarrote();
                gg.setVisible(true);
                break;
            case 2:
                GerenteMercancia s = new GerenteMercancia();
                s.setVisible(true);
                break;
            case 3:
                GerentePersonal ss = new GerentePersonal();
                ss.setVisible(true);
                break;
            case 4:
                GerenteFresco sst = new GerenteFresco();
                sst.setVisible(true);
                break;
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void CampoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodigoActionPerformed

    }//GEN-LAST:event_CampoCodigoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        String areaRecibida = " ";

        areaRecibida = retornaArea(numero2);

        try {
            if (controlador.verificarCodigo(this.CampoCodigo.getText())) {

                Producto prod = controlador.recuperarProductoPorCodOb(this.CampoCodigo.getText());

                if (prod.getArea().equals(areaRecibida)) {

                    prod.setDescripcion(this.CampoDescripcion.getText());
                    prod.setCantidad(Integer.parseInt(this.CampoCantidad.getText()));
                    controlador.modificarProducto(prod);
                    JOptionPane.showMessageDialog(null, "Accion realizada Correctamente!");
                    
                } else {
                    
                    Object[] message = {"El gerente no Pertenece al area del producto"};
                    JOptionPane.showMessageDialog(ModificarProducto.this, message, "Error", JOptionPane.OK_OPTION);
                    limpiarCampos();
                }
                limpiarCampos();
            } else {
                Object[] message = {"Codigo No existe"};
                JOptionPane.showMessageDialog(ModificarProducto.this, message, "Error", JOptionPane.OK_OPTION);
                limpiarCampos();
            }

        } catch (SQLException | NumberFormatException ex) {
            Object[] message = {" ocurri?? error "};
            JOptionPane.showMessageDialog(ModificarProducto.this, message, "Error", JOptionPane.OK_OPTION);
            limpiarCampos();

        }

    }

    private void limpiarCampos() {
        this.CampoCodigo.setText(null);
        this.CampoDescripcion.setText(null);
        this.CampoCantidad.setText(null);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void CampoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCantidadActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int numero3 = 0;
                new ModificarProducto(numero3, numero3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoCantidad;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoDescripcion;
    private javax.swing.JLabel FondoCliente;
    private javax.swing.JButton Salir;
    private javax.swing.JButton btnModificar;
    // End of variables declaration//GEN-END:variables
    Controlador controlador = new Controlador();
    int numero;
    int numero2;
}
