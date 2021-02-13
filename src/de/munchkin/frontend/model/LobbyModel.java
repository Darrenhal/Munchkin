package de.munchkin.frontend.model;

import java.awt.Image;

import de.munchkin.frontend.view.Lobby;

public class LobbyModel {
	
	private int playerCount;
	private String lobbyHistory;
	private Lobby lobby;
	private int minPlayers;
	private int maxPlayers;
	
	public LobbyModel(int playerCount, String lobbyHistory, int minPlayers, int maxPlayers) {
		
		this.playerCount = playerCount;
		this.lobbyHistory = lobbyHistory;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		
	}
	
	public void playerJoined() {
		playerCount++;
		lobby.updatePlayerCount(playerCount);
		checkPlayerCount();
	}
	
	public void playerLeft() {
		playerCount--;
		lobby.updatePlayerCount(playerCount);
		checkPlayerCount();
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
	
	public void startMatch() {
		lobby.dispose();
	}
	
	public Image getIconImage() {
		return lobby.getIconImage();
	}
	
	public void checkPlayerCount() {
		if (playerCount <= maxPlayers && playerCount >= minPlayers) {
			lobby.enableGameStart(true);
		} else {
			lobby.enableGameStart(false);
		}
	}
	
}
