package com.sdz.model;

import java.util.ArrayList;

public class Professeur {
	
	private String nom, prenom;
	private ArrayList<Classe> classes;
	
	public Professeur (String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
		this.classes = new ArrayList<Classe>();
	}
	
	public String toString(){
		return this.nom+" "+this.prenom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	public void addClasse (Classe c){
		if(!classes.contains(c))
			classes.add(c);
	}
	
	public ArrayList<Classe> getClasses(){
		return this.classes;
	}
}
