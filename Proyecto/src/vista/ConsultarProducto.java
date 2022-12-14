/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.Producto;

public class ConsultarProducto extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarProducto
     */
    public ConsultarProducto(int numero) {
        this.numero = numero;
        this.controlador = new Controlador();
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

        Volver = new javax.swing.JButton();
        Abarrotes = new javax.swing.JButton();
        Mercancia = new javax.swing.JButton();
        Personal = new javax.swing.JButton();
        Fresco = new javax.swing.JButton();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        FondoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Salir.png"))); // NOI18N
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 700, 110, -1));

        Abarrotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Abarrotes.png"))); // NOI18N
        Abarrotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbarrotesActionPerformed(evt);
            }
        });
        getContentPane().add(Abarrotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, 40));

        Mercancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Mercancia.png"))); // NOI18N
        Mercancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MercanciaActionPerformed(evt);
            }
        });
        getContentPane().add(Mercancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 110, 40));

        Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Personal.png"))); // NOI18N
        Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalActionPerformed(evt);
            }
        });
        getContentPane().add(Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 110, 40));

        Fresco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Fresco.png"))); // NOI18N
        Fresco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrescoActionPerformed(evt);
            }
        });
        getContentPane().add(Fresco, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 110, 40));

        campoBuscar.setBackground(new java.awt.Color(51, 51, 51));
        campoBuscar.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        campoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(campoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 200, 50));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 100, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "PLU", "EAN", "Descripcion", "Precio", "Peso", "Cantidad", "Area"
            }
        ));
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 900, -1));

        FondoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Consultarproducto.jpg"))); // NOI18N
        getContentPane().add(FondoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.setVisible(false);
        switch (numero) {
            case 1:
                GerenteAbarrote ga = new GerenteAbarrote();
                ga.setVisible(true);
                this.setVisible(false);
                break;
            case 4:
                GerenteFresco gf = new GerenteFresco();
                gf.setVisible(true);
                this.setVisible(false);
                break;
            case 5:
                GerenteGeneral gg = new GerenteGeneral();
                gg.setVisible(true);
                this.setVisible(false);
                break;
            case 2:
                GerenteMercancia gm = new GerenteMercancia();
                gm.setVisible(true);
                this.setVisible(false);
                break;
            case 3:
                GerentePersonal gp = new GerentePersonal();
                gp.setVisible(true);
                this.setVisible(false);
                break;
            case 6:
                PrincipalCajero p = new PrincipalCajero();
                p.setVisible(true);
                this.setVisible(false);
                break;
            case 7:
                PrincipalSistemas s = new PrincipalSistemas();
                s.setVisible(true);
                this.setVisible(false);
                break;
            default:
                Login vista = new Login();
                vista.setVisible(true);
                this.setVisible(false);
                break;
        }
    }//GEN-LAST:event_VolverActionPerformed

    private void AbarrotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbarrotesActionPerformed
        try {
            //productos.setText(this.controlador.listaAbarrotes().toString());
            table.setModel(new TablaConsulta(controlador.listaAbarrotes()));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AbarrotesActionPerformed

    private void MercanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MercanciaActionPerformed
        try {
            //productos.setText(this.controlador.listaMercancia().toString());
            table.setModel(new TablaConsulta(controlador.listaMercancia()));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MercanciaActionPerformed

    private void PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalActionPerformed
        try {
            //productos.setText(this.controlador.listaPersonal().toString());
            table.setModel(new TablaConsulta(controlador.listaPersonal()));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PersonalActionPerformed

    private void FrescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrescoActionPerformed
        try {
            //productos.setText(this.controlador.listaFresco().toString());
            table.setModel(new TablaConsulta(controlador.listaFresco()));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FrescoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            List<Producto> miLista = new ArrayList<Producto>();
            
            if (controlador.verificarCodigo(this.campoBuscar.getText())) {

                miLista.add(controlador.recuperarProductoPorCodObOdES(this.campoBuscar.getText()));
                 table.setModel(new TablaConsulta(miLista));
                 limpiarCampos();
            } else {
                if (controlador.verificarDescripcion(this.campoBuscar.getText())) {
                    
                miLista.add(controlador.recuperarProductoPorCodObOdES(this.campoBuscar.getText()));
                 table.setModel(new TablaConsulta(miLista));
                 limpiarCampos();
                } else {
                    Object[] message = {"Codigo o descripcion no valido"};
                    JOptionPane.showMessageDialog(ConsultarProducto.this, message, "Error", JOptionPane.OK_OPTION);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void limpiarCampos() {
        this.campoBuscar.setText(null);
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
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int numero = 0;
                new ConsultarProducto(numero).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abarrotes;
    private javax.swing.JLabel FondoCliente;
    private javax.swing.JButton Fresco;
    private javax.swing.JButton Mercancia;
    private javax.swing.JButton Personal;
    private javax.swing.JButton Volver;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    int numero;
    Controlador controlador;
}
