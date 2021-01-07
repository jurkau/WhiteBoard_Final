package com.codebind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlStrokeWeight implements ActionListener{

    StrokeWeightWindow sww;

    public ControlStrokeWeight(StrokeWeightWindow sww) {this.sww = sww; }

    public void actionPerformed(ActionEvent actionEvent) 
    {

        if(actionEvent.getSource() == sww.getComboBox() )
        {
        	System.out.println("Nouvelle taille s�lectionn�e");
        	sww.changerTaille();
        }

    }
}
