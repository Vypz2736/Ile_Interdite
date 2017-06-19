/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import util.*;
/**
 *
 * @author Vypz
 */


public class VueTresors extends JPanel {
    
    private ArrayList<Tresor> tresors = new ArrayList();
    private BufferedImage statue;
    private BufferedImage cristal;
    private BufferedImage pierre;
    private BufferedImage calice;
    private BufferedImage statueg;
    private BufferedImage cristalg;
    private BufferedImage pierreg;
    private BufferedImage caliceg;
    private JLabel label = new JLabel("Trésors acquis");
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    public VueTresors(ArrayList<Tresor> at) {
        try {
            label.setForeground(new Color(200,200,200,200));
            label.setFont(new Font(label.getFont().getFontName(), label.getFont().getStyle(), (int)dim.getWidth()/125));
            label.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, 0, 0, (int)dim.getWidth()/7));
            add(label);
            tresors = at;
            statue = ImageIO.read(Main.class.getResource("/img/tresors/Statue.png"));
            cristal = ImageIO.read(Main.class.getResource("/img/tresors/Cristal.png"));
            pierre = ImageIO.read(Main.class.getResource("/img/tresors/Pierre.png"));
            calice = ImageIO.read(Main.class.getResource("/img/tresors/Calice.png"));
            statueg = ImageIO.read(Main.class.getResource("/img/tresors/Statueg.png"));
            cristalg = ImageIO.read(Main.class.getResource("/img/tresors/Cristalg.png"));
            pierreg = ImageIO.read(Main.class.getResource("/img/tresors/Pierreg.png"));
            caliceg = ImageIO.read(Main.class.getResource("/img/tresors/Caliceg.png"));
        } catch (IOException ex) {
            Logger.getLogger(VueTresors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(30,30,30));
        int h = getHeight()*2;
        int l = h/235*195;
        int x = 0;//(getWidth()-l)/2;
        int y = 0;//(getHeight()-h)/2;
        g.fillRect(x, y, getWidth(), getHeight());
        if (tresors.contains(Tresor.Calice))
            g.drawImage(calice, x, y, getWidth(), getHeight(), this);
        else
            g.drawImage(caliceg, x, y, getWidth(), getHeight(), this);
        if (tresors.contains(Tresor.Pierre))
            g.drawImage(pierre, x, y, getWidth(), getHeight(), this);
        else
            g.drawImage(pierreg, x, y, getWidth(), getHeight(), this);
        if (tresors.contains(Tresor.Cristal))
            g.drawImage(cristal, x, y, getWidth(), getHeight(), this);
        else
            g.drawImage(cristalg, x, y, getWidth(), getHeight(), this);
        if (tresors.contains(Tresor.Statue))
            g.drawImage(statue, x, y, getWidth(), getHeight(), this);
        else
            g.drawImage(statueg, x, y, getWidth(), getHeight(), this);
    }
    
    public void majtresor(ArrayList<Tresor> at) {
        tresors = at;
        repaint();
    }
    
}
