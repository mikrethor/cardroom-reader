package fr.mikrethor.cardroom.ws;

import java.util.List;

import fr.mikrethor.cardroom.pojo.Account;
import fr.mikrethor.cardroom.pojo.Hand;

public interface RestOperations {

	Hand getHand(String id);

	List<Account> getAccounts();

	boolean deleteAccount(Long id);

	Account saveAccount(Account account);

}
