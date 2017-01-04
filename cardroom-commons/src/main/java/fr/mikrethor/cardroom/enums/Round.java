package fr.mikrethor.cardroom.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum Round {

	/**
	 * PREFLOP Phase.
	 */
	PRE_FLOP("preflop"),
	/**
	 * FLOP Phase.
	 */
	FLOP("flop"),
	/**
	 * TURN Phase.
	 */
	TURN("turn"),
	/**
	 * RIVER Phase.
	 */
	RIVER("river"),
	/**
	 * SHOWDOWN Phase.
	 */
	SHOWDOWN("showdown");

	/**
	 * Value.
	 */
	@NonNull
	private String value;

	/**
	 * Convertie une chaine de caractere en EAction.
	 * 
	 * @param value
	 *            chaine de caractere.
	 * @return EAction
	 */
	public static Round valueOfCode(String value) {
		for (final Round status : values()) {
			if (status.getValue().equals(value)) {
				return status;
			}
		}
		throw new IllegalArgumentException("Partnership status cannot be resolved for value " + value);
	}
}
