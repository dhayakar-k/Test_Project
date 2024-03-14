package acl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SimpleClientApp {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 5500));
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            System.out.println(new String(buffer, 0, bytesRead));
        } catch (IOException e) {
           TCPServer tcpServer = new TCPServer();
           TCPServer.initiateConnection();
                System.out.println("1234");
                socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", 5500));
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                System.out.println(new String(buffer, 0, bytesRead));
            System.out.println("Socket closed");
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
