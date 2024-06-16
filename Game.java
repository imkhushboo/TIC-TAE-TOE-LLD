import Tic_tae_toe.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Game {
    Deque<Player> players;
    Board board;

    Game(){
        initializeGame();
    }

    public void initializeGame(){
        // creating 2 players
        players = new LinkedList<>();
        PlayingPiece pieceX = new PieceX();
        Player  player1 = new Player("Player1",pieceX);

        PlayingPiece pieceO = new PieceO();
        Player player2 = new Player("Player2",pieceO);

        players.add(player1);
        players.add(player2);

        board = new Board(3);

    }


    public String startGame(){
        boolean nowinner = true;

        while(nowinner)
        {
            Player playerturn = players.removeFirst();

            board.print();

            List<Pair<Integer,Integer>>freecells = board.getfreecells();

            if(freecells.isEmpty())
            {
                nowinner = false;
                continue;

            }

            System.out.println("Player:"+playerturn.name()+"Enter row , column :");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputrow = Integer.valueOf(values[0]);
            int inputcolumn = Integer.valueOf(values[1]);

            boolean addedsuccessfully = board.addPiece(inputrow,inputcolumn,playerturn.getPiece());

            if(!addedsuccessfully){
                System.out.println("Incorrect Position , Try Again!");
                players.addFirst(playerturn);
                continue;
            }

            players.add(playerturn);

            boolean winner = isThereWinner(inputrow,inputcolumn,playerturn);

            if(winner){
                return "Winner is :" + playerturn.name();
            }

        }

        return "Game is tie";
    }

    public boolean isThereWinner(int row,int column,Player playerturn)
    {
        boolean rowmatch = true;
        boolean columnmatch = true;
        boolean diagonal = true;
        boolean antidiagonal = true;
        for(int i=0;i<board.size;i++)
        {
            if(board.board[row][i] == null || board.board[row][i] != playerturn.getPiece()) {
                rowmatch = false;
            }
        }

        for(int i=0;i<board.size;i++){
            if(board.board[i][column] == null || board.board[i][column] != playerturn.getPiece()){
                columnmatch = false;
            }
        }

        // diagonal
        for(int i=0,j=0;i< board.size && j<board.size ;i++,j++){
            if(board.board[i][j] == null || board.board[i][j] != playerturn.getPiece()){
                diagonal = false;
            }
        }

        for(int i=0,j = board.size-1;i< board.size && j>=0 ; i++,j--){
            if(board.board[i][j] == null || board.board[i][j] != playerturn.getPiece()){
                antidiagonal = false;
            }
        }

        return rowmatch || columnmatch || diagonal || antidiagonal;
    }
}
