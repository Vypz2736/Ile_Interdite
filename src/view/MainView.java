/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import models.Explorateur;
import models.Ingenieur;
import models.Joueur;
import models.Messager;
import models.Navigateur;
import models.Pilote;
import models.Plongeur;
import models.Tuile;

/**
 *
 * @author Vypz
 */
public class MainView {

    private final JFrame window;
    private VueGrille v;
    private Controleur c = new Controleur();
    VueJoueurs j = new VueJoueurs();
    private JPanel mainpanel;
    private ArrayList<String> noms;
    
    public MainView() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("L'Île Interdite");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainpanel = new JPanel(new GridBagLayout());
        mainpanel.setSize(window.getHeight(),window.getHeight());
        mainpanel.add(j);
        window.add(mainpanel);
        window.setVisible(true);
        while (j.recupsaisie().size() == 0);
        noms = j.recupsaisie();
        for (String s : noms)
            c.nouveauJoueur(s);
        c.init();
        mainpanel.remove(j);
        v = new VueGrille(getC().getGrille());
        mainpanel.add(v);
        window.setVisible(true);
    }

    /**
     * @return the v
     */
    public VueGrille getV() {
        return v;
    }

    /**
     * @return the c
     */
    public Controleur getC() {
        return c;
    }
    
    public static void main(String[] args) {
        MainView m = new MainView();
//        int nbi = 0;
//        for (Tuile t : m.getC().getAt()) {
//            if (t.estInonde()) {
//                nbi++;
//            }
//        }
//        while (1 == 1) {
//            for (Joueur j : m.getC().getJoueurs()) {
//                if (j.getAventurier() instanceof Pilote)
//                    System.out.println("Au tour de " + j.getNom() + " (Pilote) de jouer.");
//                if (j.getAventurier() instanceof Navigateur)
//                    System.out.println("Au tour de " + j.getNom() + " (Navigateur) de jouer.");
//                if (j.getAventurier() instanceof Plongeur)
//                    System.out.println("Au tour de " + j.getNom() + " (Plongeur) de jouer.");
//                if (j.getAventurier() instanceof Explorateur)
//                    System.out.println("Au tour de " + j.getNom() + " (Explorateur) de jouer.");
//                if (j.getAventurier() instanceof Ingenieur)
//                    System.out.println("Au tour de " + j.getNom() + " (Ingénieur) de jouer.");
//                if (j.getAventurier() instanceof Messager)
//                    System.out.println("Au tour de " + j.getNom() + " (Messager) de jouer.");
//                while(j.getAventurier().getNbactions()<3) {
//                    ArrayList<Tuile> tuiles = new ArrayList();
//                    for (Tuile t : j.getAventurier().getTuilesAcc(m.getC().getGrille(), 2).values()) {
//                        tuiles.add(t);
//                    }
//                    m.getV().setTuilesSurbrillance(tuiles, true);
//                    m.getC().actionJoueur(j);
//                    m.getV().setTuilesSurbrillance(tuiles, false);
//                    m.getV().couleur(m.getC().getGrille());
//                }
//                if (j.getAventurier() instanceof Pilote)
//                    j.getAventurier().setHelico(false);
//                j.getAventurier().setNbactions(0);
//            }
//            nbi = 0;
//            for (Tuile t : m.getC().getAt()) {
//                if (t.estInonde()) {
//                    nbi++;
//                }
//            }
//        }
        
    }
    
}
