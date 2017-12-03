package projPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * View popular movies and recently added movies. Search for a specific movie that you want to rent.
 * @author laurenblatchford
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
	
	private static JButton jb_addAccount; 
	private static JButton jb_addMovie;
	private static JButton jb_goAccount;
	
	public Home(){
		//Creates labels for search, recently added movies, and popular movies

		searchPanel = new JPanel();
		SearchBar search = new SearchBar(searchPanel);
		for(int i = 0; i < search.str_title.size(); i ++)
		{
			search.jp_searches[i].setBackground(Color.BLACK);
		}
		searchPanel.setLayout(new FlowLayout());
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

			@Override
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

			@Override
			public void actionPerformed(ActionEvent e) {
				UI.updateBottomPanel("addmovie");
				
			}
			
		});
		jp_addMovie = new JPanel();
		jp_addMovie.setBackground(Color.BLACK);
		jp_addMovie.add(jb_addMovie);
		
		
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.add(jp_addAccount);
		topPanel.add(jp_addMovie);
		
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
