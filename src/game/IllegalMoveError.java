package game;

/**
 * Exception thrown when a player's move breaks one of the game rules. 
 * 
 * @author Andrew Donovan
 *
 */
public class IllegalMoveError extends Exception {
	public IllegalMoveError(String errorMessage) {
		super(errorMessage);
	}
}
