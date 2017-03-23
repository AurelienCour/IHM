package com.sdz.model;

import java.util.ArrayList;

public class Classe {
	
	private ArrayList<Eleve> listeEleves;
	private String nomClasse;
	
	public Classe(String nomClasse){
		this.nomClasse = nomClasse;
		this.listeEleves = new ArrayList<Eleve>();
	}
	
	public boolean contientEnfant(Eleve e){
		return this.listeEleves.contains(e);
	}
	
	public void addEleve(Eleve eleve){
		if(!contientEnfant(eleve))
			this.listeEleves.add(eleve);
	}
	
	public ArrayList<Eleve> getListeEleve(){
		return this.listeEleves;
	}
	
	public String toString(){
		return this.nomClasse;
	}
}