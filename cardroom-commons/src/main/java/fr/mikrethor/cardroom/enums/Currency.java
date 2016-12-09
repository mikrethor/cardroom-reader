package fr.mikrethor.cardroom.enums;

import lombok.Getter;
import lombok.NonNull;

/**
 * Handled currency.
 * 
 * @author Thor
 *
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public enum Currency {

	EURO("\u20AC", "EUR"), USD("\u0024", "USD"), POUND("\u00A3", "GBP");

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
