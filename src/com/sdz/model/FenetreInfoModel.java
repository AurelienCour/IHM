package com.sdz.model;

import java.util.ArrayList;

import com.sdz.vue.FenetreInfo;

/**
 * Classe permettant de récupérer toutes les informations
 * @author Aurelien
 *
 */
public class FenetreInfoModel  {
	
	private ArrayList<Professeur> professeurs;
	
	/**
	 * Le constructeur de la classe
	 */
	public FenetreInfoModel(){
		this.professeurs = new ArrayList<Professeur>();
	}
	
	/**
	 * Fonction permettant d'ajouter un prof à notre application
	 * @param p le proffesseur a ajouter
	 */
	public void addProf (Professeur p){
		if(!professeurs.contains(p))
			this.professeurs.add(p);
	}
	
	/**
	 * Permet de récupérer les profs présent dans notre application
	 * @return la liste des professeurs
	 */
	public ArrayList<Professeur> getProf(){
		return this.professeurs;
	}
	
	/**
	 * Permet de récupérer la classe d'un élève donné
	 * @param e L'élève a rechercher
	 * @return la classe de l'élève
	 */
	public Classe getClasseEnfant (Eleve e){
		for (Professeur professeur : professeurs) {
			for (Classe classe : professeur.getClasses()) {
				if(classe.contientEnfant(e))
					return classe;
			}
		}
		return null;
	}
	
}
