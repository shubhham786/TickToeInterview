import Classes.Game;
import Classes.Player;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args)  {

        Player player1=new Player("Shan","O");
        Player player2=new Player("Shu","X");

        int dimension=3;

        List<Player> players= Arrays.asList(player1,player2);

        Game game=new Game(dimension,players);

        game.startGame();
    }
}