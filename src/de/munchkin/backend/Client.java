package de.munchkin.backend;

public class Client {
	
	private String ipAddress;
	private int port;
	
	public Client(String ipAddress, int port) {
		
		this.ipAddress = ipAddress;
		this.port = port;
		
	}
	
	public String getIPAddress() {
		return ipAddress;
	}
	
	public int getPort() {
		return port;
	}
	
}
