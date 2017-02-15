package fr.mikrethor.cardroom.ws.mapping;

import org.dozer.loader.api.BeanMappingBuilder;

/**
 * Dozer Mapping between fr.mikrethor.cardroom.pojo.Cardroom.class and
 * fr.mikrethor.cardroom.ws.jpa.Cardroom.class.
 * 
 * @author Thor
 *
 */
public class CardroomMappingBuilder extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(fr.mikrethor.cardroom.pojo.Cardroom.class, fr.mikrethor.cardroom.ws.jpa.Cardroom.class)
				.fields("name", "name").fields("domain", "domain");
	}
}
