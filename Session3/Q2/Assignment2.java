package Session3.Q2;

public class Assignment2 {
    public static void main(String[] args) {
        PriorityQueue pq = new ArrayPriorityQueue(5);
        pq.enQueue(5);
        pq.enQueue(2);
        pq.enQueue(4);
        pq.enQueue(11);
        pq.enQueue(7);
        pq.enQueue(1);

        System.out.print("\nAfter enqueue: ");
        pq.display();

        pq.deQueue();
        pq.deQueue();

        System.out.print("\nAfter dequeue: ");
        pq.display();
    }
}
