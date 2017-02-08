package fr.mikrethor.cardroom.pojo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Player account.
 * 
 * @author Thor
 *
 */
@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Account {
	/**
	 * Player linked to the account.
	 */
	@NonNull
	private Player player;
	/**
	 * Account cardroom.
	 */
	@NonNull
	private Cardroom cardroom;

	/**
	 * Filepath where to fing hand files to parse.
	 */
	@NonNull
	private String handPath;

	/**
	 * Primary key.
	 */
	private Long id;

}
