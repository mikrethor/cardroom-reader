package fr.mikrethor.cardroom.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Type enumere pour symboliser un action de jeu.
 * 
 * @author Thor
 * 
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
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
	@NonNull
	private String value;

	/**
	 * Int value.
	 */
	@NonNull
	private int intValue;

	/**
	 * Convert String into EAction.
	 * 
	 * @param value
	 *            String.
	 * @return EAction equivalent.
	 */
	public static EAction valueOfCode(String value) {
		for (final EAction status : values()) {
			if (status.getValue().equals(value)) {
				return status;
			}
		}
		throw new IllegalArgumentException("Partnership status cannot be resolved for value " + value);
	}
}
