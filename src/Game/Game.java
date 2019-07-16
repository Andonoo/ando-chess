package game;


import gui.ChessGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class to represent an instance of a game of chess. Builds the model of the chess board,
 * and passes it to the GUI for representation.
 * 
 * @author Andrew Donovan
 *
 */
public class Game {
    private BoardModel _gameBoard;
    private ChessGUI _gameGUI;
    
    /**
     * Constructs an instance of a chess game. 
     */
    public Game() {
    	_gameBoard = new BoardModel();
    	_gameGUI = new ChessGUI(_gameBoard);
    }

    /**
     * Calls for the game board to be populated ready for play.
     */
    private void startGame() {
    	_gameBoard.populateBoard();
    }
    
    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.startGame();
    }
}
