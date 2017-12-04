package projPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

/**
 * View popular movies and recently added movies. Search for a specific movie that you want to rent.
 * @author davidjohnson justinsaunders kellykolb hayleystueber laurenblatchford
 *
 */
public class Home {
	private static JPanel everythingPanel;

	private JPanel searchPanel;
	private JScrollPane scrollPane;
	
	
	private static JPanel jp_addAccount;
	private static JPanel jp_addMovie;
	private static JPanel jp_goAccount;
	
	private static JLabel jl_goAccount;
	static JTextField accountSearch;
	
	private static JButton jb_addAccount; 
	private static JButton jb_addMovie;
	private static JButton jb_goAccount;
	
	public static ViewCustomer accountView;
	
	boolean exists = false;
	
	public Home(){
		//Creates labels for search, recently added movies, and popular movies

		searchPanel = new JPanel();
		SearchBar search = new SearchBar(searchPanel);
		for(int i = 0; i < search.str_title.size(); i ++)
		{
			search.jp_searches[i].setBackground(Color.BLACK);
		}
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		//searchPanel.setPreferredSize(new Dimension(1280, 620));
		searchPanel.setBackground(Color.black);
		

		//Adds everything to one panel to be added to the UI
		everythingPanel = new JPanel();
		everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));
		everythingPanel.setBackground(Color.BLACK);
		
		//Button Setup
		jb_addAccount = new JButton();
		jb_addAccount.setIcon(new ImageIcon("addCustomer1.jpg"));
		jb_addAccount.setBorder(null);
		jb_addAccount.setRolloverIcon(new ImageIcon("addCustomer2.jpg"));
		jb_addAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb_addAccount.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				UI.updateBottomPanel("addcust");
			}					
		});
		jp_addAccount = new JPanel();
		jp_addAccount.setBackground(Color.black);
		jp_addAccount.add(jb_addAccount);
		
		jb_addMovie = new JButton();
		jb_addMovie.setIcon(new ImageIcon("addmovie1.jpg"));
		jb_addMovie.setBorder(null);
		jb_addMovie.setRolloverIcon(new ImageIcon("addmovie2.jpg"));
		jb_addMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb_addMovie.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				UI.updateBottomPanel("addmovie");
				
			}
			
		});
		jp_addMovie = new JPanel();
		jp_addMovie.setBackground(Color.BLACK);
		jp_addMovie.add(jb_addMovie);
		
		
		
		jl_goAccount = new JLabel("Search for Email Address");
		jl_goAccount.setForeground(Color.WHITE);
		accountSearch = new JTextField("", 20);
		
		jb_goAccount = new JButton();
		jb_goAccount.setIcon(new ImageIcon("go1.jpg"));
		jb_goAccount.setBorder(null);
		jb_goAccount.setRolloverIcon(new ImageIcon("go2.jpg"));
		jb_goAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jb_goAccount.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String accountName = accountSearch.getText();
				ResultSet rs = RQ.GetCustomers();
				exists = false;
				try{
					while(rs.next()){
						String existing = rs.getString("email");
						if(accountName.equals(existing))
						{
							exists = true;
							break;
						}
					}
				}catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				}catch(Exception ex){
					//Handle errors for Class.forName
					ex.printStackTrace();
				}
				
				if(!exists)
				{
					JOptionPane.showMessageDialog(UI.frame, "Email Address Not Found");
				}
				else
				{
					accountView = new ViewCustomer(accountName);
					UI.updateBottomPanel("account");
				}
				
			}
			
		});
		
		jp_goAccount = new JPanel();
		jp_goAccount.setBackground(Color.BLACK);
		jp_goAccount.setLayout(new FlowLayout());
		jp_goAccount.add(jl_goAccount);
		jp_goAccount.add(accountSearch);
		jp_goAccount.add(jb_goAccount);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.BLACK);
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.add(jp_addAccount);
		topPanel.add(jp_addMovie);
		topPanel.add(jp_goAccount);
		
		everythingPanel.add(topPanel);
		everythingPanel.add(search.searchPanel);
		scrollPane = new JScrollPane(searchPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(50, 30, 30, 50);
		everythingPanel.add(scrollPane);

	}

	/**
	 * Gets the panel with everything in it for the Home page.
	 * @return JPanel everythingPanel - The panel with all labels, textfields, and buttons in it.
	 */
	public static JPanel getPanel(){
		//Example adding movie:
		return everythingPanel;
	}
}
