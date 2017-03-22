package com.sdz.model;

import java.util.ArrayList;

public class FenetreInfoModel  {
	
	private ArrayList<Classe> lesClasses;
	
	public FenetreInfoModel(){
		this.lesClasses = new ArrayList<Classe>();
	}
	
	public void addClasse (Classe c){
		this.lesClasses.add(c);
	}
	
	public ArrayList<Classe> getClasses(){
		return this.lesClasses;
	}
}
