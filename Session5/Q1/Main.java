package Session5.Q1;

public class Main {
    public static void main(String[] args) {
        Node<Integer, Integer> root = new Node<Integer,Integer>(9, 1);
        Dictionary<Integer, Integer> dict = new Dictionary<>(root);
        Node<Integer, Integer> deleteNode = new Node<Integer,Integer>(15, 1);
        dict.add(new Node<Integer,Integer>(2, 1));
        dict.add(deleteNode);
        dict.add(new Node<Integer,Integer>(14, 1));
        dict.add(new Node<Integer,Integer>(19, 1));
        dict.add(new Node<Integer,Integer>(17, 1));
        dict.add(new Node<Integer,Integer>(21, 111));
        dict.add(new Node<Integer,Integer>(18, 1));
        dict.delete(root);
        dict.sortedList();
        // System.out.println();
        // dict.sortedListInRange(dict.getRoot(), 14, 19);
        // System.out.println();
    }
}
