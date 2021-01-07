package de.munchkin.utilities;

import java.util.ArrayList;

public class LobbyState {

	private int playerCount = 0;
	private ArrayList<String> lobbyHistory;
	
	public LobbyState(int playerCount, ArrayList<String> lobbyHistory) {
		
		this.playerCount = playerCount;
		this.lobbyHistory = lobbyHistory;
		
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public ArrayList<String> getLobbyHistory() {
		return lobbyHistory;
	}
	
}
