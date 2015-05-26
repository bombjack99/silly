package com.velvet.m.client;

/**
 * Created by ake on 5/19/15.
 */
public class Client {
    public static void main(String[] args) {
    	
        GameView view = new AkeView();
        MessageSender sender = new ServerApi();
        Controller controller = new Controller(view, sender); 

        ((AkeView) view).setPLayerListener(controller);
        ((ServerApi)sender).setServerListener(controller); 
    }
}
