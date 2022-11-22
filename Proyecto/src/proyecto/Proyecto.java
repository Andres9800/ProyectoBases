package proyecto;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vista.Login;

public class Proyecto {

    public static void main(String[] args) throws SQLException {

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
