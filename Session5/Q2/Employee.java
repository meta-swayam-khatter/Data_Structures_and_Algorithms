package Session5.Q2;

public class Employee implements Comparable<Employee> {
    private int empID;
    private String name;
    private int salary;
    private int age;

    Employee(int empID, String name, int salary, int age) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    public int getEmpID() {
        return empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void printDetails() {
        System.out.println("--Employee's Detail--");
        System.out.println("empID: " + empID);
        System.out.println("name: "+ name);
        System.out.println("salary: " + salary);
        System.out.println("age: " + age);
    }
    @Override
    public int compareTo(Employee o) {
        if(this.getSalary() == o.getSalary()) {
            return o.getAge() - this.getAge();
        }
        return o.getSalary() - this.getSalary();
    }
    @Override
    public String toString() {
        return "Employee [empID=" + empID + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
    }

    
}
