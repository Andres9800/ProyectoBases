/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class Usuario {

    int cedula;
    String nombre;
    String apellido;
    String areaAsignada;
    String rol;
    String pass;

    public Usuario() {
        this.cedula = 0;
        this.nombre = "";
        this.apellido = "";
        this.areaAsignada = "";
        this.rol = "";
        this.pass = "";
    }

    public Usuario(int cedula, String nombre, String apellido, String areaAsignada, String rol, String pass) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.areaAsignada = areaAsignada;
        this.rol = rol;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", areaAsignada=" + areaAsignada + ", rol=" + rol + ", pass=" + pass + '}';
    }

}
