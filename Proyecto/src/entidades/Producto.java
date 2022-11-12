package entidades;

import javax.xml.bind.annotation.XmlTransient;

public class Producto {
    int producto_id;
    int plu;
    double ean;
    String descripcion;
    int precio;
    int peso;
    int cantidad;
    int area;
    
    public Producto(int producto_id, String descripcion, int precio, int peso, int cantidad, int area) {
        this.producto_id = producto_id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
        this.cantidad = cantidad;
        this.area = area;
        this.plu = peso > 0 ? producto_id + 4000 : 0;
        this.ean = (producto_id - 3784247000000l);
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public double getEan() {
        return ean;
    }

    public void setEan(double ean) {
        this.ean = ean;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
      
    @Override
    public String toString() {
        return "\n" + "codigo=" + producto_id + "\n"
                + ", ean=" + ean + "\n"
                + ", plu=" + plu + "\n"
                + ", descripcion=" + descripcion + "\n"
                + ", cantidad=" + cantidad + "\n"
                + ", precio=" + precio + "\n"
                + ", peso=" + peso + "\n"
                + ", area=" + area;
    }
}
