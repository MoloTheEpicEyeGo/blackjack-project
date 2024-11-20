import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Cards
{

    //Two 52 Card Deck
    private final String[] cards = {
            "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
            "HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
            "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
            "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK",
            "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
            "HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
            "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
            "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"
    };


    //shuffle deck every time (will change so it's possible to card count)
    public void shuffleDeck()
    {
        //make the array of cards into a Arraylist of Cards
        ArrayList<String> deck = new ArrayList<>(Arrays.asList(cards));

        Collections.shuffle(deck);

        // Update the cards array with the shuffled cards
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.get(i);
        }
    }

    public String[] getCards() {
        return cards;
    }


    // Override toString() to return the full deck as a string
    @Override
    public String toString() {
        return Arrays.toString(cards);
    }
}
