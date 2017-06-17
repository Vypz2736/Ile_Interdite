/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import util.*;
/**
 *
 * @author Vypz
 */


public class VueTresors extends JPanel {
    
    private ArrayList<Tresor> tresors = new ArrayList();
    private ImageIcon statue;
    private ImageIcon cristal;
    private ImageIcon pierre;
    private ImageIcon calice;
    private ImageIcon statueg;
    private ImageIcon cristalg;
    private ImageIcon pierreg;
    private ImageIcon caliceg;
    
    public VueTresors(ArrayList<Tresor> at) {
        tresors = at;
        statue = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Statue.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        cristal = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Cristal.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        pierre = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Pierre.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        calice = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Calice.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        statueg = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Statueg.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        cristalg = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Cristalg.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        pierreg = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Pierreg.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        caliceg = new ImageIcon(new ImageIcon(getClass().getResource("/img/tresors/Caliceg.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    }

    @Override
    protected void paintComponent(Graphics g) {
        //g.setColor(new Color(30,30,30));
        //g.fillRect(0, 0, getWidth(), getHeight());
        if (tresors.contains(Tresor.Calice))
            g.drawImage(calice.getImage(), 0, 0, getWidth(), getHeight(), this);
        else
            g.drawImage(caliceg.getImage(), 0, 0, getWidth(), getHeight(), this);
        if (tresors.contains(Tresor.Pierre))
            g.drawImage(pierre.getImage(), 0, 0, getWidth(), getHeight(), this);
        else
            g.drawImage(pierreg.getImage(), 0, 0, getWidth(), getHeight(), this);
        if (tresors.contains(Tresor.Cristal))
            g.drawImage(cristal.getImage(), 0, 0, getWidth(), getHeight(), this);
        else
            g.drawImage(cristalg.getImage(), 0, 0, getWidth(), getHeight(), this);
        if (tresors.contains(Tresor.Statue))
            g.drawImage(statue.getImage(), 0, 0, getWidth(), getHeight(), this);
        else
            g.drawImage(statueg.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public void majtresor(ArrayList<Tresor> at) {
        tresors = at;
        repaint();
    }
    
}
