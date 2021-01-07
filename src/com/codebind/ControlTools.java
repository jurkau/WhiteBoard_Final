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


        if(actionEvent.getSource() == fen.btnText)
        {
            JPanel paneText = new JPanel();
            JTextArea textArea = new JTextArea();
            textArea.setDragEnabled(true);
            textArea.setSize(100,100);
            paneText.add(textArea);
            fen.tableauCourant.add(paneText);
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

    }
}
