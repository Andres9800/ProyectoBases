
package proyecto;

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
             List<Usuario> miLista = miDao.listUsuario();
         
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
