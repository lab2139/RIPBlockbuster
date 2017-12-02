import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/**
 * Displays customer information
 * @author laurenblatchford
 *
 */
public class ViewCustomer {
	public static JPanel everythingPanel;
	private JPanel customerInfoLabelPanel;
	private JPanel firstNamePanel;
	private JPanel lastNamePanel;
	private JPanel emailPanel;
	private JPanel phonePanel;
	private JPanel rentedPanel;
	private JLabel customerInfoLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JLabel rentedLabel;
	private Font font;
	private Font largeFont;
	
	/**
	 * Adds customer information into a JPanel to be viewed
	 * @param customerEmail - The email of the customer in the database
	 */
	public ViewCustomer(String customerEmail){
		//Create Font
		font = new Font("Calisto MT", Font.ITALIC, 18);
		largeFont = new Font("Calisto MT", Font.BOLD, 25);
		
		//Create Labels
		customerInfoLabel = new JLabel("Customer Information");
		customerInfoLabel.setForeground(Color.white);
		customerInfoLabel.setFont(largeFont);
		firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setForeground(Color.white);
		firstNameLabel.setFont(font);
		lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setForeground(Color.white);
		lastNameLabel.setFont(font);
		emailLabel = new JLabel("Email: ");
		emailLabel.setForeground(Color.white);
		emailLabel.setFont(font);
		phoneLabel = new JLabel("Phone: ");
		phoneLabel.setForeground(Color.white);
		phoneLabel.setFont(font);
		rentedLabel = new JLabel("Rented Movie: ");
		rentedLabel.setForeground(Color.WHITE);
		rentedLabel.setFont(font);
		
		//Create Panels
		customerInfoLabelPanel = new JPanel();
		customerInfoLabelPanel.setBackground(Color.BLACK);
		firstNamePanel = new JPanel();
		firstNamePanel.setBackground(Color.BLACK);
		lastNamePanel = new JPanel();
		lastNamePanel.setBackground(Color.BLACK);
		emailPanel = new JPanel();
		emailPanel.setBackground(Color.black);
		phonePanel = new JPanel();
		phonePanel.setBackground(Color.BLACK);
		rentedPanel = new JPanel();
		rentedPanel.setBackground(Color.black);
		
		//Add labels to Panels
		customerInfoLabelPanel.add(customerInfoLabel);
		firstNamePanel.add(firstNameLabel);
		lastNamePanel.add(lastNameLabel);
		emailPanel.add(emailLabel);
		phonePanel.add(phoneLabel);
		rentedPanel.add(rentedLabel);
		
		everythingPanel = new JPanel(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.add(customerInfoLabelPanel);
		everythingPanel.add(firstNamePanel);
		everythingPanel.add(lastNamePanel);
		everythingPanel.add(emailPanel);
		everythingPanel.add(rentedPanel);
	}
	
	/**
	 * Get the panel with all information
	 * @return everythingPanel- the panel with everything in it.
	 */
	public static JPanel getPanel(){
		return everythingPanel;
	}
}
