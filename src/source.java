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
        //Thread.sleep(3000);
        clearConsole();

        while (player.getMoney() >= 25)
        {
            // Ask the player how much they want to bet
            System.out.print("Place your bet (minimum $25): ");
            bet = scanner.nextInt();

            // Validate the bet
            if (bet < 25) {
                System.out.println("The minimum bet is $25. Please try again.");
                continue;
            }

            if (!player.placeBet(bet)) {
                System.out.println("You don't have enough money to place this bet. Game over!");
                break;
            }

            // Deal initial cards
            dealer.firstTwo(card);
            player.firstTwo(card);

            // Show dealer's first card and player's hand
            System.out.println(dealer.getHand());
            System.out.println(player.getHand());

            // Reveal dealer's hand for now (will change in future versions)
            System.out.println(dealer.revealHand());

            // Check if player wants to continue playing or quit
            System.out.print("Do you want to continue playing? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Thank you for playing!");
                break;
            }

            // Clear the console and prepare for the next round
            clearConsole();
        }

        // End of the game
        System.out.println("You don't have enough money to continue. Game over!");
    }
}

    //Trying to dix this method but cannot find a reason why its not working
    //only for version 1.0
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

