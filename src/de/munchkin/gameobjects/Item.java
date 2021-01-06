package de.munchkin.gameobjects;

public class Item implements IGameCard {
	
	private int value;
	private String itemName;
	private String description;
	private int bonus;
	private Slot slot;
	
	public Item(Slot slot) {
		
		this.slot = slot;
		
	}

	public void updateBonus() {
		bonus = bonus; 			//Logik für Bonus-Update ausdenken
	}
	
	public int getValue() {
		return value;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBonus() {
		return bonus;
	}
	
}
