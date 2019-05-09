package in.sri.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(5000);
        
        System.out.println("Server started at 5000");
        
        Socket client = server.accept();
        
        System.out.println("Client connected");
        
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        PrintStream clientOut = new PrintStream(client.getOutputStream());
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            
            String s = clientIn.readLine();
            
            if (s.equalsIgnoreCase("bye")) {
                
                System.out.println("connection closed by client");
                
                break;
                
            }
            
            System.out.println("Client: " + s);
            
            System.out.print("Server: ");
            
            s = stdIn.readLine();
            
            clientOut.println(s);
            
        }
        
        server.close();
        
        clientIn.close();
        
        clientOut.close();
        
        stdIn.close();
        
    }
    
}
