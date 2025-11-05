import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        
        int port = 6789;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader inFromClient = null;
        DataOutputStream outToClient = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for a client...");

            clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getInetAddress());

            inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToClient = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = inFromClient.readLine();
            System.out.println("Received from client: " + clientMessage);

            String response = clientMessage.toUpperCase();
            outToClient.writeBytes(response + '\n'); 
            
            System.out.println("Sent response to client: " + response);

        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        } finally {

            try {
                if (inFromClient != null) inFromClient.close();
                if (outToClient != null) outToClient.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
                System.out.println("Server shutting down.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
