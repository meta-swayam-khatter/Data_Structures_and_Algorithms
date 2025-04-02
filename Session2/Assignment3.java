package Session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private String name;
    private List<Program> programs;

    Student(String name, List<Program> programs) {
        this.name = name;
        this.programs = programs;
    }

    public String getName() {
        return name;
    }

    public List<Program> getPrograms() {
        return programs;
    }
}

class Program {
    private String name;
    private Integer capacity;

    Program(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(int newCapacity) {
        this.capacity = newCapacity;
        return;
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        ArrayQueue<Student> students = new ArrayQueue<>(5);
        List<Program> programs = new ArrayList<>();

        Program p1 = new Program("Java", 1);
        Program p2 = new Program("DBMS", 3);
        Program p3 = new Program("DSA", 2);
        Program p4 = new Program("UI/UX", 1);
        Program p5 = new Program("QA", 5);
        programs.add(p1);
        programs.add(p2);
        programs.add(p3);
        programs.add(p4);
        programs.add(p5);

        Student s1 = new Student("Swayam", new ArrayList<>(Arrays.asList(p1, p3, p2, p4, p5)));
        Student s2 = new Student("Shanu", new ArrayList<>(Arrays.asList(p1, p3, p2, p4, p5)));
        Student s3 = new Student("Soumen", new ArrayList<>(Arrays.asList(p1, p3, p2, p4, p5)));
        Student s4 = new Student("Maity", new ArrayList<>(Arrays.asList(p1, p3, p2, p4, p5)));
        students.enque(s1);
        students.enque(s2);
        students.enque(s3);
        students.enque(s4);

        Map<Student, Program> allocatedPrograms = new HashMap<>();
        while(!students.isEmpty()) {
            Student stud = students.peek();
            for(Program program : stud.getPrograms()) {
                if(program.getCapacity() > 0) {
                    allocatedPrograms.put(stud, program);
                    program.setCapacity(program.getCapacity() - 1);
                    break;
                }
            }
            if(!allocatedPrograms.containsKey(stud)) {
                System.out.println("Contain allocate any program to this student!");
            }
            students.deque();
        }

        for(Map.Entry<Student, Program> entry : allocatedPrograms.entrySet()) {
            System.out.println(entry.getValue().getName() + " program has been allocated to " +entry.getKey().getName());
        }
    }
}
