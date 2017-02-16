package fr.mikrethor.cardroom.ws;

import java.util.List;

import fr.mikrethor.cardroom.pojo.Account;
import fr.mikrethor.cardroom.pojo.Cardroom;
import fr.mikrethor.cardroom.pojo.Hand;
import fr.mikrethor.cardroom.pojo.Player;

public interface RestOperations {
	// --------------------Hand operations--------------------------
	Hand getHand(String id);

	Hand saveHand(Hand hand);

	void deletHand(Long id);

	List<Hand> saveHands(List<Hand> hands);

	// --------------------Account operations--------------------------

	List<Account> getAccounts();

	void deleteAccount(Long id);

	Account saveAccount(Account account);

	Account updateAccount(Account account);

	// --------------------Player operations--------------------------

	Player getPlayerByName(String name);

	Player getPlayer(Long id);

	void deletePlayer(Long id);

	// --------------------Cardroom operations--------------------------

	List<Cardroom> getCardrooms();

	void deleteCardroom(Long id);

	Cardroom saveCardroom(Cardroom cardroom);

	Cardroom updateCardroom(Cardroom cardroom);

}
