package ch.noebuerki.gui.navigation;

public interface Parameterized<T extends NavParams> {

	void onNavigate(T params);
}
