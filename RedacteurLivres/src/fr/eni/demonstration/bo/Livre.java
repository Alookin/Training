package fr.eni.demonstration.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Livre {
	 // attributs
    // nom du livre
    // liste de pages
    private String nomLivre;
    private List<page> pages;

    // constructeur
    public Livre(String nomLivre) {
        this.nomLivre = nomLivre;
        this.pages = new ArrayList<>();
    }

    // methodes
    public void ajouterPage(List<String> lignes) {
        // créer la page
        pages.add(new page(lignes));
    }

    public void ajouterPage(String contenu) {
        // créer la page
        List<String> lignes = Arrays.asList(contenu.split("\n"));
        pages.add(new page(lignes));
    }

    public List<String> getPage(int numeroPage) {
        return pages.get(numeroPage).getLignes();
    }

    public int getNombrePages(){
        return this.pages.size();
    }

    public String getNom(){
        return nomLivre;
    }

}


