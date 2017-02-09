package fr.mikrethor.cardroom.ws.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import fr.mikrethor.cardroom.enums.Domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CARDROOM")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Cardroom implements Serializable {

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = 5414709182527215338L;

	@Id
	@GeneratedValue(generator = "idCardroomGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "idCardroomGenerator", sequenceName = "SEQ_ID_CARDROOM", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 18)
	private Long id;

	@NonNull
	private String name;

	@NonNull
	@Enumerated(EnumType.STRING)
	private Domain domain;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardroom")
	private List<Player> players;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardroom")
	private List<Account> accounts;

}
