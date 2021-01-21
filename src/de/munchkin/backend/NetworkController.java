package de.munchkin.backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import de.munchkin.frontend.Lobby;

public class NetworkController implements Runnable {

	private String ipAddress;
	private int port;
	private boolean isServer;
	private Lobby lobby;
	
	private boolean waitingOnGameStart;
	private int playerID;
	private ArrayList<Client> clients = new ArrayList<Client>();
	private Socket so;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public NetworkController(String ipAddress, int port, boolean isServer, Lobby lobby) {
		
		this.ipAddress = ipAddress;
		this.port = port;
		this.isServer = isServer;
		this.lobby = lobby;
		
	}
	
	@Override
	public void run() {
		
		if (isServer) {
			
			clients.add(new Client("127.0.0.1", port, null, lobby));
			
			try {
				ServerSocket ss = new ServerSocket(port);
				
				while (waitingOnGameStart) {
					so = ss.accept();
					clients.add(new Client(so.getInetAddress().getHostAddress(), so.getPort(), so, lobby));
				}
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			
			try {
				so = new Socket(ipAddress, port);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
	
	public Object receive() {
		
		try {
			return in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void start() {
		waitingOnGameStart = false;
	}
	
}
