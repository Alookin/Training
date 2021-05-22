package fr.eni.ecole.quelMedecin3.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un patient
 */
public class Patient extends Personne {
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 *            nom du patient
	 * @param prenom
	 *            prénom du patient
	 * @param numeroDeTelephone
	 *            numéro de téléphone du patient
	 * @param sexe
	 *            sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @param numSecu
	 *            numéro de sécurité sociale du patient
	 * @param dateNaissance
	 *            date de naissance du patient
	 * @param commentaires
	 *            commentaires associé à ce patient (allergie, antécédents
	 *            médicaux…)
	 * @param adresse
	 *            adresse postale du patient
	 */
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu,
			LocalDate dateNaissance, String commentaires, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.sexe = sexe;
		this.numSecu = numSecu;
		this.dateNaissance = dateNaissance;
		this.commentaires = commentaires;
	}

	/**
	 * Affiche sur la console sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	public void afficher() {
		super.afficher();
		System.out.printf(
				"Sexe : %s%nNuméro de Sécurité sociale : %d%nDate de naissance : %s%nCommentaires : %s%nAdresse :%n",
				this.sexe == 'F' ? "Féminin" : "Masculin",
				this.numSecu, this.dateNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
				this.commentaires != null ? this.commentaires : "[aucun commentaire]");
		this.adresse.afficher();
	}
}
