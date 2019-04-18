package thomas.game.gui;

import javax.swing.*;

public class Gui {

		public static void run() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
			
			JFrame frame = new MainFrame(">>Generic Adventrue<<");
			
			frame.setSize(1000, 700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
				}
			});
		}
	}