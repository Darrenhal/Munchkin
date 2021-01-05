package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.munchkin.utilities.JPictureBox;

public class MunchkinLauncher extends JFrame{

	private static final long serialVersionUID = 1598309638008663371L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	private JButton btnHostGame, btnJoinGame;
	
	
	public static void main(String[] args) {
		MunchkinLauncher launcher = new MunchkinLauncher();
	}
	
	public MunchkinLauncher() {
		setTitle("Munchkin Launcher");
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
		addActionListeners();

	}
	
	private void loadComponents() {
		
		int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
		
		// Load header image
//		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("resources/Munchkin_logo.jpg"));
//		
//		JLabel imageLabel = new JLabel(image);
//		imageLabel.setVisible(true);
//		imageLabel.setBounds(200, 50, 620, 210);
//		contentPane.add(imageLabel);
		
		
		btnHostGame = new JButton("Host Game");
		btnHostGame.setBounds(50, 210, 250, 100);
		contentPane.add(btnHostGame);
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.setBounds(400, 210, 250, 100);
		contentPane.add(btnJoinGame);
		
	}
	
	private void addActionListeners() {
		
		btnHostGame.addActionListener(e -> {
			
		});
		
		btnJoinGame.addActionListener(e -> {
			
		});
		
	}
	
	
}
