package rules;

import game.BoardModel;
import game.ChessMove;
import game.Move;
import game.Player;

public class CurrentPlayerRule implements Rule {
	public boolean isBroken(BoardModel board, Move move, Player currentPlayer) {
		return !board.playerOccupies(currentPlayer, ((ChessMove)move).getOrigin());
	}

	public String getErrorMessage() {
		return "You must select one of your own pieces";
	}
}
