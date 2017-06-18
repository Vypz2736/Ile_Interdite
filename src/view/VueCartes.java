
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
    private Carte ca;
    private ArrayList<Carte> ac;
    private HashMap<Carte,PanelCarte> panels = new HashMap();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Controleur c;
    
    public VueCartes(Carte carte, ArrayList<Carte> cartes, Controleur controleur) {
        ca = carte;
        ac = cartes;
        c = controleur;
        setLayout(new GridLayout(1,7));
        images();
    }
    
    public void images() {
        this.removeAll();
        panels.clear();
        for (int i = 0; i < ac.size(); i++) {
            panels.put(ac.get(i),new PanelCarte(ac, ac.get(i), c));
            panels.get(i).setBorder(BorderFactory.createEmptyBorder(0,(int)((dim.width-dim.height)/2-dim.getHeight()/10*(7))/(2*(7)),0,(int)((dim.width-dim.height)/2-dim.getHeight()/10*(7))/(2*(7))));
            this.add(panels.get(i));
        }
        for (int i = ac.size(); i < 8; i++) {
            panels.put(ac.get(i),new PanelCarte(ac, null, c));
            panels.get(i).setBorder(BorderFactory.createEmptyBorder(0,(int)((dim.width-dim.height)/2-dim.getHeight()/10*(7))/(2*(7)),0,(int)((dim.width-dim.height)/2-dim.getHeight()/10*(7))/(2*(7))));
            this.add(panels.get(i));
        }
    }
    
    public void setCliquable(ArrayList<Carte> cartes, boolean etat) {
        for (Carte carte : cartes)
            panels.get(carte).setCliquable(etat);
    }
}
