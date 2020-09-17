package util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class ResourceFinder {
	private ResourceFinder() {}
	private static Font f;
	public static Font getFiraCodeFont() {
		if(f==null) {
			InputStream is =ResourceFinder.class.getClassLoader().getResourceAsStream("font/FiraCode-Regular.ttf");
			try {
				f=Font.createFont(Font.TRUETYPE_FONT, is);
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return f;
			
	}


}
