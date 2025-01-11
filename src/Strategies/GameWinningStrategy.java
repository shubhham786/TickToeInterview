package Strategies;

import Classes.Board;
import Classes.Move;
import Classes.Player;

public interface GameWinningStrategy {

     public boolean checkWinner(Board board, Move move);
}
