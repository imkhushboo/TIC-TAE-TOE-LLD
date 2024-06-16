# Classes:

- Player: Represents a player with a name and a playing piece (PieceX or PieceO).
- PlayingPiece: Abstract class representing a generic playing piece (PieceX and PieceO extend this).
- PieceX, PieceO: Concrete implementations of PlayingPiece, representing 'X' and 'O' pieces respectively.
- PieceType: Enum defining possible piece types ('X' and 'O').
- Board: Represents the game board with a size and a 2D array of PlayingPiece (board).
- Pair: A simple generic class to hold pairs of objects, used for coordinates (row, column).
- Game: Manages the game flow, including players, board, and game logic methods (initializeGame(), startGame(), isThereWinner()).
- Main: Entry point to start the game.

# Relationships:

- Player has a PlayingPiece.
- Game has Player instances (Deque<Player> for managing turn order) and a Board instance.
- Board has a 2D array of PlayingPiece (board).
- Game uses methods from Board (getfreecells(), addPiece()).
- Game interacts with Player and Board to manage game flow (startGame(), isThereWinner()).
