package fr.mikrethor.cardroom.utils;

/**
 * Utility class to handle roman numerals.
 * 
 * @author Thor
 *
 */
public class RomanNumeralUtils {
	/**
	 * Private constructor.
	 */
	private RomanNumeralUtils() {
	}

	/**
	 * Convert roman number in int.
	 * 
	 * @param romanNumber
	 *            String containing the roman number
	 * @return Int Int equivalent to the roman number.
	 */
	public static int toInt(String romanNumber) {
		int decimal = 0;
		int lastNumber = 0;
		final String romanNumeral = romanNumber.toUpperCase();
		/*
		 * operation to be performed on upper cases even if user enters roman
		 * values in lower case chars
		 */
		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			final char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			default:
				throw new NumberFormatException(
						String.format("Impossible to convert this %s in roman number!", romanNumber));
			}
		}
		return decimal;
	}

	private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}

}
