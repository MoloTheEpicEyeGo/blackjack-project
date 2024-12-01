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

    public void clearHand()
    {
        hand.clear();
    }

    public void hit(Cards deck) {
        String card = deck.drawCard();
        hand.add(card);
    }

    public void stand() {
        this.isStanding = true;
        System.out.println("player stands");
    }

    public void split() {
        //if statement checks if hand is splittable
        if (hand.size() == 2 && hand.get(0).charAt(1) == hand.get(1).charAt(1))
        {
            //LAST FINSIHED STOPPED HERE XXXXXXXXXXXXXXXXXXXXXXXXXXX
        }
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

    public void bet(int amount)
    {
        this.money -= amount; // Deduct the bet amount from the player's money
    }


}
