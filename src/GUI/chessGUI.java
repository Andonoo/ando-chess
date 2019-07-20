package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.BoardModelEvent;
import game.BoardModelListener;
import game.Game;

public class ChessGUI implements BoardModelListener {
    private JFrame _mainFrame;
    private ChessBoardPanel _boardPanel;
    private JPanel _engineFeedback;
    private JPanel _leftFiller;

    public ChessGUI(Game game) {
    	createAndShowGUI(game);
    }
    
    /**
     * Initializes and displays the chessGUI.
     * @param game to be displayed by GUI.
     */
    private void createAndShowGUI(Game game) {
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
    	_boardPanel = new ChessBoardPanel(game);
    	_engineFeedback = new JPanel();
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
	public void update(BoardModelEvent event) {
		_boardPanel.update(event);
	}
}
