package Etape4_ProgJTree_JTable;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.tree.*;


public class MenuJtree extends JFrame{
	
	private JTree panelJtree;
	private JLabel labelDroit;
	private JPanel panelDroit;
	private JTable panelTable;
	private JPanel panelFormulaire;
	private ArrayList<Classe> lesClasses;
	
	public MenuJtree(){
		this.lesClasses = new ArrayList<Classe>();
		this.labelDroit = new JLabel();
		this.panelDroit = new JPanel();
		this.panelDroit.setLayout(new GridLayout(2,1));
		this.panelTable = new JTable();
		Font police = new Font("Serif", Font.PLAIN, 100);
		this.labelDroit.setFont(police);
		this.labelDroit.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelDroit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setTitle("Test JTree et JTable");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			//On utilise le look and feel : NimbusLookAndFeel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			// On applique le look and feel a notre fenetre
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (InstantiationException e) {}
		catch (ClassNotFoundException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		catch (IllegalAccessException e) {}
		
		this.panelDroit.add(panelTable);
		this.panelDroit.add(labelDroit);
		this.add(panelDroit,BorderLayout.CENTER);
	}
	
	public void affichageFenetre(){
		// Creation setCellRenderer new treeCellRenderer pour perso l'affichage car appel auto a toString()
		//Création d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Classes");
		for (Classe cl : lesClasses) {
			DefaultMutableTreeNode classe = new DefaultMutableTreeNode(cl);
			for (Eleve el : cl.getListeEleve()) {
				DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
				classe.add(eleve);
			}
			racine.add(classe);
		}
		
		this.panelJtree = new JTree(racine);
		this.panelJtree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.panelJtree.addTreeSelectionListener(new Actions(this,this.panelJtree));
		this.add(this.panelJtree,BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void afficheInfo(Object node){
		if(node instanceof Eleve){
			labelDroit.setText(node.toString());
		}
		else if(node instanceof Classe){
			labelDroit.setText(node.toString());
		}
	}
	
	public void addClasse(Classe classe){
		this.lesClasses.add(classe);
	}
	
	public static void main (String[] args){
		MenuJtree etape = new MenuJtree();
		Classe c1 = new Classe("Classe 1A");
		Classe c2 = new Classe("Classe 1B");
		Classe c3 = new Classe("Classe 1C");
		
		Eleve e1 = new Eleve("Courtillat","Aurelien",21);
		Eleve e2 = new Eleve("Noyon","Laurent",20);
		Eleve e3 = new Eleve("Lhommelet","Severin",18);
		Eleve e4 = new Eleve("Martin","Audrey",25);
		Eleve e5 = new Eleve("Mazureau","Erwan",7);
		Eleve e6 = new Eleve("Roig","David",6);
		Eleve e7 = new Eleve("Hevin","Claire",10);
		Eleve e8 = new Eleve("Bournazel","Ines",15);
		Eleve e9 = new Eleve("Kislaire","Julien",23);
		
		c1.addEleve(e1);
		c1.addEleve(e2);
		c1.addEleve(e3);
		
		c2.addEleve(e4);
		c2.addEleve(e5);
		c2.addEleve(e6);
		
		c3.addEleve(e7);
		c3.addEleve(e8);
		c3.addEleve(e9);
		
		etape.addClasse(c1);
		etape.addClasse(c2);
		etape.addClasse(c3);
		
		etape.affichageFenetre();
	}
}
