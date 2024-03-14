package acl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        initiateConnection();
    }

    public static void initiateConnection() {
        long currentTIme = System.currentTimeMillis();
        long diffDate = Math.abs(currentTIme - 1704950210803l);
        System.out.println(diffDate);
        final int PORT = 5500;
        ServerSocket serverSocket ;
        Socket clientSocket ;
        try {
            serverSocket= new ServerSocket(PORT);
            System.out.println("Server listening on port " + PORT);
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("New client from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                Thread.sleep(1000); // Sleep for 1 second
                clientSocket.setSoLinger(true, 0);
                clientSocket.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
