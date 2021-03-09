package Java_2_AdvancedLevel.lesson8.client;


import javax.swing.*;

public class AppClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }
}