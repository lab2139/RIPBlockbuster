import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Creates a panel for movie poster picture, title, director, genre, lead actor, and rating
 * @author laurenblatchford
 *
 */
public class Movie {
	private static JPanel moviePanel;
	private JPanel imagePanel;
	private JPanel infoPanel;
	private String picurlString;
	private String titleString;
	private String directorString;
	private String genreString;
	private String actorString;
	private String ratingString;
	private JLabel movieImgLabel;
	private JLabel titleLabel;
	private JLabel directorLabel;
	private JLabel genreLabel;
	private JLabel actorLabel;
	private JLabel ratingLabel;
	private BufferedImage moviePoster;
	private Image moviePosterScaled;
	private URL moviePosterURL;
	private Font font;
	private final int POSTER_WIDTH = 75;
	private final int POSTER_HEIGHT = 113;
	
	
	/**
	 * Takes the picture url, title, director, genre, actor, and that will be generated from the database, and sets up
	 * a panel for the poster image to the left, and the movie info to the right. 
	 * 
	 * @param picurl - The String containing the URL of the movie poster
	 * @param title - The String of the movie title
	 * @param director - The String of the director 
	 * @param genre - The String of the genre
	 * @param actor - The String of the actor
	 * @param rating - The String of the rating
	 */
	public Movie(String picurl, String title, String director, String genre, String actor, String rating){
		//Assign arguments to variables.
		picurlString = picurl;
		titleString = title;
		directorString = director;
		genreString = genre;
		actorString = actor;
		ratingString = rating;
		
		//Get the URL from the picture URL String
		try{
			moviePosterURL = new URL(picurlString);
			moviePoster = ImageIO.read(moviePosterURL);
		} catch (MalformedURLException ex){
			System.out.println("Malformed URL");
		} catch (IOException iox){
			System.out.println("Cannot load file");
		}
		
		//Change image size
		Image moviePosterScaled = moviePoster.getScaledInstance(POSTER_WIDTH, POSTER_HEIGHT, Image.SCALE_SMOOTH);
		
		//Create Labels
		movieImgLabel = new JLabel(new ImageIcon(moviePosterScaled));
		titleLabel = new JLabel(titleString);
		directorLabel = new JLabel("Lead Director: " + directorString);
		genreLabel = new JLabel("Genre: " + genreString);
		actorLabel = new JLabel("Star: " + actorString);
		ratingLabel = new JLabel("Rating: " + ratingString);
		
		//Change Label fonts
		font = new Font("Calisto MT", Font.BOLD, 12);
		titleLabel.setForeground(Color.white);
		directorLabel.setForeground(Color.white);
		genreLabel.setForeground(Color.white);
		actorLabel.setForeground(Color.white);
		ratingLabel.setForeground(Color.white);
		titleLabel.setFont(font);
		directorLabel.setFont(font);
		genreLabel.setFont(font);
		actorLabel.setFont(font);
		ratingLabel.setFont(font);
		
		//Create Panels
		moviePanel = new JPanel();
		moviePanel.setLayout(new FlowLayout());
		moviePanel.setBackground(Color.BLACK);
		imagePanel = new JPanel();
		imagePanel.setBackground(Color.BLACK);
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setBackground(Color.BLACK);
		
		//Add labels to Panels
		imagePanel.add(movieImgLabel);
		infoPanel.add(titleLabel);
		infoPanel.add(directorLabel);
		infoPanel.add(genreLabel);
		infoPanel.add(actorLabel);
		infoPanel.add(ratingLabel);
		
		//Add image panel and info panel to main panel
		moviePanel.add(imagePanel);
		moviePanel.add(infoPanel);
	}
	
	/**
	 * Gets the main panel, moviePanel
	 * @return moviePanel - The main panel with the movie image panel and movie info inside it.
	 */
	public static JPanel getPanel(){
		return moviePanel;
	}

	public static void main(String[] args) {

	}

}
