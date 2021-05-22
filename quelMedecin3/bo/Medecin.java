package fr.eni.ecole.quelMedecin3.bo;

/**
 */
public class Medecin extends Personne {
	public static final int MAX_CRENEAUX = 15;

	private Creneau[] creneaux = new Creneau[MAX_CRENEAUX];

	/**
	 * Constructeur : crée une instance de Medecin
	 * 
	 * @param nom
	 *            nom du médecin
	 * @param prenom
	 *            prénom du médecin
	 * @param numeroDeTelephone
	 *            numéro de téléphone
	 * @param adresse
	 *            adresse postale du patient
	 */
	public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	/**
	 * Getter pour numeroDeTelephone.
	 * 
	 * @return le numéro de téléphone
	 */
	public String getNumeroDeTelephone() {
		return this.numeroDeTelephone;
	}

	/**
	 * Setter pour numeroDeTelephone.
	 * 
	 * @param numeroDeTelephone
	 *            le numéro de téléphone
	 */
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	/**
	 * Getter pour nom.
	 * 
	 * @return le nom du médecin
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Affiche sur la console sous la forme : NOM Prénom Téléphone : XXXXXXXXXX
	 * Adresse :
	 * Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 * Créneaux :
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 */
	public void AfficherAdresseEtCreneaux() {
		System.out.println("Adresse :");
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for (int i = 0; i < this.creneaux.length; i++)
			if (this.creneaux[i] != null)
				this.creneaux[i].afficher();
	}

	/**
	 * Ajoute un créneau horaire pour ce médecin
	 * @param creneauAAjouter
	 */
	void ajouterCreneau(Creneau creneauAAjouter) {
		if (this != creneauAAjouter.getMedecin()) {
			System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre");
		} else {
			int pos = 0;
			while (pos < this.creneaux.length && this.creneaux[pos] != null)
				pos++;
			if (pos == this.creneaux.length)
				System.err.println("Trop de créneaux sont affectés à ce médecin");
			else
				this.creneaux[pos] = creneauAAjouter;
		}
	}
}
