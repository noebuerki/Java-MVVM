package ch.noebuerki.java.mvvm;

import ch.noebuerki.java.mvvm.navigation.Navigator;

public abstract class BaseViewModel<V extends Enum<V>> {
	private Navigator<V> nav;

	public abstract void initialize();

	public void setNavigator(Navigator<V> nav) {
		this.nav = nav;
	}
}
