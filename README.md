# Tic Tac Toe Game

A simple command-line Tic Tac Toe game implemented in Java using Object-Oriented Design principles.

## Project Structure

```
src/
├── Classes/
│   ├── Board.java        # Game board management
│   ├── Cell.java         # Individual cell representation
│   ├── Game.java         # Main game logic
│   ├── Move.java         # Player move representation
│   └── Player.java       # Player information and actions
├── Strategies/
│   ├── GameWinningStrategy.java       # Strategy interface
│   ├── RowWinningStrategy.java        # Row win condition
│   ├── ColumnWinningStrategy.java     # Column win condition
│   └── DiagonalWinningStrategy.java   # Diagonal win condition
├── Enums/
│   ├── GameStatus.java   # Game state tracking
│   └── CellStatus.java   # Cell state tracking
├── Exception/
│   └── InvalidGame.java  # Custom game exceptions
└── Main.java            # Application entry point
```

## Features

- Command-line interface
- Dynamic board size
- Multiple players support
- Input validation
- Custom exception handling
- Different winning strategies

## Prerequisites

- Java 8 or higher
- Java IDE (recommended) or command-line compiler

## How to Run

1. Compile the project:
```bash
javac Main.java
```

2. Run the game:
```bash
java Main
```

## Game Rules

1. The game is played on a grid (default 3x3)
2. Players take turns placing their marks (X or O)
3. To win, a player must place three marks in a:
   - Horizontal row
   - Vertical column
   - Diagonal line
4. Game ends in a draw if board is full with no winner

## Gameplay Example

```
Starting game
Player 1's turn
 |   | |  |   | |  |   | |
 |   | |  |   | |  |   | |
 |   | |  |   | |  |   | |
Enter row where you want to go
1
Enter column where you want to go
1
```

## Class Descriptions

### Core Classes

- `Game`: Controls game flow and maintains state
- `Board`: Manages the game grid and display
- `Cell`: Represents individual board positions
- `Player`: Contains player information and move logic
- `Move`: Encapsulates move coordinates and player

### Supporting Classes

- `GameWinningStrategy`: Interface for winning conditions
- `RowWinningStrategy`: Checks row completion
- `ColumnWinningStrategy`: Checks column completion
- `DiagonalWinningStrategy`: Checks diagonal completion

## Design Patterns Used

1. **Strategy Pattern**
   - Used for winning condition checks
   - Easily extensible for new winning patterns

2. **Encapsulation**
   - Private class members
   - Getter/setter methods
   - Protected internal state

## Error Handling

The game includes validation for:
- Out-of-bounds moves
- Already occupied cells
- Invalid input types
- Game state violations

## Future Improvements

- GUI implementation
- AI player support
- Game state save/load
- Replay functionality
- Score tracking
- Customizable board sizes
- Undo/redo moves

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details

## Author

Your Name

## Acknowledgments

- Thanks to anyone who contributed to the design
- Inspired by classic Tic Tac Toe implementations
