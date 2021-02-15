package de.munchkin.gameobjects;

public class Item implements IGameCard {
	
	private int value;
	private String itemName;
	private String description;
	private int bonus;
	private Slot slot;
	private int packID;
	
	public Item(Slot slot, int packID) {
		
		this.slot = slot;
		this.packID = packID;
		
	}

	public void updateBonus() {
		bonus = bonus; 			//Logik für Bonus-Update ausdenken
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public int getPackID() {
		return packID;
	}
	
	public String getName() {
		return itemName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBonus() {
		return bonus;
	}
	
}
