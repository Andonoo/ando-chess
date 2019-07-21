package squares;

import game.PieceType;
import game.Player;

public class Queen extends Piece{
    public Queen(int x, int y, Player player) {
		super(x, y, player);
		if (player.equals(Player.WHITE)) {
			_type = PieceType.WQUEEN;
		} else {
			_type = PieceType.BQUEEN;
		}
	}

	protected boolean pieceMoveValid(int startX, int startY, int endX, int endY) {
		if ((startX == endX &&  startY != endY) || (startY == endY && startX != endX)) {
			return true;
		} else if ((Math.abs(endX - startX) == Math.abs(endY - startY))) {
			return true;
		} else {
			return false;
		}
	}
}

