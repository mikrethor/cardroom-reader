package fr.mikrethor.cardroom.pojo;

import fr.mikrethor.cardroom.enums.Domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Cardroom data.
 *
 * @author Thor
 */
@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Cardroom {

	private Long id;

	@NonNull
	private String name;
	@NonNull
	private Domain domain;
}
