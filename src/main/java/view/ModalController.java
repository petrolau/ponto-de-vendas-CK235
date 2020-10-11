package view;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModalController {
	private JFrame modal;
	private static ModalController mc;
	private JPanel atual;

	private ModalController() {
	}

	public static ModalController getInstance() {
		if (mc == null) {
			mc = new ModalController();
		}
		return mc;
	}

	public void createModal(JPanel jp) {
		createModal(jp,null);
	}
	public void createModal(JPanel jp,Component parent) {
		modal = new JFrame();
		modal.setBounds(0,0, 560, 390);
		modal.setResizable(false);
		modal.setLocationRelativeTo(parent);
		modal.add(jp);
		modal.setVisible(true);
		atual=jp;
		
	}
	public void closeModal() {
		modal.remove(atual);
		modal.setVisible(false);
		modal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
