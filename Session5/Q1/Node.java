package Session5.Q1;

public class Node<K extends Comparable<K>,V> {
    private K key;
    private V value;
    private Node<K,V> left;
    private Node<K,V> right;
    
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K,V> getLeft() {
        return left;
    }

    public Node<K,V> getRight() {
        return right;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }
}
