package fr.eni.demonstration.bo;

import java.util.List;

public class page {
	 // attribut
    private List<String> lignes;

    // constructeur
    public page(List<String> lignes){
        this.lignes = lignes;
    }

    // methode
    public List<String> getLignes() {
        return this.lignes;
    }

}
