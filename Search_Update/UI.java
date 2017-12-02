package projPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;

/**
 * Creates a template UI for all other classes to add panels and elements.
 * @author Lauren Blatchford
 */
public class UI {
	private static JFrame frame;
	private JPanel bannerPanel;
	private static JPanel bottomPanel;
	private JLabel bannerLabel;
	private BufferedImage banner;
	private static final int BANNER_WIDTH = 1280;
	private static final int BANNER_HEIGHT = 100;

	/**
	 * Contructor. 
	 */
	public UI(){
	}

	/**
	 * Contructs the frame, adds the banner to a label in the top panel. 
	 * @return frame - the frame for overall UI
	 */
	public static JFrame createFrame(){
		UI ui = new UI();

		//Creates the banner label. Grabs the banner image and assigns it to the banner label
		//If image does not exist, print stack error
		ui.bannerLabel = new JLabel();
		ui.bannerLabel.setPreferredSize(new Dimension(BANNER_WIDTH, BANNER_HEIGHT));
		try {
			ui.banner = ImageIO.read(new File("projectbanner.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		//In the event the banner needs to be scaled up or down, allow smooth scaling
		Image scaledBanner = ui.banner.getScaledInstance(BANNER_WIDTH, BANNER_HEIGHT, Image.SCALE_SMOOTH);

		//Add the scaled banner to the banner label.
		ui.bannerLabel.setIcon(new ImageIcon(scaledBanner));

		//Creates banner panel, add the banner label
		ui.bannerPanel = new JPanel();
		ui.bannerPanel.setLayout(new BoxLayout(ui.bannerPanel, BoxLayout.X_AXIS));
		ui.bannerPanel.add(ui.bannerLabel);
		ui.bannerPanel.setBackground(Color.black);
		ui.bannerPanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				updateBottomPanel("home");
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

		});
		ui.bannerPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		//Creates the frame
		frame = new JFrame("RIP BLOCKBUSTER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(ui.bannerPanel);
		
		frame.add(bottomPanel);
		frame.setPreferredSize(new Dimension(BANNER_WIDTH, 800));
		frame.setResizable(false);
		frame.pack();
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;
	}

	/**
	 * Gets the frame
	 * @return frame - The frame of the overall UI
	 */
	public static JFrame getFrame(){
		return frame;
	}

	/**
	 * Updates the frame to show a new panel
	 * 
	 * @param panel - panel to be added
	 */
	public static void updateBottomPanel(String page){
		//Testing classes: 
		if (bottomPanel != null){
			frame.getContentPane().remove(bottomPanel);

			if (page.equals("login")){
				Login login = new Login();
				bottomPanel = login.getPanel();
				frame.add(bottomPanel);
				frame.getContentPane().invalidate();
				frame.getContentPane().validate();
			}
			else if (page.equals("register")){
				Register register = new Register();
				bottomPanel = register.getPanel();
				frame.add(bottomPanel);
				frame.getContentPane().invalidate();
				frame.getContentPane().validate();
			}
			else if (page.equals("account")){
				Account account = new Account();
				bottomPanel = account.getPanel();
				frame.add(bottomPanel);
				frame.getContentPane().invalidate();
				frame.getContentPane().validate();
			}
			else if (page.equals("admin")){
				Admin admin = new Admin();
				bottomPanel = admin.getPanel();
				frame.add(bottomPanel);
				frame.getContentPane().invalidate();
				frame.getContentPane().validate();
			}
			else{
				Home home = new Home();
				bottomPanel = home.getPanel();
				frame.add(bottomPanel);
				frame.getContentPane().invalidate();
				frame.getContentPane().validate();
			}
		}
		else{
			if (page.equals("login")){
				Login login = new Login();
				bottomPanel = login.getPanel();
			}
			else if (page.equals("register")){
				Register register = new Register();
				bottomPanel = register.getPanel();
			}
			else if (page.equals("account")){
				Account account = new Account();
				bottomPanel = account.getPanel();
			}
			else if (page.equals("admin")){
				Admin admin = new Admin();
				bottomPanel = admin.getPanel();
			}
			else{
				Home home = new Home();
				bottomPanel = home.getPanel();
			}
		}
	}

	static ResultSet rs = null;
	
	public static void main(String[] args) {
		updateBottomPanel("home");
		createFrame();
	}

}
