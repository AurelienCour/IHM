package com.sdz.model;

import java.util.ArrayList;

import com.sdz.vue.FenetreInfo;

public class FenetreInfoModel  {
	
	private ArrayList<Professeur> professeurs;
	private FenetreInfo vue;
	
	public FenetreInfoModel(){
		this.professeurs = new ArrayList<Professeur>();
	}
	
	public void addProf (Professeur p){
		if(!professeurs.contains(p))
			this.professeurs.add(p);
	}
	
	public ArrayList<Professeur> getProf(){
		return this.professeurs;
	}
	
	public Classe getClasseEnfant (Eleve e){
		for (Professeur professeur : professeurs) {
			for (Classe classe : professeur.getClasses()) {
				if(classe.contientEnfant(e))
					return classe;
			}
		}
		return null;
	}
	
	public void addVue(FenetreInfo vue){
		this.vue = vue;
	}
	
}
