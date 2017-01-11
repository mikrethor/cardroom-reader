package fr.mikrethor.cardroom.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.mikrethor.cardroom.enums.Card;
import fr.mikrethor.cardroom.enums.Currency;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Hand {
	@NonNull
	private Cardroom cardRoom;
	@NonNull
	private String id;
	@NonNull
	private Player player;

	private Map<Integer, Player> players = new HashMap<>();
	private Map<String, Player> playersByName = new HashMap<>();
	private Player bigBlindPlayer;
	private Player smallBlindPlayer;
	private Player dealerPlayer;
	private String label;
	// private List<HandPlayersDTO> handPlayerses = new
	// ArrayList<HandPlayersDTO>(0);
	private InfoSession infoSession;
	private int nbPlayersOnOneTable;

	private Date playDate;
	private String actionPreflop;
	private String actionFlop;
	private String actionTurn;
	private String actionRiver;
	private String actionShowdown;

	private String playerPreflop;
	private String playerFlop;
	private String playerTurn;
	private String playerRiver;
	private String playerShowdown;

	private String labelGame;
	private final Map<String, Integer> mapPlayerSeat = new HashMap<>();
	private final Map<String, Card[]> mapPlayerCards = new HashMap<>();

	private Card[] flop;
	private Card turn;
	private Card river;

	private List<Action> preflopActions = new ArrayList<>();
	private List<Action> flopActions = new ArrayList<>();
	private List<Action> riverActions = new ArrayList<>();
	private List<Action> turnActions = new ArrayList<>();
	private List<Action> showdownActions = new ArrayList<>();
	private List<Action> actions = new ArrayList<>();
	private int level;
	private Integer buttonSeat;
	private long date;
	private String idTable;
	private double bigBlind;
	private double smallBlind;
	private double totalPot;
	private double rake;

	private Currency currency;

	public void addPlayer(Player player) {
		players.put(player.getSeat(), player);
		playersByName.put(player.getName(), player);
		mapPlayerSeat.put(player.getName(), player.getSeat());
	}

}
