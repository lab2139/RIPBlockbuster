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
 * Creates the panel for logging in. 
 * Press "Go" to go to Home page.
 * Press "Sign up" to go to Sign Up page.
 * @author laurenblatchford
 *
 */
public class Login{
	private static JPanel everythingPanel;
	private JPanel usernamePanel;
	private JPanel adjustUsernamePanel;
	private JPanel passwordPanel;
	private JPanel buttonPanel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField enterUsername;
	private JTextField enterPassword;
	private JButton go;
	private JButton signUp;
	private Font font;
	private EmptyBorder usernameborder;
	private EmptyBorder passwordborder;
	private EmptyBorder buttonborder;
	
/**
 * Creates the labels for username and password, textfields to enter username and password, buttons	
 * to go to the home page while logged in, or register. Adds it all to one panel, to be added to the UI.
 */
	
	public Login(){
		//Creates labels for username and password text shown.
		//Sets the font to Calisto MT, white.
		font = new Font("Calisto MT", Font.ITALIC, 18);
		usernameLabel = new JLabel("Enter Username");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(font);
		passwordLabel = new JLabel("Enter Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(font);
		
		//Creates textfields for the user to enter in their username/password
		enterUsername = new JTextField(10);
		enterPassword = new JTextField(10);
		
		//Creates a "Go" button from an image -> Goes to Home
		go = new JButton();
		go.setIcon(new ImageIcon("Go1.jpg"));
		go.setBorder(null);
		go.setRolloverIcon(new ImageIcon("Go2.jpg"));
		go.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates a "Sign up" button from an image -> Goes to SignUp
		signUp = new JButton();
		signUp.setIcon(new ImageIcon("signup1.jpg"));
		signUp.setBorder(null);
		signUp.setRolloverIcon(new ImageIcon("signup2.jpg"));
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates borders to be added to panels
		usernameborder = new EmptyBorder(180, 0, 0, 0);
		passwordborder = new EmptyBorder(20, 0, 20, 0);
		buttonborder = new EmptyBorder(0, 260, 180, 260);
		
		//Creates the panels, sets background to black, adds labels to panels		
		usernamePanel = new JPanel();
		usernamePanel.setLayout(new FlowLayout());
		usernamePanel.setBackground(Color.BLACK);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(enterUsername);
		adjustUsernamePanel = new JPanel(new BorderLayout());
		adjustUsernamePanel.add(usernamePanel, BorderLayout.PAGE_END);
		adjustUsernamePanel.setBackground(Color.BLACK);
		adjustUsernamePanel.setBorder(usernameborder);
		passwordPanel = new JPanel();
		passwordPanel.setBackground(Color.BLACK);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(enterPassword);
		passwordPanel.setBorder(passwordborder);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.add(signUp);
		buttonPanel.add(go);
		buttonPanel.setBorder(buttonborder);
		
		//Adds everything to one panel to be added to UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.add(adjustUsernamePanel);
		everythingPanel.add(passwordPanel);
		everythingPanel.add(buttonPanel);
		everythingPanel.setBackground(Color.BLACK);
	}
	
/**
 * Gets the panel with everything in it for the login page. 	
 * @return JPanel everythingPanel - The panel with all labels, textfields, and buttons in it.
 */
	public static JPanel getPanel(){
		return everythingPanel;
	}
}

