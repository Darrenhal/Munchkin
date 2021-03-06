package de.munchkin.shared;

import java.io.Serializable;

import javafx.util.Pair;

public class LobbyUpdate implements Serializable{
	
	private static final long serialVersionUID = 4006602632781476202L;
	
	private int playerCount;
	private String lobbyHistoryUpdate;
	private boolean startMatch;
	private String playerName;
	private String gender;
	private boolean disconnecting;
	private Pair<Pair<Integer, Boolean>, String> expansionPack;
	
	public LobbyUpdate(String playerName, String gender, int playerCount, String lobbyHistoryUpdate, boolean startMatch, boolean disconnecting, Pair<Pair<Integer, Boolean>, String> expansionPacks) {
		
		this.playerName = playerName;
		this.gender = gender;
		this.playerCount = playerCount;
		this.lobbyHistoryUpdate = lobbyHistoryUpdate;
		this.startMatch = startMatch;
		this.disconnecting = disconnecting;
		this.expansionPack = expansionPacks;
		
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public String getLobbyHistoryUpdate() {
		return lobbyHistoryUpdate;
	}
	
	public boolean getStartMatch() {
		return startMatch;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public boolean getDisconnecting() {
		return disconnecting;
	}
	
	public Pair<Pair<Integer, Boolean>, String> getExpansionPackUpdate() {
		return expansionPack;
	}
	
}
