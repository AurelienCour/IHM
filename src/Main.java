import javax.swing.ImageIcon;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;
import com.sdz.vue.FenetreInfo;


public class Main {
	
	
	public static void main (String[] args){
		Classe c1 = new Classe("Classe 1A");
		Classe c2 = new Classe("Classe 1B");
		Classe c3 = new Classe("Classe 1C");
	
		ImageIcon icon =new ImageIcon("Image_Bebe.png");

		Eleve e1 = new Eleve("Courtillat","Aurelien",21,'M',icon);
		Eleve e2 = new Eleve("Noyon","Laurent",20,'M',icon);
		Eleve e3 = new Eleve("Lhommelet","Severin",18,'M',icon);
		Eleve e4 = new Eleve("Martin","Audrey",25,'F',icon);
		Eleve e5 = new Eleve("Mazureau","Erwan",7,'M',icon);
		Eleve e6 = new Eleve("Roig","David",6,'M',icon);
		Eleve e7 = new Eleve("Hevin","Claire",10,'F',icon);
		Eleve e8 = new Eleve("Bournazel","Ines",15,'F',icon);
		Eleve e9 = new Eleve("Kislaire","Julien",23,'M',icon);
		
		c1.addEleve(e1);
		c1.addEleve(e2);
		c1.addEleve(e3);
		
		c2.addEleve(e4);
		c2.addEleve(e5);
		c2.addEleve(e6);
		
		c3.addEleve(e7);
		c3.addEleve(e8);
		c3.addEleve(e9);
		
		FenetreInfoModel model = new FenetreInfoModel();
		model.addClasse(c1);
		model.addClasse(c2);
		model.addClasse(c3);
		
		FenetreInfo f = new FenetreInfo(model);
	}
}
