class Node {
    int coeff;
    Node exp;
    Node next;
}

class Polynomial {
    Node head;

    static int findDegree(int[][] poly) {
        try {
            int maxDegree=0;
            for(int[] element : poly) {
                int degree=0;
                if(element.length == 1) break;
                for(int expIndex=1; expIndex<element.length; expIndex++) {
                    degree += element[expIndex];
                }
                maxDegree = Math.max(maxDegree, degree);
            }
            return maxDegree;
        } catch (Exception e) {
            return -1;
        }
    }

    // static int findDegree(String poly) {
    //     int maxDegree = 0;
    //     String[] terms = poly.split(" ");
    //     for (String term : terms) {
    //         if (term.matches(".*[a-zA-Z].*")) {
    //             int degree = 0;
    //             for (int i = 0; i < term.length(); i++) {
    //                 if (Character.isLetter(term.charAt(i))) {
    //                     int exp = 1;
    //                     if (i + 1 < term.length() && term.charAt(i + 1) == '^') {
    //                         exp = Character.getNumericValue(term.charAt(i + 2));
    //                         i += 2;
    //                     }
    //                     degree += exp;
    //                 }
    //             }
    //             maxDegree = Math.max(maxDegree, degree);
    //         }
    //     }
    //     return maxDegree;
    // }

}

public class Assignment3 {
    public static void main(String[] args) {
        // Finding degree of polynomial

        // String polynomial = "3x^2y^4 -5z^2 +x -y +20";
        // {3,2,4,0},
        // {-5,0,0,2},
        // {1,1,0,0},
        // {-1,0,1,0},
        // {20,0,0,0}

        int[][] polynomial = {
            {3,2,4},
            {-5,2},
            {1,1},
            {-1,1},
            {20}
        };
        System.out.println("Degree of polynomial: " + Polynomial.findDegree(polynomial));
    }
}
