package com.codebind;
import javax.swing.*;
import java.awt.event.*;
import java.util.AbstractList;
import java.util.Enumeration;
import java.awt.Graphics;

public class ControlMenu implements ActionListener{

    Fenetre fen;

    public ControlMenu() {}

    public ControlMenu(Fenetre fen) {this.fen = fen; }

    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == fen.itemCercle) {

        }

        if(actionEvent.getSource() == fen.itemCarre) {

        }

        if(actionEvent.getSource() == fen.itemRectangle) {

        }



    }
}
