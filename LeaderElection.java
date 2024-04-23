// import java.util.*;

// Process class representing each process in the system
class Process {
    private int processId;
    private boolean isCoordinator;

    public Process(int id) {
        processId = id;
        isCoordinator = false;
    }

    public int getProcessId() {
        return processId;
    }

    public boolean isCoordinator() {
        return isCoordinator;
    }

    public void setCoordinator(boolean coordinator) {
        isCoordinator = coordinator;
    }

    public void sendElectionMessage(Process higherIdProcess) {
        System.out.println("Process " + processId + " sends election message to process " + higherIdProcess.getProcessId());
        higherIdProcess.receiveElectionMessage(this);
    }

    public void receiveElectionMessage(Process sender) {
        System.out.println("Process " + processId + " receives election message from process " + sender.getProcessId());
        if (sender.getProcessId() > processId) {
            System.out.println("Process " + processId + " acknowledges process " + sender.getProcessId() + " as coordinator.");
            sender.setCoordinator(true);
            setCoordinator(false);
        }
    }
}

// Main class to simulate the Bully and Ring algorithms
public class LeaderElection {
    public static void main(String[] args) {
        // Create processes with IDs
        Process p1 = new Process(1);
        Process p2 = new Process(2);
        Process p3 = new Process(3);
        Process p4 = new Process(4);
        Process p5 = new Process(5);

        // Simulate the Bully algorithm
        System.out.println("\n--- Bully Algorithm ---");
        p1.sendElectionMessage(p2);
        p2.sendElectionMessage(p3);
        p3.sendElectionMessage(p4);
        p4.sendElectionMessage(p5);
        System.out.println("Process " + p5.getProcessId() + " is the coordinator.");

        // Simulate the Ring algorithm
        System.out.println("\n--- Ring Algorithm ---");
        Process[] processes = {p1, p2, p3, p4, p5};
        for (int i = 0; i < processes.length; i++) {
            if (!processes[i].isCoordinator()) {
                processes[i].sendElectionMessage(processes[(i + 1) % processes.length]);
            }
        }
        for (Process process : processes) {
            if (process.isCoordinator()) {
                System.out.println("Process " + process.getProcessId() + " is the coordinator.");
            }
        }
    }
}
