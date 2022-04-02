import java.util.Scanner;

public class InputHandler {

    public static int getNumberOfComputer() {
        System.out.println("Select the number of players from 1 to 5!");
        System.out.print("> ");
        Scanner scan = new Scanner(System.in);

        int number = -1;
        try {
            number = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Nem számot adtál meg!");
            number = getNumberOfComputers(number);
        }

        return number;
    }

    static String getChoice() { // SOLID Principles: O - open/closed
        String[] possibilities = {"throw", "1", "hold", "0"};
        String choice;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter your choice! (throw) = 1 (hold) = 0");
            System.out.print("> ");
            choice = scan.nextLine();
        } while (!isOurChoiceIn(choice, possibilities));

        return choice;
    }

    private static boolean isOurChoiceIn(String answer, String[] choices) {
        for (String choice : choices) {
            if (answer.equals(choice)) {
                return true;
            }
        }

        System.out.println("Invalid choice!: " + answer + " is not throw, 1, hold, 0.");
        return false;
    }

    public static int getNumberOfComputers(int number) {
        if (!(number == 1 || number == 2 || number == 3 || number == 4 || number == 5)) {
            getNumberOfComputer();
        }

        return number;
    }


}
