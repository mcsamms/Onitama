package com.onitama.engine;

/**
 * Creation of the enum for the Player's colour
 * @author Matthew Samms
 * @date Dec 14, 2018
 */
public enum PlayerColour {
    Red,
    Green;
    public int getColour(PlayerColour cl){
        switch (cl){
            case Red:
                return 1;
            case Green:
                return -1;
            default:
                return 0;
        }
    }
}