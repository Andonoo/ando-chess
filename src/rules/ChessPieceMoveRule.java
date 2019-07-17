package rules;

import game.BoardModel;
import game.ChessBoardModel;
import game.ChessMove;
import game.Move;

public class ChessPieceMoveRule implements Rule {
	public boolean isBroken(BoardModel board, Move move) {
		return ((ChessBoardModel)board).isValidPieceMove(((ChessMove)move));
	}

	public String getErrorMessage() {
		return "ERROR: move breaks piece restrictions";
	}
}
