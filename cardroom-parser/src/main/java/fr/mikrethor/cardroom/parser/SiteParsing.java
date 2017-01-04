package fr.mikrethor.cardroom.parser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.mikrethor.cardroom.enums.Card;
import fr.mikrethor.cardroom.enums.Currency;
import fr.mikrethor.cardroom.pojo.Cardroom;
import fr.mikrethor.cardroom.pojo.Hand;

/**
 * Classe abstraite pour les methodes generiques de parsing des fichiers generes
 * par un site de poker.
 * 
 * @author Thor
 * 
 */
public abstract class SiteParsing implements IFileSiteParser {

	protected Cardroom siteDTO;

	/**
	 * LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SiteParsing.class);
	/**
	 * Fichier à parser.
	 */
	private File fileToParse;

	/**
	 * 
	 */
	protected Map<String, Long> mapNameIdPlayers;

	/**
	 * Retourne le fichier � parser.
	 * 
	 * @return File : fichier � parser.
	 */
	public File getFileToParse() {
		return fileToParse;
	}

	/**
	 * Retourne le fichier � parser.
	 * 
	 * @param fileToParseFile
	 *            : fichier � parser.
	 */
	public void setFileToParse(File fileToParse) {
		this.fileToParse = fileToParse;
	}

	public static final String ESPACE = " ";
	public static final String DEUXPOINTS = ":";
	public static final String PARENTHESEGAUCHE = "(";
	public static final String PARENTHESEDROITE = ")";
	public static final String CROCHETOUVRANT = "[";
	public static final String CROCHETFERMANT = "]";
	public static final String SLASH = "/";
	protected Currency money = Currency.USD;
	public static final String HASHTAG = "#";
	public static final String PLUS = "+";
	public static final String VIRGULE = ",";
	public static final String UNDERSCORE = "_";
	public static final String DASH = "-";
	public static final String POINT = ".";
	public static final String PIPE = "|";
	public static final String APOSTROPHE = "'";
	public static final String VIDE = "";
	public static final String EOL = System.getProperty("line.separator");

	@Override
	public Map<String, Hand> parse() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("parseFile...");
		}
		if (!this.parseable()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("the file is not parseable.");
			}
			return null;
		} else {
			// Fait appel ela methode de parsing specifique au site.
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Demarrage du parsing...");
			}

			if (mapNameIdPlayers == null) {
				mapNameIdPlayers = new HashMap<String, Long>();
			}

			return parsing();
		}
	}

	@Override
	public Card stringToECards(String card) {
		return Card.valueOf("C_" + card.toUpperCase());
	}

	@Override
	public boolean parseable() {
		if (this.getFileToParse().exists()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Le fichier {} existe.", this.getFileToParse().getName());
			}
			if (this.getFileToParse().isFile()) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Le fichier {} est un fichier", this.getFileToParse().getName());
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public String nextLine(Scanner scanner) {
		String nextLine = scanner.nextLine();
		while (isUselesLine(nextLine)) {

			// On itere jusqu'a trouver une ligne interessante.
			nextLine = scanner.nextLine();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("iter nextLine : {}", nextLine);
			}
		}
		return nextLine;
	}

	@Override
	public String[] getCards(String cards) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("getCards : {}", cards);
		}
		if (cards == null) {
			return null;
		}
		return cards.split(ESPACE);

	}

	@Override
	public Card[] toECards(String[] cards) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("toECards : {}", "" + cards);
		}
		if (cards == null) {
			return null;
		} else {
			int index = 0;
			final Card[] tab = new Card[cards.length];
			for (final String card : cards) {
				tab[index] = stringToECards(card);
				index++;
			}
			return tab;
		}
	}

	@Override
	public String getPlayerBlind(String[] blindDealt) {
		if (blindDealt == null) {
			return null;
		} else {
			String joueur = "";

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Taille tableau : {}, tableau {}", blindDealt.length, blindDealt);
			}
			if (blindDealt.length == 5) {
				joueur = blindDealt[0];
			} else {
				final String[] newTab = new String[blindDealt.length - 1];
				for (int i = 1; i < blindDealt.length - 1; i++) {
					newTab[i - 1] = blindDealt[i];
				}
				joueur = blindDealt[0] + ESPACE + getPlayerBlind(newTab);
			}
			return joueur;
		}
	}

	@Override
	public Card[] readCards(String chaine) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("readCards : {}", chaine);
		}
		final int crochetouvrant = chaine.lastIndexOf(CROCHETOUVRANT);
		final int crochetfermant = chaine.lastIndexOf(CROCHETFERMANT);
		final String cards = chaine.substring(crochetouvrant + 1, crochetfermant);
		final Card[] tab = this.toECards(this.getCards(cards));
		return tab;
	}

	/**
	 * Permet de verifier que la chaine demarre avec une des prochaines phases.
	 * 
	 * @param chaine
	 *            Chaine en entree.
	 * @param nextPhases
	 *            Tableau des phases.
	 * @return
	 */
	protected boolean startsWith(String chaine, String[] nextPhases) {
		for (final String phase : nextPhases) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Verifie que de la chaine \"{}\" commence par la phase \"{}\"", chaine, phase);

			}
			if (chaine.startsWith(phase)) {
				return true;
			}
		}
		return false;
	}

	protected SiteParsing(File fileToParse) {
		if (LOGGER.isDebugEnabled() && fileToParse != null) {
			LOGGER.debug("{} : {}", this.getClass().getName(), fileToParse.getName());
		}
		this.setFileToParse(fileToParse);
	}

	@Override
	public void setCurrency(Currency devise) {
		money = devise;
	}

	@Override
	public Cardroom getCardroom() {
		return siteDTO;
	}

	@Override
	public void setCardroom(Cardroom siteDTO) {
		this.siteDTO = siteDTO;
	}

}
