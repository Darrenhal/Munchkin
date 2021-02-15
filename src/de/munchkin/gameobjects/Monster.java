package de.munchkin.gameobjects;

public class Monster implements IGameCard {
	
	private String name;
	private int level;
	private String description;
	private String badThings;
	private int packID;
	
	public Monster(String name, int level, String description, String badThings, int packID) {
		
		this.name = name;
		this.level = level;
		this.description = description;
		this.badThings = badThings;
		
	}
	
	@Override
	public int getPackID() {
		return packID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getBadThings() {
		return badThings;
	}
	
}
