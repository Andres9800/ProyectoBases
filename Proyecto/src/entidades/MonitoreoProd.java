/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

public class MonitoreoProd {
    int id_venta;
    String descripcion;
    String accion;
    Date fecha;
    String hora;
    String usuario;
    String tabla_afec;

    public MonitoreoProd(int id_venta, String accion, String descripcion, Date fecha, String hora, String usuario, String tabla_afectada) {
        this.id_venta = id_venta;
        this.descripcion = descripcion;
        this.accion = accion;
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
        this.tabla_afec = tabla_afectada;
    }

    public MonitoreoProd() {
        this.id_venta = 0;
        this.descripcion = "";
        this.accion = "";
        this.fecha = new Date();
        this.hora = "";
        this.usuario = "";
        this.tabla_afec = "";
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int num_mov) {
        this.id_venta = num_mov;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTabla_afectada() {
        return tabla_afec;
    }

    public void setTabla_afectada(String tabla_afectada) {
        this.tabla_afec = tabla_afectada;
    }

    @Override
    public String toString() {
        return  "\n" + "\n" + "Num_mov: " + id_venta + ", " +
                "descripcion: " + descripcion + ", " +
                "accion: " + accion + ", " +
                "fecha: " + fecha + ", " +
                "hora: " + hora + ", " +
                "usuario: " + usuario + ", " +
                "tabla_afectada: " + tabla_afec ;
    }
    
}
