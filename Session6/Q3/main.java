package Session6.Q3;

public class Main {
    public static void main(String[] args) {
        EmployeeListQuickSort obj = new EmployeeListQuickSort();
        obj.add("Swayam", 20000, 21);
        obj.add("Shanu", 20020, 23);
        obj.add("Soumen", 22000, 20);
        obj.add("Anurag", 20000, 22);

        obj.quickSort();

        obj.printList();
    }
}
