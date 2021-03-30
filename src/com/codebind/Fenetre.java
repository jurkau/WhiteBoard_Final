package com.codebind;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import javax.jnlp.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame implements ActionListener {

    JTextField filename;
    JTextField dir;

    // création des éléments du menu et des differents sous-menu
    JMenuBar barMenu;
    JMenuItem itemImage;
    JMenuItem itemTableau;
    JMenuItem itemCercle;
    JMenuItem itemRectangle;
    JMenuItem save;
    JMenuItem ouvrir;
    JMenuItem itemCarre;


    //JMenu droits;
    JMenu Diagramme;
    JMenu insert;
    JMenu partage;
    JMenu connexion;
    JMenu inscription;
    JMenu police;
    JMenu format;
    JMenu pinceau;
    JMenuItem taille;
    JMenuItem couleurText;
    JMenu fond;
    JMenuItem couleurFond;

    // File Chooser permettant de sauvegarder et ouvrir des fichiers
    JFileChooser fc;

    // création des boutons de choix de tableaux et d'effacage générale
    JButton butTab1;
    JButton butTab2;
    JButton butTab3;
    JButton btClear;

    // boutons permettant le choix du crayon, de la gomme et de sa couleur
    JButton btnGomme;
    JButton btnColorRed;
    JButton btnColorBlack;
    JButton btnColorBlue;
    JButton btnColorGreen;

    //Police
    JMenuItem policeEcriture18 = new JMenuItem("18");
    JMenuItem policeEcriture12 = new JMenuItem("12");
    JMenuItem policeEcriture25 = new JMenuItem("25");
    JMenuItem policeEcriture8 = new JMenuItem("8");
    JMenuItem policeEcriture36 = new JMenuItem("36");
    JMenuItem policeEcriture50 = new JMenuItem("50");
    JMenuItem policeEcriture10 = new JMenuItem("10");

    // Image de gomme pour le bonton gomme
    ImageIcon gomme;

    // boutons permettant l'insertion de zone de texte
    JButton btnPostite;
    JButton btnText;

    //Création des controles
    public ControlTableau controlTab;
    public ControlMenu controlMenu;
    public ControleClear clear;
    public ControlTools controlTools;

    //création d'un tableau
    WhiteBoard tableau1;
    WhiteBoard tableau2;
    WhiteBoard tableau3;
    WhiteBoard tableauCourant;

    JPanel pano;
    JPanel ptab1;
    JPanel ptab2;
    JPanel ptab3;
    JPanel ptableau;
    JPanel panToolBox;

    int sX = -1, sY = -1;
    boolean dragging = false;

    public Fenetre()
    {
        initAtribut();
        creerInterface();
        creerMenu();
        creerBoiteaOutil();
        pack();
        setSize(1350,800);                   // Fixe la taille par défaut
        setVisible(true);                                // Affiche la fenetre
        setLocationRelativeTo(null);
        setTitle("Tableau Blanc Interractif");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }


    public void initAtribut()
    {
        filename = new JTextField();
        dir = new JTextField();

        // initialisation menu
        barMenu = new JMenuBar();
        itemImage = new JMenuItem("Image");
        itemTableau = new JMenuItem("Tableau");

        // modification de l'écriture et insertion de formes
        itemCercle = new JMenuItem();
        itemCercle.setIcon(new ImageIcon("source/circle.webp"));

        itemCarre = new JMenuItem();
        itemCarre.setIcon(new ImageIcon("source/square.png"));

        itemRectangle = new JMenuItem();
        itemRectangle.setIcon(new ImageIcon("source/recrangle.png"));

        police = new JMenu("Police");

        //droits = new JMenu("Droits");
        insert = new JMenu("Insertion");
        partage = new JMenu("Partager");

        // Sauvegarde et ouverture
        save = new JMenuItem("Enregistre");
        save.addActionListener(controlMenu);
        ouvrir = new JMenuItem("Ouvrir");
        ouvrir.addActionListener(controlMenu);

        // Insertion d'éléments
        Diagramme = new JMenu("Forme");
        connexion = new JMenu("Connexion");

        inscription = new JMenu("Inscription");

        // Initiallisation Boite a outil
        btnText = new JButton("Zone de texte");
        btnGomme = new JButton();
        btnGomme.setIcon(new ImageIcon("source/gomme.jpg"));

        btnColorBlack = new JButton();
        btnColorRed = new JButton();
        btnColorBlue = new JButton();
        btnColorGreen = new JButton();
        panToolBox = new JPanel();

        // Initialisation image gomme
        gomme = new ImageIcon("gomme.jpg");
        btnGomme.setIcon(gomme);


        //initialisation des boutons sur la page principale
        butTab1 = new JButton("Tab 1");
        butTab2 = new JButton("Tab 2");
        butTab3 = new JButton("Tab 3");
        btClear = new JButton("Clear");


        //initiation des contrôles pour les action du Menu et des tableaux
        controlTab = new ControlTableau(this);
        controlMenu = new ControlMenu(this);
        clear = new ControleClear(this);


        // création des tableaux
        tableau1 = new WhiteBoard(1);
        tableau2 = new WhiteBoard(2);
        tableau3 = new WhiteBoard(3);
        tableauCourant = tableau1;
        tableauCourant.setBackground(Color.WHITE);

        ptab1 = new JPanel();
        ptab2 = new JPanel();
        ptab3 = new JPanel();
        ptableau = new JPanel();

    }

    //initialisation des listener
    
    public void creerMenu() {

        /*
         * format
         */
        format = new JMenu("Format");

        pinceau = new JMenu("Pinceau");
        taille = new JMenuItem("Changer la taille");
        couleurText= new JMenuItem("Changer la couleur");
        pinceau.add(taille);
        pinceau.add(couleurText);

        fond = new JMenu("Fond");
        couleurFond = new JMenuItem("Changer la couleur");
        fond.add(couleurFond);

        format.add(pinceau);
        format.add(fond);
        barMenu.add(format);

        //gestion des actions si on clic sur un des menu
        itemImage.addActionListener(controlMenu);
        itemTableau.addActionListener(controlMenu);
        itemCercle.addActionListener(controlMenu);
        itemCarre.addActionListener(controlMenu);
        itemRectangle.addActionListener(controlMenu);

        // gestion des actions de sauvegarde et d'ouverture
        save.addActionListener(controlMenu);
        ouvrir.addActionListener(controlMenu);


        // ajout des éléments dans le JMenu insert
        insert.add(Diagramme);
        insert.add(itemImage);
        insert.add(itemTableau);

        // ajout des différentes formes dans le sous menu diagramme
        Diagramme.add(itemCercle);
        Diagramme.add(itemCarre);
        Diagramme.add(itemRectangle);


        // ajout des éléments à la barre de Menu
        //barMenu.add(droits);
        barMenu.add(insert);
        barMenu.add(partage);
        barMenu.add(save);
        barMenu.add(ouvrir);
        barMenu.add(connexion);
        barMenu.add(inscription);
        barMenu.add(police);
        setJMenuBar(barMenu);



        //ajout des tableaux
        getContentPane().add(tableau1, BorderLayout.CENTER);
        getContentPane().add(tableau2, BorderLayout.CENTER);
        getContentPane().add(tableau3, BorderLayout.CENTER);


        tableau2.setVisible(false);
        tableau3.setVisible(false);

    }

    private void initListener(){
        /*
         * Listener menubar - Format
         */
        listener.ControlFormat controlFormat = new listener.ControlFormat(this);
        taille.addActionListener(controlFormat);
        couleurText.addActionListener(controlFormat);
        couleurFond.addActionListener(controlFormat);
    }

    public void creerBoiteaOutil()
    {
        controlTools = new ControlTools(this, tableauCourant);

        btnText.addActionListener(controlTools);
        btnGomme.addActionListener(controlTools);

        btnColorBlack.addActionListener(controlTools);
        btnColorBlack.setBackground(Color.BLACK);

        btnColorRed.addActionListener(controlTools);
        btnColorRed.setBackground(Color.RED);

        btnColorBlue.addActionListener(controlTools);
        btnColorBlue.setBackground(Color.BLUE);

        btnColorGreen.addActionListener(controlTools);
        btnColorGreen.setBackground(Color.GREEN);
    }

    public void creerInterface()
    {
        /**pour superposer setLayout = null*/
        //création du panel général avec alignement verticale des éléments
        JPanel pano = new JPanel();

        //pano.setLayout(new BoxLayout(pano, BoxLayout.Y_AXIS));

        //création du panel pour les boutons avec alignement horizontal des éléments
        JPanel panButTab = new JPanel();
        //panButTab.setLayout(new BoxLayout(panButTab, BoxLayout.X_AXIS));
        //modif
        JTextArea tfTableau1 = new JTextArea();
        tfTableau1.setBackground(Color.WHITE);


        barMenu.add(police);
        policeEcriture18.addActionListener(this);
        policeEcriture12.addActionListener(this);
        policeEcriture25.addActionListener(this);
        policeEcriture36.addActionListener(this);
        policeEcriture50.addActionListener(this);
        policeEcriture10.addActionListener(this);
        policeEcriture8.addActionListener(this);

        police.add(policeEcriture25);
        police.add(policeEcriture36);
        police.add(policeEcriture50);
        police.add(policeEcriture10);
        police.add(policeEcriture8);
        police.add(policeEcriture18);
        police.add(policeEcriture12);


        // Insertion ajout des boutons dans le panel
        panButTab.add(butTab1);
        panButTab.add(butTab2);
        panButTab.add(butTab3);
        panButTab.add(btClear);
        ///







        ///

        // ajout du panel avec les boutons dans le panel

        pano.add(panButTab);

        ptableau.add(tableau1);
        ptableau.add(tableau2);
        ptableau.add(tableau3);

        //modif
        //ptableau.setBounds(200,200,800,500);
        Border lineborder = BorderFactory.createLineBorder(Color.black, 3);
        tableau1.setBorder(lineborder);
        tableau2.setBorder(lineborder);
        tableau3.setBorder(lineborder);
        //tableau1.setPreferredSize(new Dimension(910,450));
        //tableau2.setPreferredSize(new Dimension(910,450));
        //tableau3.setPreferredSize(new Dimension(910,450));
        butTab1.setBorder(lineborder);
        butTab1.setBounds(350,40,50,50);
        butTab2.setBorder(lineborder);
        butTab2.setBounds(450,40,50,50);
        butTab3.setBorder(lineborder);
        butTab3.setBounds(550,40,50,50);
        btClear.setBorder(lineborder);
        btClear.setBounds(750,40,50,50);
        btnColorRed.setBorder(lineborder);
        btnColorRed.setBounds(800,40,50,50);
        btnColorBlack.setBorder(lineborder);
        btnColorBlack.setBounds(850,40,50,50);
        btnColorBlue.setBorder(lineborder);
        btnColorBlue.setBounds(900,40,50,50);
        btnColorGreen.setBorder(lineborder);
        btnColorGreen.setBounds(950,40,50,50);
        btnText.setBorder(lineborder);
        btnText.setBounds(1000,40,50,50);
        btnGomme.setBorder(lineborder);
        btnGomme.setBounds(1050,40,50,50);
        tableau1.setBounds(300,100,700,500);
        tableau2.setBounds(300,100,700,500);
        tableau3.setBounds(300,100,700,500);

        tfTableau1.setBounds(1090,300,200,390);
        JTextArea test = new JTextArea();
        tableau1.add(test);
        setContentPane(ptableau);


        //ajout des actions sur les boutons
        butTab1.addActionListener(controlTab);
        butTab2.addActionListener(controlTab);
        butTab3.addActionListener(controlTab);
        btClear.addActionListener(clear);

        //permet l'affichag du panel général
        //pano.add(ptableau);

        pano.add(tfTableau1);
        pano.add(butTab1);
        pano.add(butTab2);
        pano.add(butTab3);
        pano.add(btClear);
        pano.add(btnText);
        pano.add(btnGomme);
        pano.add(btnColorBlack);
        pano.add(btnColorRed);
        pano.add(btnColorBlue);
        pano.add(btnColorGreen);
        pano.setLayout(null);
        setContentPane(pano);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        tableau1.setFont(new Font("Serif", Font.BOLD, 18));
        Object source = e.getSource();
        if(source == policeEcriture18){
            tableau1.setFont(new Font("Serif", Font.BOLD, 18));
        } else if(source == policeEcriture12){
            tableau1.setFont(new Font("Serif", Font.BOLD, 12));
        } else if(source == policeEcriture25){
            tableau1.setFont(new Font("Serif", Font.BOLD, 25));
        }
        else if(source == policeEcriture36){
            tableau1.setFont(new Font("Serif", Font.BOLD, 36));
        }
        else if(source == policeEcriture50){
            tableau1.setFont(new Font("Serif", Font.BOLD, 50));
        }
        else if(source == policeEcriture10){
            tableau1.setFont(new Font("Serif", Font.BOLD, 10));
        }
        else if(source == policeEcriture8){
            tableau1.setFont(new Font("Serif", Font.BOLD, 8));
        }

        tableau2.setFont(new Font("Serif", Font.BOLD, 18));
        Object source1 = e.getSource();
        if(source1 == policeEcriture18){
            tableau2.setFont(new Font("Serif", Font.BOLD, 18));
        } else if(source1 == policeEcriture12){
            tableau2.setFont(new Font("Serif", Font.BOLD, 12));
        } else if(source1 == policeEcriture25){
            tableau2.setFont(new Font("Serif", Font.BOLD, 25));
        }
        else if(source1 == policeEcriture36){
            tableau2.setFont(new Font("Serif", Font.BOLD, 36));
        }
        else if(source1 == policeEcriture50){
            tableau2.setFont(new Font("Serif", Font.BOLD, 50));
        }
        else if(source1 == policeEcriture10){
            tableau2.setFont(new Font("Serif", Font.BOLD, 10));
        }
        else if(source1 == policeEcriture8){
            tableau2.setFont(new Font("Serif", Font.BOLD, 8));
        }

        tableau3.setFont(new Font("Serif", Font.BOLD, 18));
        Object source2 = e.getSource();
        if(source2 == policeEcriture18){
            tableau3.setFont(new Font("Serif", Font.BOLD, 18));
        } else if(source2 == policeEcriture12){
            tableau3.setFont(new Font("Serif", Font.BOLD, 12));
        } else if(source2 == policeEcriture25){
            tableau3.setFont(new Font("Serif", Font.BOLD, 25));
        }
        else if(source2 == policeEcriture36){
            tableau3.setFont(new Font("Serif", Font.BOLD, 36));
        }
        else if(source2 == policeEcriture50){
            tableau3.setFont(new Font("Serif", Font.BOLD, 50));
        }
        else if(source2 == policeEcriture10){
            tableau3.setFont(new Font("Serif", Font.BOLD, 10));
        }
        else if(source2 == policeEcriture8){
            tableau3.setFont(new Font("Serif", Font.BOLD, 8));
        }

        if(e.getSource() == btnText)
        {
            JPanel paneText = new JPanel();
            JTextArea textArea = new JTextArea();
            textArea.setDragEnabled(true);
            textArea.setSize(250,250);
            paneText.add(textArea);
            tableauCourant.add(paneText);
        }
    }

    /*
     * M�thodes pour changer la taille du crayon
     */

    public void changerTailleCrayon()
    {
        System.out.println("Ouverture de la page de s�lection de taille du crayon");
        StrokeWeightWindow strokeWeightWindow = new StrokeWeightWindow(this);
    }

    public void setNouvelleTailleCrayon(Integer NouvelleTailleCrayon)
    {
        System.out.println("Nouvelle Taille appliqu�e");
        tableauCourant.setTaille( NouvelleTailleCrayon );
    }

    /*
     * M�thodes pour changer la couleur du crayon
     */

    public void changerCouleurCrayon()
    {
        System.out.println("Ouverture de la page de s�lection de couleur du crayon");
        ColorWindow colorWindow= new ColorWindow(this);
        tableauCourant.setCouleurPinceau( colorWindow.getColor() ) ;
    }

    public void setNouvelleCouleurCraoyon(int NouvelleTailleCrayon)
    {
        System.out.println("Nouvelle Couleur du crayon appliqu�e");
        tableauCourant.setTaille( NouvelleTailleCrayon );
    }

    public JMenuItem getTaille()
    {
        return taille;
    }
    public JMenuItem getCouleurText()
    {
        return couleurText;
    }
    public JMenuItem getCouleurFond()
    {
        return couleurFond;
    }


}
