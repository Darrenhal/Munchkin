package de.munchkin.gameobjects;

import java.util.ArrayList;

public class PlayerObject {
	
	private String gender;
	private int level;
	private Class playerClass;
	private Race race;
	private int escapeValue;
	private int[] slotCounts = {2,1,1,1};
	private int strength;
	
	private ArrayList<IGameCard> equipped;
	private ArrayList<IGameCard> hand;
	private ArrayList<IGameCard> backpack;
	public final int PLAYER_IDENTIFIER;
	
	
	public PlayerObject(String gender, int playerIdentifier) {
		
		this.escapeValue = 5;
		this.race = new Race("Human", new int[] {0,0,0,0});
		this.playerClass = new Class(null);
		this.PLAYER_IDENTIFIER = playerIdentifier;
		this.level = 1;
		this.strength = level;
		this.gender = gender;
		equipped = new ArrayList<IGameCard>();
		hand = new ArrayList<IGameCard>();
		backpack = new ArrayList<IGameCard>();
		
	}
	
	public void levelUp(int amount) {
		level += amount;
	}
	
	public void loseLevels(int amount) {
		level -= amount;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void addItemToHand(Item item) {
		
		hand.add(item);
		
	}
	
	public void addItemToBackpack(Item item) {
		
		if (hand.contains(item)) {
			hand.remove(item);
		} else if(equipped.contains(item)){
			equipped.remove(item);
			updateStrength(item.getBonus() * -1);
		}

		backpack.add(item);
		
	}
	
	public void equipItem(Item item) {
		
		if (hand.contains(item)) {
			hand.remove(item);
		} else if(backpack.contains(item)){
			backpack.remove(item);
		}

		equipped.add(item);
		updateStrength(item.getBonus());
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void updateEscapeValue(int escapeValue) {
		this.escapeValue = escapeValue;
	}
	
	public int getEscapeValue() {
		return escapeValue;
	}
	
	public void setRace(Race race) {
		this.race = race;
	}
	
	public Race getRace() {
		return race;
	}
	
	public void setClass(Class playerClass) {
		this.playerClass = playerClass;
	}
	
	public Class getPlayerClass() {
		return playerClass;
	}
	
	private void updateStrength(int itemStrength) {
		this.strength += itemStrength;
	}
	
}
