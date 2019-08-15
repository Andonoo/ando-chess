package game;

/**
 * Interface to be implemented by classes which need to be notified of a change in the game state.
 * The BoardModel will call the update method on each implementing object whenever a change 
 * occurs in the model.
 * 
 * @author Andrew Donovan
 *
 */
public interface GameModelListener {
	/**
	 * Method will be called by the game model whenever a change occurs which the listeners need
	 * to be notified of.
	 * 
	 * @param event details the changes which have occurred.
	 */
	void update(ChessMoveEvent event);
}
