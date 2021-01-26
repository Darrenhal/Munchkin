package de.munchkin.backend.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import de.munchkin.backend.sessionmanagement.ClientThread;
import de.munchkin.frontend.model.LobbyModel;
import de.munchkin.shared.LobbyUpdate;
import de.munchkin.utilities.LobbyState;

public class ServerController implements Runnable, NetworkController {

	private String hostName, gender;
	private int port;
	private LobbyModel model;

	private boolean waitingOnGameStart;
	private ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	private Socket so;

	public ServerController(String hostName, String gender, int port, LobbyModel model) {

		this.hostName = hostName;
		this.gender = gender;
		this.port = port;
		this.model = model;
		this.waitingOnGameStart = true;
		
	}

	@Override
	public void run() {

//		clients.add(new ClientThread("127.0.0.1", port, null, lobby));
		
		model.addLobbyUpdate(hostName + " created the lobby!");
		model.addLobbyUpdate(hostName + " joined the lobby as a " + gender);

		try {

			ServerSocket ss = new ServerSocket(port);

			while (waitingOnGameStart) {
				so = ss.accept();
				ClientThread client = new ClientThread(so.getInetAddress().getHostAddress(), so.getPort(), so, model);
				clients.add(client);
				new Thread(client).start();
				
				Thread.sleep(100);
				
				client.getOutputStream().writeObject(new LobbyState(model.getPlayerCount(), model.getLobbyHistory()));
				
				Thread.sleep(100);
				
				for(ClientThread c : clients) {
					c.getOutputStream().writeObject(new LobbyUpdate(null, null, model.getPlayerCount(), model.getLobbyHistory(), false, false));
				}
				
			}
			
			ss.close();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getPort() {
		return port;
	}


	public void start() {
		waitingOnGameStart = false;
	}

	@Override
	public void disconnect() {
		try {
			for(ClientThread client : clients) {
				client.getOutputStream().writeObject(new LobbyUpdate(null, null, 0, null, false, true));
			}
			terminateConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void terminateConnection() {
		
		try {
			for(ClientThread client : clients) {
				client.getOutputStream().close();
				client.getInputStream().close();
				client.getSocket().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
