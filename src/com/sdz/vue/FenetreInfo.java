package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.sdz.controler.FenetreInfoControler;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;

import javafx.scene.control.TableColumn;

public class FenetreInfo extends JFrame{
	
	private JPanel panelInfo;
	private JLabel infoEleve;
	private JPanel panelTable;
	
	private JPanel panelFormulaire;
	
	private FenetreInfoControler controler;
	private FenetreInfoModel model;
	private JTree listeClasseEleve;
	private JTable tableClasse;
	
	public FenetreInfo(FenetreInfoModel model){
		this.setTitle("Test JTree et JTable");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(1080, 700);
		this.controler = new FenetreInfoControler(model,this);
		this.model = model;
		initComposant();
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
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void initComposant(){
		this.panelInfo = new JPanel();
		this.panelInfo.setLayout(new CardLayout());
		this.panelInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		Font police = new Font("Serif", Font.PLAIN, 50);
		this.infoEleve = new JLabel();
		this.infoEleve.setFont(police);
		this.infoEleve.setHorizontalAlignment(SwingConstants.CENTER);
		
	    //Les titres des colonnes
	    this.tableClasse = new JTable()
	    {
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        
        ListSelectionModel listSelectionModel = tableClasse.getSelectionModel();        
        listSelectionModel.addListSelectionListener(new ControleurTableResultat());
        
	    this.panelTable = new JPanel();
	    this.panelTable.setLayout(new BorderLayout());
	    this.panelTable.add(new JScrollPane(tableClasse),BorderLayout.CENTER);
	    
	    //this.panelInfo.add("Info", this.infoEleve);
		this.panelInfo.add("Table", this.panelTable);
		
		this.panelFormulaire = new JPanel();
		this.panelFormulaire.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		TreeListener treeListener = new TreeListener();
		//Création d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Classes");
		for (Classe cl : model.getClasses()) {
			DefaultMutableTreeNode classe = new DefaultMutableTreeNode(cl);
			for (Eleve el : cl.getListeEleve()) {
				DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
				classe.add(eleve);
			}
			racine.add(classe);
		}
		
		this.listeClasseEleve = new JTree(racine);
		listeClasseEleve.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		listeClasseEleve.addTreeSelectionListener(treeListener);
		listeClasseEleve.setPreferredSize(new Dimension(200,200));
		
		JPanel panelDroit = new JPanel();
		panelDroit.setLayout(new GridLayout(2,1));
		panelDroit.add(this.infoEleve);
		panelDroit.add(this.panelInfo);
		
		this.add(listeClasseEleve,BorderLayout.WEST);
		this.add(panelDroit, BorderLayout.CENTER);
	}
	
	public void changeLabel (String str){
		this.infoEleve.setText(str);
		//((CardLayout) this.panelInfo.getLayout()).show(this.panelInfo,"Info"); 
	}
	
	public void afficheTableEnfant(Classe obj){
		String  title[] = {"Icone","Nom", "Prenom", "Sexe", "Age",""};
		DefaultTableModel model2 = new DefaultTableModel(title,0);
		String sexe;
		for (Eleve el : obj.getListeEleve()) {
			if(el.getSexe() == 'M')
				sexe = "Garcon";
			else
				sexe = "Fille";
			model2.addRow(new Object[] {"",
										el.getNom(),
										el.getPrenom(),
										sexe,
										el.getAge(),
										el});
		}
		this.tableClasse.setModel(model2);
		
		
		javax.swing.table.TableColumn column = this.tableClasse.getColumnModel().getColumn(5);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		
		
		this.tableClasse.setPreferredScrollableViewportSize(this.tableClasse.getPreferredSize());
		((CardLayout) this.panelInfo.getLayout()).show(this.panelInfo,"Table");
	}
	
	class TreeListener implements TreeSelectionListener{
		public void valueChanged(TreeSelectionEvent arg0) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)
					listeClasseEleve.getLastSelectedPathComponent();
			if (node == null) return;
			Object nodeInfo = node.getUserObject();
			controler.getInfo(nodeInfo);
		}
	}
	
	public class ControleurTableResultat  implements ListSelectionListener{
	    public void valueChanged(ListSelectionEvent listSelectionEvent){
	        if (listSelectionEvent.getValueIsAdjusting())
	            return;
	        ListSelectionModel lsm = (ListSelectionModel)listSelectionEvent.getSource();
	        if (!lsm.isSelectionEmpty()) {
	            int selectedRow = lsm.getMinSelectionIndex();
	            Object obj = tableClasse.getValueAt(selectedRow, 5);
	            controler.getInfo(obj);
	        }
	    }
	}
}
