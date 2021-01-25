package de.munchkin.backend.sessionmanagement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.munchkin.frontend.Lobby;
import de.munchkin.shared.LobbyUpdate;

public class ClientThread implements Runnable{

	private String ipAddress;
	private int port;
	private Socket socket;
	private Lobby lobby;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean inLobby;
	private boolean inMatch;

	public ClientThread(String ipAddress, int port, Socket socket, Lobby lobby) {

		this.ipAddress = ipAddress;
		this.port = port;
		this.socket = socket;
		this.lobby = lobby;
		this.inLobby = true;
		this.inMatch = false;
		
	}

	@Override
	public void run() {
		
		lobby.playerJoined();
		
		establishStreams();
		
		while (inLobby) {
			waitForUpdates();
		}
		
		while (inMatch) {
			waitForMatchData();
		}
		
		lobby.playerLeft();
		
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
		
		lobby.addLobbyUpdate(lobbyUpdate);
		
	}
	
	private void waitForMatchData() {
		
	}
	
	private void terminateConnection() {
		
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
