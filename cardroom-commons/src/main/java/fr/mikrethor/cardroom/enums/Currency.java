package fr.mikrethor.cardroom.enums;

import lombok.*;

/**
 * Handled currency.
 * 
 * @author Thor
 *
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
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
