// AdderRemote.java - Remote object implementation

package Practical1;

import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder {
    // Constructor that throws RemoteException
    AdderRemote() throws RemoteException {
        super();
    }

    // Implementation of the remote method
    public int add(int x, int y) {
        return x + y;
    }
}
