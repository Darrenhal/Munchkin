package de.munchkin.backend.sessionmanagement;

import java.util.ArrayList;
import java.util.Collections;

import de.munchkin.backend.loading.CardLoader;
import de.munchkin.gameobjects.IGameCard;

public class GameData {
	
	private ArrayList<IGameCard> doors;
	private ArrayList<IGameCard> treasures;
	
	private ArrayList<IGameCard> doorsDiscardPile;
	private ArrayList<IGameCard> treasuresDiscardPile;
	
	public GameData() {
		
		CardLoader loader = new CardLoader();
		loader.loadBaseGame();
		
		
	}
	
	public IGameCard getDoor() {
		
		//if door stack empty, shuffle discarded doors
		if (doors.size() == 0) {
			Collections.shuffle(doorsDiscardPile);
			doors = doorsDiscardPile;
			doorsDiscardPile = new ArrayList<IGameCard>();
		}
		
		//get topmost door
		IGameCard door = doors.get(0);
		doors.remove(0);
		
		return door;
		
	}
	
	public ArrayList<IGameCard> getTreasures(int amount) {
		
		ArrayList<IGameCard> treasures = new ArrayList<IGameCard>();
		
		//if treasure stack empty, shuffle discarded treasures
		if (this.treasures.size() == 0) {
			Collections.shuffle(treasuresDiscardPile);
			doors = treasuresDiscardPile;
			treasuresDiscardPile = new ArrayList<IGameCard>();
		}
		
		//get i treasures from the stack
		for(int i = 0; i < amount; i++) {
			treasures.add(this.treasures.get(0));
			this.treasures.remove(0);
		}
		
		return treasures;
		
	}
	
}
