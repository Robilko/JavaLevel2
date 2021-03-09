package Java_2_AdvancedLevel.lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8801);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)) {

            String myMessage = "";

            Thread serverReader = new Thread(() -> {
                String serverMessage = "";
                try {
                    while(!socket.isClosed()) {
                        serverMessage = in.readLine();
                        if (!(serverMessage == null)) {
                            System.out.println("Сервер: " + serverMessage);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverReader.start();
            do{
                myMessage = sc.nextLine();
                out.println(myMessage);
                out.flush();
            }while(!myMessage.equalsIgnoreCase("/stop"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
