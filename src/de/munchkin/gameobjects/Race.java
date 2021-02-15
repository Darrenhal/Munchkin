package de.munchkin.gameobjects;

public class Race implements IGameCard {

	private String raceName;
	private int packID;
	private int[] additionalSlotCounts;

	public Race(String raceName, int packID) {
		int[] additionalSlots = new int[]{0, 0, 0, 0};

		switch (raceName) {
		case "Human":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Elf":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Dwarf":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Halfling":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Orc":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Gnome":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Centaur":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		case "Lizardman":
			additionalSlots = new int[]{0, 0, 0, 0};
			break;

		default:
			break;
		}

		new Race(raceName, additionalSlots, packID);
	}

	private Race(String raceName, int[] additionalSlotCounts, int packID) {

		this.raceName = raceName;
		this.additionalSlotCounts = additionalSlotCounts;
		this.packID = packID;

	}

	@Override
	public int getPackID() {
		return packID;
	}
	
	public String getName() {
		return raceName;
	}

	public int[] getAdditionalSlotCounts() {
		return additionalSlotCounts;
	}

}
