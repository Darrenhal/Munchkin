package de.munchkin.frontend.model;

import de.munchkin.frontend.view.Lobby;

public class LobbyModel {
	
	private int playerCount;
	private String lobbyHistory;
	private Lobby lobby;
	
	public LobbyModel(int playerCount, String lobbyHistory) {
		
		this.playerCount = playerCount;
		this.lobbyHistory = lobbyHistory;
		
	}
	
	public void playerJoined() {
		playerCount++;
		lobby.updatePlayerCount(playerCount);
	}
	
	public void playerLeft() {
		playerCount--;
		lobby.updatePlayerCount(playerCount);
	}
	
	public void addLobbyUpdate(String update) {

		lobbyHistory += update + "\n";
		lobby.addLobbyUpdate(lobbyHistory);

	}
	
	public void setLobbyHistory(String lobbyHistory) {
		
		this.lobbyHistory = lobbyHistory;
		lobby.addLobbyUpdate(lobbyHistory);
		
	}
	
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
		lobby.updatePlayerCount(playerCount);
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public String getLobbyHistory() {
		return lobbyHistory;
	}
	
	public void updateReferencedUI(Lobby lobby) {
		this.lobby = lobby;
	}
	
}
