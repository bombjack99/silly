package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
public interface GameController {
    //or just onEvent(GaemEvent ge) ?
    void joinEvent();
    void chatEvent(String s);
    void rollEvent();
    void startEvent();
}
