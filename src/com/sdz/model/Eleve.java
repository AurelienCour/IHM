package com.sdz.model;

import javax.swing.ImageIcon;

/**
 * Classe permettant de représenter un élève
 * @author Aurelien
 *
 */
public class Eleve {

	private String nom, prenom;
	private int age;
	private boolean sexe;
	private ImageIcon icon;
	
	/**
	 * Constructeur de notre objet élève
	 * @param nom Le nom de notre élève
	 * @param prenom Le prénom de notre élève
	 * @param age	L'age de notre élève
	 * @param sexe	Le sexe de notre élève
	 * @param icon	L'image de notre élève
	 */
	public Eleve(String nom, String prenom, int age, boolean sexe, ImageIcon icon){
		this.nom=nom;
		this.prenom=prenom;
		this.age = age;
		this.sexe = sexe;
		this.icon = icon;
	}
	
	/**
	 * Méthode retournant notre objet sous forme d'un String
	 */
	public String toString(){
		return this.nom+" "+this.prenom;
	}
	
	/**
	 * Méthode permettant de récupérer le nom de notre élève
	 * @return Le nom de l'élève
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Méthode permettant de récupérer le prenom de notre élève
	 * @return Le prenom de l'élève
	 */
	public String getPrenom(){
		return this.prenom;
	}
	
	/**
	 * Méthode permettant de récupérer l'age de notre élève
	 * @return l'age de l'élève
	 */
	public int getAge(){
		return this.age;
	}
	
	/**
	 * Méthode permettant de récupérer le sexe de notre élève
	 * @return Le sexe de l'élève
	 */
	public boolean getSexe(){
		return this.sexe;
	}
	
	/**
	 * Méthode permettant de récupérer la photo de notre élève
	 * @return La photo de l'élève
	 */
	public ImageIcon getPhoto(){
		return this.icon;
	}
	
	/**
	 * Méthode permettant de modifier le nom de notre élève
	 * @param nom Le nom de l'élève
	 */
	private void setNom (String nom){
		this.nom = nom;
	}
	
	/**
	 * Méthode permettant de modifier le prenom de notre élève
	 * @param prenom Le prenom de l'élève
	 */
	private void setPrenom (String prenom){
		this.prenom = prenom;
	}
	
	/**
	 * Méthode permettant de modifier l'age de notre élève
	 * @param age L'age de l'élève
	 */
	private void setAge (int age){
		this.age = age;
	}
	
	/**
	 * Fonction permettant de modifier les informations d'un élève
	 * @param nom Le nouveau nom
	 * @param prenom Le nouveau prenom
	 * @param age	Le nouvel age
	 */
	public void changeInfo(String nom, String prenom, int age){
		if(!nom.equals(this.getNom()))
			setNom(nom);
		if(!prenom.equals(this.getPrenom()))
			setPrenom(prenom);
		if(age != this.getAge())
			setAge(age);
	}
	
}
