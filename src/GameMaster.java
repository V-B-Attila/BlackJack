import Players.Computer;
import Players.Human;
import Players.Player;

import java.util.ArrayList;

//

// SOLID : Architektúra szintű refaktorálás
//  S: Single Responsibility Principle
//  O: Open/Closed Principle: Open for extension, but closed for modification
//  L: Liskov substitution principle
//  I: Interface segregation principle
//  D: Dependency Inversion

public class GameMaster {
    private ArrayList<Player> players;

    /**
     *  initialization : játék kezdőállapotának beállítása
     *  Szabályok kiíratása
     *  Játékosok létrehozása
     *  Játékosok inicializálása
     */
    public void initGame() {
        OutputHandler.showOpening();
        initPlayers();
    }

    private void initPlayers() {
        players = new ArrayList<>();
        // TODO: players = new ArrayList<>( getComputers(), getHumans(), getCyborgs() )  | interneten nézz utána |

        // TODO: Extract to new method: getComputers(): ArrayList<Players.Player>
        int numberOfComputers = InputHandler.getNumberOfComputer();
        for (int i = 1; i <= numberOfComputers; i++) {
            Computer computer = new Computer("Computer_" + i);
            players.add(computer);
        }

        // TODO: Extract to new method: getHumans(): ArrayList<Players.Player>
        Human human = new Human();
        players.add(human);
        // getCyborg()
    }

    public void playGame() {
        initGame();
        OutputHandler.showPlayers(players);

        // TODO: Extract to new method .playEachTurn(): void, Körök elkezdése

        for (int i = 1; i <= 5; i++) {
            System.out.printf("\n == Playing turn %d.! ==\n", i);
            for (Player player : players) { // player: <Players.Human | Players.Computer...>
                if (player.isPlaying) {
                    player.playTurn();
                    checkPlayerPoints(player);
                }
            }
        }

        // TODO: if draw then handle places again by throwing the dice

         OutputHandler.showPlaces(getPlayingPlayers(), getLosingPlayers());
    }

    // TODO
    private ArrayList<Player> getLosingPlayers() {
        return new ArrayList<Player>();
    }

    private void checkPlayerPoints(Player player) {
        if (player.point > 21) {
            player.isPlaying = false;
        }
    }

    private ArrayList<Player> getPlayingPlayers() {
        ArrayList<Player> result = new ArrayList<>();

        for (Player player : players) {
            if (player.isPlaying) {
                result.add(player);
            }
        }

        return result;
    }
}

// Players.Player players[] = new Players.Player[10]
// players[i]   || players.length
// ArrayList<Players.Player> players = new ArraysList<>();
// players.get(i) || players.size()