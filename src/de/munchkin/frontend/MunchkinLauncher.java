package de.munchkin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.munchkin.utilities.JPictureBox;

public class MunchkinLauncher extends JFrame{

	private static final long serialVersionUID = 1598309638008663371L;
	
	private final Toolkit toolkit = Toolkit.getDefaultToolkit();
	private final Dimension screenDim = toolkit.getScreenSize();
	private final JPanel contentPane = new JPanel(null);
	private final JButton btnHostGame = new JButton("Host Game");
	private final JButton btnJoinGame = new JButton("Join Game");
	private final JPictureBox imageLabel = new JPictureBox();
	private final Image backgroundImage;
	
	public static void main(String[] args) {
		new MunchkinLauncher();
	}
	
	public MunchkinLauncher() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Munchkin Launcher");
		setLocation(screenDim.width / 4, screenDim.height / 4);
		setSize(screenDim.width / 2, screenDim.height / 2);
		setMinimumSize(new Dimension(700, 387));
		setLayout(null);
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(253, 205, 136));
		setContentPane(contentPane);
		
		setVisible(true);
		
		backgroundImage = loadBackgroundImage();
		imageLabel.setImage(backgroundImage);
		
		loadBounds();
		addActionListeners();
		
	}
	
	private Image loadBackgroundImage() {
        final long nowMs = System.currentTimeMillis();
        final URL res = this.getClass().getResource("/Munchkin_logo.jpg");

        // load Image
        //      final ImageIcon ret1 = new ImageIcon(res); // is not as good, we eventually only need an Image, we do not need the wrapper that ImageIcon provides
        //      final BufferedImage ret2 = ImageIO.read(res); // is better, but gives us BufferedImage, which is also more than we need. plus throws IOException
        final Image ret3 = Toolkit.getDefaultToolkit().getImage(res); // best way. If behaviour plays a role: Loads the image the same way that ImageIcon CTOR would.

        final long durMs = System.currentTimeMillis() - nowMs;
        System.out.println("Loading BG Image took " + durMs + "ms.");

        return ret3;
	}
	
	void loadBounds() {
		
		int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
		
		btnHostGame.setBounds(width/2 - 300, height * 2 / 3, 250, 100);
		contentPane.add(btnHostGame);
		
		btnJoinGame.setBounds(width/2 + 50, height * 2 / 3, 250, 100);
		contentPane.add(btnJoinGame);
		
		
		imageLabel.setBounds(20, 0, width - 40, height * 2 / 3);
		contentPane.add(imageLabel);
		
		revalidate();
		repaint();
		
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
			new MatchCreation();
			dispose();
		});
		
		btnJoinGame.addActionListener(e -> {
			new MatchJoin();
			dispose();
		});
		
	}
	
	
}
