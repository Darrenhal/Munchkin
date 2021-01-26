package de.munchkin.frontend.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import de.munchkin.backend.networking.NetworkController;
import de.munchkin.frontend.model.LobbyModel;
import de.munchkin.keybindings.EnterFullscreen;
import de.munchkin.keybindings.KeyBindings;

public class Lobby extends JFrame {

	private static final long serialVersionUID = 4590660629277661996L;

	private final Toolkit toolkit = Toolkit.getDefaultToolkit();
	private final Dimension screenDim = toolkit.getScreenSize();
	
	private boolean isHost;
	private LobbyModel model;
	private NetworkController controller;
	
	private final JPanel contentPane = new JPanel(null);
	private final JButton btnStartMatch = new JButton("Start Match");
	private final JTextArea txtLobbyHistory = new JTextArea();
	private final JLabel lblPlayerCount = new JLabel("" + 1);;
	private final JLabel lblPlayers = new JLabel("Players:");

	public Lobby(Integer windowState, Image image, Boolean isHost, LobbyModel model, NetworkController controller) {
		
		this.isHost = isHost;
		this.model = model;
		this.controller = controller;
		model.updateReferencedUI(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lobby");
		setExtendedState(MAXIMIZED_BOTH);
		setSize(screenDim);
		setMinimumSize(new Dimension(800, 400));

		setIconImage(image);
		
		if (windowState == 1) {
			setUndecorated(true);
		} else {
			setUndecorated(false);
		}
		setResizable(true);

		contentPane.setLayout(null);
		setLayout(null);
		contentPane.getInputMap(KeyBindings.AFC).put(KeyStroke.getKeyStroke("F11"), "lobby_fullscreen");
		contentPane.getActionMap().put("lobby_fullscreen", new EnterFullscreen(this, this.isHost, model, controller));
		contentPane.setBackground(new Color(253, 205, 136));
		setContentPane(contentPane);

		loadComponents();
		loadBounds();
		addActionListeners();

		lblPlayerCount.setText("" + model.getPlayerCount());
		txtLobbyHistory.setText(model.getLobbyHistory());
		
		setVisible(true);

	}

	private void loadComponents() {
		
		contentPane.add(txtLobbyHistory);
		
		if (isHost) {
			contentPane.add(btnStartMatch);
			if (model.getPlayerCount() < 6) {
				
			}
		}

		
		contentPane.add(lblPlayerCount);
		contentPane.add(lblPlayers);
		
	}
	
	void loadBounds() {
		
		contentPane.setSize(getSize());

		txtLobbyHistory.setBounds(getWidth() - (getWidth() / 4 + 40), 20, getWidth() / 4,
				contentPane.getHeight() - 120);
		txtLobbyHistory.setEditable(false);

		if (isHost) {
			btnStartMatch.setBounds(20, getHeight() - 120, 150, 50);
		}
		
		lblPlayerCount.setBounds(100, 20, 50, 20);
		
		lblPlayers.setBounds(20, 20, 80, 20);
	}

	private void addActionListeners() {

		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				loadBounds();
			}
			
		});
		
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				loadBounds();
			}
			
		});
		
		if (isHost) {
			btnStartMatch.addActionListener(e -> {

				new GameScreen(0, getIconImage(), isHost);
				dispose();

			});
		}

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				controller.disconnect();
				
			}
			
		});
		
	}

	public void addLobbyUpdate(String update) {

		txtLobbyHistory.setText(update);;

	}

	public void updatePlayerCount(int playerCount) {
		lblPlayerCount.setText("" + playerCount);
		repaint();
	}
	
}