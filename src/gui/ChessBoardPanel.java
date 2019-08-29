package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.BoardModel;
import game.BoardModelEvent;
import game.BoardModelListener;
import game.GameModelListener;
import game.ChessMove;
import game.Game;
import game.IllegalMoveError;
import game.PieceType;

/**
 * Class to represent the chess board display panel. This class acts as a listener for BoardModel events,
 * which it receives and uses to update the correct buttons on the board to display their appropriate icons.
 * Also contains a nested ChessSquareListener which listens for client interactions with the buttons and 
 * fires appropriate messages back to the BoardModel.
 * 
 * @author Andrew Donovan
 *
 */
public class ChessBoardPanel extends JPanel implements BoardModelListener {
	private List<ChessSquare> _squares; 
	private Game _game; 
	private ChessSquareListener _buttonListener;
	private ChessSquare _selected;
	
	/**
	 * Creates a ChessBoardPanel instance. Sets the ChessSquare buttons into a GridLayout and 
	 * adds itself as a listener to the passed boardModel. 
	 * @param boardModel represents the game state which this panel should display.
	 */
	public ChessBoardPanel(Game game, BoardModel board) {
		board.addBoardModelListener(this);
		_game = game;
		_buttonListener = new ChessSquareListener();
		setBoardSquares();
		_selected = null;
		buildLayout();
    	setSize(800, 800);
	}
	
	/**
	 * Creates the chess boards grid and adds the squares (buttons) to this layout.
	 */
	public void buildLayout() {
		GridLayout boardLayout = new GridLayout(8,8);
		setLayout(boardLayout);
		for (ChessSquare c: _squares) {
			add(c);
		}
		doLayout();
	}
	
	/**
	 * Creates the 64 chess squares and puts them into an ArrayList where they are 
	 * indexed linearly from 0-63. This indexing is order left to right then top to bottom.
	 * Also colors these square appropriately.
	 */
	public void setBoardSquares() {
		int linIndex = 0;
		_squares = new ArrayList<ChessSquare>();
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	ChessSquare square = new ChessSquare(linIndex);
            	square.addActionListener(_buttonListener);
                if (((i + j) % 2) == 0) {
                    square.setBackground(Color.LIGHT_GRAY);
                    square.setDefaultBackground(Color.LIGHT_GRAY);
                } else {
                    square.setBackground(Color.DARK_GRAY);
                    square.setDefaultBackground(Color.DARK_GRAY);
                }
                _squares.add(square);
                linIndex++;
            }
        }
		setInitialIcons();
	}
	
	/**
	 * Updates the chess board based on a BoardModelEvent which contains information on 
	 * individual squares and how they should be updated to represent the new game state.
	 */
	public void update(BoardModelEvent event) {
		List<Integer> indices = event.getUpdateIndices();
		HashMap<Integer, PieceType> updates = event.getUpdates();
		for (Integer i: indices) {
			_squares.get(i).updateIcon(updates.get(i));
		}
	}
	
	/**
	 * Sets the icons of the squares to represent the initial state of a chess board.
	 */
	private void setInitialIcons() {
		for(int i = 0; i < 8; i++) {
			_squares.get(i+8).updateIcon(PieceType.WPAWN);
			_squares.get(i+48).updateIcon(PieceType.BPAWN);
		}
		_squares.get(0).updateIcon(PieceType.WROOK);
		_squares.get(1).updateIcon(PieceType.WKNIGHT);
		_squares.get(2).updateIcon(PieceType.WBISHOP);
		_squares.get(3).updateIcon(PieceType.WQUEEN);
		_squares.get(4).updateIcon(PieceType.WKING);
		_squares.get(5).updateIcon(PieceType.WBISHOP);
		_squares.get(6).updateIcon(PieceType.WKNIGHT);
		_squares.get(7).updateIcon(PieceType.WROOK);
		_squares.get(56).updateIcon(PieceType.BROOK);
		_squares.get(57).updateIcon(PieceType.BKNIGHT);
		_squares.get(58).updateIcon(PieceType.BBISHOP);
		_squares.get(59).updateIcon(PieceType.BQUEEN);
		_squares.get(60).updateIcon(PieceType.BKING);
		_squares.get(61).updateIcon(PieceType.BBISHOP);
		_squares.get(62).updateIcon(PieceType.BKNIGHT);
		_squares.get(63).updateIcon(PieceType.BROOK);
	}
	
	/**
	 * Class nested within ChessBoardPanel which acts as a listener for button presses on the chess board.
	 * These button presses represent user moves. 
	 * 
	 * @author Andrew Donovan
	 *
	 */
	private class ChessSquareListener implements ActionListener {
		/**
		 * Method invoked when the user interacts with the chess board. Depending on whether the user 
		 * has selected the piece to move already, this will either be interpreted as the selection of 
		 * where they want the piece to go or the selection of this piece. This information is then sent
		 * to the BoardModel to determine whether the move is appropriate.
		 */
		public void actionPerformed(ActionEvent e) {
			int selectIndex = ((ChessSquare)e.getSource()).getIndex();
			_game.selectionAttempted(selectIndex);
		}
	}
}

