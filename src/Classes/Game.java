package Classes;

import Strategies.ColumnWinningStrategy;
import Strategies.DiganolWinningStrategy;
import Strategies.GameWinningStrategy;
import Strategies.RowWinningStrategy;
import enums.CellStatus;
import enums.GameStatus;
import Exception.InvalidGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final List<GameWinningStrategy> strategies;
    private GameStatus status;
    private int currentPlayerIndex;
    private int moveCount;

    public Game(int dimension, List<Player> players) {

        this.board = new Board(dimension);
        this.players = players;
        this.strategies = initializeStrategies();
        this.status = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 0;
        this.moveCount = 0;
    }


    private List<GameWinningStrategy> initializeStrategies() {
        List<GameWinningStrategy> strats = new ArrayList<>();
        strats.add(new ColumnWinningStrategy());
        strats.add(new RowWinningStrategy());
        strats.add(new DiganolWinningStrategy());
        return strats;
    }

    public void startGame() {
        System.out.println("Starting game");
        while (status == GameStatus.IN_PROGRESS) {
            playTurn();
        }
    }

    private void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println(currentPlayer.getName() + "'s turn");
        board.displayBoard();

        try {
            Move move = getPlayerMove(currentPlayer);
            currentPlayer.makeMove(move, board);
            moveCount++;

            if (checkWinner(move)) {
                status = GameStatus.WINNER;
                announceWinner(currentPlayer);
            } else if (moveCount == board.getDimension() * board.getDimension()) {
                status = GameStatus.DRAW;
                announceDraw();
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Try Again");
        }
    }

    private Move getPlayerMove(Player currentPlayer) throws InvalidGame {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row where you want to go");
        int row = scanner.nextInt();
        System.out.println("Enter column where you want to go");
        int col = scanner.nextInt();

        validateMove(row, col);
        return new Move(row, col, currentPlayer);
    }

    private void validateMove(int row, int col) throws InvalidGame {
        if (row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension()) {
            throw new InvalidGame("row or Column outside Boundary");
        }
        if (board.getBoard().get(row).get(col).getCellStatus() == CellStatus.FILEED) {
            throw new InvalidGame("Row or Column already occupied");
        }
    }

    private boolean checkWinner(Move move) {
        for (GameWinningStrategy strategy : strategies) {
            if (strategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    private void announceWinner(Player player) {
        System.out.println("Game over");
        System.out.println("Winner is " + player.getName());
        board.displayBoard();
    }

    private void announceDraw() {
        System.out.println("Game over");
        System.out.println("Game ended in Draw");
        board.displayBoard();
    }
}
