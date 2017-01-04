package fr.mikrethor.cardroom.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Cardroom domain.
 * 
 * @author Thor
 *
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum Domain {
	COM("com"), CA("ca"), FR("fr"), IT("it"), UK("uk");

	/**
	 * Currency short name.
	 */
	@NonNull
	private String shortName;
}
