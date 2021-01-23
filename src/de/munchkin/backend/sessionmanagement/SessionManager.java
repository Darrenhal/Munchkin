package de.munchkin.backend.sessionmanagement;

import java.util.ArrayList;
import java.util.Collections;

public class SessionManager implements Runnable{
	
	private ArrayList<ClientThread> clients;
	private ClientThread activePlayer;
	
	public SessionManager(ArrayList<ClientThread> clients) {
		
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
