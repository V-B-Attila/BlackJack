package Players;

// TODO: Extract Players.Player, Players.Human, Players.Computer to new Package
public class Player {
    public String name;
    public int point = 0;
    public int numberOfThrow = 0;
    public boolean isPlaying = true;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void playTurn(){
        System.out.println("Általonás játékos kör megvalósítás");
    };



}
