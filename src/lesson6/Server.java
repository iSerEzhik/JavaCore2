package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        Socket socket;
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (ServerSocket serverSocket = new ServerSocket(8085)) {
            System.out.println("SERVER START!!!!");
            socket = serverSocket.accept();

            System.out.println("CLIENT CONNECTED!!!!");
            inputStream = new DataInputStream(socket.getInputStream());

            outputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                if (inputStream.available()!=0) {
                    String message = inputStream.readUTF();
                    System.out.println(message);
                    if (message.equalsIgnoreCase("/stopChat")) {
                        break;
                    }
                }
                if (reader.ready()) {
                    String backMessage = reader.readLine();
                    if (!backMessage.equalsIgnoreCase("/stop"))
                        outputStream.writeUTF(backMessage);
                    else break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}
