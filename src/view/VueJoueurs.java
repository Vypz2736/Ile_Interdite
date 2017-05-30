/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class VueJoueurs extends JPanel {

    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel panelLabels;
    private JPanel[] panels = new JPanel[4];
    private JLabel[] labels = new JLabel[4];
    private JTextField[] texts = new JTextField[4];
    private JPanel panelQ = new JPanel(new BorderLayout());
    private JPanel panelV = new JPanel(new BorderLayout());
    private JButton bQ = new JButton("Quitter");
    private JButton bV = new JButton("Valider");
    private boolean valider;
    private JLabel titre;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private String strimg = new String("/img/tuiles/morte.png");
    private JLabel info = new JLabel("Entrez 2 à 4 noms de joueur");
    private Controleur c;
    
    public VueJoueurs(Controleur c) {
        titre = new JLabel("Choisissez le nom des joueurs :");
        titre.setForeground(new Color(0,192,255));
        titre.setFont(new Font(titre.getFont().getFontName(), titre.getFont().getStyle(), (int)dim.getWidth()/125));
        titre.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, (int)dim.getWidth()/300, (int)dim.getWidth()/150, 0));
        mainPanel.add(titre, BorderLayout.NORTH);
        info.setFont(new Font(titre.getFont().getFontName(), titre.getFont().getStyle(), (int)dim.getWidth()/140));
        info.setForeground(new Color(0,192,255));
        info.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, (int)dim.getWidth()/300, (int)dim.getWidth()/300, 0));
        mainPanel.add(info, BorderLayout.SOUTH);
        panelLabels = new JPanel(new GridLayout(3,2));
        for (int i = 0; i < 4; i++) {
            panels[i] = new JPanel(new GridLayout(1,2));
            labels[i] = new JLabel("Joueur n°" + (i+1) + " : ");
            labels[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            labels[i].setFont(new Font(titre.getFont().getFontName(), titre.getFont().getStyle(), (int)dim.getWidth()/140));
            labels[i].setForeground(new Color(0,192,255));
            texts[i] = new JTextField();
            panels[i].add(labels[i]);
            panels[i].add(texts[i]);
            panels[i].setBackground(new Color(30,30,30));
            panels[i].setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, (int)dim.getWidth()/70, (int)dim.getWidth()/300, (int)dim.getWidth()/70));
        }
        panelQ.add(bQ, BorderLayout.CENTER);
        panelV.add(bV, BorderLayout.CENTER);
        panelQ.setBackground(new Color(30,30,30));
        panelV.setBackground(new Color(30,30,30));
        panelQ.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, (int)dim.getWidth()/30, (int)dim.getWidth()/300, (int)dim.getWidth()/30));
        panelV.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, (int)dim.getWidth()/30, (int)dim.getWidth()/300, (int)dim.getWidth()/30));
        mainPanel.setBackground(new Color(30,30,30));
        panelLabels.add(panels[0]);
        panelLabels.add(panels[1]);
        panelLabels.add(panels[2]);
        panelLabels.add(panels[3]);
        panelLabels.add(panelQ);
        panelLabels.add(panelV);
        mainPanel.add(panelLabels);
        this.add(mainPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        bQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int z = 0;
                int a = 0;
                for (int i = 0; i < 4; i++) {
                    if (!vide(texts[i].getText()))
                        z++;
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = i+1; j < 4; j++) {
                        if (!vide(texts[i].getText()) && texts[i].getText().equals(texts[j].getText()))
                            a++;
                    }
                }
                if (a != 0)
                    info.setText("Il ne peut pas y avoir 2 noms de joueur identiques");
                else if (z == 0) {
                    info.setText("Il faut au minimum 2 joueurs, vous avez entré 0 nom de joueur");
                    info.setForeground(new Color(255, 148, 0));
                }
                else if (z == 1) {
                    info.setText("Il faut au minimum 2 joueurs, vous avez entré 1 nom de joueur");
                    info.setForeground(new Color(255, 148, 0));
                    }
                else
                    c.traiterMessage(new Message(Message.TypeMessage.SAISIEFINIE));
            }
        });
    }
        
    public boolean vide(String s) {
        boolean z = true;
        if (s != null)
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ')
                    z = false;
            }
        return z;
    }
    
    public String retirerEspaces(String s) {
        int debut = 0;
        int fin = s.length()-1;
        if (s.charAt(0) == ' ') {
            for (int i = 1; i < s.length()-1; i++) {
                if (debut == 0 && s.charAt(i) != ' ')
                    debut = i;
            }
        }
        if (s.charAt(s.length()-1) == ' ') {
            for (int i = s.length()-1; i > 0; i--) {
                if (fin == s.length()-1 && s.charAt(i) != ' ')
                    fin = i;
            }
        }
        return s.substring(debut, fin+1);
    }
    
    public ArrayList<String> recupsaisie() {
        ArrayList<String> saisie = new ArrayList();
        for (int i = 0; i < 4; i++) {
            if (!vide(texts[i].getText()))
                saisie.add(retirerEspaces(texts[i].getText()));    
        }
        this.setVisible(false);
        return saisie;
    }
    
    @Override
    public void paintComponent(Graphics g) {;
        g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource(strimg)).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)).getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
}
