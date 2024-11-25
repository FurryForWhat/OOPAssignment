package feedback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedback {
    private String name;
    private String email;
    private String feedback;
    private int rating;

    static CustomerFeedback[] feedbackList = new CustomerFeedback[100];
    static int feedBackCount = 0;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public CustomerFeedback(String nam, String cat, String quan, int price) {
        this.name = nam;
        this.email = cat;
        this.feedback = quan;
        this.rating = price;
    }

    public static void feedbackRegistration() throws IOException {
        boolean flag = true;
        while (flag) {
            CustomerFeedback customerFeedback = getFeedbackInfo();
            feedbackList[feedBackCount] = customerFeedback;
            feedBackCount += 1;
            System.out.println("Wanna add more??? yes/no");
            String userInput = bufferedReader.readLine();
            if (userInput.equalsIgnoreCase("no")) {
                flag = false;
            }
        }
    }

    public static CustomerFeedback getFeedbackInfo() throws IOException {
        System.out.println("<<<<<<<<<<< Customer Feedback Registration >>>>>>>>>>>>");
        System.out.print("Enter Name :");
        String name = bufferedReader.readLine().trim();
        System.out.println("Enter Email :");
        String email = bufferedReader.readLine().trim();
        System.out.println("Enter Feedback :");
        String feedback = bufferedReader.readLine().trim();
        System.out.println("Enter rating : ");
        int rating = Integer.parseInt(bufferedReader.readLine().trim());

        return new CustomerFeedback(name, email, feedback, rating);
    }

    public static void displayAllFeedback() {
        System.out.println("********** Displaying all Feedback **********");
        int index = 1;
        for (CustomerFeedback customerFeedback : feedbackList) {
            if (customerFeedback != null) {
                System.out.print(index + "customer's feedback ->" + customerFeedback.feedback + "\n");
                index++;
            }
        }
    }

    public static void rating5Feedback() {
        int index = 0;
        for (CustomerFeedback customerFeedback : feedbackList) {
            if(customerFeedback != null){
                if (customerFeedback.rating == 5) {
                    index += 1;
                }
            }
        }
        System.out.println("the number of feedback entries with a rating of 5:" + index);
    }


public static void highestFeedbackRating() {
    CustomerFeedback first = feedbackList[0];
    for (int i = 1; i < feedBackCount - 1; i++) {
        if (first.rating < feedbackList[i].rating) {
            first = feedbackList[i];
        }
    }
    System.out.println("Customer Name : " + first.name + " gives the highest rating in feedback...\nCustomer feedback : "+first.feedback);
}

public static void avgFeedbackRating(){
        int countRating = 0;
        for(CustomerFeedback customerFeedback: feedbackList){
            if(customerFeedback != null){
                countRating += customerFeedback.rating;
            }
        }
        int avg = countRating / feedBackCount;
        System.out.println("Average feedback rating is : "+avg);
}

@Override
public String toString() {
    return "Product->\t" +
            "Name : " + this.name +
            " Category : " + this.email +
            " Quantity : " + this.feedback +
            "PricePerUnit : " + this.rating;
}
}

