package fr.eni.minmax;

import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("##########################");
		System.out.println("Veuillez saisir une valeur : ");
		System.out.println("##########################");
		int valeur = scan.nextInt();
		
		System.out.println("##########################");
		System.out.println("Veuillez saisir une valeur : ");
		System.out.println("##########################");
		int valeur2 = scan.nextInt();
		
		plusGrand(valeur, valeur2);
		int resultat = renvoiV(valeur, valeur2);
		if (resultat == 0)
			System.out.println("Les deux valeurs sont égales");
		else if (resultat > 0)
			System.out.println("La première valeur est la plus grande");
		else
			System.out.println("La seconde valeur est la plus grande");
				
		
	}
	
	public static void plusGrand(int valeur, int valeur2)
	{
		if (valeur < valeur2)
		{
			System.out.println("la valeur " + valeur2 + " est la plus grande");
		}
		if (valeur2 < valeur)
		{
			System.out.println("la valeur " + valeur + " est la plus grande");
		}
	
	}
	public static int renvoiV(int valeur, int valeur2)
	{
		if (valeur < valeur2) return -1;
		
		else if (valeur2 == valeur)	return 0;
		
		else return 1;
	}
	
	

}
