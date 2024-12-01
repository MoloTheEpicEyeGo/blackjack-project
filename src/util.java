import java.util.Scanner;

public class util
{
    public static void clearConsole() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
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
}
