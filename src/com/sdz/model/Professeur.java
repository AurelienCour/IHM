package com.sdz.model;

import java.util.ArrayList;

/**
 * Classe permettant de représenter un professeur
 * @author Aurelien
 *
 */
public class Professeur {
	
	private String nom, prenom;
	private ArrayList<Classe> classes;
	
	/**
	 * Le constructeur de la classe
	 * @param nom Le nom du professeur
	 * @param prenom Le prenom du professeur
	 */
	public Professeur (String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
		this.classes = new ArrayList<Classe>();
	}
	
	/**
	 * permet de retourner l'objet sous forme de string
	 */
	public String toString(){
		return this.nom+" "+this.prenom;
	}
	
	/**
	 * Permet de récupérer le nom du professeur
	 * @return le nom du professeur
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Permet de récupérer le prenom du professeur
	 * @return le prenom du professeur
	 */
	public String getPrenom(){
		return this.prenom;
	}
	
	/**
	 * Permet d'ajouter une classe au professeur
	 * @param c La classe a ajouter
	 */
	public void addClasse (Classe c){
		if(!classes.contains(c))
			classes.add(c);
	}
	
	/**
	 * Permet de récupérer la liste des classes d'un professeur
	 * @return Les classes du professeur
	 */
	public ArrayList<Classe> getClasses(){
		return this.classes;
	}
}
