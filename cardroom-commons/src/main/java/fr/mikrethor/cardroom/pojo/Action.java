package fr.mikrethor.cardroom.pojo;

import fr.mikrethor.cardroom.enums.Card;
import fr.mikrethor.cardroom.enums.EAction;
import fr.mikrethor.cardroom.enums.Round;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class corresponding to an action in a hand.
 * 
 * @author Thor
 * 
 */
@Setter
@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Action {
	/**
	 * Identifiant.
	 */
	private long id;
	/**
	 * La main.
	 */
	private Hand hand;

	/**
	 * Joueur qui fait l'action.
	 */
	@NonNull
	private Player player;
	/**
	 * Type d'action.
	 */
	@NonNull
	private EAction action;
	/**
	 * Montant de l'action.
	 */
	@NonNull
	private double montant;
	/**
	 * Cartes jouees dans l'action.
	 */
	private Card[] cards;
	/**
	 * Phase ou se deroule l'action..
	 */
	private Round phase;

	/**
	 * Constructeur parametre.
	 * 
	 * @param player
	 *            joueur.
	 * @param action
	 *            action du joueur.
	 * @param montant
	 *            montant joue.
	 * @param cards
	 *            cartes en jeu.
	 * @param phase
	 *            phase de jeu.
	 */
	public Action(Player player, EAction action, double montant, Card[] cards) {
		super();
		this.player = player;
		this.action = action;
		this.montant = montant;
		this.cards = cards;
	}

}
