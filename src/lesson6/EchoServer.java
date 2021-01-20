package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class EchoServer {
    private static  final int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
                 System.out.println("Ожидание подключения...");

                while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен!");
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            new Thread(()->{
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String serverMessage = scanner.nextLine();
                    try {
                        out.writeUTF(serverMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            new Thread(()->{
                while (true) {
                    try {
                        String clientMessage = in.readUTF();
                        System.out.println("Сообщение от пользователя " + clientMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

           }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
