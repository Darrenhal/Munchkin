package de.munchkin.frontend.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import de.munchkin.keybindings.EnterFullscreen;
import de.munchkin.keybindings.KeyBindings;

public class GameScreen extends JFrame{

	private static final long serialVersionUID = 6191720921815333067L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	
	private final JPanel contentPane = new JPanel(null);;
	private final JButton btn = new JButton("Button");
	
	public GameScreen(Integer windowState, Image image, Boolean isHost) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Munchkin");
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(screenDim);
		
		setIconImage(image);
		
		if (windowState == 1) {
			setUndecorated(true);
		} else {
			setUndecorated(false);
		}
		setResizable(true);
		
		contentPane.setLayout(null);
		setLayout(null);
		contentPane.getInputMap(KeyBindings.AFC).put(KeyStroke.getKeyStroke("F11"), "game_fullscreen");
		contentPane.getActionMap().put("game_fullscreen", new EnterFullscreen(this, isHost, null, null));
		contentPane.setBackground(new Color(253, 205, 136));
		setContentPane(contentPane);
		
		loadBounds();
		addActionListeners();
		
		setVisible(true);
		
	}
	
	private void loadBounds() {
		
		contentPane.setSize(getSize());
		
		btn.setBounds(40, 40, 100, 20);
		contentPane.add(btn);
		
	}
	
	private void addActionListeners() {
		
		
		
	}
	
}
