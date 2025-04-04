package Session3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileDirectory<T> extends Tree<T> {
    private Node<T> currentNode;
    private ArrayList<Node<T>> stack;

    public FileDirectory(Node<T> root) {
        super(root);
        this.currentNode = root;
        this.stack = new ArrayList<Node<T>>();
        stack.add(root);
    }

    public Node<T> getCurrentNode() {
        return currentNode;
    }

    public ArrayList<Node<T>> getStack() {
        return stack;
    }

    public void createDirectory(T newDirectoryName) {
        try {
            Node<T> newDirectory = new Node<T>(newDirectoryName, currentNode);
            for(Node<T> child : currentNode.getChildren()) {
                if(child.getData() == newDirectoryName) {
                    System.out.println("directory already present");
                    return;
                }
            }
            currentNode.addChildNode(newDirectory);
            return;
        } catch (Exception e) {
            return;
        }
    }

    public void changeDirectory(T directoryName) {
        try {
            for(Node<T> child : currentNode.getChildren()) {
                if(child.getData().equals(directoryName)) {
                    stack.add(child);
                    currentNode = child;
                    break;
                }
            }
            if(!currentNode.getData().equals(directoryName)) {
                System.out.println("Invalid directory!");
            }
            return;
        } catch (Exception e) {
            return;
        }
    }
    
    public void back() {
        try {
            if(stack.getLast() == getRoot()) {
                System.out.println("Can't go abck from the root directory!");
                return;
            }
            stack.removeLast();
            currentNode = stack.getLast();
        } catch (Exception e) {
            return;
        }
    }

    public List<Node<T>> listDirectories() {
        try {
            return currentNode.getChildren();
        } catch (Exception e) {
            return null;
        }
    }

    public Stack<Node<T>> findDirectory(T directoryName, Node<T> tempRoot, Stack<Node<T>> tempStack) {
        try {
            if(tempRoot.getData().equals(directoryName)) {
                return tempStack;
            }
            for(Node<T> child : currentNode.getChildren()) {
                tempStack.add(child);
                Stack<Node<T>> tempStack2 = findDirectory(directoryName, child, tempStack);
                if(tempStack2.peek().getData().equals(directoryName)) {
                    return tempStack2;
                }
                tempStack.pop();
            }
            if(tempStack.isEmpty()) {
                return new Stack<>();
            }
            return tempStack;
        } catch (Exception e) {
            return null;
        }
    }

    public void printTree(Node<T> node, String prefix) {
        try {
            if(node == null) {
                return;
            }
            System.out.println(prefix + "\u2514\u2500\u2500\u2500" + node.getData());

            for(Node<T> childNode : node.getChildren()) {
                printTree(childNode, (prefix + "    "));
            }
        } catch (Exception e) {
            return;
        }
    }
}
