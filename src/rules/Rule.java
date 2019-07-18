package rules;

import game.BoardModel;
import game.Move;
import game.Player;

/**
 * Interface for a game rule. Has the functionality to test whether the rule is broken, 
 * and if necessary return a message explaining what this rule broken is.
 * 
 * @author Andrew Donovan
 *
 */
public interface Rule {
	/**
	 * Determines if the rule has been broken.
	 * @return
	 */
	public boolean isBroken(BoardModel board, Move move, Player currentPlayer);
	/**
	 * @return a string detailing that this rule has been broken.
	 */
	public String getErrorMessage();
}
