package Practical5;
// import java.io.*;
import java.util.*;

class TokenRing {
    public static void main(String args[]) throws Throwable {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = scan.nextInt();
        // int m = n - 1;
        int token = 0;
        int ch = 0, flag = 0;

        // Displaying the nodes forming the ring
        for (int i = 0; i < n; i++) {
            System.out.print(" " + i);
        }
        System.out.println(" " + 0);

        do {
            if (flag == 1)
                System.out.print("Invalid Input!!...");
            System.out.print("Do you want to send again? Enter 1 for Yes and 0 for No: ");
            try {
                ch = scan.nextInt();
                if (ch != 1 && ch != 0)
                    flag = 1;
                else
                    flag = 0;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
        } while (ch != 1 && ch != 0);

        while (ch == 1) {
            System.out.println("Enter sender:");
            int s = scan.nextInt();
            System.out.println("Enter receiver:");
            int r = scan.nextInt();
            if (s >= n || r >= n) {
                System.out.print("Invalid entry");
            } else {
                System.out.println("Enter Data:");
                String a;
                a = scan.next();
                System.out.print("Token passing:");
                for (int i = token, j = token; (i % n) != s; i++, j = (j + a.length() + i)) {
                    System.out.print(" " + j + "->" + i);
                    System.out.println(" " + s);
                    System.out.println("Sender " + s + " sending data: " + a);
                    for (int k = s + 1; k != r; k = (k + 1) % n) {
                        System.out.println("Data " + a + " forwarded by " + k);
                    }
                    System.out.println("Receiver " + r + " received data: " + a);
                    token = r;
                }
            }
            do {
                try {
                    if (flag == 1)
                        System.out.print("Invalid Input!!...");
                    System.out.print("Do you want to send again? Enter 1 for Yes and 0 for No : ");
                    ch = scan.nextInt();
                    if (ch != 1 && ch != 0)
                        flag = 1;
                    else
                        flag = 0;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                }
            } while (ch != 1 && ch != 0);
        }
        scan.close();
    }
}
