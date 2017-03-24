package com.sdz.model;

import java.util.ArrayList;

/**
 * Classe permettant de représenter une classe
 * @author Aurelien
 *
 */
public class Classe {
	
	private ArrayList<Eleve> listeEleves;
	private String nomClasse;
	
	/**
	 * Constructeur de notre classe
	 * @param nomClasse Le nom de la classe
	 */
	public Classe(String nomClasse){
		this.nomClasse = nomClasse;
		this.listeEleves = new ArrayList<Eleve>();
	}
	
	/**
	 * Fonction permettant de savoir si une classe contient un enfant
	 * @param e L'enfant recherché
	 * @return true si l'enfant est présent
	 */
	public boolean contientEnfant(Eleve e){
		return this.listeEleves.contains(e);
	}
	
	/**
	 * Fonction permettant d'ajouter un enfant à notre classe
	 * @param eleve l'enfant à ajouter
	 */
	public void addEleve(Eleve eleve){
		if(!contientEnfant(eleve))
			this.listeEleves.add(eleve);
	}
	
	/**
	 * Fonction permettant de retourner tous les éleves d'une classe
	 * @return La liste des élèves
	 */
	public ArrayList<Eleve> getListeEleve(){
		return this.listeEleves;
	}
	
	/**
	 * Permet de retourner la valeur String de notre objet
	 */
	public String toString(){
		return this.nomClasse;
	}
}