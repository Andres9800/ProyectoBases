
package logic;

import java.util.Date;

public class Monitoreo {
    
    
    String codigo;
    String accion;
    Date fecha;
    String usuario;
    String tabla_afec;

    public Monitoreo(String codigo, String accion, Date fecha, String usuario, String tabla_afec) {
        this.codigo = codigo;
        this.accion = accion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.tabla_afec = tabla_afec;
    }
    
    

    public Monitoreo() {
        
        this.codigo = "";
        this.accion = "";
        this.fecha = new Date();
        this.usuario = "";
        this.tabla_afec = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTabla_afec() {
        return tabla_afec;
    }

    public void setTabla_afec(String tabla_afec) {
        this.tabla_afec = tabla_afec;
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
        return  "\n" + "\n" + "Codigo: " + codigo + ", " +
                "accion: " + accion + ", " +
                "fecha: " + fecha + ", " +
                "usuario: " + usuario + ", " +
                "tabla_afectada: " + tabla_afec ;
    }
    
}
