package fr.mikrethor.cardroom.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Type enumere correspondant au type de poker joue.
 * 
 * @author Thor
 * 
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum GameType {
	/**
	 * Valeur pour la cashgame.
	 */
	CASH("CashGame"),
	/**
	 * Valeur pour le Sit & GO.
	 */
	SNG("Sit & Go"),
	/**
	 * Valeur pour le tournoi.
	 */
	TOURNAMENT("Tournament");

	/**
	 * variable pour le type de jeu joue.
	 */
	@NonNull
	private String type;
}
