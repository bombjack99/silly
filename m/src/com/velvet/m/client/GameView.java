package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
interface GameView {
    void appendChatText(String txt);
    void setGameController(GameController gc); //should this one really be in interface?
}
