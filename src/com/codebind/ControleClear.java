package com.codebind;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ControleClear extends JFrame implements ActionListener {

    Fenetre fen;

    public ControleClear(Fenetre fen){
        this.fen = fen;
    }

    /**
     * suivant l'id du tableau permet de clear le tableau correspondant
     */
    public void actionPerformed(ActionEvent actionEvent)
    {

        if (fen.tableauCourant.getId()== 1) {
            Border lineborder = BorderFactory.createLineBorder(Color.black, 3);
            fen.tableau1.setBorder(lineborder);
            fen.tableau1.setBounds(300,100,700,500);
            //fen.tableau1.clear();
        }

        if (fen.tableauCourant.getId()== 2){
            Border lineborder = BorderFactory.createLineBorder(Color.black, 3);
            fen.tableau2.setBorder(lineborder);
            fen.tableau2.setBounds(300,100,700,500);
            //fen.tableau2.clear();
        }

        if (fen.tableauCourant.getId()== 3){
            Border lineborder = BorderFactory.createLineBorder(Color.black, 3);
            fen.tableau3.setBorder(lineborder);
            fen.tableau3.setBounds(300,100,700,500);
            //fen.tableau3.clear();
        }
    }
}
