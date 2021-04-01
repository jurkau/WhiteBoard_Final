package com.codebind;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.AbstractList;
import java.util.Enumeration;
import java.awt.Graphics;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

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

        if(actionEvent.getSource() == fen.save){

            FileFilter docFilter = new FileTypeFilter(".docx", "Microsoft Word Documents");
            FileFilter pdfFilter = new FileTypeFilter(".pdf", "PDF Documents");
            FileFilter imgFilter = new FileTypeFilter(".png", "Png Documents");


            JFileChooser c = new JFileChooser(new File("c:\\"));
            c.addChoosableFileFilter(docFilter);
            c.addChoosableFileFilter(pdfFilter);
            c.addChoosableFileFilter(imgFilter);

            c.setAcceptAllFileFilterUsed(true);

            c.setDialogTitle("Specify a file to save");
            int rval = c.showSaveDialog(fen);
            if(rval == JFileChooser.APPROVE_OPTION) {
                File fileToSave = c.getSelectedFile();
                System.out.println("Save as file:"  + fileToSave.getAbsolutePath());
            }
            if(rval == JFileChooser.CANCEL_OPTION) {
                System.out.println("You pressed cancel");
            }
        }


    }
}
