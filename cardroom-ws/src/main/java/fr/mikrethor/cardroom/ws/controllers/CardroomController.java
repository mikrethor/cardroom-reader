package fr.mikrethor.cardroom.ws.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.mikrethor.cardroom.enums.Domain;
import fr.mikrethor.cardroom.pojo.Account;
import fr.mikrethor.cardroom.pojo.Cardroom;
import fr.mikrethor.cardroom.pojo.Hand;
import fr.mikrethor.cardroom.pojo.Player;
import fr.mikrethor.cardroom.ws.errors.CardRoomException;
import fr.mikrethor.cardroom.ws.errors.DefaultErrorMessage;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CardroomController {

	/**
	 * LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CardroomController.class);

	/**
	 * Test ws up.
	 * 
	 * @return
	 */
	@RequestMapping("/test")
	public String welcome() {// Welcome page, non-rest
		return "WS is up.";
	}

	/**
	 * Reading BD test.
	 * 
	 * @return
	 */
	@RequestMapping("/hands/{id}")
	public Hand getHand(@PathVariable String id) {
		Hand hand = null;
		if ("1".equals(id)) {
			Cardroom cardroom = new Cardroom("Winamax", Domain.FR);
			hand = new Hand(cardroom, "1", new Player(cardroom, "nameplayer"));
		}
		return hand;
	}

	// Account methods

	@RequestMapping("/accounts")
	public List<Account> getAccounts() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("list all account");
		}

		Cardroom winamax = new Cardroom("Winamax", Domain.FR);
		Cardroom pokerstars = new Cardroom("Pokerstars", Domain.COM);

		Player aW = new Player(winamax, "testnamePlayeWinar");
		Player aP = new Player(pokerstars, "testnamePlayerPS");

		Account acW = new Account(aW, winamax, "test path");
		Account acP = new Account(aP, pokerstars, "test path");

		List<Account> accounts = new ArrayList<>();

		acW.setId(1l);
		acP.setId(2l);

		accounts.add(acW);
		accounts.add(acP);
		return accounts;
	}

	@DeleteMapping("/accounts")
	public boolean deleteAccount(@RequestParam(value = "id") Long id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("delete account with id : {}", id);
		}
		return true;
	}

	@PostMapping("/accounts")
	public Account saveAccount(@RequestBody Account account) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("save account {}", account);
		}
		Random r = new Random();
		account.setId(r.nextLong());
		return account;
	}

	/**
	 * Test retour liste erreurs.
	 * 
	 * @return
	 * @throws CardRoomException
	 */
	@RequestMapping("/testError")
	public void testError() throws CardRoomException {
		throw new CardRoomException("test eerreur");
	}

	@ExceptionHandler({ CardRoomException.class })
	public void handleException(HttpServletRequest request, HttpServletResponse response, CardRoomException e)
			throws IOException {
		List<String> errors = new ArrayList<String>();
		errors.add(e.getMessage());
		DefaultErrorMessage dem = new DefaultErrorMessage("001", "Erreur", errors);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "nope";
		List<DefaultErrorMessage> dems = new ArrayList<DefaultErrorMessage>();
		dems.add(dem);
		dems.add(new DefaultErrorMessage("003", "Erreur2", errors));
		try {
			json = ow.writeValueAsString(dems);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.getWriter().write(json);
	}

}
