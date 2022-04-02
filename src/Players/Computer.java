package Players;


public class Computer extends Player {

    public Computer(String name) {
        super(name);
    }


    public void playTurn(){
        // TODO: Refactor - Extract to function: OutputHandler.showPlayerTurnIntroduction(String playerName)
        System.out.println("-> " + getName() + " player playing its turn!");

        // Implementation: Strategy pattern
        int randomThrew = (int) (Math.random() * 6 + 1);
        point += randomThrew;

        // TODO: Refactor - Extract to function: OutputHandler.showPlayerTurnBody(String playerName)
        System.out.printf("%s is throwing...\n", super.name);
        System.out.printf("The player's number: %d\n", randomThrew);
        System.out.println();
        System.out.printf("Number of throw: %d\n", super.numberOfThrow);
        System.out.println();
        System.out.printf("%s points: %d\n", super.name, super.point);
    }
}
