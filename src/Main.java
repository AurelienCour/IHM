import javax.swing.ImageIcon;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.model.Professeur;
import com.sdz.vue.FenetreInfo;

/**
 * Main de l'application
 * @author Aurelien
 *
 */
public class Main {
	
	
	public static void main (String[] args){
		Professeur p1 = new Professeur("Girard","Patrick");
		Professeur p2 = new Professeur("Geniet","Annie");
		
		Classe c1 = new Classe("Classe 1A");
		Classe c2 = new Classe("Classe 1B");
		Classe c3 = new Classe("Classe 1C");
	
		ImageIcon icon =new ImageIcon("Image_Bebe.png");

		Eleve e1 = new Eleve("Courtillat","Aurelien",21,true,icon);
		Eleve e2 = new Eleve("Noyon","Laurent",20,true,icon);
		Eleve e3 = new Eleve("Lhommelet","Severin",18,true,icon);
		Eleve e4 = new Eleve("Martin","Audrey",25,false,icon);
		Eleve e5 = new Eleve("Mazureau","Erwan",7,true,icon);
		Eleve e6 = new Eleve("Roig","David",6,true,icon);
		Eleve e7 = new Eleve("Hevin","Claire",10,false,icon);
		Eleve e8 = new Eleve("Bournazel","Ines",15,false,icon);
		Eleve e9 = new Eleve("Kislaire","Julien",23,true,icon);
		
		c1.addEleve(e1);
		c1.addEleve(e2);
		c1.addEleve(e3);
		
		c2.addEleve(e4);
		c2.addEleve(e5);
		c2.addEleve(e6);
		
		c3.addEleve(e7);
		c3.addEleve(e8);
		c3.addEleve(e9);
		
		p1.addClasse(c1);
		p1.addClasse(c2);
		p2.addClasse(c3);
		
		FenetreInfoModel model = new FenetreInfoModel();
		model.addProf(p1);
		model.addProf(p2);
		
		FenetreInfo f = new FenetreInfo(model);
	}
}
