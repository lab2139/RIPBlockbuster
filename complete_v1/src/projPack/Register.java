package projPack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Creates the panel for registering. 
 * Press "Go" to register your account
 * Press "Back" to go back to the login page
 * @author laurenblatchford
 *
 */
public class Register {
	private static JPanel everythingPanel;
	private JPanel welcomePanel;
	private JPanel namePanel;
	private JPanel emailPanel;
	private JPanel passwordPanel;
	private JPanel buttonPanel;
	private JLabel welcomeLabel;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField enterName;
	private JTextField enterEmail;
	private JTextField enterPassword;
	private JButton go;
	private JButton back;
	private Font font;
	private Font welcomeFont;
	
	/**
	 * Creates a "Welcome!" text at the top of the screen
	 * adds "Enter your name" with a textfield
	 * adds "Enter your email address" with a textfield
	 * adds "Create a password" with a textfield
	 * adds "Go" button to register your account and bring you to the home page
	 * adds "Back" button to go back to the login page
	 */
	public Register(){
		//Creates labels for name, email and password text shown. 
		//Sets the font to Calisto MT, white.
		welcomeFont = new Font("Calisto MT", Font.ITALIC, 30);
		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(welcomeFont);
		font = new Font("Calisto MT", Font.ITALIC, 18);		
		nameLabel = new JLabel("Enter your name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(font);
		emailLabel = new JLabel("Enter your email address");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(font);
		passwordLabel = new JLabel("Create a password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(font);
		
		//Creates textfields for the user to enter their name/email/password
		enterName = new JTextField(15);
		enterEmail = new JTextField(15);
		enterPassword = new JTextField(15);
		
		//Creates the "Go" button from the image -> Goes to Home
		go = new JButton();
		go.setIcon(new ImageIcon("Go1.jpg"));
		go.setBorder(null);
		go.setRolloverIcon(new ImageIcon("Go2.jpg"));
		go.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates the "Back" button
		back = new JButton("Back");
		back.setIcon(new ImageIcon("back1.jpg"));
		back.setBorder(null);
		back.setRolloverIcon(new ImageIcon("back2.jpg"));
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates the panels, sets the background to black, adds labels to panels
		welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.black);
		welcomePanel.add(welcomeLabel);
		namePanel = new JPanel();
		namePanel.setBackground(Color.black);
		namePanel.add(nameLabel);
		namePanel.add(enterName);
		emailPanel = new JPanel();
		emailPanel.setBackground(Color.BLACK);
		emailPanel.add(emailLabel);
		emailPanel.add(enterEmail);
		passwordPanel = new JPanel();
		passwordPanel.setBackground(Color.BLACK);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(enterPassword);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.add(back);
		buttonPanel.add(go);
		
		
		//Adds everything to one panel to be added to UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.add(welcomePanel);
		everythingPanel.add(namePanel);
		everythingPanel.add(emailPanel);
		everythingPanel.add(passwordPanel);
		everythingPanel.add(buttonPanel);
		everythingPanel.setBackground(Color.BLACK);
	}
	
	/**
	 * Gets the panel with everything in it for the registration page. 
	 * @return JPanel everythingPanel - The panel with all labels, textfields, and buttons in it
	 */
	public static JPanel getPanel(){
		return everythingPanel;
	}

}
