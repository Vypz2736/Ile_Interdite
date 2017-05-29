/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import models.*;

/**
 *
 * @author Vypz
 */
public class VueGrille extends JPanel {
    private final VueTuile[][] tuiles = new VueTuile[6][6];
    private JPanel panelGrille;
    private ImageIcon image = new ImageIcon();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean init = true;
    
    public VueGrille(Grille grille) {
        panelGrille = new JPanel(new GridLayout(6,6));
        couleur(grille);
        this.add(panelGrille);
        panelGrille.setSize(((int)panelGrille.getSize().getWidth()),(int)(panelGrille.getSize().getWidth()));
        this.setVisible(true);
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
}
