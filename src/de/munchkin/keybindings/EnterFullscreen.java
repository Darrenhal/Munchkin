package de.munchkin.keybindings;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class EnterFullscreen extends AbstractAction{

	private static final long serialVersionUID = 1773898497666165938L;
	
	private JFrame frame;
	private Class<?> frameType;
	private Constructor<?> c;
	
	public EnterFullscreen(JFrame frame) {
		
		this.frame = frame;
		
		try {
			frameType = frame.getClass();
			c = frameType.getConstructor(Integer.class, Image.class);
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			frame.setVisible(false);
			if (frame.isUndecorated()) {
				c.newInstance(0, frame.getIconImage());
			} else {
				c.newInstance(1, frame.getIconImage());
			}

			frame.dispose();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
