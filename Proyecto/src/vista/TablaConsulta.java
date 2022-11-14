/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;




import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import logic.Producto;


public class TablaConsulta extends AbstractTableModel implements TableModel{
    
    String[] cols ={"Codigo","PLU","EAN","Descripcion","Precio","Peso","Cantidad","Area" };

    List<Producto> rows;  
  
    public  TablaConsulta(List<Producto> rows){
        this.rows=rows;
    }
       public int getColumnCount() {
        return 8;
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
            case 1:return c.getPlu();
            case 2:return c.getEan();
            case 3:return c.getDescripcion();
            case 4:return c.getPrecio();
            case 5:return c.getPeso();
            case 6:return c.getCantidad();
            case 7:return c.getArea();
            default: return "";
        }
    } 
    
}