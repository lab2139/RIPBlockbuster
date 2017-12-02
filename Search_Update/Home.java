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
