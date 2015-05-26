package com.velvet.m.client;

/**
 * Created by ake on 5/19/15.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("Starting mClient");
        // write your code here

        GameView view = new AkeView();
        MessageSender sender = new ServerAPI();
        Controller controller = new Controller(view, sender); //un-comment when server API exists
        //PlayerListener controller = new Controller(view); //remove

        ((AkeView) view).setPLayerListener(controller);
        sender.setServerListener(controller); //un-comment when server API exists
    }
}
