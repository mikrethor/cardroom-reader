package fr.mikrethor.cardroom.enums;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

/**
 * Enum for cards with standard value.
 * 
 * @author Thor
 *
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum Card implements Serializable {

	// Piques - Spades
	/**
	 * As of Spades.
	 */
	C_AS(14),
	/**
	 * King of Spades.
	 */
	C_KS(13),
	/**
	 * Queen of Spades.
	 */
	C_QS(12),
	/**
	 * Jack of Spades.
	 */
	C_JS(11),
	/**
	 * Ten of Spades.
	 */
	C_TS(10),
	/**
	 * Nine of Spades.
	 */
	C_9S(9),
	/**
	 * Eight of Spades.
	 */
	C_8S(8),
	/**
	 * Seven of Spades.
	 */
	C_7S(7),
	/**
	 * Six of Spades.
	 */
	C_6S(6),
	/**
	 * Five of Spades.
	 */
	C_5S(5),
	/**
	 * Four of Spades.
	 */
	C_4S(4),
	/**
	 * Three of Spades.
	 */
	C_3S(3),
	/**
	 * Two of Spades.
	 */
	C_2S(2),

	// Carreaux - Diamonds
	/**
	 * As of Diamonds.
	 */
	C_AD(14),
	/**
	 * King of Diamonds.
	 */
	C_KD(13),
	/**
	 * Queen of Diamonds.
	 */
	C_QD(12),
	/**
	 * Jack of Diamonds.
	 */
	C_JD(11),
	/**
	 * Ten of Diamonds.
	 */
	C_TD(10),
	/**
	 * Nine of Diamonds.
	 */
	C_9D(9),
	/**
	 * Eight of Diamonds.
	 */
	C_8D(8),
	/**
	 * Seven of Diamonds.
	 */
	C_7D(7),
	/**
	 * Six of Diamonds.
	 */
	C_6D(6),
	/**
	 * Five of Diamonds.
	 */
	C_5D(5),
	/**
	 * Four of Diamonds.
	 */
	C_4D(4),
	/**
	 * Three of Diamonds.
	 */
	C_3D(3),
	/**
	 * Two of Diamonds.
	 */
	C_2D(2),

	// Coeur - Heart
	/**
	 * As of Hearts.
	 */
	C_AH(14),
	/**
	 * King of Hearts.
	 */
	C_KH(13),
	/**
	 * Queen of Hearts.
	 */
	C_QH(12),
	/**
	 * Jack of Hearts.
	 */
	C_JH(11),
	/**
	 * Ten of Hearts.
	 */
	C_TH(10),
	/**
	 * Nine of Hearts.
	 */
	C_9H(9),
	/**
	 * Eight of Hearts.
	 */
	C_8H(8),
	/**
	 * Seven of Hearts.
	 */
	C_7H(7),
	/**
	 * Six of Hearts.
	 */
	C_6H(6),
	/**
	 * Five of Hearts.
	 */
	C_5H(5),
	/**
	 * Four of Hearts.
	 */
	C_4H(4),
	/**
	 * Three of Hearts.
	 */
	C_3H(3),
	/**
	 * Two of Hearts.
	 */
	C_2H(2),

	// Trefles - Clubs
	/**
	 * As of Clubs.
	 */
	C_AC(14),
	/**
	 * King of Clubs.
	 */
	C_KC(13),
	/**
	 * Queen of Clubs.
	 */
	C_QC(12),
	/**
	 * Jack of Clubs.
	 */
	C_JC(11),
	/**
	 * Ten of Clubs.
	 */
	C_TC(10),
	/**
	 * Nine of Clubs.
	 */
	C_9C(9),
	/**
	 * Eight of Clubs.
	 */
	C_8C(8),
	/**
	 * Seven of Clubs.
	 */
	C_7C(7),
	/**
	 * Six of Clubs.
	 */
	C_6C(6),
	/**
	 * Five of Clubs.
	 */
	C_5C(5),
	/**
	 * Four of Clubs.
	 */
	C_4C(4),
	/**
	 * Three of Clubs.
	 */
	C_3C(3),
	/**
	 * Two of Clubs.
	 */
	C_2C(2);

	/**
	 * Card value.
	 */
	private int value;

	/**
	 * Parametrized constructor.
	 * 
	 * @param value
	 */
	private Card(int value) {
		this.value = value;
	}

}
