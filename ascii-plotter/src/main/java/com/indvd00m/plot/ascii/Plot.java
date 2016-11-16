package com.indvd00m.plot.ascii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:46:00 PM
 *
 */
public class Plot implements IPlot {

	int width = 80;
	int height = 20;
	List<StringBuilder> lines;
	String string;

	public Plot(int width, int height) {
		if (width <= 0)
			throw new IllegalArgumentException();
		if (height <= 0)
			throw new IllegalArgumentException();

		this.width = width;
		this.height = height;
		lines = new ArrayList<StringBuilder>(height);
		for (int y = 0; y < height; y++) {
			StringBuilder line = new StringBuilder(width);
			String emptyLine = repeatChar(' ', width);
			line.append(emptyLine);
			lines.add(line);
		}

		updateString();
	}

	private void updateString() {
		StringBuilder sb = new StringBuilder();
		for (int i = lines.size() - 1; i >= 0; i--) {
			StringBuilder line = lines.get(i);
			sb.append(line).append('\n');
		}
		string = sb.toString();
	}

	private String repeatChar(char c, int count) {
		return repeatString(c + "", count);
	}

	private String repeatString(String s, int count) {
		String repeated = new String(new char[count]).replace("\0", s);
		return repeated;
	}

	@Override
	public void draw(int x, int y, String s) {
		if (x >= width)
			throw new IllegalArgumentException();
		if (y >= height)
			throw new IllegalArgumentException();

		if (s.matches("[\\n\\r]+")) { // multilined string
			for (String line : s.split("[\\n\\r]+")) {
				draw(x, y++, line);
				if (y >= height)
					break;
			}
			return;
		}

		if (s.length() > width - x)
			s = s.substring(0, width - x);

		StringBuilder line = lines.get(y);
		line.replace(x, x + s.length(), s);

		updateString();
	}

	@Override
	public void draw(int x, int y, String s, int count) {
		draw(x, y, repeatString(s, count));
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public List<StringBuilder> getLines() {
		return lines;
	}

	@Override
	public String getString() {
		return string;
	}

	@Override
	public String toString() {
		return getString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

}
