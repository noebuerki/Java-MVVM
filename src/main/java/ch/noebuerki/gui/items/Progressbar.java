package ch.noebuerki.gui.items;

import ch.noebuerki.gui.Constants;
import ch.noebuerki.gui.general.Point;

public class Progressbar extends javafx.scene.control.ProgressBar {

	private int maxValue;
	private static double x = 0;

	public Progressbar(Point point) {
		super(0);

		x = point.getX();
		setLayoutX(point.getX());
		setLayoutY(point.getY());

		setMinWidth(Constants.WINDOW_WIDTH / 2d);
		setMinHeight(60);
		setMaxWidth(Constants.WINDOW_WIDTH / 2d);
		setMaxHeight(60);
	}

	public Progressbar(int maxValue, Point point) {
		this(point);
		this.maxValue = maxValue;
	}

	public void setValue(int value) {
		if (maxValue > 0) {
			setProgress((double) value / maxValue);
		}
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public void setPositionAsCenter() {
		setLayoutX(x - getMinWidth() / 2);
	}
}
