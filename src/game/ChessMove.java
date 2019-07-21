package game;

public class ChessMove implements Move {
	private int _originIndex;
	private int _destinationIndex;
	
	public ChessMove(int originIndex, int destinationIndex) {
		_originIndex = originIndex;
		_destinationIndex = destinationIndex;
	}
	
	public int getOrigin() {
		return _originIndex;
	} 
	
	public int getDestination() {
		return _destinationIndex;
	} 
}