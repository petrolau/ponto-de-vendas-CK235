package util;

public class Utils {

	public static boolean areEmpty(String... args) {
		boolean result = false;
		for (String s : args) {
			result |= (s.isEmpty());
		}
		return result;
	}
}
