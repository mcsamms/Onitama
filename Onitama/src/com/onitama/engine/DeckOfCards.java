package com.onitama.engine;

import com.onitama.engine.CardColour;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mattsamms
 */
public class DeckOfCards {

    private final ArrayList<Card> deck;

    /**
     * Performs the createDeck() method;
     */
    public DeckOfCards() {
        this.deck = createDeck();
    }
    
    /**
     * Sets the values of all the cards in the base game of Onitama.
     * @return returns the ArrayList of all the cards, ie the Deck.
     */
    private ArrayList<Card> createDeck() {
        ArrayList<Card> c = new ArrayList<>(
                Arrays.asList(
                        // Two Move cards                
                        new Card("Tiger", CardColour.Blue, new int[][]{{0, 2}, {0, -1}}),
                        //Three move cards
                        new Card("Cobra", CardColour.Red, new int[][]{{1, 1}, {1, -1}, {-1, 0}}),
                        new Card("Frog", CardColour.Red, new int[][]{{-2, 0}, {-1, 1}, {1, -1}}),
                        new Card("Rabbit", CardColour.Blue, new int[][]{{1, 1}, {-1, -1}, {2, 0}}),
                        new Card("Crab", CardColour.Blue, new int[][]{{2, 0}, {-2, 0}, {0, 1}}),
                        new Card("Mantis", CardColour.Red, new int[][]{{0, -1}, {-1, 1}, {1, 1}}),
                        new Card("Horse", CardColour.Red, new int[][]{{-1, 0}, {0, 1}, {0, -1}}),
                        new Card("Ox", CardColour.Blue, new int[][]{{1, 0}, {0, 1}, {0, -1}}),
                        new Card("Crane", CardColour.Blue, new int[][]{{-1, -1}, {1, -1}, {0, 1}}),
                        new Card("Boar", CardColour.Red, new int[][]{{-1, 0}, {1, 0}, {0, 1}}),
                        new Card("Eel", CardColour.Blue, new int[][]{{-1, 1}, {-1, -1}, {1, 0}}),
                        //Four move cards
                        new Card("Dragon", CardColour.Red, new int[][]{{-2, 1}, {-1, -1}, {1, -1}, {2, 1}}),
                        new Card("Elephant", CardColour.Red, new int[][]{{1, 0}, {-1, 0}, {1, 1}, {-1, 1}}),
                        new Card("Goose", CardColour.Blue, new int[][]{{-1, 1}, {1, -1}, {-1, 0}, {1, 0}}),
                        new Card("Rooster", CardColour.Red, new int[][]{{-1, -1}, {1, 1}, {-1, 0}, {1, 0}}),
                        new Card("Monkey", CardColour.Blue, new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1}})
                )
        );
        return c;
    }
    
    /**
     * Gets the deck of cards.
     * @return Returns the deck object
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    /**
     * Gets 5 cards for the game to be played. Chooses them at random.
     * @return Returns a list of 5 Card objects.
     */
    public ArrayList<Card> getGameDeck() {
        ArrayList<Card> c = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int j = (int) (Math.random() * this.deck.size());
            c.add(deck.remove(j));
        }
        return c;
    }
}
