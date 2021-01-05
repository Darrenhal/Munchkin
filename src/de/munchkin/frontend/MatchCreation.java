package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.munchkin.backend.IPValidator;

public class MatchCreation extends JFrame{
	
	private static final long serialVersionUID = 7024906921919000602L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	
	private JComboBox<Integer> comboBoxMinPlayers, comboBoxMaxPlayers;
	private JComboBox<String> comboBoxGender;
	private JButton btnCreateGame;
	private JTextField txtPlayerName, txtIPAddress, txtPort;
	private JCheckBox cbBaseGame, cbExpansion1; //add more expansion checkboxes in the future
	private Integer[] playerCount = {1, 2, 3, 4, 5, 6};
	private String[] genders = {"male", "female"};
	
	public MatchCreation() {
		
		int width = 600;
		int height = 400;
		
		setTitle("Setup Munchkin Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(screenDim.width / 2 - width / 2, screenDim.height / 2 - height / 2);
		setSize(width, height);
		setMinimumSize(new Dimension(700, 387));
		setResizable(false);
		
		contentPane = new JPanel(null);
		contentPane.setLayout(null);
		setLayout(null);
		setContentPane(contentPane);
		contentPane.setBackground(new Color(253, 205, 136));
		
		setVisible(true);
		
		loadComponents();
		loadBounds();
		addActionListeners();
		
	}
	
	private void loadComponents() {
		
		comboBoxMinPlayers = new JComboBox<Integer>(playerCount);
		comboBoxMinPlayers.setSelectedIndex(0);
		
		comboBoxMaxPlayers = new JComboBox<Integer>(playerCount);
		comboBoxMaxPlayers.setSelectedIndex(playerCount.length - 1);
		
		cbBaseGame = new JCheckBox("Base Game");
		cbBaseGame.setSelected(true);
		cbBaseGame.setEnabled(false);
		
		cbExpansion1 = new JCheckBox("Expansion 1");
		cbExpansion1.setSelected(false);
		cbExpansion1.setEnabled(true);
		
		btnCreateGame = new JButton("Create Game");
		
		txtPlayerName = new JTextField();
		
		txtIPAddress = new JTextField();
		txtPort = new JTextField();
		
		comboBoxGender = new JComboBox<String>(genders);
		comboBoxGender.setSelectedIndex(0);
		
		JLabel lblIPAddress = new JLabel("IP Address: ");
		lblIPAddress.setBounds(20, 200, 100, 20);
		contentPane.add(lblIPAddress);
		
		txtIPAddress = new JTextField();
		
		JLabel lblPort = new JLabel("Port: ");
		lblPort.setBounds(20, 240, 100, 20);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		
	}
	
	private void loadBounds() {
		
		JLabel lblMinPlayers = new JLabel("Min. Players:");
		lblMinPlayers.setBounds(getWidth() - 300, 20, 100, 20);
		contentPane.add(lblMinPlayers);
		
		comboBoxMinPlayers.setBounds(getWidth() - 200, 20, 175, 20);
		contentPane.add(comboBoxMinPlayers);
		
		JLabel lblMaxPlayers = new JLabel("Max. Players:");
		lblMaxPlayers.setBounds(getWidth() - 300, 60, 100, 20);
		contentPane.add(lblMaxPlayers);
		
		comboBoxMaxPlayers.setBounds(getWidth() - 200, 60, 175, 20);
		contentPane.add(comboBoxMaxPlayers);
		
		cbBaseGame.setBounds(getWidth() - 200, 100, 175, 20);
		contentPane.add(cbBaseGame);
		
		cbExpansion1.setBounds(getWidth() - 200, 120, 175, 20);
		contentPane.add(cbExpansion1);
		
		btnCreateGame.setBounds(20, getHeight() - 100, 200, 40);
		contentPane.add(btnCreateGame);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setBounds(20, 20, 80, 20);
		contentPane.add(lblPlayerName);
		
		txtPlayerName.setBounds(100, 20, 100, 20);
		contentPane.add(txtPlayerName);
		
		comboBoxGender.setBounds(20, 60, 180, 20);
		contentPane.add(comboBoxGender);
		
		txtIPAddress.setBounds(100, 200, 100, 20);
		contentPane.add(txtIPAddress);
		
		txtPort.setBounds(100, 240, 100, 20);
		contentPane.add(txtPort);
		
	}
	
	private void addActionListeners() {
		
		btnCreateGame.addActionListener(e -> {
			
			String playerName = txtPlayerName.getText();
			
			int minPlayers = (int) comboBoxMinPlayers.getSelectedItem();
			int maxPlayers = (int) comboBoxMaxPlayers.getSelectedItem();
			
			String ipAddress = txtIPAddress.getText();
			String port = txtPort.getText();
			
			IPValidator validator = new IPValidator();
			
			if (playerName.equals("") || playerName == null) {
				JOptionPane.showMessageDialog(null, "No Player Name set!", "Player Name Error", JOptionPane.ERROR_MESSAGE);
			} else if(minPlayers > maxPlayers) {
				JOptionPane.showMessageDialog(null, "Player Count not set correctly!", "Player Count Error", JOptionPane.ERROR_MESSAGE);
			} else if(minPlayers > maxPlayers) {
				JOptionPane.showMessageDialog(null, "Player Count not set correctly!", "Player Count Error", JOptionPane.ERROR_MESSAGE);
			} else if (!port.matches("(0-9)*")) {
				JOptionPane.showMessageDialog(null, "Wrong Port Format", "Port Error", JOptionPane.ERROR_MESSAGE);
			} else if (!validator.validateIP(ipAddress)) {
				JOptionPane.showMessageDialog(null, "Wrong IP Format", "IP Error", JOptionPane.ERROR_MESSAGE);
			} else {
				new Lobby(0);
				dispose();
			}
			
		});
		
	}
	
}
