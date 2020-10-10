package view;

public class ModalController {
	private static ModalController mc;
	private ModalController() {}
	public static ModalController getInstance() {
		if(mc==null) {
			mc=new ModalController();
		}
		return mc;
	}
}
