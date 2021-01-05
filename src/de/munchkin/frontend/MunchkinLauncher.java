package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MunchkinLauncher extends JFrame{

	private static final long serialVersionUID = 1598309638008663371L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	private JButton btnHostGame, btnJoinGame;
	private JLabel imageLabel;
	
	
	public static void main(String[] args) {
		new MunchkinLauncher();
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
		loadBounds();
		addActionListeners();
		
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				loadBounds();
				repaint();
			}
			
		});
		
	}
	
	private void loadComponents() {
		
		// Load header image
//		ImageIcon image = new ImageIcon(toolkit.getImage(MunchkinLauncher.class.getResource("Munchkin_logo.jpg")));
//		
//		
//		
//		imageLabel = new JLabel();
//		imageLabel.setIcon(image);
		
		btnHostGame = new JButton("Host Game");
		
		btnJoinGame = new JButton("Join Game");
		
	}
	
	private void loadBounds() {
		
		int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
		
//		imageLabel.setBounds(20, 20, 700, 210);
//		contentPane.add(imageLabel);
		
		btnHostGame.setBounds(width/2 - 300, height * 2 / 3, 250, 100);
		contentPane.add(btnHostGame);
		
		btnJoinGame.setBounds(width/2 + 50, height * 2 / 3, 250, 100);
		contentPane.add(btnJoinGame);
		
	}
	
	private void addActionListeners() {
		
		btnHostGame.addActionListener(e -> {
			new MatchCreation();
			dispose();
		});
		
		btnJoinGame.addActionListener(e -> {
			new MatchJoin();
			dispose();
		});
		
	}
	
	
}
