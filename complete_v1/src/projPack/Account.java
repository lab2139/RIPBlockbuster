import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;

/**
 * A class that lets the user see their account information, including their fees, their username, their email,
 * and their password. It allows users to change their account information, excluding their fees, and lets them 
 * see what movies are their favorites. 
 * @author laurenblatchford
 *
 */
public class Account {
	private static JPanel everythingPanel;
	private JPanel welcomeLabelPanel;
	private JPanel feesPanel;
	private JPanel changeNamePanel;
	private JPanel changeEmailPanel;
	private JPanel changePasswordPanel;
	private JPanel favoriteMoviesLabelPanel;
	private JPanel moviesPanel;
	private JLabel welcomeLabel;
	private JLabel changeNameLabel;
	private JLabel changeEmailLabel;
	private JLabel changePasswordLabel;
	private JLabel feesLabel;
	private JLabel favoriteMoviesLabel;
	private JTextField enterName;
	private JTextField enterEmail;
	private JTextField enterPassword;
	private JButton goName;
	private JButton goEmail;
	private JButton goPassword;
	private Font font;
	private Font largeFont;
	
	
	/**
	 * Creates the labels for the top panel to say "Welcome!" and panel for the user to see their late fees, 
	 * and panel for them to change their name, email, and password. Changing their name, email and password
	 * updates the customer database. It also lets the user see their favorite movies.
	 */
	public Account(){
		//Create a large and small font for the labels
		font = new Font("Calisto MT", Font.ITALIC, 18);
		largeFont = new Font("Calisto MT", Font.BOLD, 25);
		
		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setFont(largeFont);
		feesLabel = new JLabel("Fees (Pay in store): ");
		feesLabel.setForeground(Color.white);
		feesLabel.setFont(font);
		changeNameLabel = new JLabel("Change your name: ");
		changeNameLabel.setForeground(Color.white);
		changeNameLabel.setFont(font);
		changeEmailLabel = new JLabel("Change your email: ");
		changeEmailLabel.setForeground(Color.white);
		changeEmailLabel.setFont(font);
		changePasswordLabel = new JLabel("Change your password: ");
		changePasswordLabel.setForeground(Color.white);
		changePasswordLabel.setFont(font);
		favoriteMoviesLabel = new JLabel("Favorites: ");
		favoriteMoviesLabel.setForeground(Color.white);
		favoriteMoviesLabel.setFont(largeFont);
		
		//Creates textfields for the user to change their username, email, password
		enterName = new JTextField(15);
		enterEmail = new JTextField(15);
		enterPassword = new JTextField(15);
		
		//Creates go button to change username
		goName = new JButton();
		goName.setIcon(new ImageIcon("Go1.jpg"));
		goName.setBorder(null);
		goName.setRolloverIcon(new ImageIcon("Go2.jpg"));
		goName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates go button to change email
		goEmail = new JButton();
		goEmail.setIcon(new ImageIcon("Go1.jpg"));
		goEmail.setBorder(null);
		goEmail.setRolloverIcon(new ImageIcon("Go2.jpg"));
		goEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates go buttn to change password
		goPassword = new JButton();
		goPassword.setIcon(new ImageIcon("Go1.jpg"));
		goPassword.setBorder(null);
		goPassword.setRolloverIcon(new ImageIcon("Go2.jpg"));
		goPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates panels, sets background to black, adds labels to panels
		welcomeLabelPanel = new JPanel();
		welcomeLabelPanel.setBackground(Color.BLACK);
		welcomeLabelPanel.add(welcomeLabel);
		feesPanel = new JPanel();
		feesPanel.setBackground(Color.BLACK);
		feesPanel.add(feesLabel);
		changeNamePanel = new JPanel();
		changeNamePanel.setBackground(Color.black);
		changeNamePanel.add(changeNameLabel);
		changeNamePanel.add(enterName);
		changeNamePanel.add(goName);
		changeEmailPanel = new JPanel();
		changeEmailPanel.setBackground(Color.BLACK);
		changeEmailPanel.add(changeEmailLabel);
		changeEmailPanel.add(enterEmail);
		changeEmailPanel.add(goEmail);
		changePasswordPanel = new JPanel();
		changePasswordPanel.setBackground(Color.BLACK);
		changePasswordPanel.add(changePasswordLabel);
		changePasswordPanel.add(enterPassword);
		changePasswordPanel.add(goPassword);
		favoriteMoviesLabelPanel = new JPanel();
		favoriteMoviesLabelPanel.setBackground(Color.black);
		favoriteMoviesLabelPanel.add(favoriteMoviesLabel);
		moviesPanel = new JPanel();
		moviesPanel.setBackground(Color.black);
		
		//Adds everything to one panel to be added to the UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.setBackground(Color.black);
		everythingPanel.add(welcomeLabelPanel);
		everythingPanel.add(feesPanel);
		everythingPanel.add(changeNamePanel);
		everythingPanel.add(changeEmailPanel);
		everythingPanel.add(changePasswordPanel);
		everythingPanel.add(favoriteMoviesLabelPanel);
		everythingPanel.add(moviesPanel);
	}
	
	/**
	 * Gets the panel with everything in it for the Account page.
	 * @return JPanel everythingPanel - The panel with all labels, textfields, and buttons in it.
	 */
	public static JPanel getPanel(){
		return everythingPanel;
	}
}
