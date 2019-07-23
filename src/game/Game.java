package game;


import gui.ChessGUI;
import rules.ChessPieceMoveRule;
import rules.CurrentPlayerRule;
import rules.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent an instance of a game (currently configured to be chess but could be easily modified). 
 * Builds the model of the game board, and passes it to the GUI for representation.
 * 
 * @author Andrew Donovan
 * 
 */
public class Game {
	private List<GameModelListener> _listeners = new ArrayList<GameModelListener>();
    private final BoardModel _gameBoard;
    private final ChessGUI _gameGUI;
    private List<Rule> _gameRules;
    private Player _playerTurn;
    private boolean _pieceSelected;
    private int _selection;
    
    /**
     * Constructs an instance of a chess game. 
     */
    public Game() {
    	_gameBoard = new ChessBoardModel();
    	_gameGUI = new ChessGUI(this, _gameBoard);
    	addGameModelListener(_gameGUI);
    	addRules();
    	_pieceSelected = false;
    }

    /**
     * Initializes the various game rules
     */
    private void addRules() {
    	_gameRules = new ArrayList<Rule>();
    	_gameRules.add(new ChessPieceMoveRule());
    	_gameRules.add(new CurrentPlayerRule());
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
			if (r.isBroken(_gameBoard, move, _playerTurn)) {
				throw new IllegalMoveError(r.getErrorMessage());
			}
		}
		_gameBoard.makeMove(move);
	}
	
	/**
	 * Method called by the GUI when the player attempts to make a selection on the game board.
	 * Can either lead to a move on the game board, an initial piece selection or an error 
	 * being thrown.
	 * 
	 * @param selectIndex
	 * @throws IllegalMoveError
	 */
	public void selectionAttempted(int selectIndex) {
		if (_pieceSelected) {
			try {
				moveAttempted(new ChessMove(_selection, selectIndex));
				_selection = -1;
				_pieceSelected = false;
			} catch (IllegalMoveError e) {
				updateListeners(new GameModelEvent(e.getMessage()));
			}
		} else {
			if (_gameBoard.playerOccupies(_playerTurn, selectIndex)) {
				_pieceSelected = true;
				_selection = selectIndex;
			} else {
				updateListeners(new GameModelEvent("ERROR: Must select your own piece"));
			}
		}
	}
	
	/**
	 * Method called when any listeners need to be notified of changes in the chess board model.
	 */
	protected void updateListeners(GameModelEvent event) {
		for (GameModelListener l: _listeners) {
			l.update(event);
		}
	}
	
	/**
     * Adds a GameModelListener to this Game model. These listeners will be updated
     * of changes in the game state through their update() method. 
     * @param listener to be notified of changes.
     */
	public void addGameModelListener(GameModelListener listener) {
		_listeners.add(listener);
	}

    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.startGame();
    }
}
