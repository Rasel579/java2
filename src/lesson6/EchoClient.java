package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static  final int PORT = 8888;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
     Socket socket = new Socket(HOST, PORT);
     DataInputStream in = new DataInputStream(socket.getInputStream());
     DataOutputStream out = new DataOutputStream(socket.getOutputStream());


     new Thread(() -> {
           try {
               while (true) {
                   String message = in.readUTF();
                   System.out.println("Сообщение от сервера " + message);
               }
           }catch (IOException e){
            e.printStackTrace();
           }
     }).start();
     new Thread(() -> {
               while (true) {
                   Scanner scanner = new Scanner(System.in);
                   String clientMessage = scanner.nextLine();
                   try {
                       out.writeUTF(clientMessage);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }

     }).start();

 }
}
