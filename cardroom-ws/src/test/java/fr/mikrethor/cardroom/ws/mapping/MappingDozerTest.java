package fr.mikrethor.cardroom.ws.mapping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.mikrethor.cardroom.enums.Domain;
import fr.mikrethor.cardroom.pojo.Cardroom;

public class MappingDozerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MappingDozerTest.class);
	long after;
	long before;
	Cardroom cardroom = null;

	@Before
	public void setUp() {
		cardroom = new Cardroom("test 1", Domain.FR);

		before = System.currentTimeMillis();
	}

	@Test
	public void cardroomMappingTest() {
		final MapperSingleton mapper = MapperSingleton.getInstance();
		final fr.mikrethor.cardroom.ws.jpa.Cardroom site = mapper.map(cardroom,
				fr.mikrethor.cardroom.ws.jpa.Cardroom.class);
		Assert.assertEquals(site.getName(), cardroom.getName());
		Assert.assertEquals(site.getDomain(), cardroom.getDomain());

	}

	@After
	public void tearDown() {
		after = System.currentTimeMillis();
		LOGGER.info("Temps de passage du test {}", after - before);
	}
}
