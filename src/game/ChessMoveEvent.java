package game;

/**
 * Event thrown by the game model when a turn has taken place and relevant views must be updated
 * to reflect this move.
 * 
 * @author Andrew Donovan
 */
public class ChessMoveEvent {
	private String _newPlayer;
	
	public ChessMoveEvent(Player player) {
		_newPlayer = player.toString();
	}
	
	public String whosTurn() {
		return _newPlayer;
	}
}
