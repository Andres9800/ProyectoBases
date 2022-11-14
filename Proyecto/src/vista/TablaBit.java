/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;




import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import logic.Monitoreo;


public class TablaBit extends AbstractTableModel implements TableModel{
    
    String[] cols ={"Codigo","Accion","Fecha","Usuario","Tabla Afectada" };

    List<Monitoreo> rows;  
  
    public  TablaBit(List<Monitoreo> rows){
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
    

    public Object getValueAt(int row, int col) {
        Monitoreo c = rows.get(row);
        switch (col){
            case 0: return c.getCodigo();
            case 1:return c.getAccion();
            case 2:return c.getFecha();
            case 3:return c.getUsuario();
            case 4:return c.getTabla_afec();
            default: return "";
        }
    } 
    
}