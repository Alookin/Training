package fr.eni.ecole.maximot3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.eni.ecole.util.Outils;

public class Dictionnaire {
	public static final String FICHIER_MOTS = "./dictionnaire.txt";
	public static final int NB_MOTS = 22506;

	private static List<String> mots;

	public static boolean motExiste(String mot) throws IOException {
		List<String> dico = Dictionnaire.getMots();
		boolean trouve = false;
		Iterator<String> itera = dico.iterator();
		while (itera.hasNext() && !trouve) {
			trouve = itera.next().toUpperCase().equals(mot);
		}
		return trouve;
	}

	public static String tirerMotAleatoirement() throws IOException {
		return Dictionnaire.getMots().get(Outils.nombreAlea(NB_MOTS));
	}

	public static List<String> getMots() throws IOException {
		if (Dictionnaire.mots == null) {
			Dictionnaire.mots = new ArrayList<>(NB_MOTS);
			try (FileInputStream fichier = new FileInputStream(FICHIER_MOTS); Scanner s = new Scanner(fichier)) {
				while (s.hasNext())
					Dictionnaire.mots.add(s.nextLine().toUpperCase());
			}
		}
		return Dictionnaire.mots;
	}
}
