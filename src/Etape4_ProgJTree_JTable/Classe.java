package Etape4_ProgJTree_JTable;

import java.util.ArrayList;

public class Classe {
	
	private ArrayList<Eleve> listeEleves;
	private String nomClasse;
	
	public Classe(String nomClasse){
		this.nomClasse = nomClasse;
		this.listeEleves = new ArrayList<Eleve>();
	}
	
	public void addEleve(Eleve eleve){
		this.listeEleves.add(eleve);
	}
	
	public ArrayList<Eleve> getListeEleve(){
		return this.listeEleves;
	}
	
	public String toString(){
		return this.nomClasse;
	}
}
