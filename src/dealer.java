import java.util.ArrayList;

public class dealer
{

    private int casinoMoney;
    ArrayList<String> hand = new ArrayList<String>();
    private String firstCard;  // To store the visible card
    private String hiddenCard; // To store the hidden card

    int handScore;
    boolean isStanding;
    boolean busted;

    public void firstTwo(Cards deck)
    {
        String firstCard = deck.drawCard(); // Dealer's face-up card
        String hiddenCard = deck.drawCard(); // Dealer's face-down card

        hand.add(firstCard);
        hand.add(hiddenCard);
    }

    public void clearHand()
    {
        hand.clear();
    }

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

    public String getHand()
    {
        return "dealer hand: [" + hand.getFirst() + "] [x]";
    }

    public ArrayList<String> revealHand()
    {
        return this.hand;
    }

}
