package squares;

import game.ChessMove;

public class Empty extends Square{
    public boolean moveTest(int iInit, int jInit, int iFin, int jFin) {
        return false;
    }

	public boolean isValidMove(ChessMove move) {
		return false;
	}
}
