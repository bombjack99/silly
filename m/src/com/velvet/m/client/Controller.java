package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
public class Controller implements PlayerListener, ServerListener {
    private GameView gameView;
    //private MessageSender sender;

    //Controller(GameView gameView, MessageSender sender) {
    //this.gameView = gameView;
    //this.sender = sender;
    // }
    Controller(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * PlayerListener API
     */
    @Override
    public void rollEvent() {
        String avatar = "Anonymous";
        // TODO: Remove! For now, bounce it back to view
        this.diceRolled(avatar, 3, 5);//remove
        //sender.sendRoll(avatar);
    }

    @Override
    public void joinEvent() {
        String avatar = "Anonymous";
        // TODO: Remove! For now, bounce it back to view
        this.playerJoined(avatar); //remove
        //sender.sendJoin(avatar);
    }

    @Override
    public void chatEvent(String txt) {
        String avatar = "Anonymous";
        // TODO: Remove! For now, bounce it back to view
        this.playerChat(avatar, txt); //remove
        //sender.sendChat(avatar, txt);
    }

    @Override
    public void startEvent() {
        String avatar = "Anonymous";
        // TODO: Remove! For now, bounce it back to view
        this.gameStarted(avatar); //remove
        //sender.sendStart(avatar);
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
