package fr.mikrethor.cardroom.enums;

/**
 * Type enumere pour symboliser un action de jeu.
 * 
 * @author Thor
 * 
 */
public enum EAction {
    /**
     * Action FOLD.
     */
    FOLDS("folds", 1),
    /**
     * Action CALL.
     */
    CALLS("calls", 2),
    /**
     * Action RAISE.
     */
    RAISES("raises", 3),
    /**
     * Action CHECK.
     */
    CHECKS("checks", 4),
    /**
     * Action BET.
     */
    BETS("bets", 5),
    /**
     * Action COLLECTED.
     */
    COLLECTED("collected", 6),
    /**
     * Action SHOW.
     */
    SHOWS("shows", 7);

    /**
     * Libelle.
     */
    private String value;

    /**
     * Valeur entiere.
     */
    private int intValue;

    /**
     * Constructeur parametre.
     * 
     * @param value
     *            valeur.
     * @param intValue
     *            valeur entiere
     */
    private EAction(String value, int intValue) {
        this.value = value;
        this.intValue = intValue;
    }

    /**
     * Getter.
     * 
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Getter.
     * 
     * @return
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Constructeur vide.
     */
    private EAction() {
        // rien.
    }

    /**
     * Convertie une chaine de caractere en EAction.
     * 
     * @param value
     *            chaine de caractere.
     * @return EAction
     */
    public static EAction valueOfCode(String value) {
        for (final EAction status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException(
                "Partnership status cannot be resolved for value " + value);
    }
}
