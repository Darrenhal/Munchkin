package de.munchkin.backend;

import java.util.ArrayList;
import java.util.Collections;

public class SessionManager implements Runnable{
	
	private ArrayList<Client> clients;
	
	public SessionManager(ArrayList<Client> clients) {
		
		this.clients = clients;
		Collections.shuffle(this.clients);
		
	}
	
	@Override
	public void run() {
		
	}
	
	public void endTurn() {
		
	}
	
}
