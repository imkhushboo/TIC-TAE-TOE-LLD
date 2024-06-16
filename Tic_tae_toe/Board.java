package Tic_tae_toe;

import java.util.ArrayList;
import java.util.List;


public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size)
    {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void print(){

        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                if(board[i][j] == null)
               System.out.print("  |");
                else{
                    System.out.print(board[i][j].piece + " |");
                }
            }
            System.out.println();

        }

    }

    public List<Pair<Integer,Integer>> getfreecells(){
        List<Pair<Integer,Integer>>freecells = new ArrayList<>();

        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                if(board[i][j] == null){
                    Pair<Integer,Integer> rowColumn = new Pair<>(i,j);
                    freecells.add(rowColumn);
                }
            }
        }
        return  freecells;
    }

    public boolean addPiece(int row,int column,PlayingPiece playingPiece){
        if(board[row][column] != null){
            return false;
        }

        board[row][column] = playingPiece;
        return true;
    }
}
