import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Creates a template UI for all other classes to add panels and elements.
 * @author Lauren Blatchford
 */
public class UI {
	private static JFrame frame;
	private JPanel bannerPanel;
	private JLabel bannerLabel;
	private BufferedImage banner;
	private static final int BANNER_WIDTH = 700;
	private static final int BANNER_HEIGHT = 100;
	
	
	/**
	 * Contructs the frame, adds the banner to a label in the top panel. 
	 */
	public UI(){
		}
	
	public static JFrame createFrame(){
		UI ui = new UI();
		Login login = new Login();
		Register register = new Register();
		Movie movie = new Movie("https://images-na.ssl-images-amazon.com/images/M/MV5BOGNkMzliMGMtMDI5Ni00OTZkLTgyMTYtNzk5ZTY1NjVhYjVmXkEyXkFqcGdeQXVyNTAzMTY4MDA@._V1_SY1000_SX675_AL_.jpg", "title", "director", "genre", "actor", "rating", 3);
		//Creates the banner label. Grabs the banner image and assigns it to the banner label
		//If image does not exist, print stack error
		ui.bannerLabel = new JLabel();
		ui.bannerLabel.setPreferredSize(new Dimension(BANNER_WIDTH, BANNER_HEIGHT));
		try {
			ui.banner = ImageIO.read(new File("projectbanner.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		//In the event the banner needs to be scaled up or down, allow smooth scaling
		Image scaledBanner = ui.banner.getScaledInstance(BANNER_WIDTH, BANNER_HEIGHT, Image.SCALE_SMOOTH);
		
		//Add the scaled banner to the banner label.
		ui.bannerLabel.setIcon(new ImageIcon(scaledBanner));
		
		//Creates banner panel, add the banner label
		ui.bannerPanel = new JPanel();
		ui.bannerPanel.setLayout(new BoxLayout(ui.bannerPanel, BoxLayout.X_AXIS));
		ui.bannerPanel.add(ui.bannerLabel);
		
		//Creates the frame
		frame = new JFrame("RIP BLOCKBUSTER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(ui.bannerPanel);
		frame.add(movie.getPanel());
		frame.pack();
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		return frame;
	}
	
	public static JFrame getFrame(){
		return frame;
	}
	
	public static void updateFrame(JFrame frame, JPanel panel){
		frame = getFrame();
		
		
	}
	
	public static void main(String[] args) {
		createFrame();
	}

}
