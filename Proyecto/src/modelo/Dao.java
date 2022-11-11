/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.MonitoreoDet;
import entidades.MonitoreoProd;
import entidades.Producto;
import entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;


public class Dao {

    Conexion c = new Conexion();
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    public void insertProducto(Producto p) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call inserta_producto (?,?,?,?,?,?,?)}");
        cst.setString(1, p.getCodigo());
        cst.setString(2, p.getDescripcion());
        cst.setInt(3, p.getCantidad());
        cst.setFloat(4, p.getPrecio());
        cst.setString(5, p.getTipo());
        cst.setFloat(6, p.getPeso());
        cst.setString(7, p.getCategoria());
        cst.execute();
        conn.close();
    }

    public void insertarUsuario(Usuario p) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call inserta_usuario (?,?,?,?,?,?)}");
        cst.setInt(1, p.getCedula());
        cst.setString(2, p.getNombre());
        cst.setString(3, p.getApellido());
        cst.setString(4, p.getAreaAsignada());
        cst.setString(5, p.getRol());
        cst.setString(6, p.getPass());
        cst.execute();
        conn.close();
    }

    public List<Producto> listaProductos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarProductos()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(
                    new Producto(
                            rs.getString("codigo"),
                            rs.getString("descripcion"),
                            rs.getInt("cantidad"),
                            rs.getFloat("precio"),
                            rs.getString("tipo"),
                            rs.getFloat("peso"),
                            rs.getString("categoria")
                    )
            );
        }
        return lista;
    }

    public void updateProducto(Producto p) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call updateproducto (?,?,?,?,?,?,?)}");
        cst.setString(1, p.getDescripcion());
        cst.setInt(2, p.getCantidad());
        cst.setFloat(3, p.getPrecio());
        cst.setString(4, p.getTipo());
        cst.setFloat(5, p.getPeso());
        cst.setString(6, p.getCategoria());
        cst.setString(7, p.getCodigo());
        cst.execute();
        conn.close();
    }

    public void deleteProducto(Producto p) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call deleteProducto (?)}");
        cst.setString(1, p.getCodigo());
        cst.execute();
        conn.close();
    }

    public List<Usuario> listUsuario() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarUsuarios()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(
                    new Usuario(
                            rs.getInt("cedula"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("areaAsignada"),
                            rs.getString("rol"),
                            rs.getString("pass")
                    )
            );
        }
        return lista;
    }

    public void registroUsuario(Usuario p) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call registrarUsuario (?,?)}");
        cst.setInt(1, p.getCedula());
        cst.setString(2, p.getNombre());
        cst.execute();
        conn.close();
    }

    public void registroMovimiento(String codigo, String descripcion) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call movimientosProductos (?,?)}");
        cst.setString(1, codigo);
        cst.setString(2, descripcion);
        cst.execute();
        conn.close();
    }

    public List<MonitoreoProd> listMovimiento() throws SQLException {
        List<MonitoreoProd> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarMovimientos()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(
                    new MonitoreoProd(
                            rs.getInt("id_venta"),
                            rs.getString("descripcion"),
                            rs.getString("accion"),
                            rs.getDate("fecha"),
                            rs.getString("hora"),
                            rs.getString("usuario"),
                            rs.getString("tabla_afec")
                    )
            );
        }
        return lista;
    }
    
    public List<MonitoreoDet> listMovDet() throws SQLException {
        List<MonitoreoDet> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarMovimientosDet()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(
                    new MonitoreoDet(
                            rs.getInt("id_cajero"),
                            rs.getString("usuario"),
                            rs.getInt("num_caja"),
                            rs.getInt("num_fact"),
                            rs.getFloat("monto_total"),
                            rs.getDate("fecha"),
                            rs.getString("hora")
                    )
            );
        }
        return lista;
    }
    
    public void insertarFactura(int p) throws SQLException {
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call inserta_factura (?)}");
        cst.setInt(1, p);
        cst.execute();
        conn.close();
        
    }
    
    public int dameMaxFact() throws SQLException{
        int maxi=0;
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{call dameMaxFact(?)}");
        stm.registerOutParameter(1, OracleTypes.INTEGER);
        stm.execute();
        maxi = stm.getInt(1);
        conn.close();
        return maxi;
    }
    
    public void insertarDetalle(int fact,int cant,float pe,String cod, int tipo) throws SQLException{
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call insertar_detalle (?,?,?,?,?)}");
        cst.setInt(1, fact);
        cst.setInt(2, cant);
        cst.setFloat(3, pe);
        cst.setString(4, cod);
        cst.setInt(5, tipo);
        cst.execute();
        conn.close();
    }

}
