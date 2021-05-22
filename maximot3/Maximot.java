package fr.eni.ecole.maximot3;

import java.io.IOException;
import java.util.Scanner;

public class Maximot {
	public static void main(String[] args) {
		try {
			Tirage tirage = new Tirage();
			System.out.println("Voici le tirage :");
			tirage.afficher();
			Scanner console = new Scanner(System.in);
			System.out.println("Quel est le mot caché dans ce tirage ?");
			String prop = console.nextLine().toUpperCase();
			if (!tirage.bonnesLettres(prop)) {
				System.out.println("Lettre incorrecte !");
			}
			else if (!tirage.estUneSolution(prop)) {
				System.out.println("Mot non présent dans le dictionnaire");
			} else {
				System.out.println("Bravo vous marquez "+prop.length()+" points");
			}
			console.close();
			for(int k : tirage.getReponses().keySet()) {
				System.out.printf("Mots de %d caractères%n", k);
				for(String mot : tirage.getReponses().get(k)) {
					System.out.printf(" - %s%n", mot);
				}
			}
		} catch (IOException e) {
			System.err.println("Problème de lecture du dictionnaire");
		}
	}
}
