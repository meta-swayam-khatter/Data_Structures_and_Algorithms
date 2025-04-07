package Session4.Q2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Question1 {
    public static void main(String[] args) {
        Map<String, Integer> strings = new HashMap<String, Integer>();
        
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                Set<Character> uniqueChar = new HashSet<Character>();
                System.out.print("Enter a String or enter 0 to EXIT: ");
                String input = sc.nextLine();
                input = input.replace(" ", "");
                if(strings.containsKey(input)) {
                    System.out.println("Unique number of characters in " + input + ": " + strings.get(input));
                    continue;
                }
                if(input.equals("0")) {
                    break;
                }
                char[] charArr = input.toCharArray();
                for (char c : charArr) {
                    uniqueChar.add(c);
                }
                strings.put(input, uniqueChar.size());
                System.out.println("Unique number of characters in " + input + ": " + uniqueChar.size());
            }
        }
    }
}
