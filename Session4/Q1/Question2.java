package Session4.Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
    
        Employee e1 = new Employee(1, "Swayam", "jaipur");
        Employee e2 = new Employee(2, "Shanu", "ambala");
        Employee e3 = new Employee(3, "Arya", "ambala");
        Employee e4 = new Employee(4, "Soumen", "chandigarh");
        Employee e5 = new Employee(4, "Anurag", "lucknow");
        
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        EmployeeComparator empCmpr = new EmployeeComparator();

        Collections.sort(employees, empCmpr);

        for (Employee employee : employees) {
            employee.printDetails();
        }
    }
}
