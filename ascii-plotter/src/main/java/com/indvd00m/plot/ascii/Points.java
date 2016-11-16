package com.indvd00m.plot.ascii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 11:26:24 PM
 *
 */
public class Points implements IPoints {

	List<IPoint> points;
	double maxX;
	double maxY;
	double minX;
	double minY;
	double diffX;
	double diffY;

	public Points(List<IPoint> points) {
		this.points = points;

		for (IPoint point : points) {
			if (maxX < point.getX())
				maxX = point.getX();
			if (maxY < point.getY())
				maxY = point.getY();
			if (minX > point.getX())
				minX = point.getX();
			if (minY > point.getY())
				minY = point.getY();
		}
		diffX = maxX - minX;
		diffY = maxY - minY;
	}

	@Override
	public List<IPoint> normalize(double maxX, double maxY) {
		List<IPoint> normalized = new ArrayList<IPoint>();
		for (IPoint point : points) {
			double x = point.getX() - minX;
			double y = point.getY() - minY;
			double relativeX = x / diffX;
			double relativeY = y / diffY;
			double normalizedX = relativeX * maxX;
			double normalizedY = relativeY * maxY;
			IPoint normalizedPoint = new Point(normalizedX, normalizedY);
			normalized.add(normalizedPoint);
		}
		return normalized;
	}

	@Override
	public List<IPoint> getPoints() {
		return points;
	}

	@Override
	public double getMaxX() {
		return maxX;
	}

	@Override
	public double getMaxY() {
		return maxY;
	}

	@Override
	public double getMinX() {
		return minX;
	}

	@Override
	public double getMinY() {
		return minY;
	}

	@Override
	public double getDiffX() {
		return diffX;
	}

	@Override
	public double getDiffY() {
		return diffY;
	}

}
