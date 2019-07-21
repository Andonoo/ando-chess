package game;

public enum Player {
	WHITE, BLACK;
	
	public String toString() {
		if (this.equals(BLACK)) {
			return "Black";
		} else {
			return "White";
		}
	}
}
