import java.util.Scanner;
import java.util.ArrayList;

public class util
{
    public static void clearConsole() {
        for (int i = 0; i < 2; i++) {
            System.out.println("*");
        }
    }


    public static boolean askToContinuePlaying(Scanner scanner) {
        String choice;
        while (true) {
            System.out.print("Do you want to continue playing? (y/n): ");
            choice = scanner.next();

            //check if input is valid
            if (choice.equalsIgnoreCase("y")) {
                return true;
            } else if (choice.equalsIgnoreCase("n")) {
                return false;
            } else {
                //if not, ask same question
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }
        }
    }

    public static int calculateHand(ArrayList<String> hand)
    {
        //aceCount tracks Aces to adjust their value from 11 to 1 if needed
        int aceCount = 0;
        int handVal = 0;

        for (String card : hand)
        {
            char rank = card.charAt(1);

            if (rank == 'A')
            {
                aceCount++;
                handVal += 11;
            }
            else if (rank == 'K' || rank == 'Q' || rank == 'J' || rank == '1')
            {
                handVal += 10;
            }
            else
            {
                handVal += Character.getNumericValue(rank); //changes char into an int
            }
        }

        while (handVal > 21 && aceCount > 0)
        {
            handVal -= 10; //changes 11 to 1 to adjust score.
            aceCount--;
        }
        return handVal;
    }
}
