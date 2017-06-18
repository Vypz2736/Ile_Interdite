/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import models.*;
import util.Message;

public class VueTourJoueurs extends JPanel {
    
    private Joueur j;
    private ArrayList<Joueur> aj;
    private ArrayList<JLabel> labels = new ArrayList();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    public VueTourJoueurs(Joueur joueur, ArrayList<Joueur> joueurs) {
        j = joueur;
        aj = joueurs;
        setBackground(new Color(35,35,35));
        setLayout(new GridLayout(aj.size(),1));
        for (int i = 0; i < aj.size(); i++) {
            if (i == 0)
                labels.add(new JLabel("File d'attente de tour :"));
            else
                labels.add(new JLabel());
            add(labels.get(i));
        }
        labels.get(0).setForeground(new Color(30,30,30));
        labels.get(0).setFont(new Font(labels.get(0).getFont().getFontName(), labels.get(0).getFont().getStyle(), (int)dim.getWidth()/125));
        texte();
    }
    
    public void fintour() {
        j = aj.get(((aj.indexOf(j)+1) % aj.size()));
        texte();
    }
    
    public void texte() {
        for (int i = 1; i < labels.size(); i++) {
            if (aj.get(((aj.indexOf(j)+i) % aj.size())).getAventurier() instanceof Pilote) {
                labels.get(i).setText("- " + i + ". Pilote : " + aj.get(((aj.indexOf(j)+i) % aj.size())).getNom());
                labels.get(i).setForeground(new Color(55,194,198));
            }
            if (aj.get(((aj.indexOf(j)+i) % aj.size())).getAventurier() instanceof Navigateur) {
                labels.get(i).setText("- " + i + ". Navigateur : " + aj.get(((aj.indexOf(j)+i) % aj.size())).getNom());
                labels.get(i).setForeground(new Color(255, 255, 0));
            }
            if (aj.get(((aj.indexOf(j)+i) % aj.size())).getAventurier() instanceof Plongeur) {
                labels.get(i).setText("- " + i + ". Plongeur : " + aj.get(((aj.indexOf(j)+i) % aj.size())).getNom());
                labels.get(i).setForeground(new Color(204, 94, 255));
            }  
            if (aj.get(((aj.indexOf(j)+i) % aj.size())).getAventurier() instanceof Explorateur) {
                labels.get(i).setText("- " + i + ". Explorateur : " + aj.get(((aj.indexOf(j)+i) % aj.size())).getNom());
                labels.get(i).setForeground(new Color(0, 195, 0));
            }
            if (aj.get(((aj.indexOf(j)+i) % aj.size())).getAventurier() instanceof Ingenieur) {
                labels.get(i).setText("- " + i + ". Ingénieur : " + aj.get(((aj.indexOf(j)+i) % aj.size())).getNom());
                labels.get(i).setForeground(new Color(255, 0, 0));
            }
            if (aj.get(((aj.indexOf(j)+i) % aj.size())).getAventurier() instanceof Messager) {
                labels.get(i).setText("- " + i + ". Messager : " + aj.get(((aj.indexOf(j)+i) % aj.size())).getNom());
                labels.get(i).setForeground(new Color(255, 148, 0));
            }
            labels.get(i).setFont(new Font(labels.get(i).getFont().getFontName(), labels.get(i).getFont().getStyle(), (int)dim.getWidth()/140));
        }
    }
}
