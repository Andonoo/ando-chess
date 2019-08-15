package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.GameModelListener;
import game.Game;
import game.BoardModel;
import game.BoardModelEvent;
import game.ChessMoveEvent;

public class ChessGUI implements GameModelListener {
    private JFrame _mainFrame;
    private ChessBoardPanel _boardPanel;
    private GameFeedbackPanel _engineFeedback;
    private JPanel _leftFiller;

    public ChessGUI(Game game, BoardModel board) {
    	createAndShowGUI(game, board);
    }
    
    /**
     * Initializes and displays the chessGUI.
     * @param game to be displayed by GUI.
     */
    private void createAndShowGUI(Game game, BoardModel board) {
    	// Initializing GUI frame
    	_mainFrame = new JFrame("Andrew's Chess");
    	_mainFrame.setLayout(new BorderLayout());
    	_mainFrame.setResizable(true);
    	_mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	_mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    	// Initializing GUI components
    	_boardPanel = new ChessBoardPanel(game, board);
    	_engineFeedback = new GameFeedbackPanel();
    	_engineFeedback.setSize(400, 800);
        _leftFiller = new JPanel();
        _leftFiller.setSize(400, 800);
        // Adding components to frame
        _mainFrame.add(_leftFiller, BorderLayout.WEST);
        _mainFrame.add(_boardPanel, BorderLayout.CENTER);
        _mainFrame.add(_engineFeedback, BorderLayout.EAST);
        _mainFrame.setVisible(true);
    }

	/**
	 * Updates the GUI based upon an update from the model.
	 */
	public void update(ChessMoveEvent event) {
		_engineFeedback.newTurn(event);
	}
}
