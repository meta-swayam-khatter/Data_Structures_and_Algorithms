class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    void rotateSubList(int L, int R, int N) {
        if (head == null || L >= R) return;
        Node prevL = null, start = head;
        for (int i = 1; i < L; i++) {
            prevL = start;
            start = start.next;
        }
        Node end = start;
        for (int i = L; i < R; i++) {
            end = end.next;
        }
        Node nextR = end.next;
        
        // Convert sublist to array
        int len = R - L + 1;
        N = N % len;
        if (N == 0) return;
        
        Node[] sublist = new Node[len];
        Node temp = start;
        for (int i = 0; i < len; i++) {
            sublist[i] = temp;
            temp = temp.next;
        }
        
        // Reconnect after rotation
        if (prevL != null) prevL.next = sublist[len - N];
        else head = sublist[len - N];
        sublist[len - 1].next = sublist[0];
        for (int i = len - N; i < len - 1; i++) {
            sublist[i].next = sublist[i + 1];
        }
        sublist[N] = nextR;
        for (int i = 0; i < len - N; i++) {
            sublist[i].next = sublist[i + 1];
        }
    }

    boolean detectLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Polynomial representation
class Polynomial {
    static int findDegree(String poly) {
        int maxDegree = 0;
        String[] terms = poly.split(" ");
        for (String term : terms) {
            if (term.matches(".*[a-zA-Z].*")) {
                int degree = 0;
                for (int i = 0; i < term.length(); i++) {
                    if (Character.isLetter(term.charAt(i))) {
                        int exp = 1;
                        if (i + 1 < term.length() && term.charAt(i + 1) == '^') {
                            exp = Character.getNumericValue(term.charAt(i + 2));
                            i += 2;
                        }
                        degree += exp;
                    }
                }
                maxDegree = Math.max(maxDegree, degree);
            }
        }
        return maxDegree;
    }
}

public class Session1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);
        
        System.out.println("Original list:");
        list.display();
        
        list.rotateSubList(2, 5, 2);
        System.out.println("List after rotating sublist:");
        list.display();
        
        // Check for loop detection
        System.out.println("Loop detected: " + list.detectLoop());
        
        // Finding degree of polynomial
        String polynomial = "3x^2y^4 -5z^2 +x -y +20";
        System.out.println("Degree of polynomial: " + Polynomial.findDegree(polynomial));
    }
}


