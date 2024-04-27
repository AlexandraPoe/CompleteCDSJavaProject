package WildLife;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LaboratoryManager {
    private int port; // Port for TCP/IP communication
    private ServerSocket serverSocket;

    public LaboratoryManager(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Error creating LaboratoryManager: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void startListening() {
        while (!Thread.interrupted()) {
            try {
                Socket clientSocket = serverSocket.accept();
                processSamples(clientSocket); // Placeholder for processing samples
            } catch (IOException e) {
                System.err.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    // Placeholder method for processing samples received through TCP/IP
    private void processSamples(Socket clientSocket) {
        try (ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream())) {
            // Implement the logic to process samples received from authorities
            System.out.println("Laboratory Manager received samples through TCP/IP.");
        } catch (IOException e) {
            System.err.println("Error processing samples: " + e.getMessage());
        }
    }

    public void stopListening() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error closing server socket: " + e.getMessage());
        }
    }
}
