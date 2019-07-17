package game;


import gui.ChessGUI;
import rules.Rule;

import java.util.List;

/**
 * Class to represent an instance of a game (currently configured to be chess but could be easily modified). 
 * Builds the model of the game board, and passes it to the GUI for representation.
 * 
 * @author Andrew Donovan
 *
 */
public class Game {
    private final BoardModel _gameBoard;
    private final ChessGUI _gameGUI;
    private final Player _playerBlack;
    private final Player _playerWhite;
    private List<Rule> _gameRules;
    private Player _playerTurn;
    
    /**
     * Constructs an instance of a chess game. 
     */
    public Game() {
    	_gameBoard = new ChessBoardModel();
    	_gameGUI = new ChessGUI(this, _gameBoard);
    	_playerBlack = Player.BLACK;
    	_playerWhite = Player.WHITE;
    }

    /**
     * Calls for the game board to be populated ready for play.
     */
    private void startGame() {
    	_gameBoard.populateBoard();
    }
    
    /**
     * Tests whether the player who attempted the move 
     * @param moved
     * @return
     */
    public boolean isTurn(Player moved) {
    	if (_playerTurn.equals(moved)){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Method called when the turn changes. Updates the current player.
     */
    public void newTurn() {
    	if (_playerTurn.equals(Player.WHITE)) {
    		_playerTurn = Player.BLACK;
    	} else {
    		_playerTurn = Player.WHITE;
    	}
    }
    
    /**
	 * Method called when there is an attempt to make a change to the game state.
	 * This method takes 2 index positions which together represent the user's requested move.
	 * The game state will be updated depending on what is appropriate as dictated by the game 
	 * rules.
	 * @param origin index of square selected first 
	 * @param destination index of the square selected second
     * @throws IllegalMoveError 
	 */
	public void moveAttempted(Move move) throws IllegalMoveError {
		for (Rule r: _gameRules) {
			if (r.isBroken(_gameBoard, move)) {
				throw new IllegalMoveError(r.getErrorMessage());
			}
		}
		_gameBoard.makeMove(move);
	}
    
    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.startGame();
    }
}
