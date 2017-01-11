package fr.mikrethor.cardroom.pojo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.mikrethor.cardroom.enums.GameType;
import fr.mikrethor.cardroom.enums.PokerType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Contains information about the game or the cashgame session.
 * 
 * @author Thor
 *
 */
@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class InfoSession {
	@NonNull
	private Cardroom site;
	private String label;

	private Double buyIn;
	private Double fee;
	private GameType gameType;
	private PokerType pokerType;

	private Set<Player> gamePlayers = new HashSet<>(0);

	private int nbPlayersOnOneTable;
	private Map<String, Player> players = new HashMap<>();
	private Map<String, Hand> hands = new HashMap<>();

	public void addHand(Hand hand) {
		if (!this.getHands().keySet().contains(hand.getId())) {
			this.getHands().put(hand.getId(), hand);
		}
	}

	public void addPlayer(Player player) {
		if (!players.containsKey(player.getName())) {
			players.put(player.getName(), player);
		}
	}
}
