package com.onitama.engine;

/**
 *
 * @author mattsamms
 * @date Dec 14, 2018
 */
public class Player {

    private Card[] cards;
    private boolean isComputer;
    private int playerColour;

    /**
     * Gives the players a starting set of cards. Sets who is player and who is
     * comp. Sets the player colour to correspond to the starting colour.
     *
     * @param cs A list of two cards
     * @param isComp
     * @param colour
     */
    public Player(Card[] cs, boolean isComp, int colour) {
        try {
            if (cs.length > 2) {
                throw new Exception("Too many cards dealt");
            }
            this.cards = cs;
            this.isComputer = isComp;
            this.playerColour = colour;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

//<editor-fold defaultstate="collapsed" desc="Getters">
    public Card[] getCards() {
        return cards;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public int getPlayerColour() {
        return playerColour;
    }

//</editor-fold>
}
