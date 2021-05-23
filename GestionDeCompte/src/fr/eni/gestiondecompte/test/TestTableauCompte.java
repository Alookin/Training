package fr.eni.gestiondecompte.test;

import fr.eni.gestiondecompte.bo.Compte;

public class TestTableauCompte {

	public static void main(String[] args) {

		Compte[] tableauCompte = new Compte[10];
		
		for (int i = 0; i<tableauCompte.length; i++) {
			int depot = 200+100*i;
			tableauCompte[i] = new Compte();
			tableauCompte[i].deposer(depot);			
		}
		
		for(int i=0; i<tableauCompte.length; i++) {
			System.out.println(tableauCompte[i]);
		}
		
			
	}

}
