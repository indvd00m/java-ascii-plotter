package com.indvd00m.plot.ascii;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:45:16 PM
 *
 */
public interface IPlot {

	String getString();

	List<StringBuilder> getLines();

	int getHeight();

	int getWidth();

	void draw(int x, int y, String s);

	void draw(int x, int y, String s, int count);

}
