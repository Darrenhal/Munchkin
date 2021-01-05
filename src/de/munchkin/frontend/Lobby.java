package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Lobby extends JFrame{

	private static final long serialVersionUID = 4590660629277661996L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	
	private JTextArea txtLobbyHistory;
	
	public Lobby(int windowState) {
		
		setTitle("Lobby");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(screenDim);
		
		if (windowState == 1) {
			setUndecorated(true);
		} else {
			setUndecorated(false);
		}
		setResizable(true);
		
		contentPane = new JPanel(null);
		contentPane.setLayout(null);
		setLayout(null);
		setContentPane(contentPane);
		contentPane.setBackground(new Color(253, 205, 136));
		
		setVisible(true);
		
		loadComponents();
		loadBounds();
		addActionListeners();
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyTyped(e);
				if (e.getKeyCode() == KeyEvent.VK_F11) {
					setVisible(false);
					if (isUndecorated()) {
						new Lobby(0);
					} else {
						new Lobby(1);
					}

					dispose();
				}
			}
			
		});
		
	}
	
	private void loadComponents() {
		
		txtLobbyHistory = new JTextArea();
		txtLobbyHistory.setEnabled(false);
		
	}
	
	private void loadBounds() {
		
		txtLobbyHistory.setBounds(getWidth() - (getWidth() / 4 + 40), 20, getWidth() / 4, contentPane.getHeight() - 60);
		contentPane.add(txtLobbyHistory);
		
	}
	
	private void addActionListeners() {
		

		
	}
	
	public void addLobbyUpdate(String update) {
		
		txtLobbyHistory.append(update + "\n");
		
	}
	
}