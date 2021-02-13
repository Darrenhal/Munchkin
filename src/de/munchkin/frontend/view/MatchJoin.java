package de.munchkin.frontend.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.munchkin.backend.networking.ClientController;
import de.munchkin.frontend.model.LobbyModel;

public class MatchJoin extends JFrame{

	private static final long serialVersionUID = -7919422581409523893L;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screenDim = toolkit.getScreenSize();
	private JPanel contentPane;
	
	private final String[] genders = {"male", "female"};
	private final JComboBox<String> comboBoxGender = new JComboBox<String>(genders);
	private final JButton btnJoinGame = new JButton("Join Game");
	private final JButton btnBack = new JButton("Back");
	private final JTextField txtPlayerName = new JTextField();
	private final JTextField txtIPAddress = new JTextField();
	private final JTextField txtPort = new JTextField();
	private final JLabel lblPlayerName = new JLabel("Player Name:");
	private final JLabel lblGender = new JLabel("Gender:");
	private final JLabel lblIPAddress = new JLabel("IP Address:");
	private final JLabel lblPort = new JLabel("Port:");
	
	public MatchJoin(Image image) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Join Game");
		setLocation(screenDim.width / 4, screenDim.height / 4);
		setSize(screenDim.width / 2, screenDim.height / 2);
		setMinimumSize(new Dimension(700, 387));
		
		setIconImage(image);
		
		contentPane = new JPanel(null);
		contentPane.setLayout(null);
		setLayout(null);
		
		contentPane.add(btnBack);
		contentPane.add(btnJoinGame);
		contentPane.add(lblPlayerName);
		contentPane.add(txtPlayerName);
		contentPane.add(lblIPAddress);
		contentPane.add(txtIPAddress);
		contentPane.add(lblPort);
		contentPane.add(txtPort);
		contentPane.add(lblGender);
		contentPane.add(comboBoxGender);
		
		setContentPane(contentPane);
		contentPane.setBackground(new Color(253, 205, 136));
		
		loadBounds();
		addActionListeners();
		
		setVisible(true);
		
	}
	
	void loadBounds() {
		
		btnBack.setBounds(contentPane.getWidth() - 60, contentPane.getHeight() - 60, 40, 40);
		
		btnJoinGame.setBounds(20, contentPane.getHeight() - 60, 100, 40);
		
		lblPlayerName.setBounds(20, 20, 200, 20);
		txtPlayerName.setBounds(100, 20, 200, 20);
		
		lblIPAddress.setBounds(20, 100, 200, 20);
		txtIPAddress.setBounds(100, 100, 200, 20);
		
		lblPort.setBounds(20, 140, 200, 20);
		txtPort.setBounds(100, 140, 200, 20);
		
		lblGender.setBounds(20, 60, 200, 20);
		comboBoxGender.setBounds(100, 60, 200, 20);
		
	}
	
	private void addActionListeners() {
		
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				loadBounds();
			}
			
		});
		
		btnBack.addActionListener(e -> {
			
			new MunchkinLauncher();
			dispose();
			
		});
		
		btnJoinGame.addActionListener(e -> {
			
			int port = new Integer(txtPort.getText());
			String ipAddress = txtIPAddress.getText();
			String playerName = txtPlayerName.getText();
			String gender = comboBoxGender.getSelectedItem().toString();
			
			LobbyModel model = new LobbyModel(1, "", 0, 0);
			ClientController controller = new ClientController(ipAddress, new Integer(port), model, playerName, gender);
			new Lobby(0, getIconImage(), false, model, controller);
			new Thread(controller).start();
			
			dispose();
			
		});
		
	}
	
}
