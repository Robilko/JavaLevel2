package Java_2_AdvancedLevel.lesson7.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientNetwork {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner sc = new Scanner(System.in);

    public void connect() {
        try {
            socket = new Socket("localhost", 8190);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while(true) {
                        String msg = in.readUTF();
                        if(msg.equalsIgnoreCase("/end")){
                            break;
                        }
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            String clientMsg = sc.nextLine();
            sendMessage(clientMsg);
            if(clientMsg.equalsIgnoreCase("/end")){
                break;
            }

        }


    }

    public boolean sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection () {
        try {
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}