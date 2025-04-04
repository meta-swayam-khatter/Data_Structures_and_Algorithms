package Session3;

import java.util.Scanner;

public class Assignment3 {
    
    public static String stringScanner() {
        String s;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                s = sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return s;

    }

    public static int intScanner() {
        int s;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                s = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return s;

    }

    public static void main(String[] args) {

        System.out.print("Enter the number of bowler: ");
        int count = intScanner();

        CustomBowlerPriorityQueue bowlers = new CustomBowlerPriorityQueue(count);
        
        System.out.print("Enter the number of balls Virat Kohli has to play: ");
        int numberOfBallsViratPlays = intScanner();

        for(int index=0; index<count; index++) {
            System.out.print("Enter the name of the bowler " + (index+1) + ": ");
            
            String bowlerName = stringScanner();
            System.out.print("Enter the number of balls available for " + (bowlerName) + ": ");
            int ballQuota = intScanner();
            // System.out.println(bowlerName + " -> " + ballQuota);
            Bowler bowler = new Bowler(bowlerName, ballQuota);
            bowlers.enQueue(bowler);
        }

        bowlers.display();

        for(int balls=0; balls<numberOfBallsViratPlays; balls++) {
            Bowler ballerBalling = bowlers.deQueue();
            System.out.print("Bowl number " + (balls+1) + " will be balled by: ");
            System.out.println(ballerBalling.getName());
            ballerBalling.bowls_a_bowl();
            bowlers.enQueue(ballerBalling);
        }
    }
}
