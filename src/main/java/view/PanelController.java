package view;

import javax.swing.JFrame;

import controller.UsuarioController;
import model.Tipo;
import model.Usuario;

public class PanelController {
	JFrame frame;
	private static PanelController p;
	private PanelController() {}
	public static PanelController getInstance() {
		if(p==null) {
			p=new PanelController();
		}
		return p;
	}
	public void start() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(UsuarioController.getInstance().getLoggedUser().getTipo()==Tipo.ADMINISTRADOR) {
			frame.add(new PanelTelaAdmin());
		}else {
			frame.add(new PanelTelaVendedor());
		}
		frame.setVisible(true);
	}
}
