package game;


import gui.ChessGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private BoardModel _gameBoard = new BoardModel();
    private ChessGUI _gameGUI = new ChessGUI(this);

    public Game() {
        startGame();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
    }

    private void startGame() {
    	_gameBoard.populateBoard();
        _gameGUI.setGame();
    }

    public void processInput(int i, int j){
        // Testing if received button is a selected piece or a selected location
        if (currentlySelected[0] == 9) {
            currentlySelected[0] = i;
            currentlySelected[1] = j;
        } else {
            // Testing whether selected move is valid and if so, moving the piece and resetting currently selected
            // variable
            if (gameBoard.makeMove(currentlySelected[0], currentlySelected[1], i, j)) {
                currentlySelected[0] = 9;
                currentlySelected[1] = 9;
                myGUI.updateGUI(gameBoard.myBoard);
            }

        }
    }
}
