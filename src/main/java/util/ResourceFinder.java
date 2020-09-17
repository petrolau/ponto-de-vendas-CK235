package util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ResourceFinder {
	private ResourceFinder() {
	}

	private static Font f;
	private static Image book;

	public static Font getFiraCodeFont() {
		if (f == null) {
			InputStream is = ResourceFinder.class.getClassLoader().getResourceAsStream("font/FiraCode-Regular.ttf");
			try {
				f = Font.createFont(Font.TRUETYPE_FONT, is);
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

	public static Image getBookImage() {
		if (book == null) {
			InputStream is = ResourceFinder.class.getClassLoader().getResourceAsStream("book.png");
			try {
				book = ImageIO.read(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
	public static Image getScaledBookImage(int side) {
		return getBookImage().getScaledInstance(side, side, Image.SCALE_SMOOTH);
	}
	public static Image getScaledBookImage(int width,int height) {
		return getBookImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

}
