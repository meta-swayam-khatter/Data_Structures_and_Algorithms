package Session3.Q1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node<T>{
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;
    private String createdAt;
    
    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<Node<T>>(Arrays.asList());
        this.createdAt = LocalDateTime.now().toString();
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void addChildNode(Node<T> childNode) {
        children.add(childNode);
    }
}

public class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }
}


