package logic;

import java.io.Serializable;

public class Cliente implements Serializable{

    public Cliente(int codigo, String username, String cedula, String direccion, int telefono) {
        this.codigo = codigo;
        this.username = username;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente() {
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    private int codigo;
    private String username;
    private String cedula;
    private String direccion;
    private int telefono;
}
