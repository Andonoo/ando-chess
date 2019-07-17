package squares;

import game.Player;

public class King extends Piece{

    public King(int x, int y, Player player) {
		super(x, y, player);
	}

	public boolean moveTest(int start_x, int start_y, int end_x, int end_y) {
        return true;
    }
}
