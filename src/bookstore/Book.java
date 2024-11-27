package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }


    public void displayDetails() {
        System.out.printf("Title: %s | Author: %s | Price: $%.2f | Quantity: %d%n", title, author, price, quantity);
    }


    public void updateStock(int change) {
        this.quantity += change;
    }

    public boolean purchaseBook(int purchaseQuantity) {
        if (purchaseQuantity > quantity) {
            System.out.println("Insufficient stock!");
            return false;
        } else {
            quantity -= purchaseQuantity;
            System.out.printf("Purchase successful! Total cost: $%.2f%n", purchaseQuantity * price);
            return true;
        }
    }


    public String getTitle() {
        return title;
    }

    public static Book getBookInfo(Scanner scanner) {
        System.out.println("Enter book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        return new Book(title, author, price, quantity);
    }
}