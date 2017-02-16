package fr.mikrethor.cardroom.ws.mapping;

import org.dozer.loader.api.BeanMappingBuilder;

/**
 * Dozer Mapping between fr.mikrethor.cardroom.pojo.Account.class and
 * fr.mikrethor.cardroom.ws.jpa.Account.class.
 * 
 * @author Thor
 *
 */
public class AccountMappingBuilder extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(fr.mikrethor.cardroom.pojo.Account.class, fr.mikrethor.cardroom.ws.jpa.Account.class)
				.fields("player", "player").fields("handPath", "handPath").fields("id", "id");
	}

}
