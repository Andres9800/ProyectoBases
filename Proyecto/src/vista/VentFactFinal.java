/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;

public class VentFactFinal extends javax.swing.JFrame {

    /**
     * Creates new form VentFactFinal
     */
    public VentFactFinal(Controlador control, String codCliente, String codVendedor/*, ListaProducto lp*/) {
        this.control = control;
        this.codCliente = Integer.parseInt(codCliente);
        this.codVendedor = Integer.parseInt(codVendedor);
        //this.lp = lp;
        initComponents();
        this.setLocationRelativeTo(null);
        //infoEmpresa();
    }
    
    private void limpiar(){
        CampoNomEmpresa.setText(null);
        CampoDireccionEmp.setText(null);
        CampoTelEmpresa.setText(null);
        CampoCedJuridica.setText(null);
        CampoFecha.setText(null);
        CampoFactElect.setText(null);
        CampoNomCliente.setText(null);
        CampoCedCliente.setText(null);
        CampoCajero.setText(null);
        CampoProductos.setEditable(false);
        CampoProductos.setText(null);
        campoSubTotal.setText(null);
        CampoDescuento.setText(null);
        CampoIVA.setText(null);
        CampoTotal.setText(null);
    }

    /*public void infoEmpresa() {
        CampoNomEmpresa.setText("Supermercado Baratico");
        CampoDireccionEmp.setText("Direccion:  " + "Heredia Centro");
        CampoTelEmpresa.setText("Telefono:  " + "25630147");
        CampoCedJuridica.setText("Cedula Juridica: " + "130246987");
        CampoFecha.setText("Fecha: " + control.fechaHora());
        CampoFactElect.setText("Numero de factura: " + String.valueOf(control.getContador()));
        //CampoNomCliente.setText("Nombre del cliente: " + control.nombreCliente(codCliente));
        //CampoCedCliente.setText("Cedula del cliente: " + control.cedulaCliente(codCliente));
        CampoCajero.setText("Cajero: " + String.valueOf(codVendedor) + " " + control.nombreVendedor(codVendedor));
        CampoProductos.setEditable(false);
        CampoProductos.setText(lp.mostrarProductos());
        campoSubTotal.setText("SubTotal: " + String.valueOf(lp.sumaCompra()));
        CampoDescuento.setText("Descuento: " + String.valueOf(lp.descuento()));
        CampoIVA.setText("IVA: " +  String.format("%.2f", lp.IVA()));
        CampoTotal.setText("Total: " + String.valueOf(lp.cantTotal()));
        jTextArea1.setEditable(false);
        
        /*Factura f = new Factura("Supermercado Baratico", "Supermercado Baratico", 25630147, 130246987,
        control.fechaHora(), control.getContador(), control.nombreCliente(codCliente), control.cedulaCliente(codCliente), codVendedor, control.nombreVendedor(codVendedor), 
        lp, lp.sumaCompra(), lp.descuento(), lp.IVA(), lp.cantTotal());
        
        //control.agregarFactura(f);
        control.setContador(control.getContador() + 1);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CampoNomEmpresa = new javax.swing.JLabel();
        CampoDireccionEmp = new javax.swing.JLabel();
        CampoTelEmpresa = new javax.swing.JLabel();
        CampoCedJuridica = new javax.swing.JLabel();
        CampoFecha = new javax.swing.JLabel();
        CampoFactElect = new javax.swing.JLabel();
        CampoNomCliente = new javax.swing.JLabel();
        CampoCedCliente = new javax.swing.JLabel();
        CampoCajero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoProductos = new javax.swing.JTextArea();
        campoSubTotal = new javax.swing.JLabel();
        CampoDescuento = new javax.swing.JLabel();
        CampoIVA = new javax.swing.JLabel();
        CampoTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CampoNomEmpresa.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        CampoNomEmpresa.setText("Nombre Empresa");
        getContentPane().add(CampoNomEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 200, 40));

        CampoDireccionEmp.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoDireccionEmp.setText("Direccion");
        getContentPane().add(CampoDireccionEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 30));

        CampoTelEmpresa.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoTelEmpresa.setText("Telefono empresa");
        getContentPane().add(CampoTelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 30));

        CampoCedJuridica.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoCedJuridica.setText("Cedula juridica");
        getContentPane().add(CampoCedJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 30));

        CampoFecha.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoFecha.setText("Fecha y hora ");
        getContentPane().add(CampoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        CampoFactElect.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoFactElect.setText("Factura electronica");
        getContentPane().add(CampoFactElect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        CampoNomCliente.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoNomCliente.setText("Nombre del cliente");
        getContentPane().add(CampoNomCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        CampoCedCliente.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoCedCliente.setText("Cedula");
        getContentPane().add(CampoCedCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        CampoCajero.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoCajero.setText("Cajero: codigo + nombre");
        getContentPane().add(CampoCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        CampoProductos.setColumns(20);
        CampoProductos.setRows(5);
        jScrollPane1.setViewportView(CampoProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 440, 240));

        campoSubTotal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        campoSubTotal.setText("SubTotal:");
        getContentPane().add(campoSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 200, -1));

        CampoDescuento.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoDescuento.setText("Descuento:");
        getContentPane().add(CampoDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 200, -1));

        CampoIVA.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoIVA.setText("IVA:");
        getContentPane().add(CampoIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 200, 20));

        CampoTotal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CampoTotal.setText("Total:");
        getContentPane().add(CampoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, 200, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Emitida conforme lo establecido en la resolución de\nFacturación Electrónica, N DGT-R-033-2019 del \nveinte de septiembre de dos mil veinte de la \nDirección General de Tributación");
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 440, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentFactFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentFactFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentFactFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentFactFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Controlador control = new Controlador();
                new VentFactFinal(control, "", ""/*, null*/).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CampoCajero;
    private javax.swing.JLabel CampoCedCliente;
    private javax.swing.JLabel CampoCedJuridica;
    private javax.swing.JLabel CampoDescuento;
    private javax.swing.JLabel CampoDireccionEmp;
    private javax.swing.JLabel CampoFactElect;
    private javax.swing.JLabel CampoFecha;
    private javax.swing.JLabel CampoIVA;
    private javax.swing.JLabel CampoNomCliente;
    private javax.swing.JLabel CampoNomEmpresa;
    private javax.swing.JTextArea CampoProductos;
    private javax.swing.JLabel CampoTelEmpresa;
    private javax.swing.JLabel CampoTotal;
    private javax.swing.JLabel campoSubTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private Controlador control;
    private int codCliente;
    private int codVendedor;
}
