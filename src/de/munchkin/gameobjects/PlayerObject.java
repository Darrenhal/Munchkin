package de.munchkin.gameobjects;

import java.util.ArrayList;

public class PlayerObject {
	
	private String gender;
	private int level;
	private ArrayList<IGameCard> equipped;
	private ArrayList<IGameCard> hand;
	private ArrayList<IGameCard> backpack;
	public final int PLAYER_IDENTIFIER;
	
	
	public PlayerObject(String gender, int playerIdentifier) {
		
		this.PLAYER_IDENTIFIER = playerIdentifier;
		this.level = 1;
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
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getGender() {
		return gender;
	}
	
}
