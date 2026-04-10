import java.util.*;

class Complaint {
    int id;
    String name;
    String issue;
    String status;

    Complaint(int id, String name, String issue) {
        this.id = id;
        this.name = name;
        this.issue = issue;
        this.status = "Pending";
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Issue: " + issue);
        System.out.println("Status: " + status);
        System.out.println("----------------------");
    }
}

public class Main {
    static ArrayList<Complaint> list = new ArrayList<>();
    static int idCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Complaint Management System ---");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Update Status");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addComplaint(sc);
                    break;

                case 2:
                    viewComplaints();
                    break;

                case 3:
                    updateStatus(sc);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addComplaint(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your complaint: ");
        String issue = sc.nextLine();

        Complaint c = new Complaint(idCounter++, name, issue);
        list.add(c);

        System.out.println("Complaint Added Successfully! ID: " + c.id);
    }

    static void viewComplaints() {
        if (list.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        for (Complaint c : list) {
            c.display();
        }
    }

    static void updateStatus(Scanner sc) {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();

        for (Complaint c : list) {
            if (c.id == id) {
                sc.nextLine(); // clear buffer
                System.out.print("Enter new status (Resolved/In Progress): ");
                c.status = sc.nextLine();
                System.out.println("Status Updated!");
                return;
            }
        }

        System.out.println("Complaint not found!");
    }
}