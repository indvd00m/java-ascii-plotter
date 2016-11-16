package com.indvd00m.plot.ascii;

import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 10:09:51 PM
 *
 */
public interface IPlotter {

	IPlot plot(List<IPoint> points);

	void setHeight(int height);

	int getHeight();

	void setWidth(int width);

	int getWidth();

	void setCaptionsCountY(int captionsCountY);

	int getCaptionsCountY();

	void setCaptionsCountX(int captionsCountX);

	int getCaptionsCountX();

	void setDrawAxis(boolean drawAxis);

	boolean isDrawAxis();

	void setDrawCaptions(boolean drawCaptions);

	boolean isDrawCaptions();

}
