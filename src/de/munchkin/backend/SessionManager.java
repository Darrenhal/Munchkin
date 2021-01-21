package de.munchkin.backend;

import java.util.ArrayList;
import java.util.Collections;

public class SessionManager implements Runnable{
	
	private ArrayList<Client> clients;
	private Client activePlayer;
	
	public SessionManager(ArrayList<Client> clients) {
		
		this.clients = clients;
		Collections.shuffle(this.clients);
		
	}
	
	@Override
	public void run() {
		
	}
	
	public void endTurn() {
		int activePlayerIndex = clients.indexOf(this.activePlayer);
		
		if (activePlayerIndex == clients.size() - 1) {
			activePlayer = clients.get(0);
		} else {
			activePlayer = clients.get(activePlayerIndex + 1);
		}
		
	}
	
}
