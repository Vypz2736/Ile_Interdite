/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.awt.*;
import javax.swing.*;
import models.*;
import util.*;

/**
 *
 * @author Vypz
 */
public class VueGrille {
    private final JPanel[][] tuiles = new JPanel[6][6];
    //private ImageIcon img;
    private JPanel panelGrille;
    private final JFrame window;
    
    public VueGrille(Grille g) {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("Plateau");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(880, (int)(dim.getHeight()));
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        panelGrille = new JPanel(new GridLayout(6,6));
        couleur(g);
        window.add(panelGrille);
        panelGrille.setSize(((int)panelGrille.getSize().getWidth()),(int)(panelGrille.getSize().getWidth()));
        window.setVisible(true);
        
    }
    
    public void couleur(Grille g) {
        JLabel label;
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                tuiles[j][i] = new JPanel(new BorderLayout());
                if (g.getGrille()[j][i] != null && !g.getGrille()[j][i].estMorte()) {
                    label = new JLabel(g.getGrille()[j][i].getNom());;
                    if (g.getGrille()[j][i].estInonde()) {
                        tuiles[j][i].setBackground(new Color(231, 177, 39));
                        label.setForeground(Color.black);
                    }
                    else {
                        tuiles[j][i].setBackground(new Color(123, 50, 0));
                        label.setForeground(Color.white);
                    }
                    tuiles[j][i].add((label), BorderLayout.CENTER);
                }
                else {
                    tuiles[j][i].removeAll();
                    tuiles[j][i].setBackground(new Color(108, 197, 255));
                }
            panelGrille.add(tuiles[j][i]);
            }
        }
    }
//    
//    public void img(Tuile t) {
//        String nmimg = "/img/tuiles/";
//        if (t.estSeche())
//            nmimg += t.getNom() + ".png";
//        if (t.estInonde())
//            nmimg = t.getNom() + "i.png";
//        img = new ImageIcon(nmimg);
//    }
//    
//    public void paintComponent(Graphics gra) {
//        gra.drawImage(img.getImage(), 0, 0, panelGrille);
//    }
    
        public static void main(String[] args) {
            Controleur c = new Controleur();
            c.nouveauJoueur("Philippe");
            c.nouveauJoueur("André");
            c.nouveauJoueur("Gérard");
            c.nouveauJoueur("Hughes");
            c.init();
            System.out.println(c.getGrille());
            VueGrille v = new VueGrille(c.getGrille());

        }
}
