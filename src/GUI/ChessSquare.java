package gui;

import javax.swing.JButton;

public class ChessSquare extends JButton {
	private int _x;
	private int _y;
	
	public ChessSquare(int x, int y) {
		super();
		_x = x;
		_y = y;
	}

	public int getXCoord() {
		return _x;
	} 
	
	public int getYCoord() {
		return _y;
	}  
}
