package com.sdz.vue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sdz.model.Eleve;

public class PanelInfoEleve extends JPanel{

	private JLabel imageEnfant;
	private JLabel nomEnfant;
	private JLabel prenomEnfant;
	private JLabel age;
	private JLabel sexe;
	private Font police = new Font("Serif", Font.PLAIN, 20);
	
	public PanelInfoEleve(){
		this.setLayout(new GridLayout(5,1));
		imageEnfant = new JLabel("");
		imageEnfant.setFont(police);
		nomEnfant = new JLabel();
		nomEnfant.setFont(police);
		prenomEnfant = new JLabel();
		prenomEnfant.setFont(police);
		age = new JLabel();
		age.setFont(police);
		sexe = new JLabel();
		sexe.setFont(police);
		this.add(imageEnfant);
		this.add(nomEnfant);
		this.add(prenomEnfant);
		this.add(age);
		this.add(sexe);
	}

	public void changeInfo(Eleve e) {
		nomEnfant.setText(e.getNom());
		prenomEnfant.setText(e.getPrenom());
		age.setText(""+e.getAge());
		sexe.setText(""+e.getSexe());
	}
}
