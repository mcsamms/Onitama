package com.onitama.engine;

import com.onitama.engine.PlayerColour;
import java.awt.Point;

/**
 *
 * @author mattsamms
 * @date December 14, 2018
 */
public class Board {

    private Piece[][] layout = new Piece[5][5];

    public Board() {
        createBoard();
    }

    /**
     * Creates the board
     */
    public void createBoard() {
        clearBoard();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i == 4) {
                    if (j != 2) {
                        layout[j][i] = new Piece(false, PlayerColour.Red, new Point(j, i), false);
                    } else {
                        layout[j][i] = new Piece(true, PlayerColour.Red, new Point(j, i), false);
                    }
                }
            }
        }
    }

    /**
     * Initializes a new blank board.
     */
    public void clearBoard() {
        layout = new Piece[5][5];
    }
}
