package projPack;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

/**
 *Controls the search functionality of the database, dynamically
 *displays and hides movies as you change the search text,
 *as well as provides links to each movie's modify file to change
 *information about the film
 * @author davidjohnson justinsaunders kellykolb hayleystueber laurenblatchford
 *
 */

public class SearchBar extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ResultSet rs;
	
	//Holds Database information for search
	static ArrayList<String> str_title = new ArrayList<String>();
	static ArrayList<String> str_genre = new ArrayList<String>();
	static ArrayList<String> str_actor = new ArrayList<String>();
	static ArrayList<String> str_url = new ArrayList<String>();
	boolean[] isShown;
	
	//Creates Search information
	JPanel f;
	JPanel[] jp_searches;
	static Movie[] movieIcon;
	JPanel moviePanel = new JPanel();
	
	//Radio Buttons to define search
	ButtonGroup searchType = new ButtonGroup();
	JRadioButton jrb_title = new JRadioButton("Title");
	JRadioButton jrb_genre = new JRadioButton("Genre");
	JRadioButton jrb_actor = new JRadioButton("Actor");
	
	//Text Field for Searching
	static JTextField searchbar = new JTextField("Search by Title...", 20);
	JPanel searchPanel = new JPanel();
	//JScrollPane scrollPane;
	
	/**
	 * Constructor for the Search Bar
	 * @param frame accesses the frame from the main
	 */
	public SearchBar(JPanel frame)
	{
		//creates local reference for main frame in class
		this.f = frame;
		
		//SearchBar Setup
		searchbar.setBounds(20, 200, 200, 200);
		searchPanel.add(searchbar);
		
		//ButtonGroup Setup
		searchType.add(jrb_title);
		searchType.add(jrb_genre);
		searchType.add(jrb_actor);
		jrb_title.setSelected(true);
		searchPanel.setLayout((new BoxLayout(searchPanel, BoxLayout.X_AXIS)));
		searchPanel.add(jrb_title);
		searchPanel.add(jrb_genre);
		searchPanel.add(jrb_actor);
				
		//Queries the Database for all films, assigns to ArrayList
		rs = RQ.SelectTitle("");
		try{
		while(rs.next()){
	         //Retrieve by column name
	    	 str_title.add(rs.getString("title"));
	    	 str_genre.add(rs.getString("genre"));
	    	 str_actor.add(rs.getString("lead_role"));
	    	 str_url.add(rs.getString("movie_image"));	 
		}
	         		      
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		
		jp_searches = new JPanel[str_title.size()];
		movieIcon = new Movie[str_title.size()];
		
		moviePanel.setBackground(Color.BLACK);
		moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
		isShown = new boolean[str_title.size()];
		
		//Formats the Search Results
		formatResults();
		
		f.add(moviePanel);
		
		//Action Listener for Radio Buttons
		jrb_title.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				searchbar.setText("Search by Title...");
				setAllVisible();
			}
		});
		jrb_genre.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				searchbar.setText("Search for Genre...");
				setAllVisible();
			}
		});
		jrb_actor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				searchbar.setText("Search for Actors...");
				setAllVisible();
			}
		});

		//Document Listener for search bar to dynamically update results
		searchbar.getDocument().addDocumentListener(new DocumentListener()
		{
			public void changedUpdate(DocumentEvent e) {
				updateResults();
			}
			public void insertUpdate(DocumentEvent e) {
				updateResults();
			}
			public void removeUpdate(DocumentEvent e) {
				updateResults();
			}
		});
		
		//Focus Listener for Search Bar
		searchbar.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	searchbar.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	//Do Nothing
		    }
		});	
	}
	/**
	 * Used to set all panels to visible when changing search type
	 */
	public void setAllVisible()
	{
		for(int i = 0; i < str_title.size(); i++)
		{
			jp_searches[i].setVisible(true);
			isShown[i] = true;
		}
		f.setPreferredSize(moviePanel.getPreferredSize());

	}
	
	/**
	 * creates a panel for each label, adds to moviePanel and builds scroll bar
	 */
	public void formatResults()
	{
		//Adds Database information to GUI
		for(int i = 0; i < str_title.size(); i++)
		{
			//jl_searches[i] = new JLabel(str_title.get(i));
			movieIcon[i] = new Movie(str_url.get(i), str_title.get(i));
			movieIcon[i].movieID = i;
			jp_searches[i] = new JPanel();
			jp_searches[i].add(movieIcon[i].getPanel());
			isShown[i] = true;
			moviePanel.add(jp_searches[i]);
		}
	}
		
	/**
	 * Dynamically checks the Text Field to update the displayed results
	 */
	public void updateResults()
	{
		String searchtext = searchbar.getText();
		String searchString = "";
		
		if(searchtext == "Search for Genre..." || searchtext == "Search for Actors..." || searchtext == "Search by Title...")
		{
			setAllVisible();
		}
		else
		{
			//Iterates through database to see if film matches
			for(int i = 0; i < str_title.size(); i++)
			{
				//Checks which radio button is selected to determine search type
				if(jrb_title.isSelected()) 
				{
					searchString = str_title.get(i);
				}
				else if(jrb_genre.isSelected()) 
				{
					searchString = str_genre.get(i);
				}
				else if(jrb_actor.isSelected()) 
				{
					searchString = str_actor.get(i);
				}
			
				//If film does not match search string, hide from results
				if(!searchString.toLowerCase().contains(searchtext.toLowerCase()))
				{
					jp_searches[i].setVisible(false);
					isShown[i] = false;
					
				}
				//If title is hidden and matches search string, make visible
				else if(isShown[i] == false && searchString.toLowerCase().contains(searchtext.toLowerCase()))
				{
					jp_searches[i].setVisible(true);
					isShown[i] = true;
				}
			
			}
		}
		f.setPreferredSize(moviePanel.getPreferredSize());
	}
}
