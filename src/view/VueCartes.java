
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
public class VueCartes extends JPanel {
    private ArrayList<Carte> ac;
    private HashMap<Carte,PanelCarte> panels = new HashMap();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Controleur c;
    
    public VueCartes(ArrayList<Carte> cartes, Controleur controleur) {
        ac = cartes;
        c = controleur;
        setLayout(new GridLayout(1,8));
        images();
    }
    
    public void images() {
        this.removeAll();
        panels.clear();
        for (int i = 0; i < ac.size(); i++) {
            panels.put(ac.get(i),new PanelCarte(ac, ac.get(i), c));
            panels.get(ac.get(i)).repaint();
            this.add(panels.get(ac.get(i)));
        }
        //affiche les emplacements de carte vide
        //for (int i = ac.size(); i < 7; i++) {
        //    this.add(new PanelCarte(ac, null, c));
        //}
        repaint();
    }
    
    public void setCliquable(ArrayList<Carte> cartes, boolean etat) {
        for (Carte carte : cartes)
            panels.get(carte).setCliquable(etat);
    }
}
