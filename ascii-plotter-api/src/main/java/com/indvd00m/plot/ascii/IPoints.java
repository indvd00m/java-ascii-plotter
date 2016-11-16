package com.indvd00m.plot.ascii;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 11:29:37 PM
 *
 */
public interface IPoints {

	List<IPoint> getPoints();

	double getMaxX();

	double getMaxY();

	double getMinX();

	double getMinY();

	double getDiffX();

	double getDiffY();

	List<IPoint> normalize(double maxX, double maxY);

}