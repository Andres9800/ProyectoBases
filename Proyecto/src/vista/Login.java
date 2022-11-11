/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.controlador = new Controlador();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        FondoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("Ingresar cédula");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 240, 30));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setText("Ingresar contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 290, 30));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 153));
        jLabel3.setText("Iniciar sesión");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 380, 50));

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 100, 40));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 260, 40));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 260, 40));

        FondoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen_1.jpg"))); // NOI18N
        getContentPane().add(FondoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        if (!this.usuario.getText().isEmpty() && !this.password.getText().isEmpty()) {
            try {
                if (this.controlador.verificarDatos(Integer.parseInt(usuario.getText()), password.getText())) {
                    switch (this.controlador.verificarRol(Integer.parseInt(usuario.getText()))) {
                        case "cajero":
                            PrincipalCajero pc = new PrincipalCajero();
                            pc.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Cajero":
                            PrincipalCajero pc2 = new PrincipalCajero();
                            pc2.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Abarrote":
                            GerenteAbarrote ga = new GerenteAbarrote();
                            ga.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "abarrote":
                            GerenteAbarrote ga2 = new GerenteAbarrote();
                            ga2.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Fresco":
                            GerenteFresco gf = new GerenteFresco();
                            gf.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "fresco":
                            GerenteFresco gf2 = new GerenteFresco();
                            gf2.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Personal":
                            GerentePersonal gp = new GerentePersonal();
                            gp.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "personal":
                            GerentePersonal gp2 = new GerentePersonal();
                            gp2.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Mercancia":
                            GerenteMercancia gm = new GerenteMercancia();
                            gm.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "mercancia":
                            GerenteMercancia gm2 = new GerenteMercancia();
                            gm2.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "General":
                            GerenteGeneral gg = new GerenteGeneral();
                            gg.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "general":
                            GerenteGeneral gg2 = new GerenteGeneral();
                            gg2.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Sistemas":
                            PrincipalSistemas s = new PrincipalSistemas();
                            s.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "sistemas":
                            PrincipalSistemas ss = new PrincipalSistemas();
                            ss.setVisible(true);
                            this.setVisible(false);
                            break;
                        default:
                            Object[] mensaje = {"Rol no existe"};
                            JOptionPane.showMessageDialog(Login.this, mensaje, "Error", JOptionPane.OK_OPTION);
                            break;
                    }
                } else {
                    Object[] mensaje = {"Usuario o contraseña no válido"};
                    JOptionPane.showMessageDialog(Login.this, mensaje, "Error", JOptionPane.OK_OPTION);
                }
            } catch (SQLException | NumberFormatException ex) {
                Object[] mensaje = {"Digitar solo números en cédula"};
                JOptionPane.showMessageDialog(Login.this, mensaje, "Error", JOptionPane.OK_OPTION);
            }
        } else {
            Object[] mensaje = {"Campo(s) vacio(s)"};
            JOptionPane.showMessageDialog(Login.this, mensaje, "Error", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_AceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel FondoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

    private final Controlador controlador;
}
