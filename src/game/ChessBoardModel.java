package game;

import java.util.ArrayList;
import java.util.List;

import squares.*;

/**
 * Represents the model component in the MVC architecture. Holds the internal representation 
 * of the game state and will update the views based on changes to this state. Also acts as a 
 * listener to the user's interface in order to react to input.
 * 
 * @author Andrew Donovan
 *
 */
public class ChessBoardModel extends BoardModel {
    private List<Square> _board;
    
    /**
     * Creates the BoardModel instance, comprised of an array of Square instances. 
     */
    public ChessBoardModel() {
    	_board = new ArrayList<Square>();
    }
    
    /**
     * Populates the game board with initial Square instances, as a regular chess board would 
     * be at the start of the game.
     */
    public void populateBoard() {
        for (int i = 0; i < 64; i++) {
        	_board.add(i, new Empty());
        }
        for (int i = 0; i < 8; i++) {
        	_board.set(i+8, new Pawn(1, (i+8)%8, Player.WHITE));
        	_board.set(i+48, new Pawn(6, (i+8)%8, Player.BLACK));
        }
        _board.set(0, new Rook(0, 0, Player.WHITE));
        _board.set(7,new Rook(7, 0, Player.WHITE));
        _board.set(56, new Rook(0, 7, Player.BLACK));
        _board.set(63, new Rook(7, 7, Player.BLACK));
        _board.set(1, new Knight(1, 0, Player.WHITE));
        _board.set(6, new Knight(6, 0, Player.WHITE));
        _board.set(57, new Knight(1, 7, Player.BLACK));
        _board.set(62, new Knight(6, 7, Player.BLACK));
        _board.set(2, new Bishop(2, 0, Player.WHITE));
        _board.set(5, new Bishop(5, 0, Player.WHITE));
        _board.set(58, new Bishop(2, 7, Player.BLACK));
        _board.set(61, new Bishop(5, 7, Player.BLACK));
        _board.set(4, new King(4, 0, Player.WHITE));
        _board.set(59, new King(3, 7, Player.BLACK));
        _board.set(3, new Queen(3, 0, Player.WHITE));
        _board.set(60, new Queen(4, 7, Player.BLACK));
    }

	/**
	 * Method determines if the location provided is occupied by the provided player. 
	 * @param player 
	 * @param location
	 * @return
	 */
	public boolean playerOccupies(Player player, int location) {
		if (_board.get(location).isOccupiedBy(player)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Determines if the move is valid for the piece at the given location.
	 * @param move
	 * @return
	 */
	public boolean isValidPieceMove(ChessMove move) {
		 return _board.get(move.getOrigin()).isValidMovement(move);
	}

	/**
	 * Will called once it is determined that the move is legal. Updates the board
	 * based on this move.
	 * @param move
	 */
	public void makeMove(Move move) {
		ChessMove chessMove = (ChessMove)move;
		Square moved = _board.get(chessMove.getOrigin());
		_board.set(chessMove.getOrigin(), new Empty());
		_board.set(chessMove.getDestination(), moved);
		BoardModelEvent event = new BoardModelEvent();
		event.addUpdate(chessMove.getOrigin(), PieceType.EMPTY);
		event.addUpdate(chessMove.getDestination(), moved.getType());
		updateListeners(event);
	}

	/**
	 * Method called when any listeners need to be notified of changes in the chess board model.
	 */
	protected void updateListeners(BoardModelEvent event) {
		for (BoardModelListener l: _listeners) {
			l.update(event);
		}
	}
}

