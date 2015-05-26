package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
public class Controller implements PlayerListener, ServerListener {
    private GameView gameView;
    private MessageSender sender;

    Controller(GameView gameView, MessageSender sender) {
    this.gameView = gameView;
    this.sender = sender;
    }
    Controller(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * PlayerListener API
     */
    @Override
    public void rollEvent() {
        sender.rollDice(); 
    }

    @Override
    public void joinEvent() {
        String avatar = "Anonymous";
        //TODO: parameters should come from UI
        sender.connectToServer("127.0.0.1", 9901, avatar);
    }

    @Override
    public void chatEvent(String txt) {
        sender.sendChatMessage(txt);
    }

    @Override
    public void startEvent() {
        sender.startNewGame();
    }

    /**
     * ServerListener API
     */
    @Override
    public void diceRolled(String avatar, int die1, int die2) {
        gameView.appendChatText(avatar + " roll " + die1 + " " + die2);
    }

    @Override
    public void playerChat(String avatar, String txt) {
        gameView.appendChatText(avatar + " says: " + txt);
    }

    @Override
    public void playerJoined(String avatar) {
        gameView.appendChatText(avatar + " has joined the game");
    }

    @Override
    public void gameStarted(String avatar) {
        gameView.appendChatText(avatar + " has started the game");
    }
}
