package de.munchkin.backend.loading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import de.munchkin.gameobjects.IGameCard;
import de.munchkin.gameobjects.Item;
import de.munchkin.gameobjects.Monster;
import de.munchkin.gameobjects.Race;
import de.munchkin.gameobjects.Slot;
import de.munchkin.gameobjects.Class;

public class CardLoader {

	private ArrayList<IGameCard> gameCards;
	private ArrayList<IGameCard> doors;
	private ArrayList<IGameCard> treasures;

	public CardLoader() {

	}

	public void loadBaseGame() {
		
		loadFile("BaseGame.csv");

	}

	public void loadExpansionPack(int expansionPack) {
		
		loadFile("Expansion" + expansionPack + ".csv");
		
	}

	public void unloadExpansionPack(int packID) {
		
		for(IGameCard card : doors) {
			if (card.getPackID() == packID) {
				doors.remove(card);
			}
		}
		
		for(IGameCard card : treasures) {
			if (card.getPackID() == packID) {
				treasures.remove(card);
			}
		}
		
		for(IGameCard card : gameCards) {
			if (card.getPackID() == packID) {
				gameCards.remove(card);
			}
		}
		
	}
	
	private void loadFile(String resource) {
		try {
			InputStream in = getClass().getResourceAsStream(resource);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {

				String[] specs = line.split(";");
				
				String cardType = specs[1];
				int packID = new Integer(specs[0]);

				switch (specs[2]) {
				case "Monster":
					appendCard(new Monster(specs[4], new Integer(specs[3]), specs[5], specs[11], packID), cardType);
					break;

				case "Item":
					appendCard(new Item(Slot.ARMOR, packID), cardType);
					break;

				case "Class":
					appendCard(new Class(specs[4], packID), cardType);
					break;

				case "Race":
					appendCard(new Race(specs[4], packID), cardType);
					break;

				default:
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void appendCard(IGameCard card, String cardType) {
		switch (cardType) {
		case "Door":
			doors.add(card);
			break;

		case "Treasure":
			treasures.add(card);
			break;

		default:
			break;
		}
	}
	
	public ArrayList<IGameCard> getGameCards() {
		return gameCards;
	}

	public ArrayList<IGameCard> getDoors() {
		return doors;
	}

	public ArrayList<IGameCard> getTreasures() {
		return treasures;
	}

}
