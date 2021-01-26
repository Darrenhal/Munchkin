package de.munchkin.keybindings;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import de.munchkin.backend.networking.NetworkController;
import de.munchkin.frontend.model.LobbyModel;
import de.munchkin.frontend.view.Lobby;

public class EnterFullscreen extends AbstractAction{

	private static final long serialVersionUID = 1773898497666165938L;
	
	private JFrame frame;
	private boolean isHost;
	private LobbyModel model;
	private NetworkController controller;
	private Class<?> frameType;
	private Constructor<?> c;
	
	public EnterFullscreen(JFrame frame, boolean isHost, LobbyModel model, NetworkController controller) {
		
		this.frame = frame;
		this.isHost = isHost;
		this.model = model;
		this.controller = controller;
		
		try {
			frameType = frame.getClass();
			if (frameType.equals(Lobby.class)) {
				c = frameType.getConstructor(Integer.class, Image.class, Boolean.class, LobbyModel.class, NetworkController.class);	
			} else {
				c = frameType.getConstructor(Integer.class, Image.class, Boolean.class);	
			}
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			frame.setVisible(false);
			if (frame.isUndecorated()) {
				if (frameType.equals(Lobby.class)) {
					c.newInstance(0, frame.getIconImage(), isHost, model, controller);
				} else {
					c.newInstance(0, frame.getIconImage(), isHost);
				}
			} else {
				if (frameType.equals(Lobby.class)) {
					c.newInstance(1, frame.getIconImage(), isHost, model, controller);
				} else {
					c.newInstance(1, frame.getIconImage(), isHost);
				}
			}

			frame.dispose();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
