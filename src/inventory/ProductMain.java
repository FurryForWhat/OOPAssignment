package inventory;


import exercise.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProductMain {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        displayAll();
    }

    public static void displayAll() throws IOException {
        boolean bigFlag = true;
        while (bigFlag){
            System.out.println("*********Register Product Here************");
            System.out.println("Press 1 to Register Product: ");
            System.out.println("Press 2 to Display all Product: ");
            System.out.println("Press 3 to display product with highest quantity:");
            System.out.println("Press 4 to display total value of all products : ");
            System.out.println("Press 5 to Exit: ");
            System.out.print("-> ");
            int userInput = Integer.parseInt(bufferedReader.readLine());
            switch (userInput){
                case 1 -> Product.productRegistration();
                case 2 -> Product.displayAllProduct();
                case 3 -> Product.highestQuantity();
                case 4 -> Product.totalValue();
                case 5 -> {
                    System.out.println("Exiting the System...");
                    bigFlag = false;
                    break;
                }default -> System.out.println("Invalid Option, Try again!!!!!");
            }
        }
    }
}
