package de.munchkin.backend.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.munchkin.frontend.model.GameScreenModel;
import de.munchkin.frontend.model.LobbyModel;
import de.munchkin.frontend.view.GameScreen;
import de.munchkin.shared.LobbyUpdate;
import de.munchkin.utilities.LobbyState;

public class ClientController implements Runnable, NetworkController {

	private String ipAddress;
	private int port;
	private LobbyModel model;
	private String playerName;
	private String gender;
	
	private boolean connected;
	
	private Socket so;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ClientController(String ipAddress, int port, LobbyModel model, String playerName, String gender) {
		
		this.ipAddress = ipAddress;
		this.port = port;
		this.model = model;
		this.playerName = playerName;
		this.gender = gender;
		this.connected = true;
		
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
		
		receiveLobbyState();
		
		while (connected) {
			waitForInput();
		}
		
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
	
	private void receiveLobbyState() {
		
		LobbyState state = null;
		
		try {
			state = (LobbyState)in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		model.addLobbyUpdate(state.getLobbyHistory());
		model.setPlayerCount(state.getPlayerCount());
		
	}
	
	private void waitForInput() {
		LobbyUpdate update = null;
		try {
			update = (LobbyUpdate)in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		if (update.getDisconnecting()) {
			connected = false;
			try {
				in.close();
				out.close();
				so.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else if (update.getStartMatch()) {
			new GameScreenModel();
			new GameScreen(0, model.getIconImage(), false);
			model.startMatch();
		} else {
			model.setPlayerCount(update.getPlayerCount());
			model.setLobbyHistory(update.getLobbyHistoryUpdate());
		}
		
	}
	
	@Override
	public void disconnect() {
		
		try {
			out.writeObject(new LobbyUpdate(playerName, gender, 0, null, false, true));
			connected = false;
			terminateConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private void terminateConnection() {
		
		try {
			out.close();
			in.close();
			so.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
