import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;

public class Admin {
	private static JPanel everythingPanel;
	private JPanel searchMoviePanel;
	private JPanel searchCustomersPanel;
	private JPanel addMoviePanel;
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
	private JTextField enterMovie;
	private JTextField enterCustomer;
	private JTextField enterUrl;
	private JTextField enterTitle;
	private JTextField enterDirector;
	private JTextField enterGenre;
	private JTextField enterActor;
	private JTextField enterRating;
	private JTextField enterQuantity;
	private JButton goAddMovie;
	private JButton goSearchMovies;
	private JButton goSearchCustomers;
	private Font font;
	
	public Admin(){
		//Creates labels for search movies and customers
		//Sets the font to Calisto MT, white
		font = new Font("Calisto MT", Font.ITALIC, 18);
		searchMoviesLabel = new JLabel("Search a movie to edit or delete");
		searchMoviesLabel.setForeground(Color.white);
		searchMoviesLabel.setFont(font);
		searchCustomersLabel = new JLabel("Search Customer to View and Edit fees");
		searchCustomersLabel.setForeground(Color.WHITE);
		searchCustomersLabel.setFont(font);
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
		quantityLabel = new JLabel();
		quantityLabel.setForeground(Color.white);
		quantityLabel.setFont(font);
		
		//Go button -> Adds movie to database
		goAddMovie = new JButton();
		goAddMovie.setIcon(new ImageIcon("Go1.jpg"));
		goAddMovie.setBorder(null);
		goAddMovie.setRolloverIcon(new ImageIcon("Go2.jpg"));
		goAddMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Search movie to edit or delete
		goSearchMovies = new JButton();
		goSearchMovies.setIcon(new ImageIcon("Go1.jpg"));
		goSearchMovies.setBorder(null);
		goSearchMovies.setRolloverIcon(new ImageIcon("Go2.jpg"));
		goSearchMovies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Go button -> Search customer to edit
		goSearchCustomers = new JButton();
		goSearchCustomers.setIcon(new ImageIcon("Go1.jpg"));
		goSearchCustomers.setBorder(null);
		goSearchCustomers.setRolloverIcon(new ImageIcon("Go2.jpg"));
		goSearchCustomers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//TextFields
		enterMovie = new JTextField(30);
		enterCustomer = new JTextField(30);
		enterUrl = new JTextField(30);
		enterTitle = new JTextField(30);
		enterDirector = new JTextField(30);
		enterGenre = new JTextField(30);
		enterRating = new JTextField(30);
		enterQuantity = new JTextField(30);
		
		
	}
	
	public static JPanel getPanel(){
		return everythingPanel;
	}
}
