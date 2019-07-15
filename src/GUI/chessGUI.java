package gui;

import game.BoardModel;
import game.Game;
import squares.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.SquareListener;

public class ChessGUI {
    private JFrame mainFrame;
    private JPanel boardPanel;
    private JLabel leftFiller;
    private JLabel engineFeedback;

    private GridBagConstraints boardConstraints = new GridBagConstraints();
    private GridBagConstraints panelConstraints = new GridBagConstraints();

    private ImageIcon wPawn = new ImageIcon("icons/whitepawn.png");
    private ImageIcon wRook = new ImageIcon("icons/whiterook.png");
    private ImageIcon wKnight = new ImageIcon("icons/whiteknight.png");
    private ImageIcon wBishop = new ImageIcon("icons/whitebishop.png");
    private ImageIcon wQueen = new ImageIcon("icons/whitequeen.png");
    private ImageIcon wKing = new ImageIcon("icons/whiteking.png");
    private ImageIcon bPawn = new ImageIcon("icons/blackpawn.png");
    private ImageIcon bRook = new ImageIcon("icons/blackrook.png");
    private ImageIcon bKnight = new ImageIcon("icons/blackknight.png");
    private ImageIcon bBishop = new ImageIcon("icons/blackbishop.png");
    private ImageIcon bQueen = new ImageIcon("icons/blackqueen.png");
    private ImageIcon bKing = new ImageIcon("icons/blackking.png");

    public ChessGUI(BoardModel boardModel) {
        prepareGUI(boardModel);
    }

    private void prepareGUI(BoardModel boardModel) {
        // Initializing frame and panel
        mainFrame = new JFrame("Andrew's Chess");
        mainFrame.setSize(1600, 800);
        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setResizable(true);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        boardPanel = new ChessBoardPanel(boardModel);
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

    public void setGame() {
        // Setting initial board pieces
        for (int i = 0; i < 8; i++) {
            boardSquares[1][i].setIcon(bPawn);
            boardSquares[6][i].setIcon(wPawn);
        }
        boardSquares[0][0].setIcon(bRook);
        boardSquares[0][7].setIcon(bRook);
        boardSquares[7][0].setIcon(wRook);
        boardSquares[7][7].setIcon(wRook);
        boardSquares[0][1].setIcon(bKnight);
        boardSquares[0][6].setIcon(bKnight);
        boardSquares[7][1].setIcon(wKnight);
        boardSquares[7][6].setIcon(wKnight);
        boardSquares[0][2].setIcon(bBishop);
        boardSquares[0][5].setIcon(bBishop);
        boardSquares[7][2].setIcon(wBishop);
        boardSquares[7][5].setIcon(wBishop);
        boardSquares[0][3].setIcon(bKing);
        boardSquares[7][3].setIcon(wKing);
        boardSquares[0][4].setIcon(bQueen);
        boardSquares[7][4].setIcon(wQueen);
    }

    public void updateGUI(Square[][] myBoard) {
        // Looping through button array, updating GUI to any changed pieces.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch(myBoard[i][j].getType()) {
                    case "wPawn":
                        boardSquares[i][j].setIcon(wPawn);
                        break;

                    case "bPawn":
                        boardSquares[i][j].setIcon(bPawn);
                        break;

                    case "wRook":
                        boardSquares[i][j].setIcon(wRook);
                        break;

                    case "bRook":
                        boardSquares[i][j].setIcon(bRook);
                        break;

                    case "wKnight":
                        boardSquares[i][j].setIcon(wKnight);
                        break;

                    case "bKnight":
                        boardSquares[i][j].setIcon(bKnight);
                        break;

                    case "wBishop":
                        boardSquares[i][j].setIcon(wBishop);
                        break;

                    case "bBishop":
                        boardSquares[i][j].setIcon(bBishop);
                        break;

                    case "wQueen":
                        boardSquares[i][j].setIcon(wQueen);
                        break;

                    case "bQueen":
                        boardSquares[i][j].setIcon(bQueen);
                        break;

                    case "wKing":
                        boardSquares[i][j].setIcon(wKing);
                        break;

                    case "bKing":
                        boardSquares[i][j].setIcon(bKing);
                        break;

                    case "Empty":
                        boardSquares[i][j].setIcon(null);
                        break;
                }
            }
        }

        // Looping through the button array, adding the updated buttons to the game's control panel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameControl.add(boardSquares[i][j]);
            }
        }

        mainFrame.add(leftFiller, panelConstraints);
        mainFrame.add(gameControl, boardConstraints);
        mainFrame.add(engineFeedback, panelConstraints);
    }
}
