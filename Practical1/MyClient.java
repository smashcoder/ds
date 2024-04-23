// MyClient.java - RMI client code

package Practical1;

import java.rmi.*;

public class MyClient {
    public static void main(String args[]) {
        try {
            // Look up the remote object by its name in the RMI registry
            Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/sonoo");
            // Call the remote method and print the result
            System.out.println(stub.add(38, 4));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
