package fr.mikrethor.cardroom.enums;

/**
 * Enum pour les types de poker (NoLimitHoldem, Omaha,...)
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
	 * Valeur.
	 */
	private String value;

	/**
	 * Constructeur parametre.
	 * 
	 * @param value
	 *            valeur.
	 */
	private PokerType(String value) {
		this.value = value;
	}

	/**
	 * Getter.
	 * 
	 * @return valeur de l'enum.
	 */
	public String getValue() {
		return value;
	}
}
