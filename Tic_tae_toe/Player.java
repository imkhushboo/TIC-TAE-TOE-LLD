package Tic_tae_toe;

public class Player {

    String name;
    PlayingPiece piece;

    public Player(String name , PlayingPiece piece)
    {
        this.name = name;
        this.piece = piece;
   }

   public String name(){
        return this.name;
   }

    public PlayingPiece getPiece() {
        return this.piece;
    }
}
