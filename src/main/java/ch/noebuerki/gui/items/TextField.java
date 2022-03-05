package ch.noebuerki.gui.items;

import ch.noebuerki.gui.general.Point;
import ch.noebuerki.gui.general.sizes.TextFieldSize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.regex.Pattern;


public class TextField extends AnchorPane {

	private static final String font = TextField.class.getResource("/font/LexendDeca-Regular.ttf").toExternalForm();
	private final javafx.scene.control.TextField textField;
	private final Text alarm;
	public boolean isValid;
	private final double x;

	public TextField(String placeHolder, TextFieldSize textFieldSize, Point point) {
		Rectangle background;
		background = new Rectangle(textFieldSize.getWidth(), textFieldSize.getWidth(), 10, Color.WHITE, Color.BLACK, new Point(0, 0));

		textField = new javafx.scene.control.TextField();

		textField.setPromptText(placeHolder);
		textField.setLayoutX(0);
		textField.setLayoutY(0);
		textField.setMinSize(background.getMinWidth() - 30, background.getMinHeight());
		textField.setMaxSize(background.getMaxWidth() - 30, background.getMaxHeight());
		textField.setBackground(Background.EMPTY);
		textField.setBorder(Border.EMPTY);

		textField.setFont(Font.loadFont(font, 25));

		alarm = new Text("!", 25, Color.RED, new Point(background.getMinWidth() - 30, 0));
		alarm.setLayoutY(background.getMinHeight() / 2d + alarm.getLayoutBounds().getHeight() / 3d - 2);
		removeAlarm();

		x = point.getX();
		setLayoutX(point.getX());
		setLayoutY(point.getY());
		setPadding(new Insets(0));
		setMinSize(background.getMinWidth(), background.getMinHeight());
		setMaxSize(background.getMaxWidth(), background.getMaxHeight());

		getChildren().addAll(background, textField, alarm);
	}

	public TextField(String placeHolder, TextFieldSize textFieldSize, Point point, EventHandler<ActionEvent> eventHandler) {
		this(placeHolder, textFieldSize, point);
		setOnAction(eventHandler);
	}

	public void setText(String text) {
		removeAlarm();
		textField.setText(text);
	}

	public String getText() {
		return textField.getText();
	}

	public void setOnAction(EventHandler<ActionEvent> value) {
		textField.setOnAction(value);
	}

	public javafx.scene.control.TextField getTextField() {
		return textField;
	}

	public void setAlarm() {
		alarm.setVisible(true);
		isValid = false;
		textField.setMinWidth(textField.getMinWidth() - 20);
		textField.setMaxWidth(textField.getMaxWidth() - 20);
	}

	public void removeAlarm() {
		alarm.setVisible(false);
		isValid = true;
		textField.setMinWidth(textField.getMinWidth() + 20);
		textField.setMaxWidth(textField.getMaxWidth() + 20);
	}

	public void toggleAlarmOnNoPatternMatch(String pattern) {
		if (Pattern.matches(pattern, getText())) {
			removeAlarm();
		} else {
			setAlarm();
		}
	}

	public void reset() {
		removeAlarm();
		textField.setText("");
	}

	public void setPositionAsCenter() {
		setLayoutX(x - getMinWidth() / 2);
	}
}
