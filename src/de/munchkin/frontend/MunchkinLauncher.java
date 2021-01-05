package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MunchkinLauncher extends JFrame{

	private static final long serialVersionUID = 1598309638008663371L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	private JButton btnHostGame, btnJoinGame;
	
	
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
//		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("resources/Munchkin_logo.jpg"));
//		
//		JLabel imageLabel = new JLabel(image);
//		imageLabel.setVisible(true);
//		imageLabel.setBounds(200, 50, 620, 210);
//		contentPane.add(imageLabel);
		
		
		btnHostGame = new JButton("Host Game");
		
		btnJoinGame = new JButton("Join Game");
		
	}
	
	private void loadBounds() {
		
		int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
		
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
