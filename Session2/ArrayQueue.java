package Session2;

interface Queue<T> {
    void enque(T item);
    T deque();
    T peek();
    boolean isEmpty();
    boolean isFull();
}

public class ArrayQueue<T> implements Queue<T> {
    private T[] queue;
    private int front, rear, size, count;
    
    @SuppressWarnings("unchecked")
    ArrayQueue(int size) {
        this.queue = (T[]) new Object[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.size = size;
    }

    @Override
    public void enque(T item) {
        try {
            if(isFull()) {
                System.out.println("Overflow");
                return;
            }
            queue[rear] = item;
            rear = (rear + 1) % size;
            count++;
            return;
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public T deque() {
        try {
            if(isEmpty()) {
                System.out.println("Underflow");
                return null;
            }
            T poped = queue[front];
            front = (front + 1) % size;
            count--;
            return poped;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public T peek() {
        try {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }
            return queue[front];
        } catch (Exception e) {
            return null;
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
    public boolean isFull() {
        try {
            return (count == size);
        } catch (Exception e) {
            return false;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            if (front < rear) {
                for (int i = front; i <= rear-1; i++) {
                    System.out.println(queue[i]);
                }
            } else {
                for (int i = front; i < size; i++) {
                    System.out.println(queue[i]);
                }

                for (int i = 0; i <= rear-1; i++) {
                    System.out.println(queue[i]);
                }
            }
        }
      }
}

