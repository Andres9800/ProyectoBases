/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;




import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import logic.Producto;


public class TablaFacturar extends AbstractTableModel implements TableModel{
    
    String[] cols ={"Codigo","Descripcion","Peso","Precio","Total" };

    List<Producto> rows;  
  
    public  TablaFacturar(List<Producto> rows){
        this.rows=rows;
    }
       public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int col){
        return cols[col];
    }

    public int getRowCount() {
        return rows.size();
    } 
    
    //String[] cols ={"Codigo","PLU","EAN","Descripcion","Precio","Peso","Cantidad","Area" };
    public Object getValueAt(int row, int col) {
        Producto c = rows.get(row);
        switch (col){
            case 0: return c.getCodigo();
            case 1:return c.getDescripcion();
            case 2:return c.getPeso();
            case 3:return c.getPrecio();
            case 4:return c.getEan();
            default: return "";
        }
    } 
    
}