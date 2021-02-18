package com.codebind;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.AbstractList;
import java.util.Enumeration;
import java.awt.Graphics;
import javax.swing.JFileChooser;

public class ControlMenu implements ActionListener{

    Fenetre fen;
    JFileChooser fc;

    public ControlMenu() {}

    public ControlMenu(Fenetre fen) {
        this.fen = fen;
        fc = new JFileChooser();
        JTextArea log;
    }

    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == fen.itemCercle) {

        }

        if(actionEvent.getSource() == fen.itemCarre) {

        }

        if(actionEvent.getSource() == fen.itemRectangle) {

        }

        if(actionEvent.getSource() == fen.save) {
            int returnVal = fc.showSaveDialog(fen);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
            }
        }

    }
}
