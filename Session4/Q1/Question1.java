package Session4.Q1;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
    
        Employee e1 = new Employee(1, "emp1", "jaipur");
        Employee e2 = new Employee(2, "emp2", "ambala");
        Employee e3 = new Employee(3, "emp3", "ambala");
        Employee e4 = new Employee(4, "emp4", "chandigarh");
        Employee e5 = new Employee(4, "emp5", "lucknow");
        
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        /*
         * cannot sort the employees in normal order because it is an object we have to specify which attribute to compare
         */
        // Collections.sort(employees);

        for (Employee employee : employees) {
            employee.printDetails();
        }
    }
}
