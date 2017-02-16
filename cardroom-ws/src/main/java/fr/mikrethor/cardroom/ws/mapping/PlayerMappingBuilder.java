package fr.mikrethor.cardroom.ws.mapping;

import org.dozer.loader.api.BeanMappingBuilder;

/**
 * Dozer Mapping between fr.mikrethor.cardroom.pojo.Player.class and
 * fr.mikrethor.cardroom.ws.jpa.Player.class.
 * 
 * @author Thor
 *
 */
public class PlayerMappingBuilder extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(fr.mikrethor.cardroom.pojo.Player.class, fr.mikrethor.cardroom.ws.jpa.Player.class)
				.fields("name", "name").fields("cardroom", "cardroom").fields("id", "id").exclude("account");

	}

}
