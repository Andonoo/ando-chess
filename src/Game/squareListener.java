package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class squareListener implements ActionListener {

    /* Initialising button listener specifications
     * i = Button row
     * j = Button col
     */
    int i;
    int j;
    Game myGame;

    public squareListener(Game myGame, int i, int j) {
        this.i = i;
        this.j = j;
        this.myGame = myGame;
    }

    public void actionPerformed(ActionEvent e) {
        /* Testing whether the action represents a selected piece or a selected move
         * If action represents selected piece -> setting as currently selected
         * If action represents selected move -> executing make move method
         */
        myGame.processInput(i, j);
    }
}
