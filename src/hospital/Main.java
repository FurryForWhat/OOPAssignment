package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Patient[] patientsList = new Patient[100];
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        PatientDisplay();
    }

    public static void PatientDisplay() throws IOException {
        int index = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("<--------------- Patient Registration System ----------------> ");
            System.out.println("Press 1 to Register.");
            System.out.println("Press 2 to display all patients.");
            System.out.println("Press 3 to view patients assigned to a specific doctor.");
            System.out.println("Press 4 to view the total number of patients suffering from a specific disease.");
            System.out.println("Press 5 to exit.");
            String input = reader.readLine();
            int userInput;
            userInput = Integer.parseInt(input);
            switch (userInput) {
                case 1 -> Register();
                case 2 -> displayAllPatients();
                case 3 -> patientsByDoctor();
                case 4 -> patientsByDisease();
                case 5 -> {
                    System.out.println("Exiting the system...");
                    flag = false;
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void Register() throws IOException {
        boolean flag = true;
        int index = 0;
        while (flag) {
            Patient newPatient = Patient.getPatientInfo();
            patientsList[index] = newPatient;
            index += 1;
            System.out.print("Do you want to add more? yes/no: ");
            String userInput = reader.readLine();
            if (userInput.equalsIgnoreCase("no")) {
                flag = false;
            }
        }
    }

    public static void displayAllPatients() {
        System.out.println("<------------Display All Patients------->");
        boolean found = false;
        for (Patient patient : patientsList) {
            if (patient != null) {
                found = true;
                System.out.println(patient);
            }
        }
        if (!found) {
            System.out.println("No data was found!");
        }
    }

    public static void patientsByDoctor() throws IOException {
        System.out.print("Enter Doctor Name: ");
        String doctor = reader.readLine();
        System.out.println("Doctor's patients are: ");
        boolean found = false;
        for (Patient patient : patientsList) {
            if (patient != null && patient.getDoctorAssigned().equalsIgnoreCase(doctor)) {
                found = true;
                System.out.println("Patient Name: " + patient.getName());
            }
        }
        if (!found) {
            System.out.println("No patients were found!");
        }
    }

    public static void patientsByDisease() throws IOException {
        System.out.print("Enter Disease Name: ");
        String disease = reader.readLine();
        System.out.println("Disease's patients are: ");
        boolean found = false;
        for (Patient patient : patientsList) {
            if (patient != null && patient.getDisease().equalsIgnoreCase(disease)) {
                found = true;
                System.out.println("Patient Name: " + patient.getName());
            }
        }
        if (!found) {
            System.out.println("No patients were found!");
        }
    }
}
