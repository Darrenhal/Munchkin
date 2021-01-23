package de.munchkin.backend.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.munchkin.frontend.Lobby;
import de.munchkin.shared.LobbyUpdate;

public class ClientController implements Runnable {

	private String ipAddress;
	private int port;
	private Lobby lobby;
	private String playerName;
	private String gender;
	
	private Socket so;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ClientController(String ipAddress, int port, Lobby lobby, String playerName, String gender) {
		
		this.ipAddress = ipAddress;
		this.port = port;
		this.lobby = lobby;
		this.playerName = playerName;
		this.gender = gender;
		
	}
	
	@Override
	public void run() {
		
		try {
			
			so = new Socket(ipAddress, port);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		establishStreams();
		
		communicatePlayerInfo();
		
	}
	
	private void establishStreams() {
		
		try {
			
			out = new ObjectOutputStream(so.getOutputStream());
			in = new ObjectInputStream(so.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getIPAddress() {
		return ipAddress;
	}
	
	public int getPort() {
		return port;
	}
	
	public void send(Object object) {
		
		try {
			out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void communicatePlayerInfo() {
		
		try {
			out.writeObject(new LobbyUpdate(playerName, gender, 0, null, false, false));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void waitForInput() {
		
		
		
	}
	
	public void disconnect() {
		
		try {
			out.writeObject(new LobbyUpdate(playerName, gender, 0, null, false, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
