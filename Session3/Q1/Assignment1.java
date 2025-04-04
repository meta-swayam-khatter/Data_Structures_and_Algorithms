package Session3.Q1;

import java.util.Scanner;
import java.util.Stack;

public class Assignment1 {
    public static void main(String[] args) {
        Node<String> root = new Node<String>("meta", null);
        FileDirectory<String> fd = new FileDirectory<String>(root);
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("R:");
                for (Node<String> directory : fd.getStack()) {
                    System.out.print("\\" + directory.getData());
                }
                System.out.print(">");
                String input = sc.nextLine();
                if(input.equals("exit")) {
                    break;
                }
                String[] arr = input.split(" ");
                switch (arr[0]) {
                    case "mkdir":
                        fd.createDirectory(arr[1]);
                        break;
                
                    case "cd":
                        fd.changeDirectory(arr[1]);
                        break;
                
                    case "bk":
                        fd.back();
                        break;
                
                    case "ls":
                        for(Node<String> directory: fd.listDirectories()) {
                            System.out.println(directory.getData() + "      " + directory.getCreatedAt());
                        }
                        break;
                
                    case "find":
                        String path = "";
                        Stack<Node<String>> stack = fd.findDirectory(arr[1], fd.getCurrentNode(), new Stack<>());
                        while(!stack.empty()) {
                            path = "/" + stack.pop().getData() + path;
                        }
                        System.out.println(path);
                        break;
                
                    case "tree":
                        fd.printTree(root, "");
                        break;
                
                    default:
                        System.out.println("command doesn't exist");
                        break;
                }
            }
        }
    }
}
