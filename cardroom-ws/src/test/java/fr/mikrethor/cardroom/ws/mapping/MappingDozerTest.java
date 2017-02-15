package fr.mikrethor.cardroom.ws.mapping;

import org.dozer.DozerBeanMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.mikrethor.cardroom.enums.Domain;
import fr.mikrethor.cardroom.pojo.Cardroom;
import fr.mikrethor.cardroom.ws.config.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MappingDozerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MappingDozerTest.class);
	long after;
	long before;
	Cardroom cardroom = null;

	@Autowired
	DozerBeanMapper mapper;

	@Before
	public void setUp() {
		cardroom = new Cardroom("test 1", Domain.FR);

		before = System.currentTimeMillis();
	}

	@Test
	public void cardroomMappingTest() {
		final fr.mikrethor.cardroom.ws.jpa.Cardroom site = mapper.map(cardroom,
				fr.mikrethor.cardroom.ws.jpa.Cardroom.class);
		Assert.assertNotNull(site.getName());
		Assert.assertNotNull(site.getDomain());
		Assert.assertEquals(site.getName(), cardroom.getName());
		Assert.assertEquals(site.getDomain(), cardroom.getDomain());

	}

	@After
	public void tearDown() {
		after = System.currentTimeMillis();
		LOGGER.info("Temps de passage du test {}", after - before);
	}
}
