// Adder.java - Interface for remote method

package Practical1;

import java.rmi.*;

public interface Adder extends Remote {
    // Remote method declaration
    public int add(int x, int y) throws RemoteException;
}
