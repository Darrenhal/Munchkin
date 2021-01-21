package de.munchkin.backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.munchkin.frontend.Lobby;

public class Client implements Runnable{

	private String ipAddress;
	private int port;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public Client(String ipAddress, int port, Socket socket, Lobby lobby) {

		this.ipAddress = ipAddress;
		this.port = port;
		this.socket = socket;

	}

	@Override
	public void run() {
		
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

	public ObjectInputStream getInputStream() {

		if (in == null) {

			try {
				in = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return in;
	}

	public ObjectOutputStream getOutputStream() {

		if (out == null) {

			try {
				out = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return out;
	}

}
