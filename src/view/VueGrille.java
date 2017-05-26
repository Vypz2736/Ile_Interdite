/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import models.*;
import util.*;

/**
 *
 * @author Vypz
 */
public class VueGrille extends JPanel {
    private final JPanel[][] tuiles = new JPanel[6][6];
    private JPanel panelGrille;
    private final JFrame window;
    private ImageIcon img;
    ArrayList<Aventurier> aventuriers;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
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
    }
    
    public void couleur(Grille grille) {
        JLabel label;
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                if (grille.getGrille()[j][i] != null && !grille.getGrille()[j][i].estMorte()) {
                    aventuriers = new ArrayList();
                    for (Aventurier a : grille.getGrille()[j][i].getAventuriers()) {
                        aventuriers.add(a);
                    }
                    img(grille.getGrille()[j][i]);
                    tuiles[j][i] = new JPanel() {
                        @Override
                        public void paintComponent(Graphics g) {
                            g.drawImage(img.getImage(), 3, 3, null);
                            int i = 1;
                            for (Aventurier a : aventuriers) {
                                if (a instanceof Pilote)
                                    g.setColor(Color.blue);
                                if (a instanceof Navigateur)
                                    g.setColor(Color.yellow);
                                if (a instanceof Plongeur)
                                    g.setColor(Color.black);
                                if (a instanceof Explorateur)
                                    g.setColor(Color.green);
                                if (a instanceof Ingenieur)
                                    g.setColor(Color.red);
                                if (a instanceof Messager)
                                    g.setColor(Color.orange);
                                g.fillOval(i*15+(i-1)*15, 15, 20, 20);
                                i++;
                            }
                            for (int j = 1; j < 5; j++) {
                                g.fillOval(j*15+(j-2)*15, 10, 20, 20);
                            }
                        }
                    };
                    label = new JLabel(grille.getGrille()[j][i].getNom());;
                    if (grille.getGrille()[j][i].estInonde()) {
                        //tuiles[j][i].setBackground(new Color(231, 177, 39));
                        //label.setForeground(Color.black);
                    }
                    else {
                        //tuiles[j][i].setBackground(new Color(123, 50, 0));
                        //label.setForeground(Color.white);
                    }
                    //tuiles[j][i].add((label), BorderLayout.CENTER);
                }
                else {
                    tuiles[j][i] = new JPanel();
                    tuiles[j][i].removeAll();
                    tuiles[j][i].setBackground(new Color(108, 197, 255));
                }
            //if (grille.getGrille()[j][i] !=null)
                //panelGrille.getGraphics().fillOval(10, 10, 10, 10);
            panelGrille.add(tuiles[j][i]);
            }
        }
    }
    
    public void img(Tuile t) {
        String nmimg = "/img/tuiles/";
        if (t.estSeche())
            nmimg += t.getNom() + ".png";
        if (t.estInonde())
            nmimg += t.getNom() + "i.png";
        img = new ImageIcon(nmimg);
        img = new ImageIcon(new ImageIcon(getClass().getResource(nmimg))
                .getImage().getScaledInstance(dim.height / 6 - 32, dim.height / 6 - 32, Image.SCALE_SMOOTH));
        System.out.println(img.getDescription());
    }
    
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
        
//    @Override
//    public void paintComponent(Graphics g) {
//        g.drawImage(img.getImage(), 0, 0, null);
//    }
}
