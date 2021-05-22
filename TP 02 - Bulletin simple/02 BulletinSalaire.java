import java.util.Scanner;

public class BulletinSalaire {

	public static void main(String[] args) {
		
		String nom = saisirString("Veuillez saisir votre nom : ");
		int totalNbSalaire = 0, totalPrime = 0;
		float totalMtSalaire = 0, totalCotisations = 0;
		
		while(!nom.isEmpty())
		{
			String prenom = saisirString("Entrer votre prénom");
			String statut = saisirString("Entrer votre statut");
			int nbHeures = saisirInt("Entrer votre nombre d'heures");
			int nbEnfants = saisirInt("Entrer votre nombre d'enfants");
			float tauxH = saisirFloat("Entrer votre taux horaire");
			
			float salaireBrut = calculerSalaireBrut(nbHeures, tauxH);
			float cotisations = calculerCotisations(salaireBrut);
			int prime = calculerPrime(nbEnfants);
			float salaire = calculerSalaire(salaireBrut, cotisations, prime);
			
			System.out.println(prenom + " " + nom + " (" + statut + ")");
			System.out.println("Votre salaire est de " + salaire + " €");			
			
			totalNbSalaire = totalNbSalaire + 1;
			totalMtSalaire = totalMtSalaire + salaire;	
			totalPrime = totalPrime + prime;
			totalCotisations = totalCotisations + cotisations;
			
			System.out.println("-----------");
			nom = saisirString("Veuillez saisir votre nom : ");
		}
		
		System.out.println("Montant total des salaires : " + totalMtSalaire);
		System.out.println("Nombre de salaires traités : " + totalNbSalaire);
		System.out.println("Total des primes : " + totalPrime);
		System.out.println("Moyen des salaires : " + (totalMtSalaire / totalNbSalaire));
	}

	private static float calculerSalaireBrut(int nbHeures, float tauxH)
	{
		if(nbHeures < 169) return (nbHeures * tauxH);
		else if(nbHeures < 180) return (169 * tauxH) + ((nbHeures-169)*tauxH*1.5f);
		else return (169 * tauxH) + (11*tauxH*1.5f) + ((nbHeures-180)*tauxH*1.6f);
	}
	
	private static float calculerCotisations(float salaireBrut)
	{
		return (salaireBrut * 26.91f) / 100;
	}
	
	/**
	 * Calcul de la prime en fonction du nombre d'enfants
	 * @param nbEnfants
	 * @return prime
	 */
	private static int calculerPrime(int nbEnfants)
	{
		switch(nbEnfants)
		{
		case 0:
			return 0;
		case 1:
			return 20;
		case 2:
			return 50;
		default:
			return (70 + (nbEnfants-2) * 20);
		}
	}
	
	private static float calculerSalaire(float salaireBrut, float cotisations, int prime)
	{
		return (salaireBrut - cotisations + (float)prime);
	}
	
	private static String saisirString(String message)
	{
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private static int saisirInt(String message)
	{
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	private static float saisirFloat(String message)
	{
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}
}
