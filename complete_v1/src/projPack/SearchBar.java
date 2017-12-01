package projPack;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.util.*;



public class SearchBar extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://webdev.cislabs.uncw.edu:3306/klk8027";

	//  Database credentials
	static final String USER = "klk8027";
	static final String PASS = "ONArfYtFw";
	
	//Holds Database information for search
	ArrayList<String >str_title = new ArrayList<String>();
	ArrayList<String >str_genre = new ArrayList<String>();
	ArrayList<String >str_actor = new ArrayList<String>();
	boolean[] isShown;
	
	//Creates Search information
	JPanel f;
	JPanel[] jp_searches;
	JLabel[] jl_searches;
	JPanel moviePanel = new JPanel();
	JPanel masterPanel = new JPanel();
	
	//Radio Buttons to define search
	ButtonGroup searchType = new ButtonGroup();
	JRadioButton jrb_title = new JRadioButton("Title");
	JRadioButton jrb_genre = new JRadioButton("Genre");
	JRadioButton jrb_actor = new JRadioButton("Actor");
	
	//Text Field for Searching
	JTextField searchbar = new JTextField("Search by Title...", 20);
	JPanel searchPanel = new JPanel();
	JScrollPane scrollPane;
	
	/**
	 * Constructor for the Search Bar
	 * @param frame accesses the frame from the main
	 */
	public SearchBar(JPanel frame)
	{
		//creates local reference for main frame in class
		this.f = frame;
		masterPanel.setSize(400, 10000);
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
		masterPanel.add(searchPanel);
				
		//Queries the Database for all films, assigns to ArrayList
		loadDatabase();
		
		//Sets ArrayLists to size of Database
		jl_searches = new JLabel[str_title.size()];
		jp_searches = new JPanel[str_title.size()];
		masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
		moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
		isShown = new boolean[str_title.size()];
		scrollPane = new JScrollPane(moviePanel);
		
		//Formats the Search Results
		formatResults();
		
		masterPanel.add(scrollPane);
		f.add(masterPanel);

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
		        // nothing
		    }
		});
		
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
	}
	
	/**
	 * creates a panel for each label, adds to moviePanel and builds scroll bar
	 */
	public void formatResults()
	{
		//Adds Database information to GUI
		for(int i = 0; i < str_title.size(); i++)
		{
			jl_searches[i] = new JLabel(str_title.get(i));
			jp_searches[i] = new JPanel();
			jp_searches[i].add(jl_searches[i]);
			isShown[i] = true;
			moviePanel.add(jp_searches[i]);
		}
		
			
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(50, 30, 30, 50);
	}
	
	/**
	 * Loads the database for the search to utilize
	 */
	public void loadDatabase()
	{
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM movies where title like \"%\" ORDER by title";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         //Retrieve by column name
			    	 str_title.add(rs.getString("title"));
			    	 str_genre.add(rs.getString("genre"));
			    	 str_actor.add(rs.getString("lead_role"));
		      }
			         		      
		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	}
	
	/**
	 * Dynamically checks the Text Field to update the displayed results
	 */
	public void updateResults()
	{
		String searchtext = searchbar.getText();
		String searchString = "";
		
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
		moviePanel.setPreferredSize(moviePanel.getPreferredSize());
	}
}
