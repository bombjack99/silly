package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
public interface PlayerListener {
    //or just onEvent(GaemEvent ge) ?

    /**
     * Player hit "join button"
     */
    void joinEvent();

    /**
     * Player hit "chat button/something"
     * @param txt Chat message to send to game server
     */
    void chatEvent(String txt);

    /**
     * Player hit "roll dice button"
     */
    void rollEvent();

    /**
     * Player hit "start button"
     */
    void startEvent();
}
