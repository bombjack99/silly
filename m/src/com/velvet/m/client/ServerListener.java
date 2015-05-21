package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
public interface ServerListener {
    /**
     * Someone (could be us) roll the dice
     * @param avatar Who did it?
     * @param die1 integer representation of 1st die
     * @param die2 integer representation of 2nd die
     */
    void diceRolled(String avatar, int die1, int die2);

    /**
     * Someone is sending a chat message
     * @param avatar Who send it?
     * @param txt Chat message received
     */
    void playerChat(String avatar, String txt);

    /**
     * Someone enter the game
     * @param avatar Who?
     */
    void playerJoined(String avatar);

    /**
     * Someone start a new game
     * @param avatar who?
     */
    void gameStarted(String avatar);
}
