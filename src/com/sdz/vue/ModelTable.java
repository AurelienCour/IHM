package com.sdz.vue;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;

/**
 * Classe représentant le model de notre JTable
 * @author Aurelien
 *
 */
public class ModelTable extends AbstractTableModel {

	private ArrayList<Eleve> donnees;
	private final String[] entetes = {"Icone", "Nom", "Prenom", "Sexe", "Age"};
	private FenetreInfo fenetreInfo;

	/**
	 * Le constructeur de notre classe
	 * @param model Le model contenant nos données
	 * @param fenetreInfo 
	 */
	public ModelTable(FenetreInfoModel model, FenetreInfo fenetreInfo) {
		super();
		this.fenetreInfo = fenetreInfo;
		donnees = new ArrayList<Eleve>();
	}

	/**
	 * Initialise les données de la table
	 * @param cl La classe a importer au sein de la table
	 */
	public void initDonnees(Classe cl){
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for (Eleve eleve : cl.getListeEleve()) {
			donnees.add(eleve);
		}
		reload();
	}

	/**
	 * Permet de recharger la table
	 */
	public void reload(){
		fireTableDataChanged();
	}
	
	public int getRowCount() {
		return donnees.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return "";
		case 1:
			return donnees.get(rowIndex).getNom();
		case 2:
			return donnees.get(rowIndex).getPrenom();
		case 3:
			return donnees.get(rowIndex).getSexe();
		case 4:
			return donnees.get(rowIndex).getAge();
		default:
			return null; //Ne devrait jamais arriver
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 1 || columnIndex == 2 || columnIndex == 4)
			return true; //Toutes les cellules éditables
		return false;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    if(aValue != null){
	        Eleve eleve = donnees.get(rowIndex);
	 
	        switch(columnIndex){
	            case 1:
	            	eleve.changeInfo((String)aValue, eleve.getPrenom(), eleve.getAge());
	            	fenetreInfo.getPanelInfo().changeLabelEnfant(eleve);
	            	fenetreInfo.updateTree();
	                break;
	            case 2:
	            	eleve.changeInfo(eleve.getNom(), (String)aValue, eleve.getAge());
	            	fenetreInfo.getPanelInfo().changeLabelEnfant(eleve);
	            	fenetreInfo.updateTree();
	                break;
	            case 4:
	            	eleve.changeInfo(eleve.getNom(), eleve.getPrenom(), Integer.parseInt((String)aValue));
	            	fenetreInfo.getPanelInfo().changeLabelEnfant(eleve);
	            	fenetreInfo.updateTree();
	                break;
	        }
	    }
	}
	
	@Override
	public Class getColumnClass(int columnIndex){
		switch(columnIndex){
			case 3:
				return Boolean.class;
			default:
				return Object.class;
		}
	}

	/**
	 * Permet d'ajouter un élève à notre table
	 * @param eleve
	 */
	public void addEleve(Eleve eleve) {
		donnees.add(eleve);
		fireTableRowsInserted(donnees.size() -1, donnees.size() -1);
	}
	
	public Eleve getEleveRow(int rowIndex){
		return donnees.get(rowIndex);
	}

	public void removeEleve(int rowIndex) {
		donnees.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}
