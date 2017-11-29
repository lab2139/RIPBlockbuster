import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Admin {
	private static JPanel everythingPanel;
	private JPanel searchMoviesPanel;
	private JPanel searchCustomersPanel;
	private JPanel addMoviePanel;
	private JPanel addMovieLabelPanel;
	private JPanel urlPanel;
	private JPanel titlePanel;
	private JPanel directorPanel;
	private JPanel genrePanel;
	private JPanel ratingPanel;
	private JPanel quantityPanel;
	private JPanel addMovieButtonPanel;
	private JPanel addRecentPanel;
	private JPanel removeRecentPanel;
	private JPanel addPopularPanel;
	private JPanel removePopularPanel;
	private JLabel searchMoviesLabel;
	private JLabel searchCustomersLabel;
	private JLabel addMovieLabel;
	private JLabel urlLabel;
	private JLabel titleLabel;
	private JLabel directorLabel;
	private JLabel genreLabel;
	private JLabel actorLabel;
	private JLabel ratingLabel;
	private JLabel quantityLabel;
	private JLabel addRecentLabel;
	private JLabel removeRecentLabel;
	private JLabel addPopularLabel;
	private JLabel removePopularLabel;
	private JTextField enterMovie;
	private JTextField enterCustomer;
	private JTextField enterUrl;
	private JTextField enterTitle;
	private JTextField enterDirector;
	private JTextField enterGenre;
	private JTextField enterActor;
	private JTextField enterRating;
	private JTextField enterQuantity;
	private JTextField enterAddRecent;
	private JTextField enterRemoveRecent;
	private JTextField enterAddPopular;
	private JTextField enterRemovePopular;
	private JButton goAddMovie;
	private JButton goSearchMovies;
	private JButton goSearchCustomers;
	private JButton goAddRecent;
	private JButton goRemoveRecent;
	private JButton goAddPopular;
	private JButton goRemovePopular;
	private Font font;
	private Font largeFont;
	private static JScrollPane everythingScroll;
	
	public Admin(){
		//Creates labels for search movies and customers
		//Sets the font to Calisto MT, white
		font = new Font("Calisto MT", Font.ITALIC, 12);
		largeFont = new Font("Calisto MT", Font.BOLD, 16);
		addMovieLabel = new JLabel("Add Movie: ");
		addMovieLabel.setForeground(Color.white);
		addMovieLabel.setFont(largeFont);
		searchMoviesLabel = new JLabel("Search a movie to edit or delete");
		searchMoviesLabel.setForeground(Color.white);
		searchMoviesLabel.setFont(largeFont);
		searchCustomersLabel = new JLabel("Search a customer to edit");
		searchCustomersLabel.setForeground(Color.WHITE);
		searchCustomersLabel.setFont(largeFont);
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
		addRecentLabel = new JLabel("Add Recently Added Movie");
		addRecentLabel.setForeground(Color.white);
		addRecentLabel.setFont(largeFont);
		removeRecentLabel = new JLabel("Remove Recently Added Movie");
		removeRecentLabel.setForeground(Color.white);
		removeRecentLabel.setFont(largeFont);
		addPopularLabel = new JLabel("Add Popular Movie");
		addPopularLabel.setForeground(Color.WHITE);
		addPopularLabel.setFont(largeFont);
		removePopularLabel = new JLabel("Remove Popular Movie");
		removePopularLabel.setForeground(Color.WHITE);
		removePopularLabel.setFont(largeFont);
		
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
		
		//Go button -> Search movie to edit or delete
		goSearchMovies = new JButton();
		goSearchMovies.setIcon(go1);
		goSearchMovies.setBorder(null);
		goSearchMovies.setRolloverIcon(go2);
		goSearchMovies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Search customer to edit
		goSearchCustomers = new JButton();
		goSearchCustomers.setIcon(go1);
		goSearchCustomers.setBorder(null);
		goSearchCustomers.setRolloverIcon(go2);
		goSearchCustomers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Add movie to recently added movies
		goAddRecent = new JButton();
		goAddRecent.setIcon(go1);
		goAddRecent.setBorder(null);
		goAddRecent.setRolloverIcon(go2);
		goAddRecent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Remove movie from recently added movies
		goRemoveRecent = new JButton();
		goRemoveRecent.setIcon(go1);
		goRemoveRecent.setBorder(null);
		goRemoveRecent.setRolloverIcon(go2);
		goRemoveRecent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Add movie to popular movies
		goAddPopular = new JButton();
		goAddPopular.setIcon(go1);
		goAddPopular.setBorder(null);
		goAddPopular.setRolloverIcon(go2);
		goAddPopular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Remove movie from recently added movies
		goRemovePopular = new JButton();
		goRemovePopular.setIcon(go1);
		goRemovePopular.setBorder(null);
		goRemovePopular.setRolloverIcon(go2);
		goRemovePopular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//TextFields
		enterMovie = new JTextField(20);
		enterCustomer = new JTextField(20);
		enterUrl = new JTextField(25);
		enterTitle = new JTextField(25);
		enterDirector = new JTextField(25);
		enterGenre = new JTextField(25);
		enterRating = new JTextField(25);
		enterQuantity = new JTextField(25);
		enterAddRecent = new JTextField(20);
		enterRemoveRecent = new JTextField(20);
		enterAddPopular = new JTextField(20);
		enterRemovePopular = new JTextField(20);
		
		//Create Panels
		addMoviePanel = new JPanel();
		addMoviePanel.setLayout(new BoxLayout(addMoviePanel, BoxLayout.Y_AXIS));
		addMoviePanel.setBackground(Color.BLACK);
		addMoviePanel.setBorder(new LineBorder(Color.white, 3));
		searchMoviesPanel = new JPanel();
		searchMoviesPanel.setBackground(Color.BLACK);
		searchMoviesPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchCustomersPanel = new JPanel();
		searchCustomersPanel.setBackground(Color.BLACK);
		searchCustomersPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
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
		ratingPanel = new JPanel();
		ratingPanel.setBackground(Color.black);
		quantityPanel = new JPanel();
		quantityPanel.setBackground(Color.BLACK);
		addMovieButtonPanel = new JPanel();
		addMovieButtonPanel.setBackground(Color.BLACK);
		addRecentPanel = new JPanel();
		addRecentPanel.setBackground(Color.BLACK);
		removeRecentPanel = new JPanel();
		removeRecentPanel.setBackground(Color.BLACK);
		removeRecentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		addPopularPanel = new JPanel();
		addPopularPanel.setBackground(Color.black);
		removePopularPanel = new JPanel();
		removePopularPanel.setBackground(Color.black);
		removePopularPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		
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
		ratingPanel.add(ratingLabel);
		ratingPanel.add(enterRating);
		quantityPanel.add(quantityLabel);
		quantityPanel.add(enterQuantity);
		addMovieButtonPanel.add(goAddMovie);
		addRecentPanel.add(addRecentLabel);
		addRecentPanel.add(enterAddRecent);
		addRecentPanel.add(goAddRecent);
		removeRecentPanel.add(removeRecentLabel);
		removeRecentPanel.add(enterRemoveRecent);
		removeRecentPanel.add(goRemoveRecent);
		addPopularPanel.add(addPopularLabel);
		addPopularPanel.add(enterAddPopular);
		addPopularPanel.add(goAddPopular);
		removePopularPanel.add(removePopularLabel);
		removePopularPanel.add(enterRemovePopular);
		removePopularPanel.add(goRemovePopular);
		searchMoviesPanel.add(searchMoviesLabel);
		searchMoviesPanel.add(enterMovie);
		searchMoviesPanel.add(goSearchMovies);
		searchCustomersPanel.add(searchCustomersLabel);
		searchCustomersPanel.add(enterCustomer);
		searchCustomersPanel.add(goSearchCustomers);
		
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
		everythingPanel.add(searchMoviesPanel);
		everythingPanel.add(searchCustomersPanel);
		everythingPanel.add(addRecentPanel);
		everythingPanel.add(removeRecentPanel);
		everythingPanel.add(addPopularPanel);
		everythingPanel.add(removePopularPanel);
	}
	
	public static JPanel getPanel(){
		return everythingPanel;
	}
}
