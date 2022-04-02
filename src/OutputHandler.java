import Players.Player;

import java.util.ArrayList;

public class OutputHandler  {
    public static String boldStart = "\033[1m";
    public static String boldEnd = "\033[0m";

    public static void showOpening() {
        System.out.println(boldStart + "==  Black Jack implementation in Java!  ☺==\n" + boldEnd);
    }

    public static void showPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }


    public static void showPlaces(ArrayList<Player> playingPlayers, ArrayList<Player> losingPlayers) {
        showWinners(playingPlayers);
        showLosers(losingPlayers);
    }

    private static void showWinners(ArrayList<Player> playingPlayers) {
        // TODO: Sort players by point (Implement compareTo)
        System.out.println("== Winners ==");
        for (Player player : playingPlayers) {
            // player = playingPlayers.get(i);
            System.out.printf("%s scored %d point\n" ,player.getName(), player.point);

        }
    }


    private static void showLosers(ArrayList<Player> losingPlayers) {
        System.out.println("== Losers ==");
        for (Player player : losingPlayers) {
            System.out.println("- " + player.getName());
        }
    }
}
