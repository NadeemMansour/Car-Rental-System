
import javax.swing.UIManager;
import view.LoginScreen;

public class MainApp {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {new LoginScreen().setVisible(true);});
    }
}