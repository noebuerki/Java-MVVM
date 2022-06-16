package ch.noebuerki.java.mvvm.general.sizes;

public enum TextFieldSize implements Size {
	SMALL(290, 45),
	MEDIUM(570, 60),
	LARGE(570, 60);

	private final int width;
	private final int height;

	TextFieldSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
