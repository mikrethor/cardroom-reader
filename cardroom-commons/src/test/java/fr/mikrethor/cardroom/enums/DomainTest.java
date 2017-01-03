package fr.mikrethor.cardroom.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Thor on 2016-12-11.
 */
public class DomainTest {
	@Test
	public void testToString() {
		Assert.assertEquals(5, Domain.values().length);
		Assert.assertEquals("Domain(shortName=ca)", Domain.CA.toString());
		Assert.assertEquals("Domain(shortName=com)", Domain.COM.toString());
		Assert.assertEquals("Domain(shortName=fr)", Domain.FR.toString());
		Assert.assertEquals("Domain(shortName=it)", Domain.IT.toString());
		Assert.assertEquals("Domain(shortName=uk)", Domain.UK.toString());
	}
}