package com.sdz.vue.Renderer;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.sdz.vue.FenetreInfo;

public class SexeCellRenderer extends DefaultTableCellRenderer {
    private Icon imageGarcon;
    private Icon imageFille;
 
    public SexeCellRenderer() {
        super();
        URL url = FenetreInfo.class.getResource("Image/garcon.png");
        imageGarcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
        url = FenetreInfo.class.getResource("Image/fille.png");
        imageFille = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Boolean homme = (Boolean)value;
        setText("");
        if(homme){
            setIcon(imageGarcon);
        } else {
            setIcon(imageFille);
        }
        return this;
    }
}