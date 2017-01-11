package fr.mikrethor.cardroom.pojo;

import java.util.HashSet;
import java.util.Set;

import fr.mikrethor.cardroom.enums.Card;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Player {
	@NonNull
	private Cardroom cardroom;
	@NonNull
	private String name;
	
    private Set<Account> accountDTOes = new HashSet<Account>(0);
    private Integer seat;
    private Boolean on;
    private Double stack;
    private Card[] cards;
}
