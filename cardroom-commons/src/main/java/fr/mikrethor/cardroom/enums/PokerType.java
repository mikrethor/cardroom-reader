package fr.mikrethor.cardroom.enums;

/**
 * Enum which symbolizes (NoLimitHoldem, Omaha,...)
 * 
 * @author Thor
 *
 */
public enum PokerType {
	/**
	 * Hold'em.
	 */
	HOLDEM("Hold'em"),
	/**
	 * Omaha.
	 */
	OMAHA("Omaha"),
	/**
	 * Omaha Hi/Lo.
	 */
	OHILO("Omaha Hi/Lo"),
	/**
	 * Razz
	 */
	RAZZ("Razz"),
	/**
	 * Stud.
	 */
	STUD("Stud");

	/**
	 * Value.
	 */
	private String value;

	/**
	 * Constructeur parametre.
	 * 
	 * @param value
	 *            String.
	 */
	private PokerType(String value) {
		this.value = value;
	}

	/**
	 * Getter.
	 * 
	 * @return enum value.
	 */
	public String getValue() {
		return value;
	}
}
