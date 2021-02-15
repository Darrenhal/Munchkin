package de.munchkin.gameobjects;

public class Class implements IGameCard {

	private String className;
	private int packID;
	
	public Class(String className, int packID) {
		
		this.className = className;
		this.packID = packID;
		
	}
	
	@Override
	public int getPackID() {
		return packID;
	}
	
	@Override
	public String getName() {
		return className;
	}
	
}
