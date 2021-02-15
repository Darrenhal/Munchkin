package de.munchkin.gameobjects;

public class Amplifier implements IGameCard{

	private int packID;
	
	public Amplifier(int packID) {
		
		this.packID = packID;
		
	}
	
	@Override
	public int getPackID() {
		return packID;
	}
	
	@Override
	public String getName() {
		return null;
	}
	
}
