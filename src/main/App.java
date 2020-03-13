package main;



import java.awt.Frame;

import javax.swing.SwingUtilities;


import view.Window;

public class App {

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() ->{
			Window window = new Window();
			
			window.setVisible(true);
		});


	}

}
