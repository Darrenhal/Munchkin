package de.munchkin.gameobjects;

import java.util.ArrayList;

public class PlayerObject {
	
	private String gender;
	private int level;
	private ArrayList<IGameCard> inventory;
	private ArrayList<IGameCard> Backpack;
	
	
	public PlayerObject() {
		
		
		
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
	
	
	
}
