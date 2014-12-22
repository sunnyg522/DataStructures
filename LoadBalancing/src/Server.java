
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for handling the requests of clients
 */
public class Server {
    private static Scanner keyboard = new Scanner(System.in);
    private static List<Socket> connectedClients = new LinkedList<Socket>();
    
    /**
     * Return the number of clients connected to the server
     * @return number of connected clients
     */
    public synchronized static int getLoad() {
        return connectedClients.size();
    }
    
    /**
     * Increments the load by adding the new connected socket
     * @param socket the socket connected
     */
    public synchronized static void addLoad(Socket socket) {
        connectedClients.add(socket);
    }
    
    /**
     * Decrements the load by removing a connected socket
     * @param socket the disconnected socket
     */
    public synchronized static void removeLoad(Socket socket) {
        connectedClients.remove(socket);
    }
    
    /**
     * A method to force the user to enter an integer
     * @param prompt the message to ask the user
     * @return integer value
     */
    public static int getInt(String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(keyboard.nextLine());
            } catch(Exception error) {
                System.out.println("Error: Please enter a number.");
            }
        }
    }
    
    /**
     * Entry point of the server
     * @param args unused arguments
     */
    public static void main(String[] args) {
        // Ask for the port where the server will attempt to run
        int port = getInt("What port number would you like to run this server?: ");
        
        try {
            // Attempt to run the server on the designated port
            ServerSocket ss = new ServerSocket(port);
            
            System.out.println("The server is now running...");
            System.out.println("To stop the server please use the stop button of Netbeans or Eclipse. Or press ctrl + c if you are running it in a console.");
            
            while(true) {
                // Wait for a client to connect
                System.out.println("Waiting for client...");
                Socket s = ss.accept();
                
                // Ready the communication to the client
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
                // Check the type of client if it is a MID-SERVER or a CLIENT
                String type = in.readLine();
                
                if(type.equalsIgnoreCase("MIDSERVER")) {
                    // Create a thread for a mid server
                    new Thread(new MidServerHandler(s)).start();
                } else {
                    // Create a thread for a client
                    addLoad(s);
                    new Thread(new ClientHandler(s)).start();
                }
            }
        } catch(Exception error) {
            System.out.println("The server failed to run on the port. Most probably because the port is blocked by your firewall, or it is being used by another application.");
            System.exit(0);
        }
    }
}

/**
 * This class handles all client requests. It simply do calculation of numbers
 */
class ClientHandler implements Runnable {
    private Socket socket;
    
    /**
     * Initialize the communication point to the client
     * @param socket way to receive and send message to the client
     */
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        System.out.println("A client has connected.");
        System.out.println("The server load is now " + Server.getLoad());
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);
            
            // The client runs permanently until it is deliberately stopped
            while(true) {
                // get the 2 numbers
                double firstNumber = Double.parseDouble(in.readLine());
                double secondNumber = Double.parseDouble(in.readLine());
                
                // get operation 
                String operation = in.readLine();
                
                // return the result
                if(operation.equalsIgnoreCase("ADD"))
                    out.println(firstNumber + secondNumber);
                else if(operation.equalsIgnoreCase("SUBTRACT"))
                    out.println(firstNumber - secondNumber);
                else if(operation.equalsIgnoreCase("DIVIDE"))
                    out.println(firstNumber / secondNumber);
                else if(operation.equalsIgnoreCase("MULTIPLY"))
                    out.println(firstNumber * secondNumber);
            }
        } catch(Exception e) {            
        }
                
        Server.removeLoad(this.socket);
        System.out.println("A client has disconnected.");
        System.out.println("The server load is now " + Server.getLoad());
    }
}

/**
 * This class handles all the mid server connected. The mid server contacts this
 * server just to simply check how many clients it is currently processing
 */
class MidServerHandler implements Runnable {
    private Socket socket;
    
    /**
     * Initialize the communication point to the mid server
     * @param socket way to receive and send message to the mid server
     */
    public MidServerHandler(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Handles the request from the mid server
     */
    @Override
    public void run() {
        System.out.println("Mid server has connected.");
                
        // The mid server infinitely runs and exits only when stopped
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);

            while(true) {
                String command = in.readLine();
                
                if(command.equalsIgnoreCase("GETLOAD"))
                    out.println(Server.getLoad());
            }
        } catch(Exception error) {
            System.out.println("Mid server has disconnected.");
        }
    }
}