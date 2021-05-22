package fr.eni.ecole.quelMedecin3.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un créneau horaire pour un médecin
 */
public class Creneau {
	private LocalTime heureDebut;
	private int duree;
	private Medecin medecin;

	/**
	 * Constructeur
	 * 
	 * @param heureDebut
	 *            heure de début du créneau
	 * @param duree
	 *            durée du créneau en minutes
	 * @param medecin
	 *            médecin possédant ce créneau
	 */
	public Creneau(LocalTime heureDebut, int duree, Medecin medecin) {
		this.heureDebut = heureDebut;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(this);
	}

	/**
	 * Affiche un créneau horaire sous la forme :
	 * 00:00 - 00:00 (XX minutes)
	 */
	public void afficher() {
		System.out.printf("%s - %s (%d minutes)%n",
				this.heureDebut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
				this.heureDebut.plusMinutes(this.duree).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
				this.duree);
	}

	/**
	 * Getter pour medecin.
	 * @return the medecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}

}
