import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

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
public class AddMovie {
	public static JPanel everythingPanel;
	private JPanel addMoviePanel;
	private JPanel addMovieLabelPanel;
	private JPanel urlPanel;
	private JPanel titlePanel;
	private JPanel directorPanel;
	private JPanel genrePanel;
	private JPanel actorPanel;
	private JPanel ratingPanel;
	private JPanel quantityPanel;
	private JPanel addMovieButtonPanel;
	private JLabel addMovieLabel;
	private JLabel urlLabel;
	private JLabel titleLabel;
	private JLabel directorLabel;
	private JLabel genreLabel;
	private JLabel actorLabel;
	private JLabel ratingLabel;
	private JLabel quantityLabel;
	private JTextField enterUrl;
	private JTextField enterTitle;
	private JTextField enterDirector;
	private JTextField enterGenre;
	private JTextField enterActor;
	private JTextField enterRating;
	private JTextField enterQuantity;
	private JButton goAddMovie;
	private Font font;
	private Font largeFont;
	
	public AddMovie(){
		//Creates labels for search movies and customers
		//Sets the font to Calisto MT, white
		font = new Font("Calisto MT", Font.ITALIC, 12);
		largeFont = new Font("Calisto MT", Font.BOLD, 16);
		
		//Creates Labels for adding movies including: URL, Title, director, Genre, Actor, Rating, Quantity
		addMovieLabel = new JLabel("Add Movie: ");
		addMovieLabel.setForeground(Color.white);
		addMovieLabel.setFont(largeFont);
		urlLabel = new JLabel("URL: ");
		urlLabel.setForeground(Color.white);
		urlLabel.setFont(font);
		titleLabel = new JLabel("Title: ");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(font);
		directorLabel = new JLabel("Director: ");
		directorLabel.setForeground(Color.white);
		directorLabel.setFont(font);
		genreLabel = new JLabel("Genre: ");
		genreLabel.setForeground(Color.white);
		genreLabel.setFont(font);
		actorLabel = new JLabel("Actor: ");
		actorLabel.setForeground(Color.white);
		actorLabel.setFont(font);
		ratingLabel = new JLabel("Rating: ");
		ratingLabel.setForeground(Color.white);
		ratingLabel.setFont(font);
		quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setForeground(Color.white);
		quantityLabel.setFont(font);
		
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
		goAddMovie = new JButton();
		goAddMovie.setIcon(go1);
		goAddMovie.setBorder(null);
		goAddMovie.setRolloverIcon(go2);
		goAddMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//TextFields
		enterUrl = new JTextField(25);
		enterTitle = new JTextField(25);
		enterDirector = new JTextField(25);
		enterGenre = new JTextField(25);
		enterActor = new JTextField(25);
		enterRating = new JTextField(25);
		enterQuantity = new JTextField(25);
		
		//Create Panels
		addMoviePanel = new JPanel();
		addMoviePanel.setLayout(new BoxLayout(addMoviePanel, BoxLayout.Y_AXIS));
		addMoviePanel.setBackground(Color.BLACK);
		addMoviePanel.setBorder(new LineBorder(Color.white, 3));
		addMovieLabelPanel = new JPanel();
		addMovieLabelPanel.setBackground(Color.BLACK);
		urlPanel = new JPanel();
		urlPanel.setBackground(Color.BLACK);
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.black);
		directorPanel = new JPanel();
		directorPanel.setBackground(Color.BLACK);
		genrePanel = new JPanel();
		genrePanel.setBackground(Color.black);
		actorPanel = new JPanel();
		actorPanel.setBackground(Color.black);
		ratingPanel = new JPanel();
		ratingPanel.setBackground(Color.black);
		quantityPanel = new JPanel();
		quantityPanel.setBackground(Color.BLACK);
		addMovieButtonPanel = new JPanel();
		addMovieButtonPanel.setBackground(Color.BLACK);
		
		//Add labels, textfields, and buttons to respective panels
		addMovieLabelPanel.add(addMovieLabel);
		urlPanel.add(urlLabel);
		urlPanel.add(enterUrl);
		titlePanel.add(titleLabel);
		titlePanel.add(enterTitle);
		directorPanel.add(directorLabel);
		directorPanel.add(enterDirector);
		genrePanel.add(genreLabel);
		genrePanel.add(enterGenre);
		actorPanel.add(actorLabel);
		actorPanel.add(enterActor);
		ratingPanel.add(ratingLabel);
		ratingPanel.add(enterRating);
		quantityPanel.add(quantityLabel);
		quantityPanel.add(enterQuantity);
		addMovieButtonPanel.add(goAddMovie);
		
		//Add panels to encompassing panel
		addMoviePanel.add(addMovieLabelPanel);
		addMoviePanel.add(urlPanel);
		addMoviePanel.add(titlePanel);
		addMoviePanel.add(directorPanel);
		addMoviePanel.add(genrePanel);
		addMoviePanel.add(ratingPanel);
		addMoviePanel.add(quantityPanel);
		addMoviePanel.add(addMovieButtonPanel);
		
		//Adds everything to one panel to be added to the UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.setBackground(Color.BLACK);
		everythingPanel.add(addMoviePanel);
	}
	
	/**
	 * 
	 * @return
	 */
	public static JPanel getPanel(){
		return everythingPanel;
	}
}
