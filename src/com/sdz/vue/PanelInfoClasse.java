package com.sdz.vue;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInfoClasse extends JPanel{
	
	private JLabel labelInfoClasse;

	public PanelInfoClasse(){
		
		Font police = new Font("Serif", Font.PLAIN, 50);
		labelInfoClasse = new JLabel();
		labelInfoClasse.setFont(police);
		labelInfoClasse.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoClasse.setVerticalAlignment(SwingConstants.CENTER);
		
		this.add(labelInfoClasse);
	}
	
	public void changeInfo(String str) {
		labelInfoClasse.setText(str);
	}
}
