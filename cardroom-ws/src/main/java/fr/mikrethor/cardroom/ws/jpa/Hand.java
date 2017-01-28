package fr.mikrethor.cardroom.ws.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "HAND")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Hand implements Serializable {

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = 5414709182527215338L;

	@Id
	@GeneratedValue(generator = "idHandGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "idHandGenerator", sequenceName = "SEQ_ID_HAND", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 18)
	private Long id;

	@NonNull
	private String name;

}
