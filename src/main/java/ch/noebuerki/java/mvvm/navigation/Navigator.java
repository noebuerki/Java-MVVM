package ch.noebuerki.java.mvvm.navigation;

import ch.noebuerki.java.mvvm.BaseView;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator<V extends Enum<V>> {

	private final Stage stage;
	private final Map<V, BaseView> sceneMap;
	private BaseView activeScene;

	public Navigator(Stage stage) {

		this.stage = stage;
		sceneMap = new HashMap<>();
	}

	public void registerScene(V type, BaseView scene) {

		sceneMap.put(type, scene);
	}

	public <P extends NavParams> void navigateToWithParams(V type, P params) {

		activeScene = sceneMap.get(type);

		if (activeScene instanceof Parameterized) {
			((Parameterized) activeScene).setParams(params);
		}

		navigateTo(type);
	}

	public void navigateTo(V type) {

		activeScene = sceneMap.get(type);

		activeScene.initialize();

		stage.setScene(activeScene);
		stage.show();

		activeScene.getFocus();
	}
}
