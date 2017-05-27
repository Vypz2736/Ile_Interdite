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
public class VueTuile extends JPanel{

    private Tuile t;
    private boolean surbrillance;
    
    public VueTuile(Tuile t) {
        this.t = t;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {;
        int i = 1;
        
        g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/tuiles/morte.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)).getImage(), 0, 0, getWidth(), getHeight(), this);
        if (t != null && !t.estMorte())
            g.drawImage(img(t).getImage(), getWidth()*1/20, getHeight()*1/20, getWidth()*9/10, getHeight()*9/10, this);
        if (t != null) {
            Graphics2D g2 = (Graphics2D) g;
            for (Aventurier a : t.getAventuriers()) {
                if (a instanceof Pilote)
                    g.setColor(new Color(55,194,198));
                if (a instanceof Navigateur)
                    g.setColor(new Color(255, 255, 0));
                if (a instanceof Plongeur)
                    g.setColor(new Color(204, 94, 255));
                if (a instanceof Explorateur)
                    g.setColor(new Color(0, 195, 0));
                if (a instanceof Ingenieur)
                    g.setColor(new Color(255, 0, 0));
                if (a instanceof Messager)
                    g.setColor(new Color(255, 148, 0));
                g2.setStroke(new BasicStroke(getWidth()/60));
                g2.fillOval(((getWidth()/10)*4/5) + (i-1)*((getWidth()/10)*50/20), (getWidth()/10)*4/5, (getWidth()/10)*6/4, (getWidth()/10)*6/4);
                g2.setColor(new Color(0, 0, 0));
                g2.drawOval(((getWidth()/10)*4/5) + (i-1)*((getWidth()/10)*50/20), (getWidth()/10)*4/5, (getWidth()/10)*6/4, (getWidth()/10)*6/4);
                i++;
            }
        }
    }
    
    public ImageIcon img(Tuile t) {
        String nmimg = "/img/tuiles/";
        if (t != null && t.estSeche())
            nmimg += t.getNom();
        else if (t != null && t.estInonde())
            nmimg += t.getNom() + "i";
        //ImageIcon img = new ImageIcon(nmimg);
        else
            nmimg += "morte";
        if (getSurbrillance())
            nmimg += "s.png";
        else
            nmimg += ".png";
        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(nmimg)).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
//                                                                                                                largeur          hauteur         adaptation
        return img;
    }
    
    public void maj(Tuile t, boolean surbrillance) {
        this.t = t;
        this.setSurbrillance(surbrillance);
        repaint();
        System.out.println(t);
    }

    /**
     * @return the surbrillance
     */
    public boolean getSurbrillance() {
        return surbrillance;
    }

    /**
     * @param surbrillance the surbrillance to set
     */
    public void setSurbrillance(boolean surbrillance) {
        this.surbrillance = surbrillance;
    }
    
}