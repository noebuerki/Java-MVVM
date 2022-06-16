package ch.noebuerki.java.mvvm.navigation;

public interface Parameterized<T extends NavParams> {
	void setParams(T params);
}
