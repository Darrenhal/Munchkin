package de.munchkin.shared;

import java.io.Serializable;

public class MatchData implements Serializable{

	private static final long serialVersionUID = -1990329349781848524L;
	
	private boolean activeTurn;
	private String playerName;
	private int discardableCards;
	
	
	public MatchData(boolean activeTurn, String playerName, int discardableCards) {
		
		this.activeTurn = activeTurn;
		this.discardableCards = discardableCards;
		
	}
	
	public boolean getActiveTurn() {
		return activeTurn;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getDiscardableCards() {
		return discardableCards;
	}
	
}
