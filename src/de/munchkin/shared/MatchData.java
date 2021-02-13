package de.munchkin.shared;

import java.io.Serializable;

public class MatchData implements Serializable{

	private static final long serialVersionUID = -1990329349781848524L;
	
	boolean activeTurn;
	int discardableCards;
	
	
	public MatchData(boolean activeTurn, int discardableCards) {
		
		this.activeTurn = activeTurn;
		this.discardableCards = discardableCards;
		
	}
	
	
	
}
