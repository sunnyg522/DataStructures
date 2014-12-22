
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Scanner keyboard = new Scanner(System.in);
    
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
     * A method to force the user to enter a double
     * @param prompt the message to ask the user
     * @return double value
     */
    public static double getDouble(String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(keyboard.nextLine());
            } catch(Exception error) {
                System.out.println("Error: Please enter a number.");
            }
        }
    }
    
    /**
     * Run the calculator app
     * @param socket socket that sends information to server and receive as well
     * @throws Exception happens when server crashes
     */
    private static void runCalculator(Socket socket) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        
        // tell server that this is a client
        out.println("CLIENT");
        
        while(true) {
            System.out.println("Hi, Welcome to the Calculator App, What would you like to do?");
            System.out.println("[1] ADD");
            System.out.println("[2] SUBTRACT");
            System.out.println("[3] MULTIPLY");
            System.out.println("[4] DIVIDE");
            System.out.println("[5] EXIT");
            
            int choice = getInt("Choice: ");
            
            // Stop if user wishes to terminate
            if(choice == 5)
                break;
            
            // Ask for the first and second number
            double firstNumber = getDouble("Enter first number: ");
            double secondNumber = getDouble("Enter second number: ");
            
            // Avoid division by 0
            if(choice == 4 && secondNumber == 0) {
                System.out.println("Error: You cannot divide by 0.");
            } else {
                // Send to the server the numbers
                out.println(firstNumber);
                out.println(secondNumber);
                
                switch(choice) {
                    case 1: out.println("ADD"); break;
                    case 2: out.println("SUBTRACT"); break;
                    case 3: out.println("MULTIPLY"); break;
                    case 4: out.println("DIVIDE"); break;
                }
                
                // Get the result
                System.out.println("The answer is: ");
                System.out.println(in.readLine());
            }
        }
    }
    
    /**
     * A simple calculator application
     * @param args unused arguments
     */
    public static void main(String[] args) {
        // Setup the client to connect to the mid server first
        try {
            int midServerPort = getInt("What port number is the mid server running?: ");
            
            System.out.print("What address is the mid server running?: ");
            String midServerAddress = keyboard.nextLine();
            
            System.out.println("Connecting to the mid server...");
            Socket midServerSocket = new Socket(midServerAddress, midServerPort);
            
            System.out.println("Successfully connected to mid server... waiting for best server information...");
            
            // Ready the communication from the midserver
            BufferedReader midServerIn = new BufferedReader(new InputStreamReader(midServerSocket.getInputStream()));
            
            String bestServerAddress = midServerIn.readLine();
            int bestServerPort = Integer.parseInt(midServerIn.readLine());
            System.out.println("Best server is " + bestServerAddress + " at port " + bestServerPort);
            
            // Connect to the best server
            try {
                System.out.println("Connecting to best server...");
                Socket bestServer = new Socket(bestServerAddress, bestServerPort);
                System.out.println("Successfully connected to best server... running calculator application...");
                runCalculator(bestServer);
            } catch(Exception error) {
                System.out.println("Error: Failed to connect to best server, it crashed.");
                System.exit(0);
            }
        } catch(Exception error) {
            System.out.println("Error: Failed to connect to the mid server, it doesn't exist.");
        }
    }
}
