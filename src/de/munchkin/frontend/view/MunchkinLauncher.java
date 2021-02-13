package de.munchkin.frontend.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.munchkin.utilities.JPictureBox;

public class MunchkinLauncher extends JFrame{

	private static final long serialVersionUID = 1598309638008663371L;
	
	private final Toolkit toolkit = Toolkit.getDefaultToolkit();
	private final Dimension screenDim = toolkit.getScreenSize();
	private final JPanel contentPane = new JPanel(null);
	private final JButton btnHostGame = new JButton("Host Game");
	private final JButton btnJoinGame = new JButton("Join Game");
	private final JPictureBox imageLabel = new JPictureBox("/Munchkin_logo.jpg");
	
	public static void main(String[] args) {
		loadLookAndFeel();
		new MunchkinLauncher();
	}
	
	public MunchkinLauncher() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Munchkin Launcher");
		setLocation(screenDim.width / 4, screenDim.height / 4);
		setSize(screenDim.width / 2, screenDim.height / 2);
		setMinimumSize(new Dimension(700, 387));
		setLayout(null);
		
		setIconImage(imageLabel.getImage());
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(253, 205, 136));
		contentPane.add(btnHostGame);
		contentPane.add(btnJoinGame);
		contentPane.add(imageLabel);
		setContentPane(contentPane);
		
		setVisible(true);
		
		loadBounds();
		addActionListeners();
		
	}
	
	void loadBounds() {
		
		int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
		
		btnHostGame.setBounds(width/2 - 300, height * 2 / 3, 250, 100);
		
		btnJoinGame.setBounds(width/2 + 50, height * 2 / 3, 250, 100);
		
		imageLabel.setBounds(20, 0, width - 40, height * 2 / 3);
		
	}
	
	private void addActionListeners() {
		
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				loadBounds();
			}
			
		});
		
		btnHostGame.addActionListener(e -> {
			new MatchCreation(getIconImage());
			dispose();
		});
		
		btnJoinGame.addActionListener(e -> {
			new MatchJoin(getIconImage());
			dispose();
		});
		
	}
	
	public static void loadLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
}
