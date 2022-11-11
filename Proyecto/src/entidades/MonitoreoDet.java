/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

public class MonitoreoDet {
    int ID_CAJERO;
    String USUARIO;
    int NUM_CAJA;
    int NUM_FACT;
    float MONTO_TOTAL;
    Date FECHA;
    String HORA;

    public MonitoreoDet(int ID_CAJERO, String USUARIO, int NUM_CAJA, int NUM_FACT, float MONTO_TOTAL, Date FECHA, String HORA) {
        this.ID_CAJERO = ID_CAJERO;
        this.USUARIO = USUARIO;
        this.NUM_CAJA = NUM_CAJA;
        this.NUM_FACT = NUM_FACT;
        this.MONTO_TOTAL = MONTO_TOTAL;
        this.FECHA = FECHA;
        this.HORA = HORA;
    }

    public MonitoreoDet() {
        ID_CAJERO=0;
        USUARIO="";
        NUM_CAJA=0;
        NUM_FACT=0;
        MONTO_TOTAL=0.0f;
        FECHA=new Date();
        HORA="";
    }

    public int getID_CAJERO() {
        return ID_CAJERO;
    }

    public void setID_CAJERO(int ID_CAJERO) {
        this.ID_CAJERO = ID_CAJERO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public int getNUM_CAJA() {
        return NUM_CAJA;
    }

    public void setNUM_CAJA(int NUM_CAJA) {
        this.NUM_CAJA = NUM_CAJA;
    }

    public int getNUM_FACT() {
        return NUM_FACT;
    }

    public void setNUM_FACT(int NUM_FACT) {
        this.NUM_FACT = NUM_FACT;
    }

    public float getMONTO_TOTAL() {
        return MONTO_TOTAL;
    }

    public void setMONTO_TOTAL(float MONTO_TOTAL) {
        this.MONTO_TOTAL = MONTO_TOTAL;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    

    @Override
    public String toString() {
        return  "\n" + "\n" + "Num_cajero: " + ID_CAJERO + ", " +
                "Usuario: " + USUARIO + ", " +
                "Caja: " + NUM_CAJA + ", " +
                "Factura: " + NUM_FACT + ", " +
                "Monto: " + MONTO_TOTAL + ", " +
                "Fecha: " + FECHA + ", " +
                "Hora: " + HORA ;
    }
    
}
