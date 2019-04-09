package com.onitama.engine;

import com.onitama.engine.CardColour;

/**
 *
 * @author Matthew Samms
 * @date December 14, 2018
 */
public class Card {

    private final String name;
    private final CardColour startingPlayer;
    private final int[][] playerMoves;

    /**
     * Creates the cards
     *
     * @param name Card name as string
     * @param startingPlayer Takes in the colour of the card which indicates
     * the starting player
     * @param v indicates the vector of possible moves for each card.
     */
    public Card(String name, CardColour startingPlayer, int[][] v) {
        this.name = name;
        this.startingPlayer = startingPlayer;
        this.playerMoves = v;
    }

//<editor-fold defaultstate="collapsed" desc="Getters">
    public String getName() {
        return name;
    }
    
    public CardColour getStartingPlayer() {
        return startingPlayer;
    }
    
    public int[][] getPlayerMoves() {
        return playerMoves;
    }
//</editor-fold>
    
    /**
     * Prints the cards to the Console.
     */
    public void printMoves(){
        String x = "";
        for (int[] playerMove : playerMoves) {
            for (int j = 0; j < playerMoves.length; j++) {
                x += playerMove[j];
            }
            x += "\n";
        }
        System.out.println(x);
    }
}
