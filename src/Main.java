import java.util.Scanner;


public class Main {
    // Players.Player
    
    // Players.Human
    static String playerName = "John";
    static int playerPoints = 0;

    // Players.Computer
    static int opponentPoints = 0;

    // 1 2 3 4 5
    // .playTurn()

    static boolean game = false;

    static Scanner scan = new Scanner(System.in);
    static int numberOfThrow = 0;

    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        gameMaster.playGame();
    }

    /**
     * This method handles the initialization of the game!
     */
    public static void init() {
        showWelcome();
    }

    private static void showWelcome() {
        System.out.println();
        System.out.printf("Welcome %s!\n", playerName);
    }

    /**
     * Kérje be a választ ameddig nem egyezik meg valamelyik lehetőséggel
     * Lehetőségek: throw-1, hold-0
     *
     * @return a játékos válasza
     */
    private static String getChoice() { // SOLID Principles: O - open/closed
        String[] possibilities = {"throw", "1", "hold", "0"};
        String choice;

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

    private static void playGame() {
        boolean newGame = false;
        while (newGame == false) {
            boolean end = false;
            while (end == false) {
                String playerChoice = getChoice();
                switch (playerChoice) {
                    case "throw":
                    case "1":
                        throwDices();
                        if (playerPoints >= 21) {
                            end = true;
                        }
                        break;
                    case "hold":
                    case "0":
                        System.out.printf("%s is holding by %d!\n", playerName, playerPoints);
                        end = true;
                        break;
                }
            }
            opponentPoints = getOpponentPoints();
//            winner(playerPoints, opponentPoints);

            boolean loop = false;
            String choice = scan.nextLine();
            do {
                switch (choice) {
                    case "yes":
                        restartStats();
                        newGame = false;
                        loop = true;
                        break;
                    case "no":
                        newGame = true;
                        loop = true;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        System.out.println("New game yes/no?");
                        choice = scan.nextLine();
                }
            } while (loop == false);
        }
    }

    private static void restartStats() {
        numberOfThrow = 0;
        playerPoints = 0;
    }


    private static void throwDices() {

    }

    static int getOpponentPoints() {
        opponentPoints = (int) (Math.random() * 11 + 15);
        System.out.printf("The opponent points: %d\n", opponentPoints);
        return opponentPoints;
    }

//    static void winner(int playerScore, int opponentScore) {
//        System.out.println();
//        if (playerPoints == 21) {
//            System.out.printf("%s(s) win by %d!\n", playerName, playerPoints);
//        } else if (playerPoints > 21) {
//            System.out.printf("%s(s) lose by %d!\n", playerName, playerPoints);
//        } else if (playerScore == opponentScore) {
//            System.out.println("The game is draw!");
//        } else if ((playerScore > opponentScore || opponentScore > 21) && playerScore < 21) {
//            System.out.println(boldStart + "CONGRATULATION" + boldEnd);
//            System.out.printf("%s win by %d\n", playerName, playerPoints);
//        } else {
//            System.out.printf("Opponent win by %d!\n", opponentPoints);
//        }
//        System.out.println("New game yes/no?");
//    }


    static boolean newGame() {
        playerPoints = 0;
        boolean loop = false;
        String choice = "";
        while (loop == false) {
            System.out.println("New game press \"1\"");
            System.out.println("Exit press\"0\"");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            if (choice.equals("0") || choice.equals("1")) {
                if (choice.equals("1")) {
                    game = false;
                } else if (choice.equals("0")) {
                    game = true;
                }
                loop = true;
            } else {
                loop = false;
            }
        }
        return game;
    }
}
