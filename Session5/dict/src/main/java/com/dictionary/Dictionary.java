package com.dictionary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

interface DictionaryInterface<K extends Comparable<K>,V> {
    public void add(Node<K,V> node);

    public boolean delete(Node<K,V> node);

    public V getValue(K key);

    public void sortedList();

    public void sortedListInRange(Node<K,V> node, K k1, K k2);
}

public class Dictionary<K extends Comparable<K>,V> implements DictionaryInterface<K,V> {
    Node<K,V> root;

    Dictionary(Node<K,V> root) {
        this.root = root;
    }

    Dictionary() {
    }

    public Node<K,V> getRoot() {
        return root;
    }

    public static Dictionary<String, String> createDictionary(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Dictionary<String, String> myDict = new Dictionary<>();

        JsonNode node = objectMapper.readTree(file);
        List<String> keys = new ArrayList<>();
        Iterator<String> it = node.fieldNames();

        it.forEachRemaining(e -> keys.add(e));

        for (String key : keys) {
            String value = node.get(key).asText();
            myDict.add(new Node<String,String>(key, value));
        }

        return myDict;
    }

    @Override
    public void add(Node<K, V> node) {
        try {
            Node<K,V> parentNode = root;
            Node<K,V> currentNode = root;
            while(true) {
                if(currentNode == null) {
                    this.root = node;
                    break;
                }
                if(currentNode.getKey().compareTo(node.getKey()) > 0) {    // node is less than current node
                    parentNode = currentNode;
                    currentNode = currentNode.getLeft();
                    if(currentNode == null) {
                        parentNode.setLeft(node);
                        break;
                    }
                } else if(currentNode.getKey().compareTo(node.getKey()) < 0) {    // node is greater than current node
                    parentNode = currentNode;
                    currentNode = currentNode.getRight();
                    if(currentNode == null) {
                        parentNode.setRight(node);
                        break;
                    }
                } else {    // node is equal to current node, which is not possible in dictionary
                    throw new AssertionError("A node with this key already exist!!");
                }
            }
            currentNode = node;
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    @Override
    public boolean delete(Node<K, V> node) {
        try {
            Node<K,V> parentNode = root;
            Node<K,V> currentNode = root;
            while(currentNode != null) {
                if(currentNode.getKey().compareTo(node.getKey()) > 0) {    // node is less than current node
                    parentNode = currentNode;
                    currentNode = currentNode.getLeft();
                } else if(currentNode.getKey().compareTo(node.getKey()) < 0) {    // node is greater than current node
                    parentNode = currentNode;
                    currentNode = currentNode.getRight();
                } else {    // node is equal to current node, delete it
                    break;
                }
            }
            if(currentNode == null) {
                System.out.println("The node you want to delete is not present!!");
                return false;
            }
            if(currentNode.getLeft() == null && currentNode.getRight() == null) {    // current node has no child
                if(parentNode.getLeft().equals(currentNode)) {
                    parentNode.setLeft(null);
                } else {
                    parentNode.setRight(null);
                }
                return true;
            } else if(currentNode.getLeft() == null || currentNode.getRight() == null) {    // if current node has one child
                if(parentNode.getLeft().equals(currentNode)) {
                    parentNode.setLeft(currentNode.getLeft()==null?currentNode.getLeft():currentNode.getRight());
                } else {
                    parentNode.setRight(currentNode.getLeft()==null?currentNode.getLeft():currentNode.getRight());
                }
                return true;
            } else {    // if current node has both child
                Node<K,V> tempParent = currentNode.getRight();
                Node<K,V> tempNode = currentNode.getRight();
                while(tempNode.getLeft() != null) {
                    tempParent = tempNode;
                    tempNode = tempNode.getLeft();
                }
                tempParent.setLeft(tempNode.getRight());
                tempNode.setLeft(currentNode.getLeft());
                tempNode.setRight(currentNode.getRight());
                if(parentNode.getLeft().equals(node)) {
                    parentNode.setLeft(tempNode);
                } else if(parentNode.getRight().equals(node)) {
                    parentNode.setRight(tempNode);
                } else {
                    root = tempNode;
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public V getValue(K key) {
        try {
            Node<K,V> currentNode = root;
            while(currentNode != null) {
                if(currentNode.getKey().compareTo(key) == 0) {
                    return currentNode.getValue();
                } else if(currentNode.getKey().compareTo(key) > 0) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode = currentNode.getRight();
                }
            }
            return null;
        } catch (Exception e) {
            throw new Error("Error in getting the value!");
        }
    }

    @Override
    public void sortedList() {
        try {
            inOrderTraversal(root);
            return;
        } catch (Exception e) {
            throw new Error("Error is returning the sorted list!");
        }
    }

    public void inOrderTraversal(Node<K,V> node) {
        try {
            if(node == null) {
                return;
            }
            inOrderTraversal(node.getLeft());
            System.out.print("{" + node.getKey() + ", " + node.getValue() + "}" + " --> ");
            inOrderTraversal(node.getRight());
        } catch (Exception e) {
            throw new Error("Error during In-Order_Traversal!");
        }
    }

    @Override
    public void sortedListInRange(Node<K,V> node, K k1, K k2) {
        try {
            if(node == null) {
                return;
            }
            sortedListInRange(node.getLeft(), k1, k2);
            System.out.print((node.getKey().compareTo(k1) >= 0 && node.getKey().compareTo(k2) <= 0) ? "{" + node.getKey() + ", " + node.getValue() + "}" + " --> " : "");
            sortedListInRange(node.getRight(), k1, k2);
        } catch (Exception e) {
            throw new Error("Error in returning the sorted list in a range!");
        }
    }

}
