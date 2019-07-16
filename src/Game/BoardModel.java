package game;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import gui.ChessBoardPanel;
import gui.ChessSquare;
import squares.*;

/**
 * Represents the model component in the MVC architecture. Holds the internal representation 
 * of the game state and will update the views based on changes to this state. Also acts as a 
 * listener to the user's interface in order to react to input.
 * 
 * @author Andrew Donovan
 *
 */
public class BoardModel {
    private List<Square> _myBoard;
    private BoardModelListener _boardModelListener;

    /**
     * Creates the BoardModel instance, comprised of an array of Square instances. 
     */
    public BoardModel() {
    	_myBoard = new ArrayList<Square>();
    }

    /**
     * Populates the game board with initial Square instances, as a regular chess board would 
     * be at the start of the game.
     */
    public void populateBoard() {
        // Setting board elements to EMPTY
        for (int i = 0; i < 64; i++) {
               _myBoard.add(i, new Empty());
        }
        // Setting pieces
        for (int i = 0; i < 64; i++) {
            _myBoard.add(i+8, new Pawn(1, (i+8)%8, 'w'));
            _myBoard.add(i+48, new Pawn(6, (i+8)%8, 'b'));
        }
        _myBoard.add(0, new Rook(0, 0, 'w'));
        _myBoard.add(7,new Rook(7, 0, 'w'));
        _myBoard.add(56, new Rook(0, 7, 'b'));
        _myBoard.add(63, new Rook(7, 7, 'b'));
        _myBoard.add(1, new Knight(1, 0, 'w'));
        _myBoard.add(6, new Knight(6, 0, 'w'));
        _myBoard.add(57, new Knight(1, 7, 'b'));
        _myBoard.add(62, new Knight(6, 7, 'b'));
        _myBoard.add(2, new Bishop(2, 0, 'w'));
        _myBoard.add(5, new Bishop(5, 0, 'w'));
        _myBoard.add(58, new Bishop(2, 7, 'b'));
        _myBoard.add(61, new Bishop(5, 7, 'b'));
        _myBoard.add(4, new King(4, 0, 'w'));
        _myBoard.add(59, new King(3, 7, 'b'));
        _myBoard.add(3, new Queen(3, 0, 'w'));
        _myBoard.add(60, new Queen(4, 7, 'b'));
    }

    /**
     * Adds a BoardModelListener to this BoardModel. These listeners will be updated
     * of changes in the game state through their update() method. 
     * @param listener to be notified of changes.
     */
	public void addBoardModelListener(BoardModelListener listener) {
		_boardModelListener = listener;
	}

	/**
	 * Method called by user interface when they attempt to make a change to the game state.
	 * This method takes 2 index positions which together represent the user's requested move.
	 * It then updates the game state depending on what is appropriate as dictated by the game 
	 * rules.
	 * @param origin index of square selected first 
	 * @param destination index of the square selected second
	 */
	public void moveAttempted(int origin, int destination) {
		BoardModelEvent update = new BoardModelEvent();
		update.addUpdate(origin, PieceType.EMPTY);
		update.addUpdate(destination, PieceType.BKING);
		_boardModelListener.update(update);
	}
}

