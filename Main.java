import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee number: ");
        int employeeNumber = sc.nextInt();
        sc.nextLine(); // to consume the newline character left by nextInt()
        
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        Employee employee = employeeDatabase.findEmployee(employeeNumber);
        
        if (employee != null) {
            System.out.println("Employee Number: " + employee.getEmployeeNumber());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Birthday: " + employee.getBirthday());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("SSS #: " + employee.getSssNumber());
            System.out.println("Philhealth #: " + employee.getPhilhealthNumber());
            System.out.println("TIN #: " + employee.getTinNumber());
            System.out.println("Pag-ibig #: " + employee.getPagibigNumber());
            System.out.println("Status: " + employee.getStatus());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Immediate Supervisor: " + employee.getImmediateSupervisor());
            System.out.println("Basic Salary: " + employee.getBasicSalary());
            System.out.println("Rice Subsidy: " + employee.getRiceSubsidy());
            System.out.println("Phone Allowance: " + employee.getPhoneAllowance());
            System.out.println("Clothing Allowance: " + employee.getClothingAllowance());
            System.out.println("Gross Semi-monthly Rate: " + employee.getGrossSemiMonthlyRate());
            System.out.println("Hourly Rate: " + employee.getHourlyRate());
        } else {
            System.out.println("Employee not found.");
        }
    }
}
