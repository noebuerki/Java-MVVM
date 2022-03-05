package ch.noebuerki.gui.items;

import ch.noebuerki.gui.general.Point;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Text extends javafx.scene.text.Text {

	private static double x = 0;
	private static final String font = Text.class.getResource("/font/LexendDeca-Regular.ttf").toExternalForm();

	public Text(String text, int size, Color color, Point point) {
		this(text, size, point);

		setStroke(color);
		setFill(color);
	}

	public Text(String text, int size, Point point) {
		super(text);

		x = point.getX();
		setLayoutX(point.getX());
		setLayoutY(point.getY() + size);

		setFont(Font.loadFont(font, size));
		setStroke(Color.BLACK);
		setStrokeWidth(1);

	}

	public void setPositionAsCenter() {
		setLayoutX(x - getLayoutBounds().getWidth() / 2);
	}

	public void setPositionAsRight() {
		setLayoutX(x -getLayoutBounds().getWidth());
	}
}
