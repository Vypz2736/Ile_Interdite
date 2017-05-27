/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import models.*;
import util.*;

/**
 *
 * @author Vypz
 */
public class VueGrille extends JPanel {
    private final VueTuile[][] tuiles = new VueTuile[6][6];
    private JPanel panelGrille;
    private final JFrame window;
    private ImageIcon image = new ImageIcon();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    boolean init = true;
    
    public VueGrille(Grille grille) {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("Plateau");
        window.setSize((int)(dim.getHeight()), (int)(dim.getHeight()));
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        panelGrille = new JPanel(new GridLayout(6,6));
        couleur(grille);
        window.add(panelGrille);
        panelGrille.setSize(((int)panelGrille.getSize().getWidth()),(int)(panelGrille.getSize().getWidth()));
        window.setVisible(true);
        init = false;
    }
    
    public void couleur(Grille grille) {
        panelGrille = new JPanel(new GridLayout(6,6));
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                if (init) {
                    tuiles[j][i] = new VueTuile(grille.getGrille()[j][i]);
                    panelGrille.add(tuiles[j][i]);
                }
                else
                    tuiles[j][i].maj(grille.getGrille()[j][i],getTuilesSurbrillance().contains(tuiles[j][i]));
            }
        }
    }
    
    public void setTuilesSurbrillance(ArrayList<Tuile> tuilesacc, boolean etat) {
        for (Tuile t : tuilesacc) {
            tuiles[t.getLigne()][t.getColonne()].setSurbrillance(etat);
        }
    }
    
    public ArrayList<VueTuile> getTuilesSurbrillance() {
        ArrayList<VueTuile> panels = new ArrayList();
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                if (tuiles[j][i].getSurbrillance())
                    panels.add(tuiles[j][i]);
            }
        }
        return panels;
    }
    
    public static void main(String[] args) {
        Controleur c = new Controleur();
        c.nouveauJoueur("Philippe");
        c.nouveauJoueur("André");
        c.nouveauJoueur("Gérard");
        c.nouveauJoueur("Hughes");
        c.init();
        //System.out.println(c.getGrille());
        VueGrille v = new VueGrille(c.getGrille());
        int nbi = 0;
        for (Tuile t : c.getAt()) {
            if (t.estInonde()) {
                nbi++;
            }
        }
        while (1 == 1) {
            for (Joueur j : c.getJoueurs()) {
                if (j.getAventurier() instanceof Pilote)
                    System.out.println("Au tour de " + j.getNom() + " (Pilote) de jouer.");
                if (j.getAventurier() instanceof Navigateur)
                    System.out.println("Au tour de " + j.getNom() + " (Navigateur) de jouer.");
                if (j.getAventurier() instanceof Plongeur)
                    System.out.println("Au tour de " + j.getNom() + " (Plongeur) de jouer.");
                if (j.getAventurier() instanceof Explorateur)
                    System.out.println("Au tour de " + j.getNom() + " (Explorateur) de jouer.");
                if (j.getAventurier() instanceof Ingenieur)
                    System.out.println("Au tour de " + j.getNom() + " (Ingénieur) de jouer.");
                if (j.getAventurier() instanceof Messager)
                    System.out.println("Au tour de " + j.getNom() + " (Messager) de jouer.");
                while(j.getAventurier().getNbactions()<3) {
                    ArrayList<Tuile> tuiles = new ArrayList();
                    for (Tuile t : j.getAventurier().getTuilesAcc(c.getGrille(), 2).values()) {
                        tuiles.add(t);
                    }
                    v.setTuilesSurbrillance(tuiles, true);
                    c.actionJoueur(j);
                    v.setTuilesSurbrillance(tuiles, false);
                    v.couleur(c.getGrille());
                }
                if (j.getAventurier() instanceof Pilote)
                    j.getAventurier().setHelico(false);
                j.getAventurier().setNbactions(0);
            }
            nbi = 0;
            for (Tuile t : c.getAt()) {
                if (t.estInonde()) {
                    nbi++;
                }
            }
        }
        
    }
}
