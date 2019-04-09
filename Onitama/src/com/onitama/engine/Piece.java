package com.onitama.engine;

import com.onitama.engine.PlayerColour;
import java.awt.Point;

/**
 *
 * @author mattsamms
 * @date Dec 14, 2018
 */
public class Piece {

    private boolean master;
    private PlayerColour colour;
    private Point position;
    private boolean player;

    /**
     * Creates the Piece and sets its initial position as well as the type of
     * piece and if it is player and not computer.
     *
     * @param type sets whether a piece is true for master
     * @param c sets the colour of the piece
     * @param p sets the initial position
     * @param pl true for player false for computer
     */
    public Piece(boolean type, PlayerColour c, Point p, boolean pl) {
        this.master = type;
        this.colour = c;
        this.position = p;
        this.player = pl;
    }

//<editor-fold defaultstate="collapsed" desc="Getters">
    public boolean isMaster() {
        return master;
    }

    public PlayerColour getColour() {
        return colour;
    }

    public Point getPosition() {
        return position;
    }

//</editor-fold>
}
