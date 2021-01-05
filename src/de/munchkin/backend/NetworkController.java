package de.munchkin.backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class NetworkController implements Runnable {

	private String ipAddress;
	private int port;
	private boolean isServer;
	private boolean waitingOnGameStart;
	private int playerID;
	private ArrayList<Client> clients;
	private Socket so;
	
	public NetworkController(String ipAddress, int port, boolean isServer) {
		
		this.ipAddress = ipAddress;
		this.port = port;
		this.isServer = isServer;
		
	}
	
	@Override
	public void run() {
		
		if (isServer) {
			
			clients.add(new Client("127.0.0.1", port));
			
			try {
				ServerSocket ss = new ServerSocket(port);
				
				while (waitingOnGameStart) {
					so = ss.accept();
					clients.add(new Client(so.getInetAddress().getHostAddress(), so.getPort()));
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
	
	public String getIPAddress() {
		return ipAddress;
	}
	
	public int getPort() {
		return port;
	}
	
}
