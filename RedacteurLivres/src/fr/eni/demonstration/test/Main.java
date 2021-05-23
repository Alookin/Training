package fr.eni.demonstration.test;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import fr.eni.demonstration.bo.Livre;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated public static void main(String[] args) {

        // variable livre
        Livre livreAlookin = new Livre("Les Bases de la programmation");

        // créer une instance de PdfReader
        try{
            PdfReader pdf = new PdfReader("livre.pdf");

            for(int i = 1; i < pdf.getNumberOfPages(); i++){
                livreAlookin.ajouterPage(PdfTextExtractor.getTextFromPage(pdf, i));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        // proposer à l'utilisateur d'entrer un mot
        Scanner scan = new Scanner(System.in);
        String mot = scan.next();
        AtomicInteger compteurMots = new AtomicInteger();

        // afficher la page 1
        livreAlookin.getPage(1)
                .stream()
                .filter(ligne -> ligne.contains(mot))
                .forEach(ligneavecmot -> {
                    compteurMots.getAndIncrement();
                });

        // Afficher le nombre de mots
        System.out.println("Nombre de fois : " + mot + " -> " + compteurMots + " fois");

    }

}
