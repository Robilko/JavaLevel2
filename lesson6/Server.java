package Java_2_AdvancedLevel.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8801)) {
            System.out.println("******* Сервер запущен ********");
            try (Socket clientSocket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                 Scanner sc = new Scanner(System.in)
            ) {
                System.out.println("******** Клиент подключен ********");
                out.println("*** Клиент подключен ***");
                out.flush();

                String myMessage = "";

                Thread clientReader = new Thread(() -> {
                    String clientMessage = "";
                    try {
                        while (!server.isClosed()) {
                            clientMessage = in.readLine();
                            if (!(clientMessage == null)) {
                                System.out.println("Клиент: " + clientMessage);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                clientReader.start();
                do {
                    myMessage = sc.nextLine();
                    out.println(myMessage);
                    out.flush();
                } while (!myMessage.equalsIgnoreCase("/stop"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
