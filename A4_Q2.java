
import java.util.HashSet;
import java.util.Scanner;

class Attendance {
    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {
        if (students.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    void displayAttendance() {
        System.out.println("Students Present:");
        for (String name : students) {
            System.out.println(name);
        }
    }
}

public class A4_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance a = new Attendance();

        System.out.print("Enter name to mark attendance: ");
        String name1 = sc.nextLine();
        a.markAttendance(name1);

        System.out.print("Enter name to mark attendance: ");
        String name2 = sc.nextLine();
        a.markAttendance(name2);

        a.displayAttendance();

        sc.close();
    }
}
