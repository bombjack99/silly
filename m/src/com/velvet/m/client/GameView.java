package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
interface GameView {
    /**
     * Got a new chat message from someone.
     * @param txt Chat message to display
     */
    void appendChatText(String txt);
}
