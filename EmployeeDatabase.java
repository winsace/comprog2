import java.util.ArrayList;

public class EmployeeDatabase {
    private ArrayList<Employee> employeeList;

    public EmployeeDatabase() {
        employeeList = new ArrayList<Employee>();
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Add employee1 to the list
        Employee employee1 = new Employee(10001, "Crisostomo", "Jose", "February 14, 1988", 
                                           "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands", 
                                           "918-621-603", "49-1632020-8", "382189453145", "317-674-022-000", 
                                           "441093369646", "Regular", "HR Manager", "N/A", 62670, 1500, 1000, 
                                           1000, 31335, 373.04);
        employeeList.add(employee1);
        
        // Add employee2 to the list
        Employee employee2 = new Employee(10002, "Mata", "Christian", "October 21, 1987", 
                                           "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "783-776-744", 
                                           "49-2959312-6", "824187961962", "103-100-522-000", "631052853464", 
                                           "Regular", "Account Team Leader", "Romualdez, Fredrick", 42975, 1500, 
                                           800, 800, 21488, 255.80);
        employeeList.add(employee2);
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee findEmployee(int employeeNumber) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                return employee;
            }
        }
        return null;
    }
}
