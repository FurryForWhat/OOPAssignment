package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

public class BookstoreApplication {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bookstore Menu ---");
            System.out.println("1. Register a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Purchase a book");
            System.out.println("5. Add stock to an existing book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (books.size() < 50) {
                        books.add(Book.getBookInfo(scanner));
                    } else {
                        System.out.println("Bookstore can only store 50 books.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- All Books ---");
                    for (Book book : books) {
                        book.displayDetails();
                    }
                    break;
                case 3:
                    System.out.print("Enter the title to search: ");
                    String searchTitle = scanner.nextLine();
                    boolean found = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                            book.displayDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title to purchase: ");
                    String purchaseTitle = scanner.nextLine();
                    boolean purchased = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(purchaseTitle)) {
                            System.out.print("Enter quantity to purchase: ");
                            int purchaseQuantity = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            purchased = book.purchaseBook(purchaseQuantity);
                            break;
                        }
                    }
                    if (!purchased) {
                        System.out.println("Purchase failed!");
                    }
                    break;
                case 5:
                    System.out.print("Enter the title to add stock: ");
                    String stockTitle = scanner.nextLine();
                    boolean stockAdded = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(stockTitle)) {
                            System.out.print("Enter quantity to add: ");
                            int stockQuantity = scanner.nextInt();
                            scanner.nextLine();
                            book.updateStock(stockQuantity);
                            System.out.println("Stock updated successfully!");
                            stockAdded = true;
                            break;
                        }
                    }
                    if (!stockAdded) {
                        System.out.println("Book not found!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
