package view;

import java.awt.GraphicsEnvironment;

import javax.swing.UIManager;

import util.ResourceFinder;

public class ModalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment grEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		grEnv.registerFont(ResourceFinder.getFiraCodeFont());
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.err.println(e);
		}
		ModalController.getInstance().createModal(new PanelAdicionarAdmin());
	}

}
