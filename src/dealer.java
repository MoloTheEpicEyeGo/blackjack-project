import java.util.ArrayList;

public class dealer extends Cards
{

    private int casinoMoney;
    ArrayList<String> hand = new ArrayList<String>();
    int handScore;
    boolean isStanding;
    boolean busted;

    public void hit() {
        // Dealer logic for hitting
    }

    public void stand() {
        // Dealer logic for standing
    }

    public boolean over21() {
        // Logic to check if dealer's total is over 21
        return false;
    }
}
