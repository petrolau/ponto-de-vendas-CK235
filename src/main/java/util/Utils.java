package util;

import javax.swing.JOptionPane;

public class Utils {

	public static boolean areEmpty(String... args) {
		boolean result = false;
		for (String s : args) {
			result |= (s.isEmpty());
		}
		return result;
	}
	public static void errorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	

}

