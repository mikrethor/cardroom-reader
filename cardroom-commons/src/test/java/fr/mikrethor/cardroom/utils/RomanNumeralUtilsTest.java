package fr.mikrethor.cardroom.utils;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralUtilsTest {
	@Test
	public void testToInt() {
		Assert.assertEquals(1000, RomanNumeralUtils.toInt("M"));
		Assert.assertEquals(500, RomanNumeralUtils.toInt("D"));
		Assert.assertEquals(100, RomanNumeralUtils.toInt("C"));
		Assert.assertEquals(50, RomanNumeralUtils.toInt("L"));
		Assert.assertEquals(10, RomanNumeralUtils.toInt("X"));
		Assert.assertEquals(5, RomanNumeralUtils.toInt("V"));
		Assert.assertEquals(1, RomanNumeralUtils.toInt("I"));

		try {
			RomanNumeralUtils.toInt("p");
			Assert.fail();
		} catch (NumberFormatException e) {
			// Nothing
		}
		Assert.assertEquals(1111, RomanNumeralUtils.toInt("MCXI"));
		Assert.assertEquals(3, RomanNumeralUtils.toInt("III"));
		Assert.assertEquals(4, RomanNumeralUtils.toInt("IV"));

	}
}
