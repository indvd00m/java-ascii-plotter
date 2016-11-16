package com.indvd00m.plot.ascii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @date 2016-Nov-16 11:47:15 PM
 *
 */
public class Captions {

	List<String> captionsX;
	List<String> captionsY;
	int captionsYWidth;

	public Captions(IPoints points, int captionsCountX, int captionsCountY) {
		captionsX = createCaptions(points.getMinX(), points.getDiffX(), captionsCountX);
		captionsY = createCaptions(points.getMinY(), points.getDiffY(), captionsCountY);

		int captionsYWidth = 0;
		for (String yCaption : captionsY) {
			int length = yCaption.length();
			if (captionsYWidth < length)
				captionsYWidth = length;
		}
		this.captionsYWidth = captionsYWidth;
	}

	private List<String> createCaptions(double minValue, double diffValues, int count) {
		List<String> captions = new ArrayList<String>(count);

		double captionsStep = diffValues / (count - 1);
		for (int i = 0; i < count; i++) {
			double value = i * captionsStep + minValue;
			String caption = formatCaption(value, captionsStep);
			captions.add(caption);
		}
		return captions;
	}

	private String formatCaption(double value, double captionsStep) {
		String caption = null;
		if (captionsStep < 10d)
			caption = String.format("%1$,.2f", value);
		else
			caption = String.format("%,d", (int) value);
		return caption;
	}

	public List<String> getCaptionsX() {
		return captionsX;
	}

	public List<String> getCaptionsY() {
		return captionsY;
	}

	public int getCaptionsYWidth() {
		return captionsYWidth;
	}

}
