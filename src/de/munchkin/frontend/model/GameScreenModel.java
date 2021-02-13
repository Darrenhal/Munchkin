package de.munchkin.frontend.model;

import java.util.ArrayList;
import java.util.Collections;

import de.munchkin.gameobjects.IGameCard;

public class GameScreenModel {
	
	private ArrayList<IGameCard> doors;
	private ArrayList<IGameCard> treasures;
	
	private ArrayList<IGameCard> doorsDiscardPile;
	private ArrayList<IGameCard> treasuresDiscardPile;
	
	public GameScreenModel() {
		
		
		
	}
	
	public IGameCard getDoor() {
		
		if (doors.size() == 0) {
			Collections.shuffle(doorsDiscardPile);
			doors = doorsDiscardPile;
			doorsDiscardPile = new ArrayList<IGameCard>();
		}
		
		IGameCard door = doors.get(0);
		doors.remove(0);
		
		return door;
		
	}
	
	public ArrayList<IGameCard> getTreasures(int amount) {
		
		ArrayList<IGameCard> treasures = new ArrayList<IGameCard>();
		
		if (this.treasures.size() == 0) {

			Collections.shuffle(treasuresDiscardPile);
			doors = treasuresDiscardPile;
			treasuresDiscardPile = new ArrayList<IGameCard>();
			
		}
		
		for(int i = 0; i < amount; i++) {
			treasures.add(this.treasures.get(0));
			this.treasures.remove(0);
		}
		
		return treasures;
		
	}
	
}
