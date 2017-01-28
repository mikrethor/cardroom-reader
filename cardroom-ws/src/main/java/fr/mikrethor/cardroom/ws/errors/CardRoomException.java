package fr.mikrethor.cardroom.ws.errors;

public class CardRoomException extends Exception {

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = -7020841972681326671L;

	String message;

	public CardRoomException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
