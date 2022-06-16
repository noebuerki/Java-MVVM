package ch.noebuerki.java.mvvm.elements;

import ch.noebuerki.java.mvvm.general.Point;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Rectangle extends Region {

	public Rectangle(int width, int height, int radius, Color background, Color border, Point point) {
		setMinSize(width, height);
		setMaxSize(width, height);

		setBackground(new Background(new BackgroundFill(background, new CornerRadii(radius), new Insets(0))));
		setBorder(new Border(new BorderStroke(border, BorderStrokeStyle.SOLID, new CornerRadii(radius), new BorderWidths(5))));

		setLayoutX(point.getX());
		setLayoutY(point.getX());
	}
}
