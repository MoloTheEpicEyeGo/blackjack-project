import java.util.ArrayList;

public class player
{

    private int money;
    ArrayList<String> hand = new ArrayList<String>();
    int bet;
    int handScore;
    boolean isStanding;
    boolean busted;


    //player object
    public player(int initialMoney)
    {
        this.money = initialMoney;
        this.hand = new ArrayList<>();
        this.handScore = 0;
        this.isStanding = false;
        this.busted = false;
    }


    public void hit() {
        // Logic for the "hit" action
    }

    public void stand() {
        // Logic for the "stand" action
    }

    public void split() {
        // Logic for the "split" action
    }

    public void doubleDown() {
        // Logic for the "double down" action
    }

    public boolean over21() {
        // Logic to check if total is over 21
        return false;
    }
}
