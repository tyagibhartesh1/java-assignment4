
import java.util.ArrayList;
import java.util.Scanner;

class Library {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String title) {
        books.add(title);
        System.out.println("Book added successfully.");
    }

    void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Current Books:");
            for (String book : books) {
                System.out.println(book);
            }
        }
    }
}

public class A4_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    lib.addBook(title);
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    title = sc.nextLine();
                    lib.removeBook(title);
                    break;

                case 3:
                    lib.displayBooks();
                    break;

                case 4:
                    System.out.println("Exiting Library System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
