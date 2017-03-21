package Etape4_ProgJTree_JTable;

public class Eleve {

	private String nom, prenom;
	private int age;
	
	public Eleve(String nom, String prenom, int age){
		this.nom=nom;
		this.prenom=prenom;
		this.age = age;
	}
	
	public String toString(){
		return this.nom+" "+this.prenom;
	}
}
