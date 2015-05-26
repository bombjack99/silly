package com.velvet.m.client;

/**
 * @author bavinfre
 *
 */
public interface MessageSender {
	
	
	
	
	/**
	 * Sends chat message to server 
	 * which will be broadcasted to all 
	 * connected players
	 *  @param String containing message to send
	 */
	void sendChatMessage(String message);
	
	/**
	 * Sends message to server to roll the dice 
	 */
	void rollDice();
	
	/**
	 * Connects to default server
	 * @param player - in-game name of player
	 * @return true if connection succeeded, false otherwise 
	 */
	boolean connectToServer(String gameName);
	
	/**
	 * Connects to server of choice 
	 * @param serverIP - IP to server
	 * @param serverPort - Port which server listens on
	 * @param gameName - In-game name of player
	 * @return true if connection succeeded, false otherwise
	 */
	boolean connectToServer(String serverIP, int serverPort, String gameName);
	
		
	/**
	 * Starts new game
	 */
	void startNewGame();
	

}
