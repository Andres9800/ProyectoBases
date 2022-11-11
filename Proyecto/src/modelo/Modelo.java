package modelo;

import entidades.Producto;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class Modelo extends Observable {
    
    public Modelo() {
        carrito=new ArrayList<Producto>();
    }
    
    public void notificar(Object evento) {
        System.out.println("Notificando actualización.." + evento);
        setChanged();
        notifyObservers(evento);
    }
    public String fechaHora() {
        Date objDate = new Date();        
        return objDate.toString();
    }
    
    private List<Producto> carrito;
    private Usuario user;
    
    public void meterAlCarro(Producto a){
        carrito.add(a);
    }
    
    public void sacarDelCarro(Producto cod){
        carrito.remove(cod);
    }
    
    public void vaciarCarro(){
        carrito.clear();
    }
    
    public List<Producto> todoCarrito(){
        return carrito;
    }
    
    public void setUser(Usuario u){
        user=u;
        user.setPass("");/*nunca se debe almacenar contra*/
    }
    
    public Usuario getUser(){
        return user;
    }
}
