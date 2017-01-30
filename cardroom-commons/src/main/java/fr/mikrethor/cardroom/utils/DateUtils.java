package fr.mikrethor.cardroom.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * Parse a String and return the equivalent Date.
	 * 
	 * @param stringToDate
	 *            String to parse.
	 * @param pattern
	 *            String pattern.
	 * @return Date date
	 * @throws ParseException
	 *             when parsing failed.
	 */
	public static Date toDate(String stringToDate, String pattern) throws ParseException {
		final DateFormat sdf = new SimpleDateFormat(pattern);
		final Date date = sdf.parse(stringToDate);
		// TODO handle Locale
		return date;
	}
}
