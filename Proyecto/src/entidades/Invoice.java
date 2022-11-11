/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;


public class Invoice {
    int idFactura;
    Usuario admCedula;
    int caja;
    String cajero;
    Date fecha;

    public Invoice(Usuario admCedula, int caja, String cajero, Date fecha) {
        this.admCedula = admCedula;
        this.caja = caja;
        this.cajero = cajero;
        this.fecha = fecha;
    }

    public Invoice() {
        this.idFactura = 0;
        this.admCedula = new Usuario();
        this.caja = 0;
        this.cajero = "";
        this.fecha = new Date();
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Usuario getAdmCedula() {
        return admCedula;
    }

    public void setAdmCedula(Usuario admCedula) {
        this.admCedula = admCedula;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Invoice{" + "idFactura=" + idFactura + ", admCedula=" + admCedula + ", caja=" + caja + ", cajero=" + cajero + ", fecha=" + fecha + '}';
    }
    
    
    
}
