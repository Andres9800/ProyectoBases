
package logic;

public class Usuario {

    int cedula;
    String username;
    String areaAsignada;
    String rol;
    String pass;

    public Usuario() {
        this.cedula = 0;
        this.username = "";
   
        this.areaAsignada = "";
        this.rol = "";
        this.pass = "";
    }

    public Usuario(int cedula, String username,  String areaAsignada, String rol, String pass) {
        this.cedula = cedula;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Usuario{" + "cedula=" + cedula + ", Username=" + username + ", areaAsignada=" + areaAsignada + ", rol=" + rol + ", pass=" + pass + '}';
    }

}
