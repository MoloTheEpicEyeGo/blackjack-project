import java.util.Scanner;

public class source
{

    public static void main(String[] args) throws InterruptedException
    {
        // Welcome message
        System.out.println("BlackJack 1.0 \nby: travis t.");

        //vars
        int playCountBeforeShuffle = 0;
        int bet = 0;
        //Making new Objects
        Cards card = new Cards();
        player player = new player(10000);
        dealer dealer = new dealer();

        //User input object
        Scanner scanner = new Scanner(System.in);

        //shuffle deck
        card.shuffleDeck();

        //Showing player their starting stats
        System.out.println("starting bankroll: " + "$" + player.getMoney());
        Thread.sleep(2000);
        util.clearConsole();

        while (player.getMoney() >= 25)
        {
            // Ask the player how much they want to bet
            System.out.print("place bet (minimum $25): ");
            bet = scanner.nextInt();

            // Validate the bet
            if (bet < 25)
            {
                System.out.println("the minimum bet is $25.");
                continue;
            }

            if (!player.placeBet(bet))
            {
                System.out.println("no money, BYE!");
                break;
            }

            // Deal initial cards into individual array
            dealer.firstTwo(card);
            player.firstTwo(card);








            // Show dealer's first card and player's hand
            System.out.println(dealer.getHand());
            Thread.sleep(1500);
            System.out.println(player.getHand());











            // Reveal dealer's hand for now (will change in future versions)
            System.out.println("dealer hand: " + dealer.revealHand());

            // Check if player wants to continue playing or quit
            System.out.print("Do you want to continue playing? (y/n): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing!");
                break;
            }
            else if (choice.equalsIgnoreCase("y")) {
                continue;
            }

            // Clear the console and prepare for the next round
            util.clearConsole();
        }

        // End of the game
        System.out.println("You don't have enough money to continue. Game over!");
    }
}


