package controlador;

import entidades.Cliente;
import entidades.Factura;
import entidades.MonitoreoDet;
import entidades.MonitoreoProd;
import entidades.Producto;
import entidades.Usuario;
import entidades.Vendedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import modelo.Dao;
import modelo.Modelo;

/**
 *
 * @author Greivin
 */
public class Controlador {

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
        System.out.println("Control inicializado..");
        contador = 1000;
        dao = new Dao();
    }

    public Controlador() {
        this(new Modelo());
        dao = new Dao();
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean verificarDatos(String userName, String password) throws SQLException {
        List<Usuario> users = dao.listUsuario();
        for (Usuario user : users) {
            if (user.getUsername().equals(userName) && user.getPass().equals(password)) {
                modelo.setUser(user);
                System.out.println(modelo.getUser());
                return true;
            }
        }
        return false;
    }

    public String verificarRol(String username) throws SQLException {
        List<Usuario> users = dao.listUsuario();
        for (Usuario user : users) {
            if (user.getUsername().equals(username)) {
                dao.registroUsuario(user);
                return user.getAreaAsignada();
            }
        }
        return "";
    }
    
    public void registrar(Observer obs) {
        System.out.println("Registrando observador..");
        modelo.addObserver(obs);
    }

    ////////////////////////////////////////////////////////////////////////////
    public void modificarProducto(Producto prod ) throws SQLException { // que reciba el area y verifique que el area sea igual a la del codigo si es igual que haga la actualizacion
        
        dao.registroMovimiento(prod.getCodigo(), prod.getDescripcion());
        dao.updateProducto(prod);
    }

    public boolean verificarCodigo(String cod) throws SQLException {
        List<Producto> lista = dao.listaProductos();
        for (Producto prod : lista) {
            if (prod.getCodigo().equals(cod)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarDescripcion(String desc) throws SQLException {
        List<Producto> lista = dao.listaProductos();
        for (Producto prod : lista) {
            if (prod.getDescripcion().equals(desc)) {
                return true;
            }
        }
        return false;
    }

    public String mostrarCodigoProducto(String codigo) throws SQLException {
        List<Producto> lista = dao.listaProductos();
        for (Producto producto : lista) {
            if (producto.getCodigo().equals(codigo)) {
                return producto.toString();
            }
        }
        return null;
    }

    public String mostrarDescripProd(String descrip) throws SQLException {
        List<Producto> lista = dao.listaProductos();
        for (Producto producto : lista) {
            if (producto.getDescripcion().equals(descrip)) {
                return producto.toString();
            }
        }
        return null;
    }

    public String recuperarProductoPorCod(String codigo) throws SQLException {
        List<Producto> listaA = dao.listaProductos();
        for (Producto p : listaA) {
            if (p.getCodigo().equals(codigo)) {
                return p.toString();
            }
        }
        return null;
    }

    public String recuperarProductoPorDescrip(String descrip) throws SQLException {
        List<Producto> listaA = dao.listaProductos();
        for (Producto p : listaA) {
            if (p.getDescripcion().equals(descrip)) {
                return p.toString();
            }
        }
        return null;
    }

    public String recuperarDescripcion(String codigo) throws SQLException {
        List<Producto> listaA = dao.listaProductos();
        for (Producto p : listaA) {
            if (p.getCodigo().equals(codigo)) {
                return p.getDescripcion();
            }
        }
        return null;
    }

    public void insertarProducto(Producto p) throws SQLException {
        dao.registroMovimiento(p.getCodigo(), p.getDescripcion());
        dao.insertProducto(p);
    }

    public void eliminarProducto(Producto p) throws SQLException {
        dao.registroMovimiento(p.getCodigo(), recuperarDescripcion(p.getCodigo()));
        dao.deleteProducto(p);
    }

    public List<MonitoreoProd> listarMovimientos() throws SQLException {
        return dao.listMovimiento();
    }
    
    public List<MonitoreoDet> listarDetallesBit() throws SQLException {
        return dao.listMovDet();
    }

    public void insertarUsuario(Usuario u) throws SQLException {
        dao.insertarUsuario(u);
    }

    public List listaAbarrotes() throws SQLException {
        List<Producto> lista = dao.listaProductos();
        List<Producto> abarrotes = new ArrayList<>();
        for (Producto p : lista) {
            if (p.getArea().equals("Abarrote")) {
                abarrotes.add(p);
            }
        }
        return abarrotes;
    }

    public List listaFresco() throws SQLException {
        List<Producto> lista = dao.listaProductos();
        List<Producto> frescos = new ArrayList<>();
        for (Producto p : lista) {
            if (p.getArea().equals("Fresco")) {
                frescos.add(p);
            }
        }
        return frescos;
    }

    public List listaMercancia() throws SQLException {
        List<Producto> lista = dao.listaProductos();
        List<Producto> mercancias = new ArrayList<>();
        for (Producto p : lista) {
            if (p.getArea().equals("Mercancia")) {
                mercancias.add(p);
            }
        }
        return mercancias;
    }

    public List listaPersonal() throws SQLException {
        List<Producto> lista = dao.listaProductos();
        List<Producto> personales = new ArrayList<>();
        for (Producto p : lista) {
            if (p.getArea().equals("Personal")) {
                personales.add(p);
            }
        }
        return personales;
    }

    public Producto recuperarProducto(String codigo) throws SQLException {
        List<Producto> lista = dao.listaProductos();
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
    
    public void meterAlCarro(String a,float cant) throws SQLException{
        Producto p=recuperarProducto(a);
        if(p==null){
            throw new SQLException ("product not found");
        }else{
            if("Fresco".equals(p.getArea())){
                if(p.getPeso()<cant){
                    throw new SQLException ("exceed cant");
                    
                }else{
                    p.setPeso(cant);
                }
            }else{
                if(p.getCantidad()<Math.round(cant)){
                    throw new SQLException ("exceed cant");
                }else{
                    p.setCantidad(Math.round(cant));
                }
                
            }
            modelo.meterAlCarro(p);
        }
        
    }
    
    public void sacarDelCarro(String cod) throws Exception{
        Producto elim=null;
        for (Producto p : modelo.todoCarrito()) {
            if(p.getCodigo().equals(cod)){
                elim=p;
            }
        }
        if(elim==null){throw new Exception("a");}
        modelo.sacarDelCarro(elim);
    }
    
    public void vaciarCarro(){
        modelo.vaciarCarro();
    }

    public List<Producto> todoCarrito(){ return modelo.todoCarrito();}
    
    
    public String parseaLista(List<Producto> lista){
        String fin="Codigo   Descripcion     Peso       Precio c/u      Total"+"\n";
        for (Producto p : lista) {
            if (p.getArea().equals("Fresco")) {
                fin+=p.getCodigo()+"        "+p.getDescripcion()+"      "+p.getPeso()+"           "+p.getPrecio()+"       "+(p.getPeso()*p.getPrecio())+"\n";
            }else{
                fin+=p.getCodigo()+"        "+p.getDescripcion()+"      "+p.getCantidad()+"           "+p.getPrecio()+"        "+(p.getCantidad()*p.getPrecio())+"\n";
            }
        }
        return fin;
    }
    
    public float suma(){
        float tot=0f;
        for (Producto p : modelo.todoCarrito()) {
            if (p.getArea().equals("Fresco")) {
                tot=tot+(p.getPeso()*p.getPrecio());
            }else{
                tot=tot+(p.getCantidad()*p.getPrecio());
            }
        }
        return tot;
    }

    public void enviar(int numCaj) throws SQLException{
        dao.insertarFactura(numCaj);
        int fact=dao.dameMaxFact();
 
        for(Producto u:modelo.todoCarrito()){
            if(u.getArea().equals("Fresco")||u.getArea().equals("fresco")){
                dao.insertarDetalle(fact,0,u.getPeso(),u.getCodigo(),1);
            }else{
                dao.insertarDetalle(fact,u.getCantidad(),0.0f,u.getCodigo(),0);
            }
            
        }
        
        //cajero deberia estar guardado en model
    }
    
    public Usuario empleado(){
        return modelo.getUser();
    }
    private final Modelo modelo;
    private int contador;
    private Dao dao;
}
