package fr.eni.ecole.quelMedecin3.bo;

/**
 * Classe modélisant une personne Cette classe regroupe les éléments communs à
 * toutes les personnes qu'elles soient médecin ou patient
 */
public class Personne {
	protected String nom;
	protected String prenom;
	protected String numeroDeTelephone;
	protected Adresse adresse;

	/**
	 * 
	 * Constructeur
	 * 
	 * @param nom
	 *            nom de la personne
	 * @param prenom
	 *            prénom de la personne
	 * @param numeroDeTelephone
	 *            numéro de téléphone de la personne
	 * @param adresse
	 *            adresse de la personne
	 */
	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.adresse = adresse;
	}

	/**
	 * Affiche les information sur la personne sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 */
	public void afficher() {
		System.out.printf("%s %s%nTéléphone : %s%n", this.nom, this.prenom, this.numeroDeTelephone);
	}
}