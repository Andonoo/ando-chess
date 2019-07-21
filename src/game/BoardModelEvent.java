package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Event fired by the BoardModel to notify any listeners of the changes which have occurred in the 
 * board squares. Currently this just delivers the index of the squares changed, and the types 
 * which they should be updated to represent.
 * 
 * @author Andrew Donovan
 *
 */
public class BoardModelEvent {	
	HashMap<Integer, PieceType> _updates;
	List<Integer> _updateIndices;
	
	/**
	 * Creates a BoardModelEvent instance.
	 */
	public BoardModelEvent() {	
		_updates = new HashMap<Integer, PieceType>();
		_updateIndices = new ArrayList<Integer>();
	}

	/**
	 * Returns the core information about the event and changes to the board which have occurred. This
	 * information is represented as a HashMap where the key is the index of the square to be updated
	 * and the value is the type which is should be updated to.
	 * @return a HashMap representing which squares should be updated and what they should be updated to.
	 */
	public HashMap<Integer, PieceType> getUpdates() {
		return _updates;
	}

	/**
	 * @return the indices of squares which should be updated.
	 */
	public List<Integer> getUpdateIndices() {
		return _updateIndices;
	}
	
	/**
	 * Adds an update which will be sent to BoardModelListeners.  
	 * @param index represents the position on the chess board which should be updated (0-63)
	 * @param type represents the type of square the position should be updated to represent.
	 */
	public void addUpdate(int index, PieceType type) {
		_updates.put(index, type);
		_updateIndices.add(index);
	}
}
