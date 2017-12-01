package projPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * View popular movies and recently added movies. Search for a specific movie that you want to rent.
 * @author laurenblatchford
 *
 */
public class Home {
	private static JPanel everythingPanel;
	private JPanel logInSignUpPanel;
	private JPanel searchPanel;
	private JPanel recentlyAddedPanel;
	private static JPanel recentlyAddedListPanel;
	private JPanel popularPanel;
	private static JPanel popularListPanel;
	private JLabel searchLabel;
	private JLabel recentlyAddedLabel;
	private JLabel popularLabel;
	private JTextField enterSearch;
	private JButton go;
	private JButton logIn;
	private JButton signUp;
	private JButton logOut;
	private Font font;
	private Font largefont;
	
	public Home(){
		//Creates labels for search, recently added movies, and popular movies
		//sets main font to Caliso MT, white, large font is larger for categories
		font = new Font("Calisto MT", Font.ITALIC, 18);
		searchLabel = new JLabel("Search Movies");
		searchLabel.setForeground(Color.white);
		searchLabel.setFont(font);
		largefont = new Font("Calisto MT", Font.BOLD, 30);
		recentlyAddedLabel = new JLabel("Recently Added Movies");
		recentlyAddedLabel.setForeground(Color.white);
		recentlyAddedLabel.setFont(largefont);
		popularLabel = new JLabel("Popular Movies");
		popularLabel.setForeground(Color.white);
		popularLabel.setFont(largefont);
		
		//Creates textfield to search for specific movies
		enterSearch = new JTextField("Enter Movie Title, Director, Star, or Genre", 30);
		enterSearch.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				enterSearch.setText("");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		
		//Creates "Go" button from an image -> generates list of movies
		go = new JButton();
		go.setIcon(new ImageIcon("Go1.jpg"));
		go.setBorder(null);
		go.setRolloverIcon(new ImageIcon("Go2.jpg"));
		go.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		go.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(enterSearch.getText());
			}
			
		});
		
		//Creates "Login" button from image -> goes to Login page
		//Only appears if user is logged in
		logIn = new JButton();
		logIn.setIcon(new ImageIcon("login1.jpg"));
		logIn.setBorder(null);
		logIn.setRolloverIcon(new ImageIcon("login2.jpg"));
		logIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates "Sign up" button -> goes to Register page
		//Only appears if user is logged in
		signUp = new JButton();
		signUp.setIcon(new ImageIcon("signup1.jpg"));
		signUp.setBorder(null);
		signUp.setRolloverIcon(new ImageIcon("signup2.jpg"));
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates "Log Out" button -> goes to Home page
		logOut = new JButton();
		logOut.setIcon(new ImageIcon("logout1.jpg"));
		logOut.setBorder(null);
		logOut.setRolloverIcon(new ImageIcon("logout2.jpg"));
		logOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Creates the panels, sets background to black, adds labels, textfield, and button to panels
		logInSignUpPanel = new JPanel();
		logInSignUpPanel.setBackground(Color.black);
		logInSignUpPanel.add(signUp);
		logInSignUpPanel.add(logIn);
		searchPanel = new JPanel();
		SearchBar search = new SearchBar(searchPanel);
		search.masterPanel.setBackground(Color.black);
		for(int i = 0; i < search.str_title.size(); i ++)
		{
			search.jl_searches[i].setForeground(Color.white);
			search.jp_searches[i].setBackground(Color.BLACK);
		}
		searchPanel.setLayout(new FlowLayout());
		searchPanel.setBackground(Color.black);
		searchPanel.add(searchLabel);
		searchPanel.add(enterSearch);
		searchPanel.add(go);
		recentlyAddedPanel = new JPanel();
		recentlyAddedPanel.setBackground(Color.BLACK);
		recentlyAddedPanel.add(recentlyAddedLabel);
		recentlyAddedListPanel = new JPanel();
		recentlyAddedListPanel.setLayout(new FlowLayout());
		recentlyAddedListPanel.setBackground(Color.BLACK);
		popularPanel = new JPanel();
		popularPanel.setBackground(Color.BLACK);
		popularPanel.add(popularLabel);
		popularListPanel = new JPanel();
		popularListPanel.setLayout(new FlowLayout());
		popularListPanel.setBackground(Color.BLACK);
		
		//Adds everything to one panel to be added to the UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.setBackground(Color.BLACK);
		everythingPanel.add(logInSignUpPanel);
		everythingPanel.add(searchPanel);
		everythingPanel.add(recentlyAddedPanel);
		everythingPanel.add(recentlyAddedListPanel);
		everythingPanel.add(popularPanel);
		everythingPanel.add(popularListPanel);
	}
	
	/**
	 * Takes a movie title, looks up corresponding movie in database, 
	 * adds it to the recent movies list.
	 * @param movieTitle - Title of the movie to be entered
	 */
	public static void addRecent(String movieTitle){
		//Code to find movie in database
		
		//Example code
		Movie movie = new Movie("https://images-na.ssl-images-amazon.com/images/M/MV5BOGNkMzliMGMtMDI5Ni00OTZkLTgyMTYtNzk5ZTY1NjVhYjVmXkEyXkFqcGdeQXVyNTAzMTY4MDA@._V1_SY1000_SX675_AL_.jpg", "title", "director", "genre", "actor", "rating", 3);
		recentlyAddedListPanel.add(movie.getPanel());
	}
	/**
	 * Takes movie title, looks up corresponding movie in database, 
	 * adds it to the popular movies list.
	 * @param movieTitle - Title of the movie to be entered
	 */
	public static void addPopular(String movieTitle){
		//Code to find movie in database
		
		//Example code
		
	}
	
	/**
	 * Gets the panel with everything in it for the Home page.
	 * @return JPanel everythingPanel - The panel with all labels, textfields, and buttons in it.
	 */
	public static JPanel getPanel(){
		//Example adding movie:
		addRecent("The Disaster Artist");
		return everythingPanel;
	}
}
