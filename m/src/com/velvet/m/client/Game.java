package com.velvet.m.client;

/**
 * Created by ake on 5/21/15.
 */
public class Game implements GameController {
    private GameView gameView;

    //Game(GameView gameView, GameServerModel abstractService) {}

    Game(GameView gameView) {
        this.gameView = gameView;
        gameView.setGameController(this);
    }

    public void rollEvent() {
        gameView.appendChatText(this.getClass() + " rollEvent");
    }

    public void joinEvent() {
        gameView.appendChatText(this.getClass() + " joinEvent");
    }

    public void chatEvent (String s) {
        String avatar = "Anonymous";
        gameView.appendChatText(this.getClass() + " chatEvent from " + avatar + ": "+ s);
        //enum cmd = GameCmd.CHAT;
        //Avatar me = tbd.getName();
        //abstractServiceAPI.sendMessage(cmd, me, s);
    }

    public void startEvent() {
        gameView.appendChatText(this.getClass() + " startEvent");
    }
}
