/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Vypz
 */
class PanelTrait extends JPanel {
    
    private Color[] couleur = {new Color(138, 181, 200),new Color(138, 181, 200),new Color(92, 131, 174),new Color(92, 131, 174),new Color(92, 131, 174),new Color(67, 93, 144),new Color(67, 93, 144),new Color(53, 67, 114),new Color(53, 67, 114),new Color(186, 33, 51)};
    private int indice;
    
    public PanelTrait (int i) {
        indice = i;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(couleur[indice]);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.fillRect(0, (getHeight()-2)/2, getWidth()/3, 2);
    }
    
}
