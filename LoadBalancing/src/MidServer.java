
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
 * All clients connect to this midserver for the first time only and the reason is to only
 * know which server to connect to.
 */
public class MidServer {
    private static Scanner keyboard = new Scanner(System.in);
    
    private static List<Integer> serverPortNumbers = new LinkedList<Integer>();
    private static List<String> serverAddresses = new LinkedList<String>();
    private static List<Socket> serverSockets = new LinkedList<Socket>();
    
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
     * Connect this mid server to the other servers
     */
    private static void setupConnectionToServers() {
        // Attempt to connect this mid server to the other server first
        System.out.println("We are setting up the mid server to connect to the other servers...");
        System.out.println("Please make sure the other servers are already running on the ports you selected...");
        
        while(true) {
            // Connect to a server
            int serverPort = getInt("What port number is the other server running?: ");
            
            System.out.print("What address is the other server running?: ");
            String serverAddress = keyboard.nextLine();
            
            try { 
                Socket socket = new Socket(serverAddress, serverPort);
                
                // Write a message to the server that this is a mid server
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                out.println("MIDSERVER");
                
                // Add the connected server to the collection
                serverSockets.add(socket);
                serverAddresses.add(serverAddress);
                serverPortNumbers.add(serverPort);
                
                System.out.println("The server has been successfully added.");
            } catch(Exception e) {
                System.out.println("Error: Failed to connect to the server. The server doesn't exist.");
            }
            
            // Ask again if they user would like to add another server
            String again = "";
            
            while(true) {
                System.out.print("Do you have any other servers to add? (y/n): ");
                again = keyboard.nextLine();
                
                if(again.equalsIgnoreCase("Y") || again.equalsIgnoreCase("N"))
                    break;
                
                System.out.println("Error: Please enter Y or N only.");
            }
            
            // Stop if no more servers to add
            if(again.equalsIgnoreCase("N"))
                break;
        }
    }
    
    /**
     * Run the mid server
     * @param args unused arguments
     */
    public static void main(String[] args) {
        setupConnectionToServers();
        
        System.out.println();
        System.out.println("Okay, let us now set up this mid server to run.");
        
        // Ask for the port where the server will attempt to run
        int port = getInt("What port number would you like to run this mid server?: ");
        
        try {
            // Attempt to run the server on the designated port
            ServerSocket ss = new ServerSocket(port);
            
            System.out.println("The mid server is now running...");
            System.out.println("To stop the mid server please use the stop button of Netbeans or Eclipse. Or press ctrl + c if you are running it in a console.");
            
            while(true) {
                // Wait for a client to connect
                System.out.println("Waiting for client...");
                Socket s = ss.accept();
                
                // Ready the communication to the client
                PrintWriter clientOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                
                System.out.println("A client has connected...");
                System.out.println("Finding the best server for the client...");
                
                // Find the server with the least load
                Socket bestServer = null;
                int bestServerLoad = 0;
                
                for(Socket server : serverSockets) {
                    BufferedReader serverIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
                    PrintWriter serverOut = new PrintWriter(new OutputStreamWriter(server.getOutputStream()), true);
                    
                    serverOut.println("GETLOAD");
                    int serverLoad = Integer.parseInt(serverIn.readLine());
                    
                    if(bestServer == null || serverLoad < bestServerLoad) {
                        bestServer = server;
                        bestServerLoad = serverLoad;
                    }
                }
                
                // After finding the best server, we need to return to the client the best server information
                int index = serverSockets.indexOf(bestServer);
                System.out.println("Best Server found is " + serverAddresses.get(index) + " at port " + serverPortNumbers.get(index));
                
                clientOut.println(serverAddresses.get(index));
                clientOut.println(serverPortNumbers.get(index));
                
                System.out.println("Done...");
            }
        } catch(Exception error) {
            System.out.println("The mid server failed to run on the port. Most probably because the port is blocked by your firewall, or it is being used by another application.");
            System.exit(0);
        }
    }
}
