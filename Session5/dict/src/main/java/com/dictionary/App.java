package com.dictionary;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // Node<Integer, Integer> root = new Node<>(9, 1);
        Dictionary<String, String> dict = Dictionary.createDictionary(new File("Session5\\dict\\src\\main\\java\\com\\dictionary\\JSONdata.json"));
        dict.sortedList();
        // Dictionary<Integer, Integer> dict = new Dictionary<>(root);
        // Node<Integer, Integer> deleteNode = new Node<>(15, 1);
        // dict.add(new Node<Integer,Integer>(2, 1));
        // dict.add(deleteNode);
        // dict.add(new Node<Integer,Integer>(14, 1));
        // dict.add(new Node<Integer,Integer>(19, 1));
        // dict.add(new Node<Integer,Integer>(17, 1));
        // dict.add(new Node<Integer,Integer>(21, 111));
        // dict.add(new Node<Integer,Integer>(18, 1));
        // dict.delete(root);
        // dict.sortedList();
        // System.out.println();
        // dict.sortedListInRange(dict.getRoot(), 14, 19);
        // System.out.println();
    }
}
