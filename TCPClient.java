import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 6789;
        Socket socket = null;
        DataOutputStream outToServer = null;
        BufferedReader inFromServer = null;

        try {

            socket = new Socket(serverAddress, port);
            System.out.println("Connected to server.");

            outToServer = new DataOutputStream(socket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "Hello from Anil";
            System.out.println("Sending to server: " + message);
            outToServer.writeBytes(message + '\n');

            String serverResponse = inFromServer.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverAddress);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverAddress);
        } finally {

            try {
                if (inFromServer != null) inFromServer.close();
                if (outToServer != null) outToServer.close();
                if (socket != null) socket.close();
                System.out.println("Connection closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
