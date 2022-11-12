package entidades;

public class Producto {
    String codigo;
    String descripcion;
    int cantidad;
    float precio;
    String tipo;
    float peso;
    String categoria;

    public Producto(String codigo, String descripcion, int cantidad, float precio, String tipo, float peso, String categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
        this.peso = peso;
        this.categoria = categoria;
    }

    public Producto() {
        this.codigo = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.precio = 0;
        this.tipo = "";
        this.peso = 0;
        this.categoria = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "\n" +  "codigo=" + codigo + "\n" +
                ", descripcion=" + descripcion + "\n" +
                ", cantidad=" + cantidad + "\n" +
                ", precio=" + precio + "\n" +
                ", tipo=" + tipo + "\n" +
                ", peso=" + peso + "\n" +
                ", categoria=" + categoria;
    }
    
    
}
