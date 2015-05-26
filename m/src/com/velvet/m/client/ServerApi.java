package com.velvet.m.client;

public class ServerApi implements MessageSender {
	
	private ServerListener sl = null;
	private String serverIP   = "127.0.0.1";
	private int serverPort    = 9901;
	private String gameName   = "Nisse Hult";

	@Override
	public void sendChatMessage(String message) {
		// TODO: send to server here
		
		// XXX dev code below. TBR
		sl.playerChat(gameName, message);
		sl.playerChat("Server", "hej från serversidan");
		
		
	}

	@Override
	public void rollDice() {
		// TODO actually call the server to get dice here
		
		// XXX dev code below. TBR
		int die1 = (int)(Math.random() * 6) + 1 ;
		int die2 = (int)(Math.random() * 6) + 1;
		sl.diceRolled(gameName, die1, die2);
		sl.playerChat("Server", gameName + " just rolled " + die1 + " and " + die2);
		
	}

	@Override
	public boolean connectToServer(String gameName) {
		return this.connectToServer(this.serverIP, this.serverPort, gameName);
	}

	@Override
	public boolean connectToServer(String serverIP, int serverPort,
			String gameName) {
		//TODO: add exception here for if no ServerListener is set or IP is bogus
		
		this.serverIP = serverIP;
		this.gameName = gameName;
		
		//TODO use exceptions if no game name?
		//TODO connection code to server here
		
		// XXX dev code below. TBR
		sl.playerJoined(gameName);
		sl.playerChat("Server", gameName + ", welcome to Monopoly version 0.1");
		
		return true;
	}

	@Override
	public void startNewGame() {
		// TODO connection code to server here
		
		// XXX dev code below. TBR
		sl.gameStarted(gameName);
		sl.playerChat("Server", "New game started by " + gameName);
		
	}
	
	
	
	public void setServerListener(ServerListener sl) {
		this.sl = sl;
	}
	
}
