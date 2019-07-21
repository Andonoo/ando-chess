package squares;

import game.PieceType;
import game.Player;

public class King extends Piece{
    public King(int x, int y, Player player) {
		super(x, y, player);
		if (player.equals(Player.WHITE)) {
			_type = PieceType.WKING;
		} else {
			_type = PieceType.BKING;
		}
	}

	protected boolean pieceMoveValid(int startX, int startY, int endX, int endY) {
        if ((Math.abs(endX - startX) == 1 && endY == startY) || (Math.abs(endY - startY) == 1 && endX == startX)) {
        	return true;
        } else if (Math.abs(endX - startX) == Math.abs(endY - startY) && Math.abs(endX - startX) == 1) {
        	return true;
        } else {
        	return false;
        }
	}
}
