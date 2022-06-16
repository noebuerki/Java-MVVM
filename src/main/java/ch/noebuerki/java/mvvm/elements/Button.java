package ch.noebuerki.java.mvvm.elements;

import ch.noebuerki.java.mvvm.Constants;
import ch.noebuerki.java.mvvm.general.Point;
import ch.noebuerki.java.mvvm.general.sizes.ButtonSize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Button extends javafx.scene.control.Button {

	private static final String font = Button.class.getResource("/font/LexendDeca-Regular.ttf").toExternalForm();
	private static double x = 0;

	public Button(String text, ButtonSize buttonSize, Color backgroundColor, Color borderColor, Color textColor, Point point, EventHandler<ActionEvent> eventHandler) {
		this(text, backgroundColor, borderColor, textColor, point, eventHandler);
		setMinWidth(buttonSize.getWidth());
		setMinHeight(buttonSize.getHeight());
		setMaxWidth(buttonSize.getWidth());
		setMaxHeight(buttonSize.getHeight());
	}

	private Button(String text, Color backgroundColor, Color borderColor, Color textColor, Point point, EventHandler<ActionEvent> eventHandler) {
		super(text);

		x = point.getX();
		setLayoutX(point.getX());
		setLayoutY(point.getY());
		setFont(Font.loadFont(font, 25));
		setTextFill(textColor);

		setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(10), Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(borderColor, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

		setOnMousePressed(value -> {
			ColorAdjust adjust = new ColorAdjust();
			adjust.setBrightness(-0.1);
			setEffect(adjust);
		});

		setOnMouseReleased(value -> {
			ColorAdjust adjust = new ColorAdjust();
			adjust.setBrightness(0);
			setEffect(adjust);
		});

		setOnAction(eventHandler);
	}

	public Button(String text, int width, int height, Color backgroundColor, Color borderColor, Color textColor, Point point, EventHandler<ActionEvent> eventHandler) {
		this(text, backgroundColor, borderColor, textColor, point, eventHandler);

		setMinWidth(width);
		setMinHeight(height);
		setMaxWidth(width);
		setMaxHeight(height);
	}

	public void setPositionAsCenter() {
		setLayoutX(x - getMinWidth() / 2);
	}

	public void setPositionAsRight() {
		setLayoutX(x - getMinWidth());
	}

	public void select() {
		setTextFill(Color.WHITE);
		setBackground(new Background(new BackgroundFill(Constants.COLOR_BUTTON, new CornerRadii(10), Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(Constants.COLOR_BUTTON, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

	}

	public void deselect() {
		setTextFill(Color.BLACK);
		setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
	}
}
