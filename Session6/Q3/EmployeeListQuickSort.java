package Session6.Q3;

public class EmployeeListQuickSort {
    EmployeeNode head;

    void add(String name, int salary, int age) {
        EmployeeNode newNode = new EmployeeNode(name, salary, age);
        if (head == null) {
            head = newNode;
            return;
        }
        EmployeeNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void printList() {
        EmployeeNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " - Salary: " + temp.salary + ", Age: " + temp.age);
            temp = temp.next;
        }
    }

    int compare(EmployeeNode a, EmployeeNode b) {
        if (a.salary != b.salary)
            return b.salary - a.salary;
        else
            return a.age - b.age;
    }

    // Partition function
    EmployeeNode[] partition(EmployeeNode head, EmployeeNode end) {
        EmployeeNode pivot = end;
        EmployeeNode prev = null, curr = head, tail = pivot;
        EmployeeNode newHead = null, newEnd = tail;

        while (curr != pivot) {
            if (compare(curr, pivot) < 0) {
                if (newHead == null) newHead = curr;
                prev = curr;
                curr = curr.next;
            } else {
                if (prev != null) prev.next = curr.next;
                EmployeeNode tmp = curr.next;
                curr.next = null;
                tail.next = curr;
                tail = curr;
                curr = tmp;
            }
        }

        if (newHead == null) newHead = pivot;
        newEnd = tail;
        return new EmployeeNode[]{newHead, pivot, newEnd};
    }

    // Main recursive quicksort
    EmployeeNode quickSortRecur(EmployeeNode head, EmployeeNode end) {
        if (head == null || head == end) return head;

        EmployeeNode[] partitioned = partition(head, end);
        EmployeeNode newHead = partitioned[0];
        EmployeeNode pivot = partitioned[1];
        EmployeeNode newEnd = partitioned[2];

        // Recurse on left side
        if (newHead != pivot) {
            EmployeeNode temp = newHead;
            while (temp.next != pivot) temp = temp.next;
            temp.next = null;

            newHead = quickSortRecur(newHead, temp);
            EmployeeNode tail = getTail(newHead);
            tail.next = pivot;
        }

        // Recurse on right side
        pivot.next = quickSortRecur(pivot.next, newEnd);

        return newHead;
    }

    EmployeeNode getTail(EmployeeNode node) {
        while (node != null && node.next != null) node = node.next;
        return node;
    }

    void quickSort() {
        head = quickSortRecur(head, getTail(head));
    }
}