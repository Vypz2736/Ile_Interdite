/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Explorateur;
import models.Ingenieur;
import models.Joueur;
import models.Messager;
import models.Navigateur;
import models.Pilote;
import models.Plongeur;
import util.Message;

/**
 *
 * @author Vypz
 */
public class PanelJoueur extends JPanel {

    private ArrayList<Joueur> aj = new ArrayList();
    private Joueur j;
    private Controleur c;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean cliquable = false;
    private int x1, l, y1, h;
    
    public PanelJoueur(ArrayList<Joueur> joueurs, Joueur joueur, Controleur controleur) {
        j = joueur;
        c = controleur;
        addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (cliquable)
                c.traiterMessage(new Message(Message.TypeMessage.JOUEUR,aj.indexOf(j)));
            }
        });
        if (j.getAventurier() instanceof Pilote)
            add(new JLabel("Pilote"));
        if (j.getAventurier() instanceof Navigateur)
            add(new JLabel("Navigateur"));
        if (j.getAventurier() instanceof Plongeur)
            add(new JLabel("Plongeur"));           
        if (j.getAventurier() instanceof Explorateur)
            add(new JLabel("Explorateur"));            
        if (j.getAventurier() instanceof Ingenieur)
            add(new JLabel("Ingénieur"));
        if (j.getAventurier() instanceof Messager)
            add(new JLabel("Messager"));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        x1 = (int) (getWidth()-(getHeight()))/2;
        l = (int) getHeight();
        y1 = (int) 0;
        h = (int) getHeight();
        if (!cliquable) {
            g.setColor(new Color(150,150,150));
            g.fillRect(x1, y1, l, h);
        }
        g.setColor(Color.black);
        g.drawRect(x1, y1, l-1, h-1);
        g.drawRect(x1+1, y1+1, l-3, h-3);
        if (j.getAventurier() instanceof Pilote)
            g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/personnages/pilote.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))
                                .getImage(), x1, y1, l, h, this);
        if (j.getAventurier() instanceof Navigateur)
            g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/personnages/navigateur.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))
                                .getImage(), x1, y1, l, h, this);
        if (j.getAventurier() instanceof Plongeur)
            g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/personnages/plongeur.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))
                                .getImage(), x1, y1, l, h, this);
        if (j.getAventurier() instanceof Explorateur)
            g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/personnages/explorateur.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))
                                .getImage(), x1, y1, l, h, this);
        if (j.getAventurier() instanceof Ingenieur)
            g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/personnages/ingenieur.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))
                                .getImage(), x1, y1, l, h, this);
        if (j.getAventurier() instanceof Messager)
            g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/personnages/messager.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))
                                .getImage(), x1, y1, l, h, this);
        if (!cliquable) {
            g.setColor(new Color(150,150,150,150));
            g.fillRect(x1, y1, l, h);
        }
        
    }

    /**
     * @param cliquable the cliquable to set
     */
    public void setCliquable(boolean cliquable) {
        this.cliquable = cliquable;
        repaint();
    }
}
