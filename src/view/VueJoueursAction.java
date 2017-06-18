/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import models.Joueur;
import models.*;

/**
 *
 * @author Vypz
 */
public class VueJoueursAction extends JPanel {
    private Joueur j;
    private ArrayList<Joueur> aj;
    private HashMap<Joueur,PanelJoueur> panels = new HashMap();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Controleur c;
    
    public VueJoueursAction(Joueur joueur, ArrayList<Joueur> joueurs, Controleur controleur) {
        setLayout(new GridLayout(0,joueurs.size()-1));
        j = joueur;
        aj = joueurs;
        c = controleur;
        setLayout(new GridLayout(1,aj.size()-1));
        images();
    }
    
    public void images() {
        this.removeAll();
        panels.clear();
        for (int i = 0; i < aj.size()-1; i++) {
            panels.put(aj.get((aj.indexOf(j)+1+i) % aj.size()),new PanelJoueur(aj, aj.get((aj.indexOf(j)+1+i) % aj.size()), c));
            panels.get(aj.get((aj.indexOf(j)+1+i) % aj.size())).setBorder(BorderFactory.createEmptyBorder(0,(int)((dim.width-dim.height)/2-dim.getHeight()/10*(aj.size()-1))/(2*(aj.size()-1)),0,(int)((dim.width-dim.height)/2-dim.getHeight()/10*(aj.size()-1))/(2*(aj.size()-1))));
            this.add(panels.get(aj.get((aj.indexOf(j)+1+i) % aj.size())));
        }
    }
    
    public void fintour() {
        j = aj.get(((aj.indexOf(j)+1) % aj.size()));
        images();
    }
    
    public void setCliquable(ArrayList<Joueur> joueurs, boolean etat) {
        for (Joueur joueur : joueurs)
            panels.get(j).setCliquable(etat);
    }
}
