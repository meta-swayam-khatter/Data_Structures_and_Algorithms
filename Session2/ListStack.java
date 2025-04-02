package Session2;

import java.util.ArrayList;
import java.util.List;

interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
    void display();
}

public class ListStack<T> implements Stack<T> {
    private List<T> stack;
    private int size;

    ListStack(int size) {
        this.stack = new ArrayList<>();
        this.size = size;
    }

    @Override
    public void push(T item) {
        try {
            if(stack.size() >= size) {
                System.out.println("Overflow");
                return;
            }
            stack.add(item);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public T pop() {
        try {
            if(stack.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            T poped = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return poped;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public T peek() {
        try {
            if(stack.size() == 0) {
                System.out.println("No items present");
                return null;
            }
            return stack.get(stack.size()-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            return stack.size() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        try {
            return stack.size() == size;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void display() {
        try {
            if(isEmpty()) {
                System.out.println("Stack is empty!");
                return;
            }
            for(T item : stack) {
                System.out.print(item + " ");
            }
            return;
        } catch (Exception e) {
            return;
        }
    }
}