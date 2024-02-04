package tools;

public class ExitGameException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExitGameException() {
	}

	public ExitGameException(String message) {
		super(message);
	}

}