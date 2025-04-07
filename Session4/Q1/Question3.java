package Session4.Q1;

import java.util.HashSet;
import java.util.Set;

public class Question3 {
    public static void main(String[] args) {
        Set<Employee> employeesSet = new HashSet<Employee>();
        Employee e1 = new Employee(1, "emp1", "jaipur");
        Employee e2 = new Employee(2, "emp2", "ambala");
        Employee e3 = new Employee(3, "emp3", "ambala");
        Employee e4 = new Employee(2, "emp4", "chandigarh");

        employeesSet.add(e1);
        employeesSet.add(e2);
        employeesSet.add(e3);
        employeesSet.add(e4);

        for (Employee employee : employeesSet) {
            employee.printDetails();
        }
    }
}
