package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.ChessMoveEvent;

public class GameFeedbackPanel extends JPanel {
	private JLabel _playerLabel;
	private JLabel _errorMessage;
	private String _turnsPlayer;
	
	public GameFeedbackPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		_turnsPlayer = "White Player's Turn";
		_errorMessage = new JLabel();
		_playerLabel = new JLabel();
		_playerLabel.setText(_turnsPlayer);
		add(_playerLabel);
		add(_errorMessage);
	}
	
	public void newTurn(ChessMoveEvent e) {
		_turnsPlayer = e.whosTurn();
		_playerLabel.setText(_turnsPlayer+" Player's Turn");
		_errorMessage.setText("");
	}

	public void displayError(String errorMessage) {
		_errorMessage.setText(errorMessage);
	}
}
