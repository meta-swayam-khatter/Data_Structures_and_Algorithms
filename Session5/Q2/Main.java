package Session5.Q2;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Swayam", 100000, 21);
        Employee emp2 = new Employee(2, "Shanu", 10000, 23);
        Employee emp3 = new Employee(3, "Anurag", 100000, 20);
        LinkedList<Employee> list = new LinkedList<>(emp1);
        list.add(emp2);
        list.add(emp3);
        Node<Employee> sortedListHead = list.sort();
        list.display(sortedListHead);
    }
}
