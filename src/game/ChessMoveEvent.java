package game;

/**
 * Event thrown by the game model when a turn has taken place and relevant views must be updated
 * to reflect this move.
 * 
 * @author Andrew Donovan
 */
public class ChessMoveEvent {
	private final String _newPlayer;
	private final EventType _type;
	private String _errorMessage;
	
	public ChessMoveEvent(Player player, EventType type) {
		_newPlayer = player.toString();
		_type = type;
	}
	
	public String whosTurn() {
		return _newPlayer;
	}
	
	public EventType getType() {
		return _type;
	}
	
	public void setErrorMessage(String message) {
		_errorMessage = message;
	}
	
	public String errorMessage() {
		if (_errorMessage == null) {
			return "";
		} else {
			return _errorMessage;
		}
	}
	
	public enum EventType { 
		ILLEGAL, SUCCESSFUL
	}
}
