package de.munchkin.utilities;

import java.io.Serializable;

public class LobbyState implements Serializable{

	private static final long serialVersionUID = -73671352531301967L;
	
	private int playerCount = 0;
	private String lobbyHistory;
	
	public LobbyState(int playerCount, String lobbyHistory) {
		
		this.playerCount = playerCount;
		this.lobbyHistory = lobbyHistory;
		
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public String getLobbyHistory() {
		return lobbyHistory;
	}
	
}
