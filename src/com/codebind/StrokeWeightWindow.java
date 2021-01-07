package com.codebind;

import javax.swing.*;
import java.awt.*;


public class StrokeWeightWindow extends JFrame{

	private JComboBox<Integer> comboBox;
	private ControlStrokeWeight controlStrokeWeight;
	private Fenetre fen;


    public StrokeWeightWindow(Fenetre fen)
    {
    	this.fen = fen;
        setSize(200,150);                   // Fixe la taille par défaut
        setVisible(true);                                // Affiche la fenetre
        setLocationRelativeTo(null);
        setTitle("Selection Couleur");
        //pas besoin de la commande de fermeture, le dialog le fait pour nous
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel pano = new JPanel();
        
        Integer[] listeTaille = new Integer [25];
        for(Integer i = 1; i <= 25; i++)
        {
        	listeTaille[i-1] = i;
        }
        comboBox = new JComboBox<Integer>(listeTaille);
        comboBox.setPreferredSize(new Dimension(50,25));

        comboBox.setMaximumSize( comboBox.getPreferredSize() );
        
        pano.add(comboBox);
        
        setContentPane(pano);
        
        controlStrokeWeight = new ControlStrokeWeight(this);
        comboBox.addActionListener(controlStrokeWeight);
        
        System.out.println("DEBUG");
    }
    
    public void changerTaille()
    {
    	System.out.println("D�but de l'application de la nouvelle taille");
    	fen.setNouvelleTailleCrayon( (Integer) comboBox.getSelectedItem() );       
    	setVisible(false);
    }
    
    public JComboBox<Integer> getComboBox()
    {
    	return comboBox;
    }
    
}