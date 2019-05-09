package in.sri.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String args[]) throws UnknownHostException, IOException {
        
        Socket client = new Socket("127.0.0.1", 5000);
        
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        PrintStream clientOut = new PrintStream(client.getOutputStream());
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            
            System.out.print("Client: ");
            
            String s = stdin.readLine();
            
            clientOut.println(s);
            
            s = clientIn.readLine();
            
            if (s.equalsIgnoreCase("bye")) {
                
                System.out.println("connection closed by server");
                
                break;
            }
            
            System.out.println("Server: " + s);
        }
        
        clientIn.close();
        clientOut.close();
        stdin.close();
        client.close();
        
    }
    
}
