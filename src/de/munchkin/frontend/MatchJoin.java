package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MatchJoin extends JFrame{

	private static final long serialVersionUID = -7919422581409523893L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	
	private JComboBox<String> comboBoxGender;
	private JButton btnJoinGame;
	private JTextField txtPlayerName, txtIPAddress, txtPort;
	private String[] genders = {"male", "female"};
	
	public MatchJoin() {
		
		setTitle("Join Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(screenDim.width / 4, screenDim.height / 4);
		setSize(screenDim.width / 2, screenDim.height / 2);
		setMinimumSize(new Dimension(700, 387));
		
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
		
		
		
	}
	
	private void loadBounds() {
		
		
		
	}
	
	private void addActionListeners() {
		
	}
	
}
