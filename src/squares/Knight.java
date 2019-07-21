package squares;

import game.PieceType;
import game.Player;

public class Knight extends Piece{
    public Knight(int x, int y, Player player) {
		super(x, y, player);
		if (player.equals(Player.WHITE)) {
			_type = PieceType.WKNIGHT;
		} else {
			_type = PieceType.BKNIGHT;
		}
	}

	protected boolean pieceMoveValid(int startX, int startY, int endX, int endY) {
		if ((Math.abs(endX - startX) == 1 &&  Math.abs(endY - startY) == 2) || (Math.abs(endY - startY) == 1 &&  Math.abs(endX - startX) == 2)) {
			return true;
		} else {
			return false;
		}
	}
}
