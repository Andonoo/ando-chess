package squares;

public class Pawn extends Piece{

    int x;
    int y;
    char player;

    public Pawn(int x, int y, char player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public boolean moveTest(int start_x, int start_y, int end_x, int end_y) {
        return true;
    }

    public String getType() {
        String type;
        type = String.format("%c"+ "Pawn", player);
        return type;
    }
}
