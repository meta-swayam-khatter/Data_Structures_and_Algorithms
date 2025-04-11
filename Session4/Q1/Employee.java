package Session4.Q1;

public class Employee {
    private int empId;
    private String name;
    private String address;
    
    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void printDetails() {
        System.out.println("Id: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + empId;
        return result;
    }

    @Override   
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (empId != other.empId)
            return false;
        return true;
    }
}
