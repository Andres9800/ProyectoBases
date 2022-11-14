package proyecto;

import controlador.Controlador;
import entidades.Monitoreo;
import entidades.Producto;
import entidades.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Dao;
import vista.Login;

public class Proyecto {
    




    public static void main(String[] args) throws SQLException {

        Dao miDao = new Dao();
        Controlador miControl = new Controlador();
        
        

        

        //Producto prod = miControl.recuperarProductoPorCodOb("1234");
        //prod.setDescripcion("MODIFI");
        //prod.setCantidad(22);
        // miControl.modificarProducto(prod);
        // System.out.print(prod.toString()+"\n");
//            Producto miP = new Producto("6060","Atun",10,10,10,"Fresco",10,10);
//            miDao.insertProducto(miP);
        List<Monitoreo> miLista = miDao.listarBitProductos();

         for(int i = 0;i<miLista.size();i++){
          System.out.print(miLista.get(i).toString()+"\n");
         } 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException e) {
        }
        new Proyecto().init();
    }

    public void init() {
        SwingUtilities.invokeLater(() -> {
            mostrarInterfaz();
        });
    }

    public void mostrarInterfaz() {
        Login vista = new Login();
        vista.setVisible(true);
    }

}
