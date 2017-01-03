package fr.mikrethor.cardroom.pojo;

import org.junit.Assert;
import org.junit.Test;

import fr.mikrethor.cardroom.enums.Domain;

/**
 * Created by Thor on 2017-01-03.
 */
public class CardroomTest {
	@Test
	public void testConstructor() {

		Cardroom cardRoom = new Cardroom();
		Assert.assertEquals(null, cardRoom.getDomain());
		Assert.assertEquals(null, cardRoom.getName());

		cardRoom = new Cardroom("test", Domain.CA);
		Assert.assertEquals(Domain.CA, cardRoom.getDomain());
		Assert.assertEquals("test", cardRoom.getName());

	}
}