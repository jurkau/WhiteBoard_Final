package com.codebind;

import baseDonne.ConnectionUtilisateur;
import baseDonne.Inscription;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlConnection implements ActionListener {

    ConnectionUtilisateur cu;

    public ControlConnection(ConnectionUtilisateur cu) {
        this.cu = cu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == cu.jButton1) {
            Fenetre fen = new Fenetre();
            cu.dispose();
        }
        else if(actionEvent.getSource() == cu.inscription){
            Inscription ins = new Inscription();
            cu.dispose();
        }

    }
}
