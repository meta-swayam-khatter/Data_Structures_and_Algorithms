package Session3.Q3;

public class CustomBowlerPriorityQueue{
    private Bowler[] pQueue;
    private int front, rear, count, size;

    // @SuppressWarnings("unchecked")
    CustomBowlerPriorityQueue(int size) {
        this.pQueue = new Bowler[100];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
        this.size = size;
    }
    
    public void enQueue(Bowler item) {
        try {
            if(isFull()) {
                System.out.println("Overflow!");
                return;
            }
            int pos = rear;
            while(pos >= front && pQueue[pos].getNoOfBowls() <= item.getNoOfBowls()) {
                // System.out.println("enqueing: " + pQueue[pos].getNoOfBowls() + " " + item.getNoOfBowls());
                pQueue[(pos+1)] = pQueue[pos];
                pos--;
            }
            pQueue[pos+1] = item;
            rear = (rear + 1);
            count++;
            return;
        } catch (Exception e) {
            return;
        }
    }
    
    public Bowler deQueue() {
        try {
            if(isEmpty()) {
                System.out.println("Underflow!");
                return null;
            }
            Bowler poped = pQueue[front];
            front = (front + 1);
            count--;
            return poped;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean isFull() {
        try {
            return (count == size);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isEmpty() {
        try {
            return (count == 0);
        } catch (Exception e) {
            return false;
        }
    }
    
    public void display() {
        try {
            if (isEmpty()) {
                System.out.println("Empty Queue");
            } else {
                // System.out.println("front: " + front + " rear: " + rear);
                if (front < rear) {
                    for (int i = front; i <= rear; i++) {
                        System.out.println(pQueue[i].getName() + " -> " + pQueue[i].getNoOfBowls());
                    }
                } else {
                    for (int i = front; i < size; i++) {
                        System.out.println(pQueue[i].getName() + " -> " + pQueue[i].getNoOfBowls());
                    }
                    for (int i = 0; i <= rear; i++) {
                        System.out.println(pQueue[i].getName() + " -> " + pQueue[i].getNoOfBowls());
                    }
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}

