package Java_2_AdvancedLevel.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class MainWindow extends JFrame {


    public MainWindow() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 300, 450, 700);
        setResizable(false);

        JPanel messageHistory = new JPanel();
        messageHistory.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        messageHistory.add(scrollPane, CENTER);
        add(messageHistory, CENTER);

        JPanel sendMessage = new JPanel();
        sendMessage.setBackground(Color.YELLOW);
        sendMessage.setPreferredSize(new Dimension(450, 30));
        sendMessage.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        JButton buttonSend = new JButton("Send");
        sendMessage.add(textField, CENTER);
        sendMessage.add(buttonSend, EAST);
        add(sendMessage, SOUTH);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "Я: " + textField.getText() + "\n");
                textField.setText(null);
            }
        });

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "Я: " + textField.getText() + "\n");
                textField.setText(null);
            }
        });

        setVisible(true);

    }
}



