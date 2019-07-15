package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.BoardModel;

public class ChessBoardPanel extends JPanel {
	private ChessSquare[][] _squares; 
	private BoardModel _boardModel; 
	private ChessSquareListener _buttonListener;
	
	public ChessBoardPanel(BoardModel boardModel) {
		_boardModel = boardModel;
		_boardModel.addBoardModelListener(this);
		setBoardSquares();
		_buttonListener = new ChessSquareListener();
	}
	
	public void setBoardSquares() {
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	ChessSquare square = new ChessSquare(i, j);
                if (((i + j) % 2) == 0) {
                    square.setBackground(Color.LIGHT_GRAY);
                } else {
                    square.setBackground(Color.DARK_GRAY);
                }
                _squares[i][j] = square;
                _squares[i][j].addActionListener(_buttonListener);
            }
        }
	}
	
	public void setIcons() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				_squares[i][j].setIcon(_boardModel.getIcon());
			}
		}
	}
	
	
	private class ChessSquareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int xCoord = ((ChessSquare)e.getSource()).getXCoord();
			int yCoord = ((ChessSquare)e.getSource()).getYCoord();
			_boardModel.selectionMade(xCoord, yCoord);
		}
	}
}

