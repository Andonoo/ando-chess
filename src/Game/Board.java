package Game;
import Squares.*;

public class Board {

    // Setting 'board' as 2D array of square. These will later be populated with empty spaces and pieces objects.
    public Square[][] myBoard = new Square[8][8];

    public Board() {
    }

    public void populateBoard() {

        /* This method populates the board with empty spaces and pieces */

        // Setting board elements to EMPTY
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                myBoard[row][col] = new Empty();
            }
        }

        // Setting pawn pieces
        for (int col = 0; col < 8; col++) {
            myBoard[1][col] = new Pawn(1, col, 'b');
            myBoard[6][col] = new Pawn(6, col, 'w');
        }

        // Setting rook pieces
        myBoard[0][0] = new Rook(0, 0, 'b');
        myBoard[0][7] = new Rook(0, 7, 'b');
        myBoard[7][0] = new Rook(7, 0, 'w');
        myBoard[7][7] = new Rook(7, 7, 'w');

        // Setting knight pieces
        myBoard[0][1] = new Knight(0, 1, 'b');
        myBoard[0][6] = new Knight(0, 6, 'b');
        myBoard[7][1] = new Knight(7, 6, 'w');
        myBoard[7][6] = new Knight(7, 6, 'w');

        // Setting bishop pieces
        myBoard[0][2] = new Bishop(0, 2, 'b');
        myBoard[0][5] = new Bishop(0, 5, 'b');
        myBoard[7][2] = new Bishop(7, 2, 'w');
        myBoard[7][5] = new Bishop(7, 5, 'w');

        // Setting king pieces
        myBoard[0][3] = new King(0, 3, 'b');
        myBoard[7][3] = new King(7, 3, 'w');

        // Setting queen pieces
        myBoard[0][4] = new Queen(0, 4, 'b');
        myBoard[7][4] = new Queen(7, 4, 'w');
    }

    public boolean makeMove(int iInit, int jInit, int iFin, int jFin) {

        // Testing whether desired movement is valid for the type of piece, and if so, moving the object to it's new
        // location and replacing it's old location with an empty square
        if (myBoard[iInit][jInit].moveTest(iInit,jInit,iFin,jFin)) {
            myBoard[iFin][jFin] = myBoard[iInit][jInit];
            myBoard[iInit][jInit] = new Empty();
            return true;
        }

        return true;
    }

}

