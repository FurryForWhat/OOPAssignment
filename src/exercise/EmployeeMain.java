package exercise;

import moviebooking.Movie;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;


public class EmployeeMain {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        displayAll();
    }

    public static void displayAll() throws IOException {
        boolean bigFlag = true;
        while (bigFlag){
            System.out.println("*********Register Employee Here************");
            System.out.println("Press 1 to Register Employee: ");
            System.out.println("Press 2 to Display all employees: ");
            System.out.println("Press 3 to display total Employee:");
            System.out.println("Press 4 to display average Salary : ");
            System.out.println("Press 6 to count each department employees : ");
            System.out.println("Press 5 to Exit: ");
            System.out.print("-> ");
            int userInput = Integer.parseInt(bufferedReader.readLine());
            switch (userInput){
                case 1 -> Employee.EmployeeRegistration();
                case 2 -> Employee.displayALlEmployee(Employee.employeeList);
                case 3 -> Employee.totalEmployee();
                case 4 -> Employee.avgSalary();
                case 5 -> {
                    System.out.println("Exiting the System...");
                    bigFlag = false;
                    break;
                }
                case 6 -> Employee.countEmployeeByEachDprt();
                default -> System.out.println("Invalid Option, Try again!!!!!");
            }
        }
    }
}
