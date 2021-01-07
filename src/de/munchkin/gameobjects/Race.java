package de.munchkin.gameobjects;

public class Race implements IGameCard{

	private String raceName;
	private int[] additionalSlotCounts;
	
	public Race(String raceName, int[] additionalSlotCounts) {
		
		this.raceName = raceName;
		this.additionalSlotCounts = additionalSlotCounts;
		
	}
	
	public String getRaceName() {
		return raceName;
	}
	
	public int[] getAdditionalSlotCounts() {
		return additionalSlotCounts;
	}
	
}
