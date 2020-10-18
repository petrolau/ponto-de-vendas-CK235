package util;

import java.awt.GraphicsEnvironment;

import controller.VendaController;

public class TestePdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment grEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		grEnv.registerFont(ResourceFinder.getFiraCodeFont());
		Utils.gerarRelatorioVendas(VendaController.getVendasList());
	}

}
