package entidades;

public class Vendedor {

    public Vendedor(int codigo, String username) {
        this.codigo = codigo;
        this.username = username;
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



    private int codigo;
    private String username;
}
