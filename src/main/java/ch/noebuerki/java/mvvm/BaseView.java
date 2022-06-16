package ch.noebuerki.java.mvvm;

import ch.noebuerki.java.mvvm.elements.Button;
import ch.noebuerki.java.mvvm.general.Point;
import ch.noebuerki.java.mvvm.general.sizes.ButtonSize;
import ch.noebuerki.java.mvvm.navigation.Navigator;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public abstract class BaseView<S extends Enum<S>, VM extends BaseViewModel<S>> extends Scene {

	protected final VM viewModel;
	protected final Group root;
	protected AnchorPane pane;
	protected Button back;
	protected Button quit;

	public BaseView(Navigator<S> nav, VM viewModel) {

		super(new Group());
		root = (Group) super.getRoot();

		this.viewModel = viewModel;
		this.viewModel.setNavigator(nav);

		prepareBaseElements();
		prepareView();
	}

	private void prepareBaseElements() {
		this.pane = new AnchorPane();

		root.getChildren().add(pane);

		pane.setMinSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

		back = addElement(new Button("Zur" + Constants.ue + "ck", ButtonSize.SMALL, Constants.COLOR_BUTTON, Constants.COLOR_BUTTON, Color.WHITE, new Point(20, 703), event -> {
		}));
		quit = addElement(new Button("Beenden", ButtonSize.SMALL, Constants.COLOR_BUTTON, Constants.COLOR_BUTTON, Color.WHITE, new Point(970, 703), event -> System.exit(0)));

	}

	protected abstract void prepareView();

	// Helper Methods
	protected <I extends Node> I addElement(I item) {
		pane.getChildren().add(item);
		return item;
	}

	public void initialize() {
		viewModel.initialize();
		getFocus();
	}

	public void getFocus() {
		root.requestFocus();
		pane.requestFocus();
	}
}
