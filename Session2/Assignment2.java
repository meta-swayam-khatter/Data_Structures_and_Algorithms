package Session2;

public class Assignment2 {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        queue.enque(6);
        queue.enque(7);

        queue.display();
        System.out.println();
        
        queue.deque();
        queue.deque();
        
        queue.display();
        System.out.println();
        
        queue.enque(10);
        queue.enque(11);
        
        queue.display();
    }
}
