package Players;

import java.util.Scanner;

public class Human extends Player {
    public Human() {
        super(getPlayerName());
    }

   static private String getPlayerName() {
        System.out.println("Please enter your name!");
        System.out.print("> ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    /**
     * TODO dokumentáció
     *
     * Players.Human's turn implementation, possiblites:
     *  + Hold: ...
     *  + Throw: ...
     */
    public void playTurn(){
        // TODO: Refactor - Extract to function: showPlayerTurn(String playerName)
        System.out.println("-> " + getName() + " player playing his turn!");

        switch (getChoice()) { // Refactoring step: replace conditional with polymorphism
            case "1":
            case "throw":
                System.out.println("Players.Player is throwing!");
                int randomThrew = (int) (Math.random() * 6 + 1);
                point += randomThrew;
                System.out.printf("%s is throwing...\n", name);
                System.out.printf("The player's number: %d\n", randomThrew);
                System.out.println();
                System.out.printf("Number of throw: %d\n", numberOfThrow);
                System.out.println();
                System.out.printf("%s points: %d\n", name, point);
                break;
            case "0":
            case "hold":
                System.out.println("Players.Player is holding!");
                break;
            default:
                System.out.println("[ERROR] unexpected choice");
        }
    }

    /**
     * TODO metódus dokumentálása
     * ...
     * @return "throw" | "1" | "hold" | "0"
     */
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
}
