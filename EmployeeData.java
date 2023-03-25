import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private List<Employee> employeeList;

    public EmployeeData() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();

        // Employee 1 object
        Employee employee1 = new Employee(
            10001, "Crisostomo", "Jose", "February 14, 1988",
            "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands",
            "918-621-603", "49-1632020-8", "382189453145", "317-674-022-000",
            "441093369646", "Regular", "HR Manager", "N/A", 62670, 1500, 1000,
            1000, 31335, 373.04);

        // Add employee 1 to list
        employeeData.addEmployee(employee1);

        // Employee 2 object
        Employee employee2 = new Employee(
            10002, "Mata", "Christian", "October 21, 1987",
            "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu",
            "783-776-744", "49-2959312-6", "824187961962", "103-100-522-000",
            "631052853464", "Regular", "Account Team Leader", "Romualdez, Fredrick",
            42975, 1500, 800, 800, 21488, 255.80);

        // Add employee 2 to list
        employeeData.addEmployee(employee2);

        // Print all employees in the list
        List<Employee> employees = employeeData.getEmployeeList();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
