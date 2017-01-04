package fr.mikrethor.cardroom.pojo;

import java.util.Arrays;

import fr.mikrethor.cardroom.enums.Card;
import fr.mikrethor.cardroom.enums.EAction;
import fr.mikrethor.cardroom.enums.Round;

/**
 * Classe symbolisant une action d'un coup.
 * 
 * @author Thor
 * 
 */
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
	 * Identifiant du joueur.
	 */
	private long playerId;

	/**
	 * Joueur qui fait l'action.
	 */
	private Player player;
	/**
	 * Type d'action.
	 */
	private EAction action;
	/**
	 * Montant de l'action.
	 */
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
	 * Getter du joueur.
	 * 
	 * @return PlayerDTO
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Setter du joueur.
	 * 
	 * @param player
	 *            PlayerDTO
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Getter de l'action.
	 * 
	 * @return EAction
	 */
	public EAction getAction() {
		return action;
	}

	/**
	 * Setter de l'action.
	 * 
	 * @param action
	 *            EAction
	 */
	public void setAction(EAction action) {
		this.action = action;
	}

	/**
	 * Getter du montant.
	 * 
	 * @return double
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter du montant.
	 * 
	 * @param montant
	 *            double
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Getter des cartes.
	 * 
	 * @return tableau de ECard
	 */
	public Card[] getCards() {
		return cards;
	}

	/**
	 * Setter des cartes.
	 * 
	 * @param cards
	 *            tableau de ECard
	 */
	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public Round getPhase() {
		return phase;
	}

	public void setPhase(Round phase) {
		this.phase = phase;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	/**
	 * Constructeur vide.
	 */
	public Action() {
		// permet le newInstance
	}

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
	public Action(Player player, EAction action, double montant, Card[] cards, Round phase) {
		super();
		this.player = player;
		this.action = action;
		this.montant = montant;
		this.cards = cards;
		this.phase = phase;
	}

	@Override
	public String toString() {
		String playerName = null;
		String phaseLibelle = null;
		if (player != null) {
			playerName = player.getName();
		}
		if (phase != null) {
			phaseLibelle = phase.getValue();
		}
		return "Action [player=" + playerName + ", action=" + action + ", montant=" + montant + ", cards="
				+ Arrays.toString(cards) + "phase=" + phaseLibelle + "]";
	}
}
