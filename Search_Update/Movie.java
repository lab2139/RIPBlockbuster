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
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Creates a panel for movie poster picture, title, director, genre, lead actor, rating, and number of inventory
 * @author laurenblatchford
 *
 */
public class Movie {
	private static JPanel moviePanel;
	private JPanel imagePanel;
	private JPanel infoPanel;
	private int quantityInt;
	private String picurlString;
	private String titleString;
	private String directorString;
	private String genreString;
	private String actorString;
	private String ratingString;
	private String quantityString;
	private JLabel movieImgLabel;
	private JLabel titleLabel;
	private JLabel directorLabel;
	private JLabel genreLabel;
	private JLabel actorLabel;
	private JLabel ratingLabel;
	private JLabel quantityLabel;
	private JButton reserve;
	private BufferedImage moviePoster;
	private Image moviePosterScaled;
	private URL moviePosterURL;
	private Font font;
	private final int POSTER_WIDTH = 100;
	private final int POSTER_HEIGHT = 160;
	
	
	/**
	 * Takes the picture url, title, director, genre, actor, rating, and stock, and that will be generated from the database, and sets up
	 * a panel for the poster image to the left, and the movie info to the right. 
	 * Adds a button to reserve the movie to pick up from the store.
	 * 
	 * @param picurl - The String containing the URL of the movie poster
	 * @param title - The String of the movie title
	 */
	public Movie(String picurl, String title){
		//Assign arguments to variables.
		picurlString = picurl;
		titleString = title;
		
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
		
		//Change Label fonts
		font = new Font("Calisto MT", Font.BOLD, 12);
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(font);
		
		//Create Panels
		moviePanel = new JPanel();
		moviePanel.setLayout(new FlowLayout());
		moviePanel.setBackground(Color.BLACK);
		imagePanel = new JPanel();
		imagePanel.setBackground(Color.BLACK);
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setBackground(Color.BLACK);
		
		//Add labels to Panels
		imagePanel.add(movieImgLabel);
		infoPanel.add(titleLabel);

		//Add image panel and info panel to main panel
		moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
		moviePanel.add(imagePanel);
		moviePanel.add(infoPanel);
		
		//moviePanel.addMouseListener(l);
	}
	
	/**
	 * Gets the main panel, moviePanel
	 * @return moviePanel - The main panel with the movie image panel and movie info inside it.
	 */
	public JPanel getPanel(){
		return moviePanel;
	}
}
