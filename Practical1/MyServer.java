// MyServer.java - RMI server code

package Practical1;

import java.rmi.*;
// import java.rmi.registry.*;

public class MyServer {
    public static void main(String args[]) {
        try {
            // Create an instance of the remote object
            Adder stub = new AdderRemote();
            // Bind the remote object to a name in the RMI registry
            Naming.rebind("rmi://localhost:5000/sonoo", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
