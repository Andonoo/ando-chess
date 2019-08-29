package rules;

import game.BoardModel;
import game.ChessBoardModel;
import game.ChessMove;
import game.Move;
import game.Player;

public class ChessPieceMoveRule implements Rule {
	public boolean isBroken(BoardModel board, Move move, Player currentPlayer) {
		return !((ChessBoardModel)board).isValidPieceMove(((ChessMove)move));
	}

	public String getErrorMessage() {
		return "Move breaks piece restrictions";
	}
}
