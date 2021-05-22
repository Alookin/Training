package fr.eni.ecole.quelMedecin3.bo;

/**
 * Classe modélisant un médecin généraliste
 * 
 */
public class MedecinGeneraliste extends Medecin {

	private static int tarif = 25;

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
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	/**
	 * Getter pour tarif.
	 * 
	 * @return le tarif de la consultation
	 */
	public static int getTarif() {
		return MedecinGeneraliste.tarif;
	}

	/**
	 * Setter pour tarif.
	 * 
	 * @param tarif
	 *            le tarif de la consultation
	 */
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see fr.eni.ecole.quelMedecin3.bo.Personne#afficher()
	 */
	@Override
	public void afficher() {
		super.afficher();
		System.out.printf("Tarif : %d€%n", MedecinGeneraliste.getTarif());
		this.AfficherAdresseEtCreneaux();
	}
}
