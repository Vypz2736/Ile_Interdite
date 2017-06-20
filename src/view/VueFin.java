/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import controleur.Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Tuile;
import util.Message;

/**
 *
 * @author Vypz
 */
public class VueFin extends JPanel {
       
    private JLabel text;
    private boolean gagne = true;
    private JButton replay;
    private JButton finish;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Controleur c;
    private JLabel rèson;
    private JPanel layout = new JPanel(new GridBagLayout());
   
    public VueFin(boolean g, Tuile t, Controleur controleur){
        c = controleur;
        gagne = g;
        setLayout(new BorderLayout());
        setBackground(new Color(35,35,35));
        JPanel label = new JPanel(new GridLayout(2,1));
        label.setBackground(new Color(35,35,35));
        text = new JLabel();
        text.setFont(new Font(text.getFont().getFontName(), text.getFont().getStyle(), (int)dim.getWidth()/50));
        text.setForeground(new Color(0,192,255));
        label.add(text);
        if (gagne)
            text.setText("Bravo, vous avez gagné !!!");
        else {
            text.setText("Dommage, vous avez perdu,");
            if (t.estMorte())
                rèson = new JLabel("L'heliport est coulé...");
            else
                rèson = new JLabel("Un des trésors est perdu...");
            label.add(rèson);
            rèson.setFont(new Font(rèson.getFont().getFontName(), rèson.getFont().getStyle(), (int)dim.getWidth()/75));
            rèson.setForeground(new Color(0,192,255));
        }
        layout.add(label);
        this.add(layout, BorderLayout.NORTH);
        layout.setBackground(new Color(35,35,35));
        JPanel boutons = new JPanel(new GridLayout(1,5));
        boutons.setBackground(new Color(35,35,35));
        this.setBackground(new Color(35,35,35));
        replay = new JButton("Rejouer");
        boutons.add(new JLabel());
        boutons.add(replay);
        boutons.add(new JLabel());
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.RELANCER));
            }
        });
        finish = new JButton("Quitter");
        boutons.add(finish);
        boutons.add(new JLabel());
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(boutons,BorderLayout.SOUTH);
        boutons.setBorder(BorderFactory.createEmptyBorder(0, 0, (int)dim.getWidth()/150, 0));
        this.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/4, 0, (int)dim.getWidth()/4, 0));
        setVisible(true);
    }
   
}