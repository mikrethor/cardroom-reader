package fr.mikrethor.cardroom.ws.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.mikrethor.cardroom.ws.errors.DefaultErrorMessage;
import fr.mikrethor.cardroom.ws.errors.CardRoomException;
import fr.mikrethor.cardroom.ws.jpa.Hand;
import fr.mikrethor.cardroom.ws.jpa.HandRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CardroomController {
	@Autowired
	HandRepository handRepo;

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
	@RequestMapping("/hand")
	public Hand hand() {
		return handRepo.findOne(1L);
	}

	/**
	 * Test retour liste erreurs.
	 * 
	 * @return
	 * @throws CardRoomException
	 */
	@RequestMapping("/testError")
	public Hand testError() throws CardRoomException {
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
