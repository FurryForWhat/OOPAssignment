package feedback;

import inventory.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class CustomerFeedbackMain {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        displayALl();
    }

    public static void displayALl() throws IOException {

        boolean bigFlag = true;
        while (bigFlag){
            System.out.println("*********Register Customer Feedback Here************");
            System.out.println("Press 1 to Register Feedback: ");
            System.out.println("Press 2 to Display all Feedback: ");
            System.out.println("Press 3 to display average feedback rating:");
            System.out.println("Press 4 to display feedback with highest rating : ");
            System.out.println("Press 6 to Count the number of feedback entries with a rating of 5 : ");
            System.out.println("Press 5 to Exit: ");
            System.out.print("-> ");
            int userInput = Integer.parseInt(bufferedReader.readLine());
            switch (userInput){
                case 1 -> CustomerFeedback.feedbackRegistration();
                case 2 -> CustomerFeedback.displayAllFeedback();
                case 3 -> CustomerFeedback.avgFeedbackRating();
                case 4 -> CustomerFeedback.highestFeedbackRating();
                case 5 -> {
                    System.out.println("Exiting the System...");
                    bigFlag = false;
                    break;
                }case 6 -> CustomerFeedback.rating5Feedback();
                default -> System.out.println("Invalid Option, Try again!!!!!");
            }
        }
    }
}
