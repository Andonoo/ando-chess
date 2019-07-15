package Game;

import GUI.chessGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    private Board gameBoard = new Board();
    private static int[] currentlySelected = new int[2];
    private chessGUI myGUI = new chessGUI(this);

    public Game() {
        startGame();
    }

    public static void main(String[] args) {
        Game myGame = new Game();
        currentlySelected[0] = 9;
        currentlySelected[1] = 9;
    }

    private void startGame() {
        gameBoard.populateBoard();
        myGUI.setGame();
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
