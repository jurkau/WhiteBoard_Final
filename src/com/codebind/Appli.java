package com.codebind;

import baseDonne.ConnectionUtilisateur;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.sql.SQLException;

class Appli extends JFrame {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                try {
                    ConnectionUtilisateur c = new ConnectionUtilisateur();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
