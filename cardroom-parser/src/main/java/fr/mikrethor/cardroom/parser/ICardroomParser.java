package fr.mikrethor.cardroom.parser;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.mikrethor.cardroom.enums.Card;
import fr.mikrethor.cardroom.enums.Currency;
import fr.mikrethor.cardroom.enums.GameType;
import fr.mikrethor.cardroom.pojo.Action;
import fr.mikrethor.cardroom.pojo.Cardroom;
import fr.mikrethor.cardroom.pojo.Hand;
import fr.mikrethor.cardroom.pojo.InfoSession;
import fr.mikrethor.cardroom.pojo.Player;

/**
 * Parsing API.
 * 
 * @author Thor
 * 
 */
public interface ICardroomParser {
	/**
	 * Methode de parsing du fichier en entree.
	 * 
	 * @return un objet Map avec l'identifiant de la main et un HandDTO.
	 */
	Map<String, Hand> parse();

	/**
	 * Indique si le fichier est parseable.
	 * 
	 * @return
	 */
	boolean parseable();

	/**
	 * Lit la premiere la ligne d'une nouvelle main.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param phase
	 *            String : phase en cours.
	 * @param nextPhases
	 *            String[] : correspondant aux prochaines phases.
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseNewHandLine(String nextLine, Scanner input, String phase, String[] nextPhases, InfoSession infoSession,
			Hand hand);

	/**
	 * Lit la seconde ligne d'une main.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param phase
	 *            String : phase en cours.
	 * @param nextPhases
	 *            String[] : correspondant aux prochaines phases.
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseTableLine(String nextLine, Scanner input, String phase, String[] nextPhases, InfoSession infoSession,
			Hand hand);

	/**
	 * Lit les positions des joueurs.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param phase
	 *            String : phase en cours.
	 * @param nextPhases
	 *            String[] : correspondant aux prochaines phases.
	 * 
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseSeatLine(String nextLine, Scanner input, String phase, String[] nextPhases, InfoSession game,
			Hand hand);

	/**
	 * TODO.
	 * 
	 * @param nextLine
	 * @param input
	 * @param phase
	 * @param nextPhases
	 * @param hand
	 * @return
	 */
	String parseAntesAndBlinds(String nextLine, Scanner input, String phase, String[] nextPhases, InfoSession game,
			Hand hand);

	/**
	 * Lit les informations sur le dealer.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param phase
	 *            String : phase en cours.
	 * @param nextPhases
	 *            String[] : correspondant aux prochaines phases.
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseDealer(String nextLine, Scanner input, String phase, String[] nextPhases, Hand hand);

	/**
	 * Permet de mutualiser la lecture des actions par phase.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param hand
	 *            HandDTO : main en cours.
	 * @param phase
	 *            String : phase en cours.
	 * @param nextPhases
	 *            String[] : correspondant aux prochaines phases.
	 * @param actions
	 *            List<ActionDTO> : liste d'ActionDTO.
	 * @return String : le nextLine en cours.
	 */
	String parseActionsByPhase(String nextLine, Scanner input, Hand hand, String phase, String[] nextPhases,
			List<Action> actions);

	String parsePreflop(String nextLine, Scanner input, Hand hand);

	/**
	 * Lit le flop.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * 
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseFlop(String nextLine, Scanner input, Hand hand);

	/**
	 * Lit le Turn.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * 
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseTurn(String nextLine, Scanner input, Hand hand);

	/**
	 * Lit la River.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * 
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseRiver(String nextLine, Scanner input, Hand hand);

	/**
	 * Lit le Showdown.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseShowdown(String nextLine, Scanner input, Hand hand);

	/**
	 * Lit le résumé de la main.
	 * 
	 * @param nextLine
	 *            String : chaine retournee par le nextLine du Scanner.
	 * @param input
	 *            Scanner.
	 * @param phase
	 *            String : phase en cours.
	 * @param nextPhases
	 *            String[] : correspondant aux prochaines phases.
	 * @param hand
	 *            HandDTO : main en cours.
	 * @return String : le nextLine en cours.
	 */
	String parseSummary(String nextLine, Scanner input, InfoSession session, String phase, String[] nextPhases,
			Hand hand);

	/**
	 * Retourne un tableau de chaines de caracteres correspondant aux cartes.
	 * 
	 * @param cards
	 * @return
	 */
	String[] getCards(String cards);

	/**
	 * Transforme un tableau de chaine de caracteres en tableau de ECards.
	 * 
	 * @param cards
	 * @return
	 */
	Card[] toECards(String[] cards);

	/**
	 * Retourne le joueur qui est de grosse blinde ou de petite blinde selon la
	 * chaine.
	 * 
	 * @param blindDealt
	 * @return
	 */
	String getPlayerBlind(String[] blindDealt);

	/**
	 * Transforme une chaine en tableau de ECards.
	 * 
	 * @param chaine
	 * @return
	 */
	Card[] parseCards(String chaine);

	/**
	 * Transforme une chaine de caracteres en ActionDTO.
	 * 
	 * @param chaine
	 * @param players
	 * @return
	 */
	Action parseAction(String chaine, Map<String, Player> players);

	/**
	 * 
	 * @param card
	 * @return
	 */
	Card stringToECards(String card);

	/**
	 * Retourne la ligne suivante.
	 * 
	 * @param scanner
	 * @return
	 */
	String nextLine(Scanner scanner);

	/**
	 * Retourne l'identifiant du tournoi.
	 * 
	 * @return
	 */
	String getTournamentId();

	/**
	 * Initialise la devise.
	 * 
	 * @param devise
	 */
	void setCurrency(Currency devise);

	/**
	 * Parse pour retourner le fichier de la partie.
	 * 
	 * @return un objet Map avec l'identifiant de la main et un HandDTO.
	 */
	public InfoSession parsing();

	/**
	 * Parse le Buy-In.
	 * 
	 * @param chaine
	 * @return
	 */
	Double parseBuyIn(String chaine);

	/**
	 * Parse le Fee.
	 * 
	 * @param chaine
	 * @return
	 */
	Double parseFee(String chaine);

	/**
	 * Parse le niveau des blindes.
	 * 
	 * @param chaine
	 * @return
	 */
	int parseLevel(String chaine);

	/**
	 * Parse l'identifiant de la main.
	 * 
	 * @param chaine
	 * @return
	 */
	String parseHandIdSite(String chaine);

	/**
	 * Parse la petite blind.
	 * 
	 * @param chaine
	 * @return
	 */
	Double parseSmallBlind(String chaine);

	/**
	 * Parse la grosse blind.
	 * 
	 * @param chaine
	 * @return
	 */
	Double parseBigBlind(String chaine);

	/**
	 * Parse l,identifiant de la table.
	 * 
	 * @param chaine
	 * @return
	 */
	String parseTableId(String chaine);

	/**
	 * Parse le nombre de joueur par table.
	 * 
	 * @param chaine
	 * @return
	 */
	String parseNumberOfPlayerByTable(String chaine);

	/**
	 * Parse l'identifiant de la partie.
	 * 
	 * @param chaine
	 * @return
	 */
	String parseGameIdSite(String chaine);

	/**
	 * Parse la position du bouton.
	 * 
	 * @param chaine
	 * @return
	 */
	Integer parseButtonSeat(String chaine);

	/**
	 * Parse la siège du joueur.
	 * 
	 * @param chaine
	 * @return
	 */
	Player parsePlayerSeat(String chaine);

	/**
	 * Parse la valeur du pot.
	 * 
	 * @param chaine
	 * @return
	 */
	Double parseTotalPot(String chaine);

	/**
	 * Parse le rake.
	 * 
	 * @param chaine
	 * @return
	 */
	Double parseRake(String chaine);

	/**
	 * Parse le joueur qui a généré le fichier de la partie.
	 * 
	 * @param chaine
	 * @return
	 */
	String parsePlayerAccount(String chaine);

	/**
	 * Détermine le type de jeu à partir du nom du fichier.
	 * 
	 * @param fileName
	 * @return
	 */
	GameType getGameTypeFromFilename(String fileName);

	/**
	 * Retourne la date de la main.
	 * 
	 * @param chaine
	 *            String qui contient la date.
	 * @return Date de la main.
	 */
	Date parseHandDate(String chaine);

	/**
	 * Retourne la devise de la main.
	 * 
	 * @param chaine
	 *            String qui contient la devise.
	 * @return ECurrency de la main.
	 */
	Currency parseCurrency(String chaine);

	/**
	 * Indique si la ligne en parametre a des informations qui vont etre
	 * parsees.
	 * 
	 * @param line
	 *            String ligne en entree.
	 * @return Vrai si la ligne ne contient pas d'information utile..
	 */
	Boolean isUselesLine(String line);

	/**
	 * Retourne le site correspondant.
	 * 
	 * @return Cardroom lié au au parser.
	 */
	Cardroom getCardroom();

	Map<String, StringBuffer> fileToMap();

	Hand textToHandDto(StringBuffer text, InfoSession infoSession);

	void setCardroom(Cardroom cardRoom);
}
