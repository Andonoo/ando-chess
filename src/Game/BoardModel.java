package game;

import java.awt.event.ActionEvent;

import gui.ChessBoardPanel;
import squares.*;

public class BoardModel {
    // Setting 'board' as 2D array of square. These will later be populated with empty spaces and pieces objects.
    private Square[][] _myBoard;
    private ChessBoardPanel _boardModelListener;

    public BoardModel() {
    }

    /**
     * Populates the game board with initial pieces.
     */
    public void populateBoard() {
        // Setting board elements to EMPTY
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                _myBoard[row][col] = new Empty();
            }
        }

        // Setting pieces
        for (int col = 0; col < 8; col++) {
            _myBoard[1][col] = new Pawn(1, col, 'b');
            _myBoard[6][col] = new Pawn(6, col, 'w');
        }
        _myBoard[0][0] = new Rook(0, 0, 'b');
        _myBoard[0][7] = new Rook(0, 7, 'b');
        _myBoard[7][0] = new Rook(7, 0, 'w');
        _myBoard[7][7] = new Rook(7, 7, 'w');
        _myBoard[0][1] = new Knight(0, 1, 'b');
        _myBoard[0][6] = new Knight(0, 6, 'b');
        _myBoard[7][1] = new Knight(7, 6, 'w');
        _myBoard[7][6] = new Knight(7, 6, 'w');
        _myBoard[0][2] = new Bishop(0, 2, 'b');
        _myBoard[0][5] = new Bishop(0, 5, 'b');
        _myBoard[7][2] = new Bishop(7, 2, 'w');
        _myBoard[7][5] = new Bishop(7, 5, 'w');
        _myBoard[0][3] = new King(0, 3, 'b');
        _myBoard[7][3] = new King(7, 3, 'w');
        _myBoard[0][4] = new Queen(0, 4, 'b');
        _myBoard[7][4] = new Queen(7, 4, 'w');
    }
    
    public boolean makeMove(int iInit, int jInit, int iFin, int jFin) {
        // Testing whether desired movement is valid for the type of piece, and if so, moving the object to it's new
        // location and replacing it's old location with an empty square
        if (_myBoard[iInit][jInit].moveTest(iInit,jInit,iFin,jFin)) {
            _myBoard[iFin][jFin] = _myBoard[iInit][jInit];
            _myBoard[iInit][jInit] = new Empty();
            return true;
        }

        return true;
    }

	public void addBoardModelListener(Object o) {
		
	}

	public void selectionMade(int xCoord, int yCoord) {
		
	}
}

