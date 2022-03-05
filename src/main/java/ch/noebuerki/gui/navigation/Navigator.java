package ch.noebuerki.gui.navigation;

import ch.noebuerki.gui.BaseScene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator<E extends Enum<E>> {

	private final Stage stage;
	private final Map<E, BaseScene> sceneMap;
	private BaseScene activeScene;

	public Navigator(Stage stage) {

		this.stage = stage;
		sceneMap = new HashMap<>();
	}

	public void registerScene(E type, BaseScene scene) {

		sceneMap.put(type, scene);
	}

	public <T extends NavParams> void navigateToWithParams(E type, T params) {

		activeScene = sceneMap.get(type);

		if (activeScene instanceof Parameterized) {
			((Parameterized) activeScene).onNavigate(params);
		}

		navigateTo(type);
	}

	public void navigateTo(E type) {

		activeScene = sceneMap.get(type);

		if (activeScene instanceof Initializable) {
			((Initializable) activeScene).initialize();
		}

		stage.setScene(activeScene);
		stage.show();

		activeScene.getFocus();
	}
}
