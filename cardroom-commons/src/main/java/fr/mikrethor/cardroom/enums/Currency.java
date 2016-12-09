package fr.mikrethor.cardroom.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Handled currency.
 * 
 * @author Thor
 *
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum Currency {
	/**
	 * Euro.
	 */
	EURO("\u20AC", "EUR"),
	/**
	 * US Dollars.
	 */
	USD("\u0024", "USD"),
	/**
	 * Pound sterling.
	 */
	POUND("\u00A3", "GBP");

	/**
	 * Currency symbol in UTF8.
	 */
	@NonNull
	private String symbol;

	/**
	 * Currency short name.
	 */
	@NonNull
	private String shortName;

}
