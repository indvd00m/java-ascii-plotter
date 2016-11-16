package com.indvd00m.plot.ascii;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:10:09 PM
 *
 */
public class Plotter implements IPlotter {

	int width = 80;
	int height = 20;
	int captionsCountX = 5;
	int captionsCountY = 5;
	boolean drawCaptions = true;
	boolean drawAxis = true;

	@Override
	public IPlot plot(List<IPoint> pointsList) {
		if (pointsList == null)
			throw new IllegalArgumentException();

		IPlot plot = new Plot(width, height);
		IPoints points = new Points(pointsList);
		Captions captions = new Captions(points, captionsCountX, captionsCountY);

		if (drawCaptions)
			drawCaptions(plot, points, captions);
		if (drawAxis)
			drawAxis(plot, captions);
		drawPoints(plot, points, captions);

		return plot;
	}

	private void drawCaptions(IPlot plot, IPoints points, Captions captions) {
		int startX = 0;
		int startY = 0;

		{
			// y captions
			Deque<String> captionsY = new LinkedList<String>(captions.getCaptionsY());
			String bottomCaption = captionsY.pollFirst();
			String topCaption = captionsY.pollLast();
			double captionStep = (double) (height - 1) / (double) (captionsY.size() + 1);
			for (int y = startY + 1; y < height; y++) {
				String caption;
				if (y == startY + 1)
					caption = bottomCaption;
				else if (y == height - 1)
					caption = topCaption;
				else if (y % captionStep < 1) {
					caption = captionsY.pollFirst();
				} else {
					caption = " ";
				}

				caption = String.format("%" + captions.getCaptionsYWidth() + "s", caption);
				plot.draw(startX, y, caption);
			}
		}

		{
			// x captions
			Deque<String> captionsX = new LinkedList<String>(captions.getCaptionsX());
			String leftCaption = captionsX.pollFirst();
			String rightCaption = captionsX.pollLast();
			double captionStep = (double) (width - captions.getCaptionsYWidth()) / (double) (captionsX.size() + 1);

			String caption = captionsX.pollFirst();
			int num = 0;
			while (caption != null) {
				num++;

				int position = startX + captions.getCaptionsYWidth() + (int) (captionStep * num);
				position -= caption.length() / 2;
				plot.draw(position, startY, caption);

				caption = captionsX.pollFirst();
			}

			plot.draw(startX + captions.getCaptionsYWidth(), startY, leftCaption);
			plot.draw(width - rightCaption.length(), startY, rightCaption);
		}
	}

	private void drawAxis(IPlot plot, Captions captions) {
		int startX = 0;
		int startY = 0;

		if (drawCaptions) {
			startX += captions.getCaptionsYWidth();
			startY += 1;
		}

		// y axes
		for (int y = startY + 1; y < height; y++) {
			plot.draw(startX, y, "|");
		}

		// x axes
		plot.draw(startX + 1, startY, "-", width - (startX + 1));

		plot.draw(startX, startY, "+");
	}

	private void drawPoints(IPlot plot, IPoints points, Captions captions) {
		int startX = 0;
		int startY = 0;

		if (drawAxis) {
			startX += 1;
			startY += 1;
		}
		if (drawCaptions) {
			startX += captions.getCaptionsYWidth();
			startY += 1;
		}

		int pointsWidth = width - startX - 1;
		int pointsHeight = height - startY - 1;

		List<IPoint> normalized = points.normalize(pointsWidth, pointsHeight);
		for (IPoint point : normalized) {
			int x = (int) (startX + point.getX());
			int y = (int) (startY + point.getY());
			plot.draw(x, y, "*");
		}
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		if (width <= 3)
			throw new IllegalArgumentException();
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		if (height <= 3)
			throw new IllegalArgumentException();
		this.height = height;
	}

	@Override
	public int getCaptionsCountX() {
		return captionsCountX;
	}

	@Override
	public void setCaptionsCountX(int captionsCountX) {
		if (captionsCountX < 2)
			throw new IllegalArgumentException();
		this.captionsCountX = captionsCountX;
	}

	@Override
	public int getCaptionsCountY() {
		return captionsCountY;
	}

	@Override
	public void setCaptionsCountY(int captionsCountY) {
		if (captionsCountY < 2)
			throw new IllegalArgumentException();
		this.captionsCountY = captionsCountY;
	}

	@Override
	public boolean isDrawCaptions() {
		return drawCaptions;
	}

	@Override
	public void setDrawCaptions(boolean drawCaptions) {
		this.drawCaptions = drawCaptions;
	}

	@Override
	public boolean isDrawAxis() {
		return drawAxis;
	}

	@Override
	public void setDrawAxis(boolean drawAxis) {
		this.drawAxis = drawAxis;
	}

}
