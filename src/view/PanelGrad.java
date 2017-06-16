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
public class PanelGrad extends JPanel implements Comparable {
    
    private int indice;
    private boolean actuel;
    private int height;
    private Color[] couleur = {new Color(138, 181, 200),new Color(138, 181, 200),new Color(92, 131, 174),new Color(92, 131, 174),new Color(92, 131, 174),new Color(67, 93, 144),new Color(67, 93, 144),new Color(53, 67, 114),new Color(53, 67, 114),new Color(186, 33, 51)};
    
    public PanelGrad(int i, int h/*, boolean a*/) {
        indice = i;
        height = h / 3;
        //actuel = a;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(couleur[getIndice()]);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (actuel) {
            g.setColor(new Color(255,0,0));
            g.fillOval(0, (getHeight()-5)/2, getWidth(), 5);
            g.setColor(new Color(35,35,35));
            g.drawOval(0, (getHeight()-5)/2, getWidth()-1, 5);
        }
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param actuel the actuel to set
     */
    public void setActuel(boolean actuel) {
        this.actuel = actuel;
    }

    @Override
    public int compareTo(Object o) {
        PanelGrad p = (PanelGrad) o;
        if (this.getIndice() == p.getIndice())
            return 0;
        if (this.getIndice() > p.getIndice())
            return 1;
        else
            return -1;
    }
    
    
    
}
