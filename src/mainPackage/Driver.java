package mainPackage;

import java.net.MalformedURLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws MalformedURLException {
		
		MainFrame window = new MainFrame("Elior's Weather Channel");
		SwingUtilities.invokeLater(window);
	}
}
