package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    private String name;
    private String email;
    private String phone;
    private String department;
    private double salary;

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int EmployeeCount = 0;
    static double salaryCount = 0;
    static Employee[]  employeeList = new Employee[100];


    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void EmployeeRegistration() throws IOException {
        boolean flag = true;
        while (flag){
            Employee employee = getEmployeeInfo();
            employeeList[EmployeeCount] = employee;
            EmployeeCount++;
            salaryCount += employee.getSalary();
            System.out.print("add more?? yes/no");
            String yN = bufferedReader.readLine();
            if(yN.equalsIgnoreCase("no")){
                flag = false;
            }

        }
    }

    public static Employee getEmployeeInfo() throws IOException {
        System.out.println("*************** Employee Registration ************");
        System.out.print("Enter Name : ");
        String name = bufferedReader.readLine();
        System.out.print("Enter Email : ");
        String email = bufferedReader.readLine();
        System.out.print("Enter Phone Number : ");
        String phone = bufferedReader.readLine();
        System.out.print("Enter Department : ");
        String dprt = bufferedReader.readLine();
        System.out.print("Enter Salary : ");
        double salary = Double.parseDouble(bufferedReader.readLine());

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setDepartment(dprt);
        employee.setSalary(salary);

        return employee;
    }

    public static void displayALlEmployee(Employee[] employeeList){
        System.out.println("*********** Displaying all employee ***********");
        for(Employee employee: employeeList){
            if(employee == null){
                continue;
            }else{
                String name = "Name->"+employee.getName();
                String email = "Email->"+employee.getEmail();
                String phone = "Phone->"+employee.getPhone();
                String deprt = "Department->"+employee.getDepartment();
                String salary = "Salary->"+employee.getSalary();
                System.out.print(name+" | "+employee+" | "+phone+ " | "+deprt+" | "+salary+"\n");
            }
        }
    }

    public static void totalEmployee(){
        System.out.println("Total Employee is :"+EmployeeCount);
    }
    public static  void avgSalary(){
        double avg = salaryCount / EmployeeCount;
        System.out.print("Average salary is :"+avg);
    }
    public static void countEmployeeByEachDprt() throws IOException {
        System.out.print("******* DepartmentList ******");
        Map<String,Integer> deprtCount = new HashMap<>();

        for(Employee employee: employeeList){
            if( employee == null){
                continue;
            }else {
                deprtCount.put(employee.getDepartment(),deprtCount.getOrDefault(employee.getDepartment(),0)+1);
            }

        }
        for(Map.Entry<String,Integer> entry : deprtCount.entrySet()){
            System.out.println(entry.getKey()+ ": "+entry.getValue());
        }
        boolean flag = true;
        while (flag){
            System.out.println("Enter Department Name (or type 'exit' to quit): ");
            String dp = bufferedReader.readLine();

            if ("exit".equalsIgnoreCase(dp)) {
                flag = false;
                System.out.println("Exiting...");
            } else if (deprtCount.containsKey(dp)) {
                System.out.println("Total Employees in " + dp + ": " + deprtCount.get(dp));
            } else {
                System.out.println("Department not found.");
            }
        }
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", phone='" + this.phone + '\'' +
                ", department='" + this.department + '\'' +
                ", salary=" + this.salary +
                '}';
    }
}
