package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.ChessMoveEvent;

public class GameFeedbackPanel extends JPanel {
	private JLabel _playerLabel;
	private String _turnsPlayer;
	
	public GameFeedbackPanel() {
		_turnsPlayer = "White";
		_playerLabel = new JLabel();
		_playerLabel.setText(_turnsPlayer);
		add(_playerLabel);
	}
	
	public void newTurn(ChessMoveEvent e) {
		_turnsPlayer = e.whosTurn();
		_playerLabel.setText(_turnsPlayer+"'s Turn");
	}
}
