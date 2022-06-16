package ch.noebuerki.java.mvvm.general.sizes;

public enum ProgressbarSize implements Size {

	EXTRA_SMALL(150, 50),
	SMALL(180, 60),
	MEDIUM(250, 80),
	LARGE(300, 95);

	private final int width;
	private final int height;

	ProgressbarSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
