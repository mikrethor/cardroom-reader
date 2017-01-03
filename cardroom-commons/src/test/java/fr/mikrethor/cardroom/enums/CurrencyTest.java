package fr.mikrethor.cardroom.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Thor on 2016-12-11.
 */
public class CurrencyTest {
	@Test
	public void testToString() {
		Assert.assertEquals(3, Currency.values().length);
		Assert.assertEquals("Currency(symbol=\u20AC, shortName=EUR)", Currency.EURO.toString());
		Assert.assertEquals("Currency(symbol=\u0024, shortName=USD)", Currency.USD.toString());
		Assert.assertEquals("Currency(symbol=\u00A3, shortName=GBP)", Currency.POUND.toString());
	}
}