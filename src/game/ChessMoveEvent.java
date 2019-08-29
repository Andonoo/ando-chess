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
	private int _selectIndex;
	private String _errorMessage;
	
	public ChessMoveEvent(Player player, EventType type) {
		_newPlayer = player.toString();
		_type = type;
	}
	
	public ChessMoveEvent(Player player, EventType type, int selectIndex) {
		_newPlayer = player.toString();
		_type = type;
		_selectIndex = selectIndex;
	}
	
	public ChessMoveEvent(Player player, EventType type, String errorMessage) {
		_newPlayer = player.toString();
		_type = type;
		_errorMessage = errorMessage;
	}
	
	public String whosTurn() {
		return _newPlayer;
	}
	
	public EventType getType() {
		return _type;
	}
	
	public String errorMessage() {
		if (_errorMessage == null) {
			return "";
		} else {
			return _errorMessage;
		}
	}

	public int selectIndex() {
		return _selectIndex;
	}
	
	public enum EventType { 
		ILLEGAL, SUCCESSFUL, SELECTION
	}
}
