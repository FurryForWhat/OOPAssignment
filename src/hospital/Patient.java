package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Patient {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDoctorAssigned() {
        return doctorAssigned;
    }

    public void setDoctorAssigned(String doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }

    private String name;
    private int age;
    private String disease;
    private String doctorAssigned;
    public Patient(){

    }
    public static void display(ArrayList[] patientList,int index){

    }
    public static Patient getPatientInfo() throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("<--------------- Patient Registration ---------------->");
        System.out.print("Enter Name : ");
        String inName = scan.readLine();
        System.out.print("Enter Age : ");
        int inAge = Integer.parseInt(scan.readLine());
        System.out.print("Enter disease type : ");
        String inDisease = scan.readLine();
        System.out.print("Enter doctorAssigned : ");
        String inDoc = scan.readLine();

        Patient patient = new Patient();
        patient.name = inName;
        patient.age = inAge;
        patient.disease = inDisease;
        patient.doctorAssigned = inDoc;
        return patient;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", disease='" + this.disease + '\'' +
                ", doctorAssigned='" + this.doctorAssigned + '\'' +
                '}';
    }
}
