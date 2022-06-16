package ch.noebuerki.java.mvvm.elements;

import ch.noebuerki.java.mvvm.Constants;
import ch.noebuerki.java.mvvm.general.Point;

public class Progressbar extends javafx.scene.control.ProgressBar {

	private static double x = 0;
	private int maxValue;

	public Progressbar(int maxValue, Point point) {
		this(point);
		this.maxValue = maxValue;
	}

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
