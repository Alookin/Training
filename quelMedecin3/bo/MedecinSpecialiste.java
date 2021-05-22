package fr.eni.ecole.quelMedecin3.bo;

public class MedecinSpecialiste extends Medecin {
	private String specialite;
	private int tarif;

	/**
	 * Constructeur
	 * @param nom nom du médecin
	 * @param prenom prenom du médecin
	 * @param numeroDeTelephone numéro de téléphone du médecin
	 * @param adresse adresse postale du médecin
	 * @param specialite nom de la sépcialité du médecin
	 * @param tarif tarif pratiqué par ce médecin pour une consultationS
	 */
	public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse, String specialite,
			int tarif) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.specialite = specialite;
		this.tarif = tarif;
	}

	/** 
	 * {@inheritDoc}
	 * @see fr.eni.ecole.quelMedecin3.bo.Personne#afficher()
	 */
	@Override
	public void afficher() {
		super.afficher();
		System.out.printf("Spécialité : %s%nTarif : %d€%n", this.specialite, this.tarif);
		this.AfficherAdresseEtCreneaux();
	}
}
