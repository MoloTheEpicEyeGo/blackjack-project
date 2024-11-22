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

    public void firstTwo(Cards deck)
    {
        String card = deck.drawCard();
        String secondCard = deck.drawCard();

        hand.add(card);
        hand.add(secondCard);
    }

    public void hit(Cards deck) {
        String card = deck.drawCard();
        hand.add(card);
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

    public int getMoney()
    {
        return this.money;
    }

    public ArrayList<String> getHand()
    {
        System.out.print("player hand: ");
        return this.hand;
    }

    public boolean over21() {
        // Logic to check if total is over 21
        return false;
    }

    public boolean placeBet(int betAmount) {
        if (betAmount > 0 && betAmount <= money) {
            this.bet = betAmount; // Set the current bet
            this.money -= betAmount; // Deduct the bet from the player's money
            System.out.println("player placed a bet of $" + betAmount);
            System.out.println("remaining money: $" + this.money);
            return true;
        } else {
            System.out.println("INVALID bet amount. You have $" + this.money + " available.");
            return false;
        }
    }


}
