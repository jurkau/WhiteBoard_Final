package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlTools implements ActionListener {

    Fenetre fen;
    WhiteBoard whiteBoard;

    public ControlTools() {}

    public ControlTools(Fenetre fen)
    {
        this.fen = fen;
    }

    public ControlTools(Fenetre fen, WhiteBoard whiteBoard)
    {
        this.fen = fen;
        this.whiteBoard = whiteBoard;
    }


    public void actionPerformed(ActionEvent actionEvent) {


        if(actionEvent.getSource() == fen.btnColorYellow)
        {
            whiteBoard.setCouleurPinceau(Color.YELLOW);
        }


        if(actionEvent.getSource() == fen.btnColorBlue)
        {
            System.out.println(whiteBoard.getId());
            whiteBoard.setCouleurPinceau(Color.BLUE);
        }

        if(actionEvent.getSource() == fen.btnColorGreen)
        {
            whiteBoard.setCouleurPinceau(Color.GREEN);
        }

        if(actionEvent.getSource() == fen.btnColorRed)
        {
            whiteBoard.setCouleurPinceau(Color.RED);
        }

        if(actionEvent.getSource() == fen.btnColorBlack)
        {
            whiteBoard.setCouleurPinceau(Color.BLACK);
        }


        if(actionEvent.getSource() == fen.btnGomme)
        {
            whiteBoard.setCouleurPinceau(Color.WHITE);
        }

        if(actionEvent.getSource() == fen.taille1){
            whiteBoard.setTaille(15);
        }

        if(actionEvent.getSource() == fen.itemCercle) {
            whiteBoard.drawOval();
        }

        if(actionEvent.getSource() == fen.itemCarre) {
            whiteBoard.drawCarre();
        }

        if(actionEvent.getSource() == fen.itemRectangle) {
            whiteBoard.drawRect();
        }

    }
}
