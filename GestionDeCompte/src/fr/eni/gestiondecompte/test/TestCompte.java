package fr.eni.gestiondecompte.test;

import fr.eni.gestiondecompte.bo.Compte;

public class TestCompte {

	public static void main(String[] args) {
		
		//appel du constructeur de la classe
		
		Compte compte1 = new Compte();
		Compte compte2 = new Compte();
		
		compte1.deposer(500);		
		compte2.deposer(1000);
		compte1.virerVers(75, compte2);
		compte2.retirer(10);
		
		System.out.println("Compte 1 : ");
		System.out.println(compte1.toString());
		System.out.println("Compte 2 : ");
		System.out.println(compte2.toString());
		
	}

}
