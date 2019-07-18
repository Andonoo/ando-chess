package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class to represent the model of a game board in a turn based game 
 * such as chess.
 * 
 * @author Andrew Donovan
 *
 */
public abstract class BoardModel {
	protected List<BoardModelListener> _listeners = new ArrayList<BoardModelListener>();
	
	/**
     * Adds a BoardModelListener to this BoardModel. These listeners will be updated
     * of changes in the game state through their update() method. 
     * @param listener to be notified of changes.
     */
	public void addBoardModelListener(BoardModelListener listener) {
		_listeners.add(listener);
	}
	
	/**
     * Populates the game board with initial Square instances, as a regular chess board would 
     * be at the start of the game.
     */
	public abstract void populateBoard();
	
	/**
	 * Method determines if the location provided is occupied by the provided player. 
	 * @param player 
	 * @param location
	 * @return
	 */
	public abstract boolean playerOccupies(Player player, int location);
	
	/**
	 * Will called once it is determined that the move is legal. Updates the board
	 * based on this move.
	 * @param move
	 */
	public abstract void makeMove(Move move);
	
	/**
	 * Method called when any listeners need to be notified of changes in the board model.
	 */
	protected abstract void updateListeners(BoardModelEvent event);
}
