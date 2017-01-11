package fr.mikrethor.cardroom.pojo;

import java.util.HashSet;
import java.util.Set;

import fr.mikrethor.cardroom.enums.Domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Dto pour les comptes du joueur.
 * 
 * @author Thor
 *
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Account {
	/**
	 * Joueur correspondant.
	 */
	@NonNull
	private Player player;
	/**
	 * Site d'appartenance du comnpte.
	 */
	@NonNull
	private Cardroom cardroom;

	/**
	 * Chemin du répertoire contenant les mains.
	 */
	@NonNull
	private String handPath;
	/**
	 * Liste des fichiers à analyser.
	 */
	//TODO
	// private Set<FileDTO> files = new HashSet<FileDTO>(0);

	/**
	 * Constructeur paramétré avec les sets.
	 * 
	 * @param accountDTOId
	 *            int : identifiant du compte.
	 * @param playerDTO
	 *            PlayerdTO : joueur du compte.
	 * @param siteDTO
	 *            SiteDTO : site du compte.
	 * @param label
	 *            String : label du commpte.
	 * @param handPath
	 *            String : Chemin des fichiers de main.
	 * @param fileDTOes
	 *            : Set des fichiers des mians.
	 */
	// public Account(Integer accountDTOId, Player playerDTO,
	// Cardroom siteDTO, String label, String handPath,
	// Set<FileDTO> fileDTOes) {
	// this.id = accountDTOId;
	// this.player = playerDTO;
	// this.cardroom = siteDTO;
	// this.label = label;
	// this.handPath = handPath;
	// this.files = fileDTOes;
	// }

}
