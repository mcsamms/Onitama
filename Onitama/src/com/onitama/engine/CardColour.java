package com.onitama.engine;

/**
 * Creation of enum for the colour of the card.
 * @author Matthew Samms
 * 
 */
public enum CardColour{
    Red,
    Blue;
        public int getColour(CardColour cl){
        switch (cl){
            case Red:
                return 1;
            case Blue:
                return -1;
            default:
                return 0;
        }
    }
}


