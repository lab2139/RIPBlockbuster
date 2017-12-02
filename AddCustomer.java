import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Page to let admin accounts add movies to the database, remove movies from a database, 
 * add popular movies to the home page, remove popular movies from the home page
 * add recently added movies to the home page, and remove recently added movies from the database
 * @author laurenblatchford
 *
 */
public class AddCustomer {
	public static JPanel everythingPanel;
	//private JLabel addCustomerPanel;
	private JPanel addCustomerLabelPanel;
	private JPanel firstNamePanel;
	private JPanel lastNamePanel;
	private JPanel emailPanel;
	private JPanel phonePanel;
	private JPanel addCustomerButtonPanel;
	private JLabel addCustomerLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JTextField enterFirstName;
	private JTextField enterLastName;
	private JTextField enterEmail;
	private JTextField enterPhone;
	private JButton goAddCustomer;
	private Font font;
	private Font largeFont;
	
	public AddCustomer(){
		//Creates labels for search movies and customers
		//Sets the font to Calisto MT, white
		font = new Font("Calisto MT", Font.ITALIC, 12);
		largeFont = new Font("Calisto MT", Font.BOLD, 16);
		
		//Creates Labels for adding movies including: URL, Title, director, Genre, Actor, Rating, Quantity
		addCustomerLabel = new JLabel("Add Customer: ");
		addCustomerLabel.setForeground(Color.white);
		addCustomerLabel.setFont(largeFont);
		firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setForeground(Color.white);
		firstNameLabel.setFont(font);
		lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setForeground(Color.white);
		lastNameLabel.setFont(font);
		emailLabel = new JLabel("Email: ");
		emailLabel.setForeground(Color.white);
		emailLabel.setFont(font);
		phoneLabel = new JLabel("Phone Number (xxx-xxx-xxxx): ");
		phoneLabel.setForeground(Color.white);
		phoneLabel.setFont(font);
		
		//Go button images
		ImageIcon go1big = new ImageIcon("Go1.jpg");
		Image go1resize = go1big.getImage();
		Image newgo1 = go1resize.getScaledInstance(54, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon go1 = new ImageIcon(newgo1);
		ImageIcon go2big = new ImageIcon("Go2.jpg");
		Image go2resize = go2big.getImage();
		Image newgo2 = go2resize.getScaledInstance(54, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon go2 = new ImageIcon(newgo2);
		
		
		//Go button -> Adds movie to database
		goAddCustomer = new JButton();
		goAddCustomer.setIcon(go1);
		goAddCustomer.setBorder(null);
		goAddCustomer.setRolloverIcon(go2);
		goAddCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goAddCustomer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String first_name = enterFirstName.getText();
				String last_name = enterLastName.getText();
				String email = enterEmail.getText();
				String phone = enterPhone.getText();
				RQ.AddUser(first_name, last_name, phone, email);
				JOptionPane.showMessageDialog(UI.frame, "User Added.");
			}
			
		});
		
		//TextFields
		enterFirstName = new JTextField(25);
		enterLastName = new JTextField(25);
		enterEmail = new JTextField(25);
		enterPhone = new JTextField(25);
		
		//Create Panels
		//addCustomerPanel.setLayout(new BoxLayout(addCustomerPanel, BoxLayout.Y_AXIS));
		//addCustomerPanel.setBackground(Color.BLACK);
		//addCustomerPanel.setBorder(new LineBorder(Color.white, 3));
		addCustomerLabelPanel = new JPanel();
		addCustomerLabelPanel.setBackground(Color.BLACK);
		firstNamePanel = new JPanel();
		firstNamePanel.setBackground(Color.BLACK);
		lastNamePanel = new JPanel();
		lastNamePanel.setBackground(Color.black);
		emailPanel = new JPanel();
		emailPanel.setBackground(Color.BLACK);
		phonePanel = new JPanel();
		phonePanel.setBackground(Color.black);
		addCustomerButtonPanel = new JPanel();
		addCustomerButtonPanel.setBackground(Color.BLACK);
		
		//Add labels, textfields, and buttons to respective panels
		addCustomerLabelPanel.add(addCustomerLabel);
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(enterFirstName);
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(enterLastName);
		emailPanel.add(emailLabel);
		emailPanel.add(enterEmail);
		phonePanel.add(phoneLabel);
		phonePanel.add(enterPhone);
		addCustomerButtonPanel.add(goAddCustomer);
		
		//Adds everything to one panel to be added to the UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.setBackground(Color.BLACK);
		everythingPanel.add(addCustomerLabelPanel);
		everythingPanel.add(firstNamePanel);
		everythingPanel.add(lastNamePanel);
		everythingPanel.add(emailPanel);
		everythingPanel.add(phonePanel);
		everythingPanel.add(addCustomerButtonPanel);
	}
	
	/**
	 * 
	 * @return
	 */
	public static JPanel getPanel(){
		return everythingPanel;
	}
}
