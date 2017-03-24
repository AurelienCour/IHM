package com.sdz.vue;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.sdz.model.Classe;
import com.sdz.model.Eleve;
import com.sdz.model.FenetreInfoModel;

public class ModelTable extends AbstractTableModel {

	private ArrayList<Eleve> donnees;
	private final String[] entetes = {"Icone", "Nom", "Prenom", "Sexe", "Age"};

	public ModelTable(FenetreInfoModel model) {
		super();
		donnees = new ArrayList<Eleve>();
	}

	public void initDonnees(Classe cl){
		if(!donnees.isEmpty())
			donnees.removeAll(donnees);
		for (Eleve eleve : cl.getListeEleve()) {
			donnees.add(eleve);
		}
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
	public Class getColumnClass(int columnIndex){
		switch(columnIndex){
			case 3:
				return Boolean.class;
			default:
				return Object.class;
		}
	}


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
