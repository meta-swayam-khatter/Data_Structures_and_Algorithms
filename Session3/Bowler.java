package Session3;

public class Bowler{
    private String name;
    private int noOfBowls;

    public Bowler(String name, int noOfBowls) {
        this.name = name;
        this.noOfBowls = noOfBowls;
    }

    public String getName() {
        return name;
    }

    public int getNoOfBowls() {
        return noOfBowls;
    }

    public void bowls_a_bowl() {
        try {
            this.noOfBowls--;
        } catch (Exception e) {
            return;
        }
    }
}
