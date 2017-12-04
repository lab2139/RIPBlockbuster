package projPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

/**
 * Displays customer information
 * @author davidjohnson justinsaunders kellykolb hayleystueber laurenblatchford
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
	
	ResultSet rs;
	private JLabel queryFirst;
	private JLabel queryLast;
	private JLabel queryEmail;
	private JLabel queryPhone;
	private JLabel queryRented;
	
	private JButton deleteButton;
	private JLabel deleteLabel;
	private JPanel deletePanel;
	String email;
	/**
	 * Adds customer information into a JPanel to be viewed
	 * @param customerEmail - The email of the customer in the database
	 */
	public ViewCustomer(String customerEmail){
		//Create Font
		email = customerEmail;
		font = new Font("Calisto MT", Font.ITALIC, 18);
		largeFont = new Font("Calisto MT", Font.BOLD, 25);
		
		rs = RQ.ViewCustomer(customerEmail);
	
		try{
			while(rs.next()){
				queryFirst = new JLabel(rs.getString("c_first"));
				queryFirst.setForeground(Color.WHITE);
				queryFirst.setFont(font);
			
				queryLast = new JLabel(rs.getString("c_last"));
				queryLast.setForeground(Color.WHITE);
				queryLast.setFont(font);
			
				queryEmail = new JLabel(rs.getString("email"));
				queryEmail.setForeground(Color.WHITE);
				queryEmail.setFont(font);
			
				queryPhone = new JLabel(rs.getString("phone_num"));
				queryPhone.setForeground(Color.WHITE);
				queryPhone.setFont(font);
			}
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception ex){
			//Handle errors for Class.forName
			ex.printStackTrace();
		}
		
		
		
		//Create Labels
		customerInfoLabel = new JLabel("Customer Information");
		customerInfoLabel.setForeground(Color.WHITE);
		customerInfoLabel.setFont(largeFont);
		firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setForeground(Color.WHITE);
		firstNameLabel.setFont(font);
		lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setFont(font);
		emailLabel = new JLabel("Email: ");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(font);
		phoneLabel = new JLabel("Phone: ");
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(font);
		rentedLabel = new JLabel("Rented Movie: ");
		rentedLabel.setForeground(Color.WHITE);
		rentedLabel.setFont(font);
		queryRented = new JLabel(RQ.ViewRented(customerEmail));
		queryRented.setForeground(Color.WHITE);
		queryRented.setFont(font);
		deleteLabel = new JLabel("Delete Account");
		deleteLabel.setForeground(Color.WHITE);
		deleteLabel.setFont(largeFont);
		
		//Create Panels
		customerInfoLabelPanel = new JPanel();
		customerInfoLabelPanel.setBackground(Color.BLACK);
		firstNamePanel = new JPanel();
		firstNamePanel.setBackground(Color.BLACK);
		lastNamePanel = new JPanel();
		lastNamePanel.setBackground(Color.BLACK);
		emailPanel = new JPanel();
		emailPanel.setBackground(Color.BLACK);
		phonePanel = new JPanel();
		phonePanel.setBackground(Color.BLACK);
		rentedPanel = new JPanel();
		rentedPanel.setBackground(Color.BLACK);
		deletePanel = new JPanel();
		deletePanel.setBackground(Color.BLACK);
		
		deleteButton = new JButton();
		deleteButton.setIcon(new ImageIcon("go1.jpg"));
		deleteButton.setBorder(null);
		deleteButton.setRolloverIcon(new ImageIcon("go2.jpg"));
		deleteButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RQ.RemoveUser(email);
				String message = email + " has been removed from User Accounts.";
				JOptionPane.showMessageDialog(UI.frame, message);
				Home.accountSearch.setText("");
				UI.updateBottomPanel("home");
			}
		});
		
		//Add labels to Panels
		customerInfoLabelPanel.add(customerInfoLabel);
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(queryFirst);
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(queryLast);
		emailPanel.add(emailLabel);
		emailPanel.add(queryEmail);
		phonePanel.add(phoneLabel);
		phonePanel.add(queryPhone);
		rentedPanel.add(rentedLabel);
		rentedPanel.add(queryRented);
		deletePanel.add(deleteLabel);
		deletePanel.add(deleteButton);
		
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.add(customerInfoLabelPanel);
		everythingPanel.add(firstNamePanel);
		everythingPanel.add(lastNamePanel);
		everythingPanel.add(emailPanel);
		everythingPanel.add(phonePanel);
		everythingPanel.add(rentedPanel);
		everythingPanel.add(deletePanel);
	}
	
	/**
	 * Get the panel with all information
	 * @return everythingPanel- the panel with everything in it.
	 */
	public static JPanel getPanel() {
		// TODO Auto-generated method stub
		return everythingPanel;
	}
}