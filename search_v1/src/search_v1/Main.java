package search_v1;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class Main {

	private static JFrame f = new JFrame("Testing Search");

	public static void main(String[] args) {
		new Main();
		
		f.setLayout(new FlowLayout());
		f.setSize(1280, 720);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SearchBar s = new SearchBar(f);
	
		f.setVisible(true);
	}

}
