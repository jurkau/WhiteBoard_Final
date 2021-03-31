package listener;



import com.codebind.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlFormat implements ActionListener{

    Fenetre fen;

    public ControlFormat(Fenetre fen) {this.fen = fen; }

    public void actionPerformed(ActionEvent actionEvent)
    {

        if(actionEvent.getSource() == fen.getTaille() )
        {
            System.out.println("D�but du changement de la taille du crayon");
            fen.changerTailleCrayon();
        }

        if(actionEvent.getSource() == fen.getCouleurText() )
        {
            System.out.println("D�but du changement de la couleur du crayon");
            fen.changerCouleurCrayon();
        }

        if(actionEvent.getSource() == fen.getCouleurFond() )
        {
            System.out.println("Changement couleur fond");
        }

    }
}
