package view;



import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.UsuarioController;
import model.Tipo;


public class PanelController {
	JFrame frame;
	Stack<JPanel> panelStack = new Stack<>();
	JPanel atual=null;
	private static PanelController p;


	private PanelController() {
	}

	public static PanelController getInstance() {
		if (p == null) {
			p = new PanelController();
		}
		return p;
	}

	private void draw(JPanel p) {
		frame.getContentPane().add(p);
		atual=p;
	}
	// Vai carregar o proximo painelno frame

	public void trocar(JPanel p) {
		
		if(atual!=null) {
			frame.remove(atual);
		}
		panelStack.push(atual);
		draw(p);
		
	}

	public void retornar() {
		frame.remove(atual);
		frame.revalidate();
		frame.repaint();
		draw(panelStack.pop());
	}
	public void encerrar() {
		
	}

	public void start() {
		frame = new JFrame();
		frame.setBounds(20,20, 768, 600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		if (UsuarioController.getInstance().getLoggedUser().getTipo() == Tipo.ADMINISTRADOR) {
			this.draw(new PanelTelaAdmin());
		} else {
			this.draw(new PanelTelaVendedor());
		}
		frame.setVisible(true);
	

	}
}
