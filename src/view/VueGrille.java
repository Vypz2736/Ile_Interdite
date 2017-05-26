/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.JPanel;
import models.*;
import util.*;

/**
 *
 * @author Vypz
 */
public class VueGrille {

    private final JPanel panelGrille;
    private final JPanel[][] tuiles = new JPanel[6][6];
    
    public VueGrille(Grille g) {
        panelGrille = new JPanel(new GridLayout(6,6));
        JPanel panelTuile;
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                panelTuile = new JPanel();
                if (g.getGrille()[j][i] == null) {
                    
                }
                else {
                    
                }
            panelGrille.add(panelTuile);
            }
        }
    }
    
}
