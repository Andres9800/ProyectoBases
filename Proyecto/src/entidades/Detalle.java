/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class Detalle {
    int cantProd;
    float subtotal;
    float total;
    Usuario admCedula;
    Producto producto;

    public Detalle() {
        this.cantProd = 0;
        this.subtotal = 0;
        this.total = 0;
        this.admCedula = new Usuario();
        this.producto = new Producto();
    }

    public Detalle(int cantProd, float subtotal, float total, Usuario admCedula, Producto producto) {
        this.cantProd = cantProd;
        this.subtotal = subtotal;
        this.total = total;
        this.admCedula = admCedula;
        this.producto = producto;
    }
    
    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Usuario getAdmCedula() {
        return admCedula;
    }

    public void setAdmCedula(Usuario admCedula) {
        this.admCedula = admCedula;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Detalle{" + "cantProd=" + cantProd + ", subtotal=" + subtotal + ", total=" + total + ", admCedula=" + admCedula + ", producto=" + producto + '}';
    }

    
    
}
