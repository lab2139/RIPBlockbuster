package projPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 * After a movie has been clicked on, show this page.
 * Allows the admin to set who has this movie rented, and who has returned it.
 * Allows the admin to edit the movie information.
 * Allows the admin to delete the movie from the database
 * @author laurenblatchford
 *
 */
public class ModifyMovie {
	private static JPanel everythingPanel;
	private JPanel moviePanel;	
	private JPanel rentPanel;
	private JPanel returnPanel;
	private JPanel editLabelPanel;
	private JPanel editUrlPanel;
	private JPanel editTitlePanel;
	private JPanel editDirectorPanel;
	private JPanel editGenrePanel;
	private JPanel editStarPanel;
	private JPanel editRatingPanel;
	private JPanel editQuantityPanel;
	private JPanel deletePanel;
	private JLabel rentLabel;
	private JLabel returnLabel;
	private JLabel editLabel;
	private JLabel urlLabel;
	private JLabel titleLabel;
	private JLabel directorLabel;
	private JLabel genreLabel;
	private JLabel starLabel;
	private JLabel ratingLabel;
	private JLabel quantityLabel;
	private JLabel deleteLabel;
	private JTextField enterRentEmail;
	private JTextField enterReturnedEmail;
	private JTextField enterUrl;
	private JTextField enterTitle;
	private JTextField enterDirector;
	private JTextField enterGenre;
	private JTextField enterStar;
	private JTextField enterRating;
	private JTextField enterQuantity;
	private JButton goRent;
	private JButton goReturn;
	private JButton goUrl;
	private JButton goTitle;
	private JButton goDirector;
	private JButton goGenre;
	private JButton goStar;
	private JButton goRating;
	private JButton goQuantity;
	private JButton goDelete;
	private Font font;
	private Font largeFont;
	private JLabel testLabel;
	private JPanel testPanel;
	public String movieTitle;
	ResultSet rs;
	
	/**
	 * Creates an overall panel that includes the movie's stub with information, 
	 * A place to choose which customer has rented the movie, and updates quantity
	 * A place to choose which customer has returned the movie, and updates quantity
	 * A place to edit the movie's picture url, title, director, genre, actor, rating, and quantity
	 * A button to delete the movie from the database.
	 * 
	 */
	public ModifyMovie(String titleString){
		int filmCount = 0;
		movieTitle = titleString;
		rs = RQ.SelectTitle(movieTitle);
		String test = "TEST";
		try {
		while(rs.next() && filmCount != 1)
		{
			test = rs.getString("title");
			System.out.println(test);
			filmCount++;
		}
		
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		//testLabel.setText(test);
		//Create a large and small font for the labels
		font = new Font("Calisto MT", Font.ITALIC, 18);
		largeFont = new Font("Calisto MT", Font.BOLD, 25);
		
		//Create Labels
		rentLabel = new JLabel("Enter customer Email who rented this movie: ");
		rentLabel.setForeground(Color.white);
		rentLabel.setFont(largeFont);
		returnLabel = new JLabel("Enter customer Email who returned this movie: ");
		returnLabel.setForeground(Color.white);
		returnLabel.setFont(largeFont);
		editLabel = new JLabel("Edit Movie Info");
		editLabel.setForeground(Color.white);
		editLabel.setFont(largeFont);
		urlLabel = new JLabel("Edit URL");
		urlLabel.setForeground(Color.white);
		urlLabel.setFont(font);
		titleLabel = new JLabel("Edit title");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(font);
		directorLabel = new JLabel("Edit director");
		directorLabel.setForeground(Color.white);
		directorLabel.setFont(font);
		genreLabel = new JLabel("Edit genre");
		genreLabel.setForeground(Color.white);
		genreLabel.setFont(font);
		starLabel = new JLabel("Edit star");
		starLabel.setForeground(Color.white);
		starLabel.setFont(font);
		ratingLabel = new JLabel("Edit rating");
		ratingLabel.setForeground(Color.white);
		ratingLabel.setFont(font);
		quantityLabel = new JLabel("Edit Quantity");
		quantityLabel.setForeground(Color.white);
		quantityLabel.setFont(font);
		deleteLabel = new JLabel("Delete Movie");
		deleteLabel.setForeground(Color.white);
		deleteLabel.setFont(largeFont);
		
		//Creates textfield for the admin to enter customer Email that has rented the movie
		enterRentEmail = new JTextField(25);
		
		//Creates textfield for the admin to enter customer Email that has returned the movie
		enterReturnedEmail = new JTextField(25);
		
		//Creates textfields for the admin to edit the movie information;
		enterUrl = new JTextField(25);
		enterTitle = new JTextField(25);
		enterDirector = new JTextField(25);
		enterGenre = new JTextField(25);
		enterStar = new JTextField(25);
		enterRating = new JTextField(25);
		enterQuantity = new JTextField(25);
		
		//Set image icons for go images
				ImageIcon go1 = new ImageIcon("Go1.jpg");
				ImageIcon go2 = new ImageIcon("Go2.jpg");
				
				//Go button to rent movie
				goRent = new JButton();
				goRent.setIcon(go1);
				goRent.setBorder(null);
				goRent.setRolloverIcon(go2);
				goRent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				goRent.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String email = enterRentEmail.getText();
						RQ.CheckOut(email, movieTitle);
						String message = email + " has rented " + movieTitle;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterRentEmail.setText("");
					}					
				});
				
				//Go button to return movie
				goReturn = new JButton();
				goReturn.setIcon(go1);
				goReturn.setBorder(null);
				goReturn.setRolloverIcon(go2);
				goReturn.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String email = enterReturnedEmail.getText();
						RQ.CheckIn(email, movieTitle);
						String message = email + " has returned " + movieTitle;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterReturnedEmail.setText("");
					}
					
				});
				
				//Go button to edit movie url
				goUrl = new JButton();
				goUrl.setIcon(go1);
				goUrl.setBorder(null);
				goUrl.setRolloverIcon(go2);
				goUrl.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newUrl = enterUrl.getText();
						RQ.EditURL(movieTitle, newUrl);
						JOptionPane.showMessageDialog(UI.frame, "The url has been updated.");
						enterUrl.setText("");
					}
					
				});
				
				//Go button to edit movie title
				goTitle = new JButton();
				goTitle.setIcon(go1);
				goTitle.setBorder(null);
				goTitle.setRolloverIcon(go2);
				goTitle.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newTitle = enterTitle.getText();
						RQ.EditTitle(movieTitle, newTitle);
						String message = "The title has been updated to " + newTitle;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterTitle.setText("");
					}
					
				});
				
				//Go button to edit movie director
				goDirector = new JButton();
				goDirector.setIcon(go1);
				goDirector.setBorder(null);
				goDirector.setRolloverIcon(go2);
				goDirector.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newDirector = enterDirector.getText();
						RQ.EditDirector(movieTitle, newDirector);
						String message = "The director has been updated to " + newDirector;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterDirector.setText("");
					}
					
				});
				
				//Go button to edit movie genre
				goGenre = new JButton();
				goGenre.setIcon(go1);
				goGenre.setBorder(null);
				goGenre.setRolloverIcon(go2);
				goGenre.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newGenre = enterGenre.getText();
						RQ.EditGenre(movieTitle, newGenre);
						String message = "The genre has been updated to " + newGenre;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterGenre.setText("");
					}
					
				});
				
				//Go button to edit movie star
				goStar = new JButton();
				goStar.setIcon(go1);
				goStar.setBorder(null);
				goStar.setRolloverIcon(go2);
				goStar.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newStar = enterStar.getText();
						RQ.EditLead(movieTitle, newStar);
						String message = "The star has been updated to " + newStar;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterStar.setText("");
					}
					
				});
				
				//Go button to edit movie rating
				goRating = new JButton();
				goRating.setIcon(go1);
				goRating.setBorder(null);
				goRating.setRolloverIcon(go2);
				goRating.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newRating = enterRating.getText();
						RQ.EditRating(movieTitle, newRating);
						String message = "The rating has been updated to " + newRating;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterRating.setText("");
					}
					
				});
				
				//Go button to edit movie quantity
				goQuantity = new JButton();
				goQuantity.setIcon(go1);
				goQuantity.setBorder(null);
				goQuantity.setRolloverIcon(go2);
				goQuantity.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String newQuantity = enterQuantity.getText();
						int newQty = Integer.parseInt(newQuantity);
						RQ.EditQty(movieTitle, newQty);
						String message = "The quantity has been updated to" + newQuantity;
						JOptionPane.showMessageDialog(UI.frame, message);
						enterQuantity.setText("");
					}
					
				});
				
				//Go button to delete movie from the database
				goDelete = new JButton();
				goDelete.setIcon(go1);
				goDelete.setBorder(null);
				goDelete.setRolloverIcon(go2);
				goDelete.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						RQ.RemoveMovie(movieTitle);
						String message = movieTitle + " has been removed from the database.";
						JOptionPane.showMessageDialog(UI.frame, message);
					}
					
		});
		//Creates panels, sets background to black, adds labels to panels
		moviePanel = new JPanel();
		moviePanel.setBackground(Color.black);
		//moviePanel.add(movie.getPanel());
		
		rentPanel = new JPanel();
		rentPanel.setBackground(Color.black);
		rentPanel.add(rentLabel);
		rentPanel.add(enterRentEmail);
		rentPanel.add(goRent);
		
		returnPanel = new JPanel();
		returnPanel.setBackground(Color.black);
		returnPanel.add(returnLabel);
		returnPanel.add(enterReturnedEmail);
		returnPanel.add(goReturn);
		
		editLabelPanel = new JPanel();
		editLabelPanel.setBackground(Color.BLACK);
		editLabelPanel.add(editLabel);
		
		editUrlPanel = new JPanel();
		editUrlPanel.setBackground(Color.BLACK);
		editUrlPanel.add(urlLabel);
		editUrlPanel.add(enterUrl);
		editUrlPanel.add(goUrl);
		
		editTitlePanel = new JPanel();
		editTitlePanel.setBackground(Color.BLACK);
		editTitlePanel.add(titleLabel);
		editTitlePanel.add(enterTitle);
		editTitlePanel.add(goTitle);
		
		editDirectorPanel = new JPanel();
		editDirectorPanel.setBackground(Color.BLACK);
		editDirectorPanel.add(directorLabel);
		editDirectorPanel.add(enterDirector);
		editDirectorPanel.add(goDirector);
		
		editGenrePanel = new JPanel();
		editGenrePanel.setBackground(Color.BLACK);
		editGenrePanel.add(genreLabel);
		editGenrePanel.add(enterGenre);
		editGenrePanel.add(goGenre);
		
		editStarPanel = new JPanel();
		editStarPanel.setBackground(Color.BLACK);
		editStarPanel.add(starLabel);
		editStarPanel.add(enterStar);
		editStarPanel.add(goStar);
		
		editRatingPanel = new JPanel();
		editRatingPanel.setBackground(Color.black);
		editRatingPanel.add(ratingLabel);
		editRatingPanel.add(enterRating);
		editRatingPanel.add(goRating);
		
		editQuantityPanel = new JPanel();
		editQuantityPanel.setBackground(Color.black);
		editQuantityPanel.add(quantityLabel);
		editQuantityPanel.add(enterQuantity);
		editQuantityPanel.add(goQuantity);
		
		deletePanel = new JPanel();
		deletePanel.setBackground(Color.BLACK);
		deletePanel.add(deleteLabel);
		deletePanel.add(goDelete);
		
		//testPanel.add(testLabel);
		
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.setBackground(Color.black);
		//everythingPanel.add(testPanel);
		everythingPanel.add(moviePanel);
		everythingPanel.add(rentPanel);
		everythingPanel.add(returnPanel);
		everythingPanel.add(editLabelPanel);
		everythingPanel.add(editUrlPanel);
		everythingPanel.add(editTitlePanel);
		everythingPanel.add(editDirectorPanel);
		everythingPanel.add(editGenrePanel);
		everythingPanel.add(editStarPanel);
		everythingPanel.add(editRatingPanel);
		everythingPanel.add(editQuantityPanel);
		everythingPanel.add(deletePanel);
	}
	
	public JPanel getPanel(){
		return everythingPanel;
	}
}