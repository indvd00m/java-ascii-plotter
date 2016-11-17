package com.indvd00m.plot.ascii.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.indvd00m.plot.ascii.IPlot;
import com.indvd00m.plot.ascii.IPlotter;
import com.indvd00m.plot.ascii.IPoint;
import com.indvd00m.plot.ascii.Plotter;
import com.indvd00m.plot.ascii.Point;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-17 12:32:42 AM
 *
 */
public class TestPlotter {

	@Before
	public void setUpLocale() throws Exception {
		Locale.setDefault(Locale.ENGLISH);
	}

	@Test
	public void test() {
		List<IPoint> points = new ArrayList<IPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			double val = Math.sin(Math.toRadians(degree));
			IPoint point = new Point(degree, val);
			points.add(point);
		}
		IPlotter plotter = new Plotter();
		IPlot plot = plotter.plot(points);
		String s = plot.getString();
		System.out.println(s);

		String expected = "";
		expected += " 1.00|                  *                                                       \n";
		expected += "     |            ************                                                  \n";
		expected += "     |          ***           ***                                               \n";
		expected += "     |        **                ***                                             \n";
		expected += " 0.50|      ***                   ***                                           \n";
		expected += "     |     **                       **                                          \n";
		expected += "     |   **                          **                                         \n";
		expected += "     |  **                             **                                       \n";
		expected += "     |***                               **                                      \n";
		expected += " 0.00|*                                  ***                                  **\n";
		expected += "     |                                     **                               *** \n";
		expected += "     |                                      **                             **   \n";
		expected += "     |                                        **                          **    \n";
		expected += "     |                                         **                       **      \n";
		expected += "-0.50|                                          ***                   ***       \n";
		expected += "     |                                            ***                **         \n";
		expected += "     |                                              ***           ***           \n";
		expected += "     |                                                 ************             \n";
		expected += "-1.00+--------------------------------------------------------------------------\n";
		expected += "     0                90                 180                270              360";

		assertEquals(expected, s);
	}

}
