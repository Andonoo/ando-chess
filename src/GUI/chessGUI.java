package gui;

import game.BoardModel;
import game.Game;
import squares.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessGUI {
    private JFrame mainFrame;
    private JPanel boardPanel;
    private JLabel leftFiller;
    private JLabel engineFeedback;

    private GridBagConstraints boardConstraints = new GridBagConstraints();
    private GridBagConstraints panelConstraints = new GridBagConstraints();

    public ChessGUI(Game game, BoardModel boardModel) {
        prepareGUI(game, boardModel);
    }

    private void prepareGUI(Game game, BoardModel boardModel) {
        // Initializing frame and panel
        mainFrame = new JFrame("Andrew's Chess");
        mainFrame.setSize(1600, 800);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setResizable(true);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        boardPanel = new ChessBoardPanel(game, boardModel);
        boardPanel.setSize(800, 800);
        boardPanel.setLayout(new GridLayout(8, 8));

        // Initializing window listener
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Initializing feedback panel
        engineFeedback = new JLabel("TODO");
        leftFiller = new JLabel("TODO");

        // Setting layout constraints
        panelConstraints.gridwidth = 400;
        panelConstraints.gridheight = 800;
        panelConstraints.weightx = 2;
        panelConstraints.weighty = 2;

        boardConstraints.weighty = 1;
        boardConstraints.weightx = 1;
        boardConstraints.fill = 1;

        /* Adding elements to frame in following order and applying gridbag constraints
         * Left empty box (for future functionality)
         * gameControl (chess board)
         * Right empty box (for future functionality)
         */
        mainFrame.add(leftFiller, panelConstraints);
        mainFrame.add(boardPanel, boardConstraints);
        mainFrame.add(engineFeedback, panelConstraints);
        mainFrame.setVisible(true);
    }
}
