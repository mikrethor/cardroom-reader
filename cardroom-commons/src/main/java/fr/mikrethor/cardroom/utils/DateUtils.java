package fr.mikrethor.cardroom.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * Parse une chaine et retourne une date equivalente.
	 * 
	 * @param stringToDate
	 *            String chaine a parser.
	 * @param pattern
	 *            String pattern pour parser la date.
	 * @return Date date
	 * @throws ParseException
	 *             si le parsing echoue.
	 */
	public static Date toDate(String stringToDate, String pattern) throws ParseException {
		final DateFormat sdf = new SimpleDateFormat(pattern);
		final Date date = sdf.parse(stringToDate);
		// TODO handle Locale
		return date;
	}
}
