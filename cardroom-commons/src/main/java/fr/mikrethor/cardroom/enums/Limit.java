package fr.mikrethor.cardroom.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Enum ( 'No limit' 'Pot limit' 'Fixed limit').
 * 
 * @author Thor
 *
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum Limit {

	/**
	 * No limit.
	 */
	NL("NL", "No limit"),
	/**
	 * Pot limit.
	 */
	PL("PL", "Pot limit"),
	/**
	 * Fixed limit.
	 */
	FL("PL", "Fixed limit");
	/**
	 * Short value.
	 */
	@NonNull
	private String shortValue;

	/**
	 * Value.
	 */
	@NonNull
	private String value;

}
