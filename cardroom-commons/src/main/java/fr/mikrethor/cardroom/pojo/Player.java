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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardroom == null) ? 0 : cardroom.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		if (cardroom == null) {
			if (other.cardroom != null) {
				return false;
			}
		} else {
			if (!cardroom.equals(other.cardroom)) {
				return false;
			}
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else {
			if (!name.equals(other.name)) {
				return false;
			}
		}
		return true;
	}

}
