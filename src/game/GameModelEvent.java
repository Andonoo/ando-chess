package game;

/**
 * Contains information regarding events in the GameModel. Currently just represents errors caused 
 * by invalid user input. 
 * 
 * @author Andrew Donovan
 *
 */
public class GameModelEvent {
	private String _errorMessage;
	
	public GameModelEvent(String errorMessage) {
		_errorMessage = errorMessage;
	}
}
