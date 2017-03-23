package com.sdz.model;

import javax.swing.ImageIcon;

public class Eleve {

	private String nom, prenom;
	private int age;
	private char sexe;
	private ImageIcon icon;
	
	public Eleve(String nom, String prenom, int age, char sexe, ImageIcon icon){
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
	
	public char getSexe(){
		return this.sexe;
	}
	
	public ImageIcon getPhoto(){
		return this.icon;
	}
}
