
package modelo;

import java.util.Date;
import logic.Monitoreo;
import logic.Producto;
import logic.Usuario;
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
        CallableStatement cst = conn.prepareCall("{call inserta_producto (?,?,?,?,?,?,?,?)}");
        cst.setString(1, p.getCodigo());
        cst.setInt(2, p.getPlu());
        cst.setFloat(3, p.getEan());
        cst.setString(4, p.getDescripcion());
        cst.setFloat(5, p.getPrecio());
        cst.setFloat(6, p.getPeso());
        cst.setInt(7, p.getCantidad());
        cst.setString(8, p.getArea());
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
                            rs.getFloat("peso"),
                            rs.getString("area"),
                            rs.getInt("plu"),
                            rs.getFloat("ean")
                    )
            );
        }
        return lista;
    }

    public void updateProducto(Producto p) throws SQLException { // 
        conn = c.conectar();
        CallableStatement cst = conn.prepareCall("{call updateproducto (?,?,?,?,?,?)}");
        cst.setString(1, p.getDescripcion());
        cst.setInt(2, p.getCantidad());
        cst.setFloat(3, p.getPrecio());
        cst.setString(4, p.getArea());
        cst.setFloat(5, p.getPeso());
        cst.setString(6, p.getCodigo());
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
                            rs.getString("username"),
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
        cst.setString(2, p.getUsername());
        cst.execute();
        conn.close();
    }

    public List<Monitoreo> listarBitProductos() throws SQLException {
        Date date = new Date();
        List<Monitoreo> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarAuditProductos()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(new Monitoreo(
                    rs.getString("codigo"),
                    rs.getString("accion"),
                    rs.getTimestamp("fecha"),
                    rs.getString("usuario"),
                    rs.getString("tabla_afectada")
            )
            );
        }
        return lista;
    }

    // public Monitoreo(String codigo, String accion, Date fecha, String usuario, String tabla_afec) {
    public List<Monitoreo> listarFacturas() throws SQLException {
        List<Monitoreo> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarAuditFacturas()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(new Monitoreo(
                    rs.getString("codigo"),
                    rs.getString("accion"),
                    rs.getTimestamp("fecha"),
                    rs.getString("usuario"),
                    rs.getString("tabla_afectada")
            )
            );
        }
        return lista;
    }

    public List<Monitoreo> listarDetalles() throws SQLException {
        List<Monitoreo> lista = new ArrayList<>();
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{? = call listarAuditDetalles()}");
        stm.registerOutParameter(1, OracleTypes.CURSOR);
        stm.execute();
        ResultSet rs = (ResultSet) stm.getObject(1);

        while (rs.next()) {
            lista.add(new Monitoreo(
                    rs.getString("codigo"),
                    rs.getString("accion"),
                    rs.getTimestamp("fecha"),
                    rs.getString("usuario"),
                    rs.getString("tabla_afectada")
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

    public int dameMaxFact() throws SQLException {
        int maxi = 0;
        conn = c.conectar();
        CallableStatement stm = conn.prepareCall("{call dameMaxFact(?)}");
        stm.registerOutParameter(1, OracleTypes.INTEGER);
        stm.execute();
        maxi = stm.getInt(1);
        conn.close();
        return maxi;
    }

    public void insertarDetalle(int fact, int cant, float pe, String cod, int tipo) throws SQLException {
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
