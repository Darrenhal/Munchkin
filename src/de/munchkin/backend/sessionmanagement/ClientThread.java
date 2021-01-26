package de.munchkin.backend.sessionmanagement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.munchkin.frontend.model.LobbyModel;
import de.munchkin.shared.LobbyUpdate;

public class ClientThread implements Runnable{

	private String ipAddress;
	private int port;
	private Socket socket;
	private LobbyModel model;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean inLobby;
	private boolean inMatch;

	public ClientThread(String ipAddress, int port, Socket socket, LobbyModel model) {

		this.ipAddress = ipAddress;
		this.port = port;
		this.socket = socket;
		this.model = model;
		this.inLobby = true;
		this.inMatch = false;
		
	}

	@Override
	public void run() {
		
		model.playerJoined();
		
		establishStreams();
		
		while (inLobby) {
			waitForUpdates();
		}
		
		while (inMatch) {
			waitForMatchData();
		}
		
		model.playerLeft();
		
		terminateConnection();
		
	}
	
	public String getIPAddress() {
		return ipAddress;
	}

	public int getPort() {
		return port;
	}

	public Socket getSocket() {
		return socket;
	}

	private void establishStreams() {
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ObjectInputStream getInputStream() {
		return in;
	}

	public ObjectOutputStream getOutputStream() {
		return out;
	}

	private void waitForUpdates() {
		LobbyUpdate update = null;
		
		try {
			update = (LobbyUpdate) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		String lobbyUpdate;
		
		if (update.getDisconnecting()) {
			inLobby = false;
			lobbyUpdate = update.getPlayerName() + " left the lobby";
		} else {
			lobbyUpdate = update.getPlayerName() + " joined the lobby as a " + update.getGender();
		}
		
		model.addLobbyUpdate(lobbyUpdate);
		
	}
	
	private void waitForMatchData() {
		
	}
	
	private void terminateConnection() {
		
		try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
