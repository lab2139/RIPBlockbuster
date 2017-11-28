import java.awt.BorderLayout;
import java.awt.Color;
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
 * @author laurenblatchford
 *
 */
public class Register {
	private static JPanel everythingPanel;
	private JPanel emailPanel;
	private JPanel passwordPanel;
	private JPanel buttonPanel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField enterEmail;
	private JTextField enterPassword;
	private JButton go;
	private JButton back;
	private Font font;
	
	
	public Register(){
		//Creates labels for email and password text shown. 
		//Sets the font to Calisto MT, white.
		font = new Font("Calisto MT", Font.ITALIC, 18);
		emailLabel = new JLabel("Enter your email address");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(font);
		passwordLabel = new JLabel("Create a password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(font);
		
		//Creates textfields for the user to enter their email/password
		enterEmail = new JTextField(15);
		enterPassword = new JTextField(15);
		
		//Creates the "Go" button from the image -> Goes to Home
		go = new JButton();
		go.setIcon(new ImageIcon("Go1.jpg"));
		go.setBorder(null);
		go.setRolloverIcon(new ImageIcon("Go2.jpg"));
		
		//Creates the "Back" button
		back = new JButton("Back");
		back.setIcon(new ImageIcon("back1.jpg"));
		back.setBorder(null);
		back.setRolloverIcon(new ImageIcon("back2.jpg"));
		
		//Creates the panels, sets the background to black, adds labels to panels
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
