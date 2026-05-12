import ui.auth.LoginFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            new LoginFrame().setVisible(true);
        });
    }
}

// import ui.auth.LoginFrame;
// import ui.main.SplashScreen;

// import javax.swing.*;

// public class Main {

//     public static void main(String[] args) {

//         //  تحسين شكل الواجهة (Swing Look & Feel)
//         try {
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         //  Splash Screen (اختياري احترافي)
//         SplashScreen splash = new SplashScreen();
//         splash.setVisible(true);

//         try {
//             Thread.sleep(2000); // وقت تحميل وهمي
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }

//         splash.dispose();

//         //  فتح شاشة تسجيل الدخول
//         SwingUtilities.invokeLater(() -> {
//             new LoginFrame().setVisible(true);
//         });
//     }
// }