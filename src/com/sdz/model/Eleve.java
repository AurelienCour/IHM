package com.sdz.model;

import javax.swing.ImageIcon;

public class Eleve {

	private String nom, prenom;
	private int age;
	private boolean sexe;
	private ImageIcon icon;
	
	public Eleve(String nom, String prenom, int age, boolean sexe, ImageIcon icon){
		this.nom=nom;
		this.prenom=prenom;
		this.age = age;
		this.sexe = sexe;
		this.icon = icon;
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
	
	public int getAge(){
		return this.age;
	}
	
	public boolean getSexe(){
		return this.sexe;
	}
	
	public ImageIcon getPhoto(){
		return this.icon;
	}
	
	private void setNom (String nom){
		this.nom = nom;
	}
	
	private void setPrenom (String prenom){
		this.prenom = prenom;
	}
	
	private void setAge (int age){
		this.age = age;
	}
	
	public void changeInfo(String nom, String prenom, int age){
		if(!nom.equals(this.getNom()))
			setNom(nom);
		if(!prenom.equals(this.getPrenom()))
			setPrenom(prenom);
		if(age != this.getAge())
			setAge(age);
	}
	
}
