package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class TestePanels {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception e){
	    	System.err.println(e);
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestePanels window = new TestePanels();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestePanels() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 580);
		frame.add(new PanelVendas());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
