package entidades;

public class Producto {

    String codigo;
    String descripcion;
    int cantidad;
    float precio;
    int plu;
    float ean;
    float peso;
    String area;

    public Producto(String codigo, String descripcion, int cantidad, float precio, float peso, String area) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.peso = peso;
        this.area = area;
        this.plu = (int)(peso != 0 ? precio + 4000 : 0);
        this.ean = (cantidad * 379);
    }

    public Producto(String codigo, String descripcion, int cantidad, float precio, float peso, String area, int plu, float ean) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.peso = peso;
        this.area = area;
        this.plu = plu;
        this.ean = ean;
    }

    public Producto() {
        this.codigo = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.precio = 0;
        this.peso = 0;
        this.area = "";
        this.plu = 0;
        this.ean = 0;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public float getEan() {
        return ean;
    }

    public void setEan(float ean) {
        this.ean = ean;
    }

    @Override
    public String toString() {
        return "\n" + "codigo=" + codigo + "\n"
                + ", descripcion=" + descripcion + "\n"
                + ", cantidad=" + cantidad + "\n"
                + ", precio=" + precio + "\n"
                + ", peso=" + peso + "\n"
                + ", Plu=" + plu + "\n"
                + ", Ean=" + ean + "\n"
                + ", Area=" + area;
    }

}
