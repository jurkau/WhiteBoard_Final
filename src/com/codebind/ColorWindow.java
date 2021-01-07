package com.codebind;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class ColorWindow extends JFrame{

	private JColorChooser selectColor;
	private Fenetre fen;


    public ColorWindow(Fenetre fen)
    {
    	this.fen = fen;
        setSize(600,250);                   // Fixe la taille par défaut
        setVisible(false);                                // Affiche la fenetre
        setLocationRelativeTo(null);
        setTitle("Selection Couleur");
        //pas besoin de la commande de fermeture, le dialog le fait pour nous
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel pano = new JPanel();
        
        selectColor = new JColorChooser();
        selectColor.setColor(Color.BLUE);
        
        selectColor.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                Color color = selectColor.getColor();
                System.out.println(color);
            }
        });
        
        Dialog dialog = JColorChooser.createDialog(null, "Selection Couleur",
                true, selectColor, null, null);
        dialog.setVisible(true);
        
        pano.add(selectColor);
        
        setContentPane(pano);
        
    }
    
    public Color getColor()
    {
    	return selectColor.getColor();
    }
    
}