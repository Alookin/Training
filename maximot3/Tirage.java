package fr.eni.ecole.maximot3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.ecole.util.Outils;

public class Tirage {

	private List<Character> lettres = new ArrayList<>();
	private Map<Integer, List<String>> reponses = new HashMap<>();

	public Tirage() throws IOException {
		String mot = Dictionnaire.tirerMotAleatoirement();
		for (int i = 0; i < mot.length(); i++) {
			lettres.add(Outils.nombreAlea(this.lettres.size() + 1), mot.charAt(i));
		}
		for (String motDico : Dictionnaire.getMots()) {
			if (bonnesLettres(motDico)) {
				List<String> motsDeLaMemeTaille = this.reponses.get(motDico.length());
				if (motsDeLaMemeTaille == null) {
					this.reponses.put(motDico.length(), new ArrayList<>());
					motsDeLaMemeTaille = this.reponses.get(motDico.length());
				}
				motsDeLaMemeTaille.add(motDico);
			}
		}
	}

	public Iterable<Character> getLettres() {
		return lettres;
	}

	public boolean bonnesLettres(String prop) {
		ArrayList<Character> clone = new ArrayList<>(this.lettres);
		int i = 0;
		while (i < prop.length() && clone.contains(prop.charAt(i))) {
			clone.remove(new Character(prop.charAt(i)));
			i++;
		}
		return i == prop.length();
	}

	public Map<Integer, List<String>> getReponses() {
		return this.reponses;
	}

	public void afficher() {
		for (char c : this.lettres) {
			System.out.print(c);
		}
		System.out.println();
	}

	public boolean estUneSolution(String prop) {
		List<String> motsSolutionsDeCetteTaille = this.reponses.get(prop.length());
		return motsSolutionsDeCetteTaille != null && motsSolutionsDeCetteTaille.contains(prop);
	}
}
