import java.util.InputMismatchException;
import java.util.Scanner;

public static void main(String[] args) throws InterruptedException {
    // Welcome message
    System.out.println("BlackJack 1.0 \nby: travis t.");

    //vars
    int bet;
    String choice;

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
    //Thread.sleep(2000);
    util.clearConsole();

    while (player.getMoney() >= 25)
    {
        //resets busts status so its not always true.
        player.bustReset();

        //Shuffle deck every round
        //will change so it shuffles every 6 rounds so card counting is possible
        card.shuffleDeck();

        System.out.print("place bet (minimum $25): ");

        try
        {
            bet = scanner.nextInt();

            //checks if bet is valid
            if (bet < 25) {
                System.out.println("the minimum bet is $25.");
                continue;
            }
            else if (bet > player.getMoney()) {
                System.out.println("the minimum bet is $25.");
                continue;
            }

            player.bet(bet);
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
            scanner.nextLine(); //clear the input
            continue;
        }

        //deal the first two cards to both dealer and player
        dealer.firstTwo(card);
        player.firstTwo(card);


        //shows the dealers and players hand.
        System.out.println(dealer.printHand());
        Thread.sleep(500);
        System.out.println(player.printHand());
        System.out.println("ur hand: " + util.calculateHand(player.getHand()));
        //start new window gui
        gui window = new gui(dealer); //gui window object
        try
        {
            util.clearConsole();
            System.out.println("hit: h  or  stand: s");
            choice = "";
            if (util.calculateHand(player.getHand()) == 21)
            {
                System.out.println("player got blackjack!");
                System.out.println("player WINS!");
                choice = "s";
            }

            while(!(choice.equals("s")))
            {
                scanner.nextLine(); //cleans line

                choice = scanner.next();
                if (choice.equals("h"))
                {
                    Thread.sleep(500);
                    player.hit(card);
                    System.out.println(player.printHand());
                    System.out.println("ur hand: " + util.calculateHand(player.getHand()));
                    if (!(util.calculateHand(player.getHand()) <= 21))
                    {
                        player.bust();
                        break;
                    }
                }
                else if (choice.equals("s"))
                {
                    player.stand();
                    System.out.println(player.printHand());
                    System.out.println("ur hand: " + util.calculateHand(player.getHand()));
                    break;
                }
            }
            util.clearConsole();

        } catch (InputMismatchException e) {
            System.out.println("invalid input");
            scanner.nextLine(); //clear the input
            continue;
        }

        //clear console for more visability
        util.clearConsole();

        //reveal dealer hand
        System.out.println("dealer hand: " + dealer.revealHand());
        System.out.println("dealers hand: " + util.calculateHand(dealer.getHand()));

        //implement dealers moves
        boolean roundResolved = false; //checks if the outcome has been decided

        // Dealer's moves
        while ((util.calculateHand(dealer.getHand()) < 17) && !player.getBust()) {
            Thread.sleep(800);
            dealer.hit(card);
            System.out.println(dealer.revealHand());
            System.out.println("dealers hand: " + util.calculateHand(dealer.getHand()) + " vs. " + util.calculateHand(player.getHand()));

            // Checks if dealer has busted
            if (!(util.calculateHand(dealer.getHand()) <= 21)) {
                dealer.bust();
                System.out.println("dealer busted. player WINS!");
                player.winMoney(bet);
                roundResolved = true; // Mark round as resolved
                break;
            }


        }

// Check winnings (only if round is unresolved)
        if (!roundResolved) {
            if (util.calculateHand(player.getHand()) > util.calculateHand(dealer.getHand()) && !player.getBust()) {
                System.out.println("player WINS!");
                player.winMoney(bet);
                roundResolved = true;
            } else if (util.calculateHand(player.getHand()) < util.calculateHand(dealer.getHand()) && !dealer.getBust()) {
                System.out.println("player LOSES!");
                roundResolved = true;
            } else if (util.calculateHand(player.getHand()) == util.calculateHand(dealer.getHand()) && !player.getBust() && !dealer.getBust()) {
                System.out.println("player PUSHES!");
                player.pushMoney(bet);
                roundResolved = true;
            }
        }

//        else if (util.calculateHand(player.getHand()) < util.calculateHand(dealer.getHand()))
//        {
//        System.out.println("player LOSES!");
//        }


        //ask if player wants to continue playing
        if (!util.askToContinuePlaying(scanner)) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }

        //clear hand method (clears both dealer and players hand)
        player.clearHand();
        dealer.clearHand();


        //clear console after every round

        util.clearConsole();

        System.out.println("$" + player.getMoney());
    }

    // End of the game
    System.out.println("You don't have enough money to continue. Game over!");

}


