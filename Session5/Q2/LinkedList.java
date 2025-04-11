package Session5.Q2;

class Node<T extends Comparable<T>>{
    private T value;
    private Node<T> next;

    Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    
    LinkedList(Node<T> head) {
        this.head = head;
    }
    LinkedList(T value) {
        this.head =new Node<T>(value);
    }
    public Node<T> getHead() {
        return head;
    }
    public void setHead(Node<T> head) {
        this.head = head;
    }
    
    public void add(Node<T> node) {
        try {
            Node<T> currNode = getHead();
            while(currNode.getNext() != null) {
                currNode = currNode.getNext();
            }
            currNode.setNext(node);
        } catch (Exception e) {
            throw new Error("Error in adding a new node!");
        }
    }
    public void add(T value) {
        try {
            Node<T> currNode = getHead();
            while(currNode.getNext() != null) {
                currNode = currNode.getNext();
            }
            currNode.setNext(new Node<T>(value));
        } catch (Exception e) {
            throw new Error("Error in adding a new node!");
        }
    }

    public Node<T> sort() {
        try {
        @SuppressWarnings("rawtypes")
        Node<T> dummy= new Node(null);
        Node<T> current=head;
        while(current != null){
            Node<T> prev=dummy;
            Node<T> nextNode=current.getNext();
            while(prev.getNext()!=null && prev.getNext().getValue().compareTo(current.getValue()) < 0){
                prev=prev.getNext();
            }
            current.setNext(prev.getNext());
            prev.setNext(current);
            current=nextNode;
        }
        return dummy.getNext(); 
        } catch (Exception e) {
            throw new Error("Error in sorting the linked list!");
        }
    }

    public void display() {
        Node<T> node = head;
        while(node.getNext() != null) {
            System.out.print(node.getValue() + "-->");
            node = node.getNext();
        }
        System.out.println(node.getValue());
    }

    public void display(Node<T> node) {
        while(node.getNext() != null) {
            System.out.print(node.getValue() + "-->");
            node = node.getNext();
        }
        System.out.println(node.getValue());
    }
}
