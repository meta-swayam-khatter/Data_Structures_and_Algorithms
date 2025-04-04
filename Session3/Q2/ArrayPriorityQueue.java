package Session3.Q2;

interface PriorityQueue {
    void enQueue(int item);
    int deQueue();
    boolean isFull();
    boolean isEmpty();
    void display();
}

public class ArrayPriorityQueue implements PriorityQueue {
    private int[] pQueue;
    private int front, rear, count, size;
    private qType type;

    public static enum qType{
        DESC,
        ASC;
    }

    ArrayPriorityQueue(int size) {
        this.pQueue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
        this.size = size;
    }

    ArrayPriorityQueue(int size, qType type) {
        this.pQueue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
        this.size = size;
        this.type = type;
    }
    
    @Override
    public void enQueue(int item) {
        try {
            if(isFull()) {
                System.out.println("Overflow!");
                return;
            }
            int pos = rear;
            while(pos >= 0 && (type == qType.DESC ? pQueue[pos] <= item : pQueue[pos] >= item)) {
                pQueue[(pos+1)%size] = pQueue[pos];
                pos--;
            }
            pQueue[pos+1] = item;
            rear = (rear + 1) % size;
            count++;
            return;
        } catch (Exception e) {
            return;
        }
    }
    
    @Override
    public int deQueue() {
        try {
            if(isEmpty()) {
                System.out.println("Underflow!");
                return -1;
            }
            int poped = pQueue[front];
            front = (front + 1) % size;
            count--;
            return poped;
        } catch (Exception e) {
            return -1;
        }
    }
    
    @Override
    public boolean isFull() {
        try {
            return (count == size);
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean isEmpty() {
        try {
            return (count == 0);
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public void display() {
        try {
            if (isEmpty()) {
                System.out.println("Empty Queue");
            } else {
                if (front < rear) {
                    for (int i = front; i <= rear; i++) {
                        System.out.print(pQueue[i] + " ");
                    }
                } else {
                    for (int i = front; i < size; i++) {
                        System.out.print(pQueue[i] + " ");
                    }
    
                    for (int i = 0; i <= rear; i++) {
                        System.out.print(pQueue[i] + " ");
                    }
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}
