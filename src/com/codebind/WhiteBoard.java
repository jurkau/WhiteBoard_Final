package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WhiteBoard extends JTextField implements MouseListener, MouseMotionListener {
    private Point curr = null;
    private Point prev = null;
    private Color couleurPinceau;
    private Color couleurFond;
    private int taille;

    //Permet d'identifier le tableau pour faciliter le traitement pour l'action du bouton clear
    public int id;


    /**
     * constructeur pour définir un identifiant du tableau pour faciliter le traitement avec le bouton clear
     * @param id
     */
    public WhiteBoard(int id) {
        addMouseListener(this);
        addMouseMotionListener(this);
        setOpaque(false);
        this.id = id;
        this.couleurPinceau = Color.BLACK;
        this.couleurFond = Color.WHITE;
    }

    public void clear() {
        getGraphics().clearRect(0, 0, getWidth(), getHeight());
    }

    public int getId(){
        return this.id;
    }
    public void setTaille(int varTaille)
    {
        this.taille = varTaille;
    }

    /**
     * permet de tracer les traits
     * @param e
     */
    @Override
    public void mouseDragged(final MouseEvent e) {
        prev=curr;
        curr=e.getPoint();
        final Graphics g = getGraphics();
        g.setColor(couleurPinceau);
        g.drawLine(prev.x,prev.y,curr.x,curr.y);
    }
    public void setCouleurPinceau(Color couleurCourante)
    {
        this.couleurPinceau = couleurCourante;
    }

    public Color getCouleurFond(){
        return this.couleurFond;
    }

    public void setCouleurFond( Color newCouleurFond )
    {
        this.couleurFond = newCouleurFond;
    }


    @Override
    public void mouseMoved(final MouseEvent e) { }

    @Override
    public void mouseClicked(final MouseEvent e) { }

    @Override
    public void mouseEntered(final MouseEvent e) { }

    @Override
    public void mouseExited(final MouseEvent e) { }

    @Override
    public void mousePressed(final MouseEvent e) {
        curr = e.getPoint();
    }

    /**
     * Permet d'arreter le dessin quand on arrete de cliquer sur la souris
     * @param e
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        prev=curr=null;
    }
}
