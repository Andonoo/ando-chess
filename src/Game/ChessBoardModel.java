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
public class ChessBoardModel extends BoardModel{
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
        for (int i = 0; i < 64; i++) {
        	_board.add(i+8, new Pawn(1, (i+8)%8, Player.WHITE));
        	_board.add(i+48, new Pawn(6, (i+8)%8, Player.BLACK));
        }
        _board.add(0, new Rook(0, 0, Player.WHITE));
        _board.add(7,new Rook(7, 0, Player.WHITE));
        _board.add(56, new Rook(0, 7, Player.BLACK));
        _board.add(63, new Rook(7, 7, Player.BLACK));
        _board.add(1, new Knight(1, 0, Player.WHITE));
        _board.add(6, new Knight(6, 0, Player.WHITE));
        _board.add(57, new Knight(1, 7, Player.BLACK));
        _board.add(62, new Knight(6, 7, Player.BLACK));
        _board.add(2, new Bishop(2, 0, Player.WHITE));
        _board.add(5, new Bishop(5, 0, Player.WHITE));
        _board.add(58, new Bishop(2, 7, Player.BLACK));
        _board.add(61, new Bishop(5, 7, Player.BLACK));
        _board.add(4, new King(4, 0, Player.WHITE));
        _board.add(59, new King(3, 7, Player.BLACK));
        _board.add(3, new Queen(3, 0, Player.WHITE));
        _board.add(60, new Queen(4, 7, Player.BLACK));
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
		 return _board.get(move.getOrigin()).isValidMove(move);
	}

	/**
	 * Will called once it is determined that the move is legal. Updates the board
	 * based on this move.
	 * @param move
	 */
	public void makeMove(Move move) {
		
	}
}

