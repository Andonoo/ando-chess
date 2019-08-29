package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import game.PieceType;

/**
 * Class to represent one square on a chess board GUI. Also functions as a button for user input.
 * 
 * @author Andrew Donovan
 */
public class ChessSquare extends JButton {
	private int _index;
	private boolean _selected;
	private Color _defaultBackground;
	private static ImageIcon wPawn = new ImageIcon("icons/whitepawn.png");
	private static ImageIcon wRook = new ImageIcon("icons/whiterook.png");
	private static ImageIcon wKnight = new ImageIcon("icons/whiteknight.png");
	private static ImageIcon wBishop = new ImageIcon("icons/whitebishop.png");
	private static ImageIcon wQueen = new ImageIcon("icons/whitequeen.png");
	private static ImageIcon wKing = new ImageIcon("icons/whiteking.png");
	private static ImageIcon bPawn = new ImageIcon("icons/blackpawn.png");
	private static ImageIcon bRook = new ImageIcon("icons/blackrook.png");
	private static ImageIcon bKnight = new ImageIcon("icons/blackknight.png");
	private static ImageIcon bBishop = new ImageIcon("icons/blackbishop.png");
	private static ImageIcon bQueen = new ImageIcon("icons/blackqueen.png");
	private static ImageIcon bKing = new ImageIcon("icons/blackking.png");
	
	/**
	 * Creates an instance of a chess square and sets it's index position on the board.
	 * @param index
	 */
	public ChessSquare(int index) {
		super();
		_index = index;
		_selected = false;
	}
	
	/**
	 * Sets the non-selected background color of this piece.
	 * @param color
	 */
	public void setDefaultBackground(Color color) {
		super.setBackground(color);
		_defaultBackground = color;
	}

	/**
	 * Updates the icon of this piece to represent the piece provided
	 * @param pieceType
	 */
	public void updateIcon(PieceType pieceType) {
		switch(pieceType) {
		case EMPTY:
			this.setIcon(null);
			break;
		case WBISHOP:
			this.setIcon(wBishop);
			break;
		case WKING:
			this.setIcon(wKing);
			break;
		case WKNIGHT:
			this.setIcon(wKnight);
			break;
		case WPAWN:
			this.setIcon(wPawn);
			break;
		case WQUEEN:
			this.setIcon(wQueen);
			break;
		case WROOK:
			this.setIcon(wRook);
			break;
		case BBISHOP:
			this.setIcon(bBishop);
			break;
		case BKING:
			this.setIcon(bKing);
			break;
		case BKNIGHT:
			this.setIcon(bKnight);
			break;
		case BPAWN:
			this.setIcon(bPawn);
			break;
		case BQUEEN:
			this.setIcon(bQueen);
			break;
		case BROOK:
			this.setIcon(bRook);
			break;
		}
	}

	/**
	 * Returns the index position of this piece on the chess board (0-63).
	 * @return
	 */
	public int getIndex() {
		return _index;
	}  
	
	/**
	 * Toggles the selection of this piece (highlighting).
	 */
	public void toggleSelected() {
		if (_selected) {
			_selected = false;
			setBackground(_defaultBackground);
		} else {
			_selected = true;
			setBackground(new Color(240, 213, 108));
		}
	}
}
