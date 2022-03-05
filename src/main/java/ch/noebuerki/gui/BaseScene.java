package ch.noebuerki.gui;

import ch.noebuerki.gui.general.sizes.ButtonSize;
import ch.noebuerki.gui.items.Button;
import ch.noebuerki.gui.general.Point;
import ch.noebuerki.gui.navigation.Navigator;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public abstract class BaseScene<E extends Enum<E>> extends Scene {
	
	protected final Navigator<E> nav;
	protected final Group root;
	protected final AnchorPane pane;
	protected final Button back;
	protected final Button quit;

	public BaseScene(Navigator<E> nav) {

		super(new Group());
		root = (Group) super.getRoot();
		this.nav = nav;

		pane = new AnchorPane();
		pane.setMinSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

		back = addItem(new Button("Zur" + Constants.ue + "ck", ButtonSize.SMALL, Constants.COLOR_BUTTON, Constants.COLOR_BUTTON, Color.WHITE, new Point(20, 703), event -> {}));
		quit = addItem(new Button("Beenden", ButtonSize.SMALL, Constants.COLOR_BUTTON, Constants.COLOR_BUTTON, Color.WHITE, new Point(970, 703), event -> System.exit(0)));

		pane.getChildren().addAll(back, quit);
		root.getChildren().addAll(pane);
	}

	protected boolean validate() {
		return true;
	}

	protected void safe() {
	}

	protected <I extends Node> I addItem(I item){
		pane.getChildren().add(item);
		return item;
	}

	public void getFocus() {
		root.requestFocus();
		pane.requestFocus();
	}
}
